package com.mycompany.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void foo()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        com.mysql.jdbc.Driver s;
        String url="jdbc:mysql://localhost:3386";
        String username="root";
        String password="";
        Connection c= DriverManager.getConnection(url, username,password);
        
    }
}
