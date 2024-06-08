public Connection getConnection()
    retourne une connection avec la base de données

    Remarque: vous devez d'abord mettre les paramètres de connexions sur un config.xml

public List<Hashtable<String,Object>> getSelect(String request)
    retourne une liste contenant un hashtable(hashmap) du réponse du requête

    Exemple:
        List<Hashtable<String,Object>> test=utildb.getSelect("select * from utilisateur");
        //Pour avoir la nème ligne et la collone nomCollonne
        test.get(n).get("nomCollone");

public List<Hashtable<String,Object>> getSelect(String request,List<Object> parameters)
    retourne une liste contenant un hashtable(hashmap) du réponse du requête avec un ou des paramètres a changer

    Exemple:
        List<Object> parametres=new List<Object>();
        parametres.add(1);
        parametres.add(2);
        List<Hashtable<String,Object>> test=utildb.getSelect("select * from utilisateur where idUtilisateur = ? and idSecteur = ?",parametres);

public static List<Hashtable<String,Object>> getSelect(Connection connection,String request)
    retourne une liste contenant un hashtable(hashmap) du réponse du requête avec une connexion a utilisé

public static List<Hashtable<String,Object>> getSelect(Connection connection,String request,List<Object> parameters)
    retourne une liste contenant un hashtable(hashmap) du réponse du requête avec un ou des paramètres a changer avec un connexion a utilisé

public <T> List<T> getSelectAndCast(String request,Class<T> classe)
    retourne une liste contenant la classe que vous avez inséré dans le paramètre provenant du réponse du requête

    Exemple:
        List<Utilisateur> utilisateurs = getSelectAndCast("select * from utilisateur",Utilisateur.class);

    Remarque:
        Les données en retour stockés sont seulement ce qui est stockable dans cette classe, conforme aux attributs de cette classe

public static <T> List<T> getSelectAndCast(Connection connection,String request,Class<T> classe)
    retourne une liste contenant la classe que vous avez inséré dans le paramètre avec une connexion a utilisé provenant du réponse du requête

public <T> List<T> getSelectAndCast(String request,List<Object> parameters,Class<T> classe)
    retourne une liste contenant la classe que vous avez inséré dans le paramètre provenant du réponse du requête et en utilisant des parametres sur ce requête

    Exemple:
        List<Object> parametres=new List<Object>();
        parametres.add(1);
        parametres.add(2);
        List<Utilisateur> test=utildb.getSelect("select * from utilisateur where idUtilisateur = ? and idSecteur = ?",parametres,Utilisateur.class);

public static <T> List<T> getSelectAndCast(Connection connection,String request,List<Object> parameters,Class<T> classe)
    retourne une liste contenant la classe que vous avez inséré dans le paramètre provenant du réponse du requête et en utilisant des parametres sur ce requête avec une connection a utilisé

public void execute(String request)
    execute la requête que vous voulez effectuer
    
    Exemple:
        utildb.execute("insert into utilisateur(nom) values('Nom')");

public void execute(String request,List<Object> parameters)
    execute la requête que vous voulez effectuer avec des paramètres dans la requête

    Exemple:
        List<Object> parametres=new List<Object>();
        parametres.add("Nom");
        utildb.execute("insert into utilisateur(nom) values(?)",parametres);

public static void execute(Connection connection,String request)
    execute la requête que vous voulez effectuer avec une connexion a utilisé

public static void execute(Connection connection,String request,List<Object> parameters)
    execute la requête que vous voulez effectuer avec des paramètres dans la requête et avec une connection a utilisé

public void insert(Object object)
    insert l'objet dans la base de données

    Exemple:
        Utilisateur utilisateur=new Utilisateur("Nom");
        utildb.insert(utilisateur);

public static void insert(Connection connection,Object object)
    insert l'object dans la base de données avec une connection a utilisé

public void update(Object object)
    modifie l'objet dans la base de données

    Exemple:
        Utilisateur utilisateur=new Utilisateur(1,"Nom");
        utildb.update(utilisateur);

    Remarque:
        Vous devez ajouter l'identifiant de l'objet

public static void update(Connection connection,Object object)
    modifie l'objet dans la base de données avec une connection a utilisé

public void delete(Object object)
    supprime l'objet dans la base de données

    Exemple:
        Utilisateur utilisateur=new Utilisateur(1);
        utildb.delete(utilisateur);

    Remarque:
        Vous devez ajouter l'identifiant de l'objet

public static void update(Connection connection,Object object)
    supprime l'objet dans la base de données avec une connection a utilisé

public <T> List<Hashtable<String,Object>> getSelect(Class<T> classe,String request)
    retourne une liste contenant un hashtable provenant du requête tout en assemblant tout ce qui est assemblable dans la classe en utilisant le nom de la classe comme clé

    Exemple:
        List<Hashtable<String,Object>> valiny=getSelect(Utilisateur.class,"select * from utilisateur natural join diplome");
        //Pour accéder aux données du nème ligne des utilisateurs
        (Utilisateur)valiny.get(n).get("Utilisateur");
        //Pour accéder aux données du nème ligne des diplomes
        (String)valiny.get(n).get("diplome");

public <T> List<Hashtable<String,Object>> getSelect(Class<T> classe,String request,List<Object> parameters)
    retourne une liste contenant un hashtable provenant du requête avec des parametres tout en assemblant tout ce qui est assemblable dans la classe en utilisant le nom de la classe comme clé

public static <T> List<Hashtable<String,Object>> getSelect(Connection connection,Class<T> classe,String request,List<Object> parameters)
    retourne une liste contenant un hashtable provenant du requête avec des parametres tout en assemblant tout ce qui est assemblable dans la classe en utilisant le nom de la classe comme clé avec une connection a utilisé

