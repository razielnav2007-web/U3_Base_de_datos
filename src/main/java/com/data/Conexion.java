/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
private static final String URL ="jdbc:mysql://localhost:3306/appempresa";
private static final String USER = "root";
private static final String PASSWORD = "1leo123Meraz";

Connection conn = null;

public Connection conectar(){
    
    try{
    conn = DriverManager.getConnection(URL, USER, PASSWORD);
    System.out.println("Conexion establecida");
    
    }catch(Exception ex){
        System.out.println("Exception: " + ex);
    }
    
    return conn;
    
}
    
}
