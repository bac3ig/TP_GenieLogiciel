/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sarah
 */
public class Conexion {
    
    static Connection conn=null;
    static String database="stock";
    static String user="root";
    static String pwd="";
    
    static{
        
       try{
            
        Class.forName("com.mysql.cj.jdbc.Driver");
      
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database,user,pwd);
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }
    
    
}
