package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private final static String HOST = "localhost";
    private final static String PORT = "3307";
    private final static String BD = "foodbyte";
    private final static String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+BD;
    private final static String USUARIO = "root";
    private final static String SENHA = "";
    
    public static Connection getConnection(){
        Connection conexao = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return(conexao);
    }
    
}
