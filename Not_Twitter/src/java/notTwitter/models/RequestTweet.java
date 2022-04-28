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
import java.sql.Timestamp;
import notTwitter.DBConnection;
import notTwitter.Tweet;
import notTwitter.User;
import notTwitter.models.UserModel; 
/**
 *
 * @author bgebo
 */
public class RequestTweet 
{
        public static ArrayList<Tweet> getAllTweet()
        {
            ArrayList<Tweet> allTweets = new ArrayList();
            try
            {
                Connection connection = DBConnection.getDBConnection();
                String query = "select id,text,user_id, timestamp, image_filename FROM tweet";
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet results = statement.executeQuery(); 
                while(results.next())
                {
                    if(results.getString("image_filename") == null)
                    {
                        String text = results.getString("text");
                        Timestamp timestamp = results.getTimestamp("timestamp");
                        int id = results.getInt("id");
                        int user_id = results.getInt("user_id");
                        Tweet currentTweet = new Tweet(id, text, user_id, null, timestamp);
                        allTweets.add(currentTweet);
                    }
                    else
                    {
                        String text = results.getString("text");
                        Timestamp timestamp = results.getTimestamp("timestamp");
                        int id = results.getInt("id");
                        int user_id = results.getInt("user_id");
                        String filename = results.getString("image_filename");
                        Tweet currentTweet = new Tweet(id, text, user_id, filename, timestamp);
                        allTweets.add(currentTweet);
                    }
                }
                return allTweets;
            }catch(Exception e)
            {
               System.out.println(e);
               return allTweets; 
            }
            
        }
}
