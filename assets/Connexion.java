package com.gbd.connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion{

    public static Connection getConnexion()
    {
        Connection connect = null;
            try{
                Class.forName("org.postgresql.Driver");
                connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/datbase","postgres","postgres");
            }
            catch(Exception e){
                
            }
            return connect;
    }

        public static String testConnex() throws Exception {
            Connection connect = null;
            String res = "oui";
            connect = Connexion.getConnexion();
            if(connect == null) {
                res = "non";
            } else {
                return res;
            }
            return res;
        }
    
        public static void closeConnection(Connection connection) {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed successfully.");
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }

}