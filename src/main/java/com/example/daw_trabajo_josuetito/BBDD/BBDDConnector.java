package com.example.daw_trabajo_josuetito.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDDConnector {
    private static BBDDConnector instance;
    private static final String JCDB_URL = "jdbc:mysql://localhost:3306/trabajo?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "6267";

    private Connection con;

    public BBDDConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");     // Si no encuentra el driver MYSQL usar el Class.forName
            con = DriverManager.getConnection(JCDB_URL,USER,PASS);

            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("ERROR. NO SE HA ESTABLECIDO LA CONEXIÓN CON LA BBDD");
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            //System.out.println("error");
            throw new RuntimeException(e);
        }
    }

    public static BBDDConnector GetInstance(){
        if (instance == null) {
            instance = new BBDDConnector();
        }
        return instance;
    }

    public Connection GetConnection() {
        return con;
    }


}
