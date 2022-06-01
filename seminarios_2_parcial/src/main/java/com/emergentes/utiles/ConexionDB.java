
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3309/bd_seminarios";
    static String usuario = "root";
    static String password = "";

    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url, usuario, password);
            if(conn != null){
                System.out.println("Conexcion OK" + conn);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR EN DRIVER" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("ERROR AL CONECTAR" + ex.getMessage());
        }

    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("ERROR AL DESCONECTAR" + ex.getMessage());
        }
    }
}
