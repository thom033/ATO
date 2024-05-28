package lohataona;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lohataona.annotation.AnnotationController;
import lohataona.annotation.GetUrl;
import lohataona.annotation.PostUrl;

public class FrontController extends HttpServlet{
    String pack;
    HashMap<String,Mapping> hashMapGet;
    HashMap<String,Mapping> hashMapPost;

    public void init()throws ServletException{
        super.init();
        scan();
    }

    private void scan(){
        this.pack=this.getInitParameter("controllerPackage");
        try {
            List<Class<?>> listes=getClassesInPackage(this.pack);
            HashMap<String,HashMap<String,Mapping>> hashMap=this.initializeHashMap(listes);
            this.hashMapGet=hashMap.get("Get");
            this.hashMapPost=hashMap.get("Post");
        } catch (Exception e) {
        }
    }

    private List<Class<?>> getClassesInPackage(String packageName) throws IOException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> resources = classLoader.getResources(path);
        while(resources.hasMoreElements()){
            URL resource = resources.nextElement();
            if(resource.getProtocol().equals("file")){
                File directory = new File(URLDecoder.decode(resource.getFile(),"UTF-8"));
                if(directory.exists() && directory.isDirectory()){
                    File[] files=directory.listFiles();
                    for(File file : files){
                        if(file.isFile() && file.getName().endsWith(".class")){
                            String className = this.pack + '.' + file.getName().replace(".class","");
                            Class<?> clazz=Class.forName(className);
                            if(clazz.isAnnotationPresent(AnnotationController.class)){
                                classes.add(clazz);
                            }
                        }
                    }
                }
            }
        }
        return classes;
    }

    public HashMap<String,HashMap<String,Mapping>> initializeHashMap(List<Class<?>> classes){
        HashMap<String,Mapping> get=new HashMap<String,Mapping>();
        HashMap<String,Mapping> post=new HashMap<String,Mapping>();
        HashMap<String,HashMap<String,Mapping>> valiny=new HashMap<String,HashMap<String,Mapping>>();
        for(int i=0;i<classes.size();i++){
            Method[] methods=classes.get(i).getDeclaredMethods();
            for(int e=0;e<methods.length;e++){
                if(methods[e].isAnnotationPresent(GetUrl.class)){
                    Mapping mapping = new Mapping(classes.get(i),methods[e].getName());
                    GetUrl annotation = methods[e].getAnnotation(GetUrl.class);
                    get.put(annotation.url(),mapping);
                }
                if(methods[e].isAnnotationPresent(PostUrl.class)){
                    Mapping mapping = new Mapping(classes.get(i),methods[e].getName());
                    PostUrl annotation = methods[e].getAnnotation(PostUrl.class);
                    post.put(annotation.url(),mapping);
                }
            }
        }
        valiny.put("Post", post);
        valiny.put("Get", get);
        return valiny;
    }

    public static String getRequest(String url){
        String[] segments=url.split("/");
        if(segments.length>1){
            return String.join("/", java.util.Arrays.copyOfRange(segments, 2, segments.length));
        }
        return "";
    }

    protected boolean isAFile(String url){
        if(url.contains(".jsp")){
            return true;
        }
        else if(url.contains(".html")){
            return true;
        }
        else if(url.contains(".css")){
            return true;
        }
        else if(url.contains(".png")){
            return true;
        }
        else if(url.contains(".jpg")){
            return true;
        }
        else if(url.contains(".jpeg")){
            return true;
        }
        return false;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String url = getRequest(request.getRequestURI());
            Mapping mapping = hashMapGet.get(url);
            if(mapping!=null){
                Class<?> classeUsed=mapping.getClasse();
                Method method=classeUsed.getMethod(mapping.getMethodName(), HttpServletRequest.class,HttpServletResponse.class);
                Constructor<?> constructeur=classeUsed.getConstructor();
                Object classObject=constructeur.newInstance();
                method.invoke(classObject, request,response);
            }
            else if(mapping==null){
                out.println("<p>"+url+"</p>");
                out.println("<p>Il n'y a pas de methode associe a ce chemin</p>");
            }
        }
        catch(java.lang.reflect.InvocationTargetException ex){
            Throwable cause = ex.getCause(); // Get the underlying exception
            out.println(cause+"\n");
            cause.printStackTrace(out);
        }
        catch(Exception ex){
            out.println(ex);
            ex.printStackTrace(out);
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String url = getRequest(request.getRequestURI());
            Mapping mapping = hashMapPost.get(url);
            if(isAFile(url)){
                out.println("est un fichier");
                return;
            }
            if(mapping!=null){
                Class<?> classeUsed=mapping.getClasse();
                Method method=classeUsed.getMethod(mapping.getMethodName(), HttpServletRequest.class,HttpServletResponse.class);
                Constructor<?> constructeur=classeUsed.getConstructor();
                Object classObject=constructeur.newInstance();
                method.invoke(classObject, request,response);
            }
            else{
                out.println("<p>"+url+"</p>");
                out.println("<p>Il n'y a pas de methode associe a ce chemin</p>");
            }
        }
        catch(java.lang.reflect.InvocationTargetException ex){
            Throwable cause = ex.getCause(); // Get the underlying exception
            out.println(cause+"\n");
            cause.printStackTrace(out);
        }
        catch(Exception ex){
            out.println(ex);
            ex.printStackTrace(out);
        }
        out.close();
    }
}