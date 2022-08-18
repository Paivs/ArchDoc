package archdoc.docmanager;

import java.sql.*;
public class DocManager {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        connect connect = new connect();
        Connection conexao = connect.connectionMySql();

        System.out.println("é viado");
        System.out.println("teu cu");

    }
}
