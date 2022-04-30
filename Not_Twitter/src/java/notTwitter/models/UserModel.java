/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notTwitter.models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import notTwitter.User;
import notTwitter.DBConnection;
/** Used for database interactions with user
 * Objects.
 * @author bgebo
 */
public class UserModel 
{
    public static boolean login(User user )
    {
        try
        {
            Connection connection = DBConnection.getDBConnection();
            
            String query = "select id, username, password, email from user "
                    + " where username = ? ";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, user.getUsername());
            
            ResultSet results = statement.executeQuery();
            
            String password = "";
            if ( results.next() ){
                
                password = results.getString("password");
                
            } 
            //try email instead
            else
            {
                try
                {

                    Connection connectionEmail = DBConnection.getDBConnection();

                    String queryEmail = "select id, username, password, email from user "
                            + " where email = ? ";

                    PreparedStatement statementEmail = connectionEmail.prepareStatement(queryEmail);

                    // indexing starts with 1, why? it's ok to cry
                    statementEmail.setString(1, user.getEmail());

                    ResultSet resultsEmail = statementEmail.executeQuery();
                    
                    if ( resultsEmail.next() ){
                        String h = resultsEmail.getString("email");
                        password = resultsEmail.getString("password");
                    } 
                    //Passing an object is actually passing the pointer of the object
                    //so making changes like this actually carry over
                    user.setUsername(resultsEmail.getString("username"));
                    resultsEmail.close();
                    statementEmail.close();
                    connectionEmail.close();

                    return !password.isEmpty() && user.getPassword().equals(password);
                }
                catch(Exception e)
                {
                     System.out.println(e);
                     return false;
                }
            }
            
            results.close();
            statement.close();
            connection.close();
            return !password.isEmpty() && user.getPassword().equals(password);
            
        }
        
        //Then try the email instead, as per the chance that user logged in with email
        catch ( Exception ex )
        {
            
            System.out.println(ex);
            return false;
        }
    }
     public static void addUser(User user){
        try{
            Connection connection = DBConnection.getDBConnection();
            
            String query = "insert into user ( username, password, email ) "
                    + " values ( ?, ?, ? )";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            
            statement.execute();
            
            statement.close();
            connection.close();
            
        }
        catch ( Exception ex ){
            System.out.println(ex);
        }
     }
     //test if has image
     public static boolean hasImage(String username)
     {
         try
         {
            Connection connection = DBConnection.getDBConnection();
            
            String query = "select filename from user "
                    + " where username = ? ";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, username);
            String filename = null;
            ResultSet results = statement.executeQuery();
            if(results.next())
            {
                filename = results.getString("filename");
            }
            if(filename != null)
            {
                return true;
            }
            results.close();
            statement.close();
            connection.close();
         }catch(Exception e)
         {
         }
         return false;
     }
     public static User getUser(String username)
     {
         User user = null;
         try
         {
            Connection connection = DBConnection.getDBConnection();
            
            String query = "select id, username, filename from user "
                    + " where username = ? ";
            
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, username);
            String filename = null;
            
            int id = 0;
            ResultSet results = statement.executeQuery();
            if(results.next())
            {
                
                filename = results.getString("filename");
                id = results.getInt("id");
            }
            user = new User(id, username, "", filename, "");
            results.close();
            statement.close();
            connection.close();
            return user;
         }catch(Exception e)
         {
             
         }
        return user;
     }
     //get user
     
     //get user arraylist
}
