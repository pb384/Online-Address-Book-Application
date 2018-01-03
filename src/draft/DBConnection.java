/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draft;



/**
 *
 * @author Saraff
 */
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author Saraff
 */
public class DBConnection {
    public static Connection con = null;
    
    public static Statement getConnection(){
        PreparedStatement ps=null;
	Statement stmt =null;
        if(con == null){
	 try
	  {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();  
            config.enforceForeignKeys(true);
            con=DriverManager.getConnection("jdbc:sqlite:/Users/Saraff/Desktop/Spring2017/Java/Database.db",config.toProperties());
            JOptionPane.showMessageDialog(null, "Connection Established");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }try
    {
	stmt=con.createStatement();
    }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e);
	}
    return stmt;
    }
}