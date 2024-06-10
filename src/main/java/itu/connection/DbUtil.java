package itu.connection;

import java.util.List;

import itu.connection.annotations.Colonne;
import itu.connection.annotations.Table;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.DriverManager;
import org.postgresql.util.PGobject;


import java.util.ArrayList;
import java.util.Hashtable;

public class DbUtil {
    private String url;
    private String user;
    private String database;
    private String mdp;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Connection getConnection() throws Exception {
        Connection c = null;

        // Charger le pilote JDBC
        Class.forName("org.postgresql.Driver");

        // Établir la connexion à la base de données
        c = DriverManager.getConnection(this.url + this.database, this.user, this.mdp);

        return c;
    }

    /**
     * @param request requête sql
     * @return une liste contenant des hashmap avec les noms de colonnes dans la
     *         base de données comme clé
     * @throws Exception
     */
    public List<Hashtable<String, Object>> getSelect(String request) throws Exception {
        Connection connection = null;
        List<Hashtable<String, Object>> valiny = new ArrayList<Hashtable<String, Object>>();
        try {
            connection = this.getConnection();
            valiny = getSelect(connection, request);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return valiny;
    }

    /**
     * @param request    requête sql avec des parametres a modifier
     * @param parameters les parametres suivants la requête
     * @return une liste contenant des hashmap avec les noms de colonnes dans la
     *         base de données comme clé
     * @throws Exception
     */
    public List<Hashtable<String, Object>> getSelect(String request, List<Object> parameters) throws Exception {
        Connection connection = null;
        List<Hashtable<String, Object>> valiny = new ArrayList<Hashtable<String, Object>>();
        try {
            connection = this.getConnection();
            valiny = getSelect(connection, request, parameters);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return valiny;
    }

    /**
     * @param connection connection a utilié
     * @param request    requête sql
     * @return une liste contenant des hashmap avec les noms de colonnes dans la
     *         base de données comme clé
     * @throws Exception
     */
    public static List<Hashtable<String, Object>> getSelect(Connection connection, String request) throws Exception {
        return getSelect(connection, request, new ArrayList<Object>());
    }

    /**
     * @param connection connection a utilisé
     * @param request    requête sql avec des parametres a modifier
     * @param parameters les parametres suivants la requête
     * @return une liste contenant des hashmap avec les noms de colonnes dans la
     *         base de données comme clé
     * @throws Exception
     */
    public static List<Hashtable<String, Object>> getSelect(Connection connection, String request,
            List<Object> parameters) throws Exception {
        List<Hashtable<String, Object>> valiny = new ArrayList<Hashtable<String, Object>>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(request);
            setStatements(pstmt, parameters);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Hashtable<String, Object> recep = new Hashtable<String, Object>();
                ResultSetMetaData metaData = rs.getMetaData();
                int nbCol = metaData.getColumnCount();
                for (int i = 0; i < nbCol; i++) {
                    String nomCollone = metaData.getColumnName(i + 1);
                    recep.put(nomCollone, rs.getObject(nomCollone));
                }
                valiny.add(recep);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
        return valiny;
    }

    private static LocalTime turnIntoLocalTime(org.postgresql.util.PGInterval interval) throws Exception {
        float seconds = (float) interval.getSeconds();
        double minutes = interval.getMinutes();
        double hours = interval.getHours();
        float millis = seconds - (int) seconds;
        millis = millis * 1000;
        LocalTime timestamp = LocalTime.of((int) hours, (int) minutes, (int) seconds, (int) millis * 1000000);
        // timestamp.setNanos((int) (duration.getNano() % 1_000_000_000));
        return timestamp;
    }

    private static void invokeSetter(Method setter, Object object, Object value) throws Exception {
        if (value.getClass() == org.postgresql.util.PGInterval.class) {
            LocalTime time = turnIntoLocalTime((org.postgresql.util.PGInterval) value);
            setter.invoke(object, time);
        } else if (value.getClass() == Date.class) {
            Date date = (Date) value;
            LocalDate localDate = date.toLocalDate();
            setter.invoke(object, localDate);
        } else if (value.getClass() == Long.class) {
            long longe = (long) value;
            setter.invoke(object, (int) longe);
        } else {
            // System.out.println(setter.getName()+" "+value.getClass());
            setter.invoke(object, value);
        }
    }

    public static void setInIfPossible(Object object, String colloneBase, Object value) throws Exception {
        Class<?> classe = object.getClass();
        Field[] attributs = classe.getDeclaredFields();
        for (int i = 0; i < attributs.length; i++) {
            if (attributs[i].isAnnotationPresent(Colonne.class)) {
                Colonne collone = attributs[i].getAnnotation(Colonne.class);
                if (collone.collone().compareToIgnoreCase(colloneBase) == 0) {
                    Method setter = getSetter(classe, attributs[i]);
                    DbUtil.invokeSetter(setter, object, value);
                    return;
                }
            }
        }
    }

    /**
     * @param <T>
     * @param request la requête sql
     * @param classe  la classe a retourné dans une liste
     * @return une liste de la classe inséré dans le paramètre du fonction
     * @throws Exception
     */
    public <T> List<T> getSelectAndCast(String request, Class<T> classe) throws Exception {
        List<T> valiny = new ArrayList<T>();
        Connection connection = null;
        try {
            connection = this.getConnection();
            valiny = getSelectAndCast(connection, request, new ArrayList<Object>(), classe);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return valiny;
    }

    /**
     * @param <T>
     * @param connection connection a utilisé
     * @param request    requête sql
     * @param classe     la classe a retourné dans une liste
     * @return une liste de la classe inséré dans le paramètre du fonction
     * @throws Exception
     */
    public static <T> List<T> getSelectAndCast(Connection connection, String request, Class<T> classe)
            throws Exception {
        return getSelectAndCast(connection, request, new ArrayList<Object>(), classe);
    }

    /**
     * @param <T>
     * @param request    la requête sql avec des paramètres
     * @param parameters les paramètres a inséré dans la requête
     * @param classe     la classe a retourné dans une liste
     * @return une liste de la classe inséré dans le paramètre du fonction
     * @throws Exception
     */
    public <T> List<T> getSelectAndCast(String request, List<Object> parameters, Class<T> classe) throws Exception {
        List<T> valiny = new ArrayList<T>();
        Connection connection = null;
        try {
            connection = this.getConnection();
            valiny = DbUtil.getSelectAndCast(connection, request, parameters, classe);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return valiny;
    }

    /**
     * @param <T>
     * @param connection connection a utilisé
     * @param request    la requête sql avec des paramètres
     * @param parameters les paramètres a inséré dans la requête
     * @param classe     la classe a retourné dans une liste
     * @return une liste de la classe inséré dans le paramètre du fonction
     * @throws Exception
     */
    public static <T> List<T> getSelectAndCast(Connection connection, String request, List<Object> parameters,
            Class<T> classe) throws Exception {
        List<T> valiny = new ArrayList<T>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(request);
            setStatements(pstmt, parameters);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ResultSetMetaData metaData = rs.getMetaData();
                int nbCol = metaData.getColumnCount();
                Constructor<T> constructor = classe.getConstructor();
                T recep = (T) constructor.newInstance();
                for (int i = 0; i < nbCol; i++) {
                    String nomCollone = metaData.getColumnName(i + 1);
                    setInIfPossible(recep, nomCollone, rs.getObject(nomCollone));
                }
                valiny.add(recep);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        }
        return valiny;
    }

    /**
     * @param request la requête sql a executé
     * @throws Exception
     */
    public void execute(String request) throws Exception {
        this.execute(request, new ArrayList<Object>());
    }

    /**
     * @param request    la requête sql avec des paramètres
     * @param parameters les paramètres a inséré dans la requête sql
     * @throws Exception
     */
    public void execute(String request, List<Object> parameters) throws Exception {
        Connection connection = null;
        try {
            connection = this.getConnection();
            connection.setAutoCommit(false);
            DbUtil.execute(connection, request, parameters);
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * @param connection connection a utilisé
     * @param request    la requête sql a executé
     * @throws Exception
     */
    public static void execute(Connection connection, String request) throws Exception {
        DbUtil.execute(connection, request, new ArrayList<Object>());
    }

    /**
     * @param connection connection a utilisé
     * @param request    la requête sql avec des paramètres a exécuté
     * @param parameters les paramètres a inséré
     * @throws Exception
     */
    public static void execute(Connection connection, String request, List<Object> parameters) throws Exception {
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(request);
            setStatements(pstmt, parameters);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
    }

    private static String getGetterName(Field field) {
        String valiny = field.getName().substring(0, 1);
        valiny = valiny.toUpperCase();
        valiny += field.getName().substring(1);
        return "get" + valiny;
    }

    private static String getSetterName(Field field) {
        String valiny = field.getName().substring(0, 1);
        valiny = valiny.toUpperCase();
        valiny += field.getName().substring(1);
        return "set" + valiny;
    }

    private static Method getGetter(Class<?> classe, Field field) throws Exception {
        String getterName = getGetterName(field);
        return classe.getMethod(getterName);
    }

    private static Method getSetter(Class<?> classe, Field field) throws Exception {
        String setterName = getSetterName(field);
        return classe.getMethod(setterName, field.getType());
    }

    private static List<Object> getValuesOf(Object object) throws Exception {
        List<Object> valiny = new ArrayList<Object>();
        Field[] attribut = object.getClass().getDeclaredFields();
        for (int i = 0; i < attribut.length; i++) {
            if (attribut[i].isAnnotationPresent(Colonne.class) && !DbUtil.isByDefault(object, attribut[i])) {
                Colonne collone = attribut[i].getAnnotation(Colonne.class);
                if (!collone.identifiant()) {
                    Method method = getGetter(object.getClass(), attribut[i]);
                    valiny.add(method.invoke(object));
                }
            }
        }
        return valiny;
    }

    private static Hashtable<String, Object> getIdentifiant(Object object) throws Exception {
        Hashtable<String, Object> valiny = new Hashtable<String, Object>();
        Field[] attributs = object.getClass().getDeclaredFields();
        for (int i = 0; i < attributs.length; i++) {
            if (attributs[i].isAnnotationPresent(Colonne.class)) {
                Colonne collone = attributs[i].getAnnotation(Colonne.class);
                if (collone.identifiant()) {
                    Method getter = getGetter(object.getClass(), attributs[i]);
                    valiny.put("valeur", getter.invoke(object));
                    valiny.put("identifiant", collone.collone());
                    return valiny;
                }
            }
        }
        throw new Exception("Cette object ne possède pas d'identifiant");
    }

    private static Object getValueIn(Object object, Field field) throws Exception {
        Method getter = getGetter(object.getClass(), field);
        return getter.invoke(object);
    }

    private static boolean isByDefault(Object object, Field field) throws Exception {
        Object objectTest = getValueIn(object, field);
        if (objectTest.getClass() == Integer.class) {
            int value = (int) objectTest;
            if (value == 0) {
                return true;
            }
        } else if (objectTest.getClass() == Float.class) {
            float value = (float) objectTest;
            if (value == 0) {
                return true;
            }
        } else if (objectTest.getClass() == Double.class) {
            double value = (double) objectTest;
            if (value == 0) {
                return true;
            }
        } else {
            if (objectTest == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param object l'object a inséré dans la base de donnée
     * @throws Exception
     */
    public void insert(Object object) throws Exception {
        Connection connection = null;
        try {
            connection = this.getConnection();
            connection.setAutoCommit(false);
            DbUtil.insert(connection, object);
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * @param connection connection a utilisé
     * @param object     l'objet a inséré dans la base de donnée
     * @throws Exception
     */
    public static void insert(Connection connection, Object object) throws Exception {
        Class<?> classObject = object.getClass();
        if (!classObject.isAnnotationPresent(Table.class)) {
            throw new Exception("Vous devez utiliser l'annotation table " + classObject.getSimpleName()
                    + " pour que ce framework marche");
        }
        Table table = classObject.getAnnotation(Table.class);
        String request = "insert into " + table.table() + "(";
        Field[] attribut = classObject.getDeclaredFields();
        String valeurs = "";
        for (int i = 0; i < attribut.length; i++) {
            if (attribut[i].isAnnotationPresent(Colonne.class) && !isByDefault(object, attribut[i])) {
                Colonne colloneUsed = attribut[i].getAnnotation(Colonne.class);
                if (!colloneUsed.identifiant()) {
                    request += colloneUsed.collone() + ",";
                    valeurs += "?,";
                }
            }
        }
        request = request.substring(0, request.length() - 1);
        valeurs = valeurs.substring(0, valeurs.length() - 1);
        request += ") values(" + valeurs + ")";
        execute(connection, request, getValuesOf(object));
    }

    /**
     * @param object l'objet a modifier dans la base de donnée
     * @throws Exception
     */
    public void update(Object object) throws Exception {
        Connection connection = null;
        try {
            connection = this.getConnection();
            connection.setAutoCommit(false);
            DbUtil.update(connection, object);
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * @param connection connection a utilisé
     * @param object     l'objet a modifié dans la base de donnée
     * @throws Exception
     */
    public static void update(Connection connection, Object object) throws Exception {
        Class<?> classObject = object.getClass();
        if (!classObject.isAnnotationPresent(Table.class)) {
            throw new Exception("Vous devez utiliser l'annotation table " + classObject.getSimpleName()
                    + " pour que ce framework marche");
        }
        Table table = classObject.getAnnotation(Table.class);
        String request = "update " + table.table() + " set ";
        Field[] attribut = classObject.getDeclaredFields();
        for (int i = 0; i < attribut.length; i++) {
            if (attribut[i].isAnnotationPresent(Colonne.class) && !isByDefault(object, attribut[i])) {
                Colonne colloneUsed = attribut[i].getAnnotation(Colonne.class);
                if (!colloneUsed.identifiant()) {
                    request += colloneUsed.collone() + "=?,";
                }
            }
        }
        Hashtable<String, Object> identifiant = getIdentifiant(object);
        request = request.substring(0, request.length() - 1) + " where " + (String) identifiant.get("identifiant")
                + "=?";
        System.out.println(request);
        List<Object> parameters = getValuesOf(object);
        parameters.add(identifiant.get("valeur"));
        execute(connection, request, parameters);
    }

    /**
     * @param object l'objet a supprimer dans la base de donnée
     * @throws Exception
     */
    public void delete(Object object) throws Exception {
        Connection connection = null;
        try {
            connection = this.getConnection();
            connection.setAutoCommit(false);
            DbUtil.delete(connection, object);
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * @param connection la connection a utilisé
     * @param object     l'objet a supprimer dans la base de donnée
     * @throws Exception
     */
    public static void delete(Connection connection, Object object) throws Exception {
        Class<?> classObject = object.getClass();
        if (!classObject.isAnnotationPresent(Table.class)) {
            throw new Exception("Vous devez utiliser l'annotation table sur " + classObject.getSimpleName()
                    + " pour que ce framework marche");
        }
        Table table = classObject.getAnnotation(Table.class);
        String request = "delete from " + table.table();
        Hashtable<String, Object> identifiant = getIdentifiant(object);
        request += " where " + (String) identifiant.get("identifiant") + "=?";
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(identifiant.get("valeur"));
        execute(connection, request, parameters);
    }

    /**
     * @param <T>
     * @param classe  la classe dominante
     * @param request la requête sql
     * @return une liste contenant un hashtable avec le nom du classe comme clé ou
     *         le nom du colonne dans la base de donnée
     * @throws Exception
     */
    public <T> List<Hashtable<String, Object>> getSelect(Class<T> classe, String request) throws Exception {
        return getSelect(classe, request, new ArrayList<Object>());
    }

    /**
     * @param <T>
     * @param classe     la classe dominante
     * @param request    la requête sql avec des paramètres
     * @param parameters les paramètres à inséré
     * @return une liste contenant un hashtable avec le nom du classe comme clé ou
     *         le nom du colonne dans la base de donnée
     * @throws Exception
     */
    public <T> List<Hashtable<String, Object>> getSelect(Class<T> classe, String request, List<Object> parameters)
            throws Exception {
        List<Hashtable<String, Object>> valiny = new ArrayList<Hashtable<String, Object>>();
        Connection connection = null;
        try {
            connection = this.getConnection();
            valiny = DbUtil.getSelect(connection, classe, request, parameters);
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return valiny;
    }

    /**
     * @param <T>
     * @param connection connection a utilisé
     * @param classe     la classe dominante
     * @param request    la requête sql avec des paramètres
     * @param parameters les paramètres à inséré
     * @return une liste contenant un hashtable avec le nom du classe comme clé ou
     *         le nom du colonne dans la base de donnée
     * @throws Exception
     */
    public static <T> List<Hashtable<String, Object>> getSelect(Connection connection, Class<T> classe, String request,
            List<Object> parameters) throws Exception {
        List<Hashtable<String, Object>> response = getSelect(connection, request, parameters);
        response = castIn(classe, response);
        return response;
    }

    /**
     * @param <T>
     * @param classe la classe a utilisé
     * @param liste  la liste a convertir en la classe utilisé
     * @return une liste contenant un hashtable avec le nom du classe comme clé ou
     *         le nom du colonne dans la base de donnée
     * @throws Exception
     */
    public static <T> List<Hashtable<String, Object>> castIn(Class<T> classe, List<Hashtable<String, Object>> liste)
            throws Exception {
        Field[] attributs = classe.getDeclaredFields();
        for (int i = 0; i < liste.size(); i++) {
            Constructor constructor = classe.getConstructor();
            Object recep = constructor.newInstance();
            for (int e = 0; e < attributs.length; e++) {
                if (attributs[e].isAnnotationPresent(Colonne.class)) {
                    Colonne collone = attributs[e].getAnnotation(Colonne.class);
                    if (liste.get(i).containsKey(collone.collone())) {
                        Method setter = getSetter(classe, attributs[e]);
                        invokeSetter(setter, recep, liste.get(i).get(collone.collone()));
                        liste.get(i).remove(collone.collone());
                    }
                }
            }
            liste.get(i).put(classe.getSimpleName(), recep);
        }
        return liste;
    }

    /**
     * @param <T>
     * @param classe la classe a utilisé
     * @param liste  la liste a convertir en la classe utilisé
     * @return une liste contenant la classe utilisé
     * @throws Exception
     */
    public static <T> List<T> castInSpecial(Class<T> classe, List<Hashtable<String, Object>> liste) throws Exception {
        List<T> valiny = new ArrayList<T>();
        Field[] attributs = classe.getDeclaredFields();
        for (int i = 0; i < liste.size(); i++) {
            Constructor constructor = classe.getConstructor();
            Object recep = constructor.newInstance();
            for (int e = 0; e < attributs.length; e++) {
                if (attributs[e].isAnnotationPresent(Colonne.class)) {
                    Colonne collone = attributs[e].getAnnotation(Colonne.class);
                    if (liste.get(i).containsKey(collone.collone())) {
                        Method setter = getSetter(classe, attributs[e]);
                        invokeSetter(setter, recep, liste.get(i).get(collone.collone()));
                        liste.get(i).remove(collone.collone());
                    }
                }
            }
            valiny.add((T) recep);
        }
        return valiny;
    }

    private static void setStatements(PreparedStatement pstmt, List<Object> parameters) throws Exception {
        for (int i = 0; i < parameters.size(); i++) {
            pstmt.setObject(i + 1, parameters.get(i));
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}