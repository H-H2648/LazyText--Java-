/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LazyText;
import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author hhong
 */

public class Database {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/MESSAGE";
    //BUNCH OF BUHS ON ADDMESSAGE. EDIT LATER LOL
    public void addMessage(String Nickname, String Message){
        Connection con = null;
        try{
            con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("connected");
            PreparedStatement insert = con.prepareStatement("INSERT INTO message (access, message) VALUES ('" + Nickname +"', '" + Message + "')");
            insert.executeUpdate();
            System.out.println("Insertion successful.");
        }
        catch(SQLException e){
            System.err.println(e);
        }      
        
        
    }
    public String takeMessage (String Key){
        Connection con = null;
        try{
            con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("connected");
            PreparedStatement statement = con.prepareStatement("SELECT message FROM MESSAGE WHERE access = '" + Key + "'");
            ResultSet rs = statement.executeQuery();
            String message = null;
            while(rs.next()){
                message = rs.getString("message");
            }
            return message;
        }
        catch(SQLException e){
            System.err.println(e);
        }      
        return "";
    }
}
