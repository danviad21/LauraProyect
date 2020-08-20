/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Laura Zarathe
 */
public class Conexion {

    private Conexion() {
    }

    private static Connection con;

    public static Connection getConexion() {

        try {
//            String username = "root";
//            String password = "";
//            String url = "jdbc:mysql://localhost:3306/multicardb?serverTimezone=America/Bogota";
//            String driver = "com.mysql.cj.jdbc.Driver";

            String url = "jdbc:mysql://localhost:3306/multicardb";
            String username = "otdavid";
            String password = "Od@vid1390";
            String driver = "com.mysql.cj.jdbc.Driver";

//            String url = "jdbc:mariadb://localhost:3306/multicardb";
//            String username = "otdavid";
//            String password = "Od@vid1390";
//            String driver = "org.mariadb.jdbc.Driver";

            Class.forName(driver);

            con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("error en la conexion a la base de datos");
            System.out.println(ex);
            return null;
        }
    }

    public static void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
}
