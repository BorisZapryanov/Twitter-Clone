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
public class Tweet_Model 
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
                        Tweet currentTweet = new Tweet(id, text, user_id, null, timestamp, false, 0);
                        allTweets.add(currentTweet);
                    }
                    else
                    {
                        String text = results.getString("text");
                        Timestamp timestamp = results.getTimestamp("timestamp");
                        int id = results.getInt("id");
                        int user_id = results.getInt("user_id");
                        String filename = results.getString("image_filename");
                        Tweet currentTweet = new Tweet(id, text, user_id, filename, timestamp, false, 0);
                        allTweets.add(currentTweet);
                    }
                }
                 results.close();
                statement.close();
                connection.close();
                
                return allTweets;
            }catch(Exception e)
            {
               System.out.println(e);
               return allTweets; 
            }
            
        }
        public static ArrayList<Tweet> getAllTweetUser(String username)
        {
            ArrayList<Tweet> allTweetsUser = new ArrayList();
            try{
                int userId = 0;
                Connection connection2 = DBConnection.getDBConnection();
                String query2 = "select id FROM user where username = ?";
                
                PreparedStatement statement2 = connection2.prepareStatement(query2);
                statement2.setString(1, username);
                ResultSet results2 = statement2.executeQuery(); 
                while(results2.next())
                {
                    userId = results2.getInt("id");
                    try
                    {
                        Connection connection = DBConnection.getDBConnection();
                        String query = "select id,text,user_id, timestamp, image_filename FROM tweet"
                                + " where user_id = ?";
                        PreparedStatement statement = connection.prepareStatement(query);
                        statement.setInt(1, userId);
                        ResultSet results = statement.executeQuery(); 
                        while(results.next())
                        {
                            if(results.getString("image_filename") == null)
                            {
                                String text = results.getString("text");
                                Timestamp timestamp = results.getTimestamp("timestamp");
                                int id = results.getInt("id");
                                int user_id = results.getInt("user_id");
                                Tweet currentTweet = new Tweet(id, text, user_id, null, timestamp, false, 0);
                                allTweetsUser.add(currentTweet);
                            }
                            else
                            {
                                String text = results.getString("text");
                                Timestamp timestamp = results.getTimestamp("timestamp");
                                int id = results.getInt("id");
                                int user_id = results.getInt("user_id");
                                String filename = results.getString("image_filename");
                                Tweet currentTweet = new Tweet(id, text, user_id, filename, timestamp, false, 0);
                                allTweetsUser.add(currentTweet);
                            }
                        }
                         results.close();
                        statement.close();
                        connection.close();

                        return allTweetsUser;
                    }catch(Exception e)
                    {
                        
                    }
                    
                    }
                    results2.close();
                    statement2.close();
                    connection2.close();
                    
            }catch(Exception e)
            {
               System.out.println(e);
               return allTweetsUser; 
            }
            return allTweetsUser;
        }
        
        /** To start, I know that this is an awful way to do this
         *  but for the purpose it is still the most convinient
         *  currently for me. 
         * @param tweetId
         * @return 
         */
        public static int getTweetUser(int tweetId)
        {
            try
            {
                int userId = 0;
                Connection connection = DBConnection.getDBConnection();
                String query = "select user_id FROM tweet where id = ?";
                
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, tweetId);
                ResultSet results = statement.executeQuery(); 
                while(results.next())
                {
                    userId = results.getInt("user_id");
                    
                }
                results.close();
                statement.close();
                connection.close();
                return userId;
                
            }catch(Exception e)
            {
               System.out.println(e);
               
            }
            return 0;
        }
        
        public static String getTweetUsername(int userId)
        {
            try
            {
                String userName = "";
                Connection connection = DBConnection.getDBConnection();
                String query = "select username FROM user where id = ?";
                
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, userId);
                ResultSet results = statement.executeQuery(); 
                while(results.next())
                {
                    userName = results.getString("username");
                    
                }
                results.close();
                statement.close();
                connection.close();
                return userName;
                
            }catch(Exception e)
            {
               System.out.println(e);
               
            }
           
            return "";
        }
        public static int getLikeCount(int tweetId)
        {
            try
            {
                int likeCount = 0;
                Connection connection = DBConnection.getDBConnection();
                String query = "select id, tweet_id FROM liked_tweet";
                
                PreparedStatement statement = connection.prepareStatement(query);
                
                ResultSet results = statement.executeQuery(); 
                while(results.next())
                {
                    if(tweetId == results.getInt("tweet_id"))
                    {
                        likeCount++;
                    }
                    
                    
                }
                results.close();
                statement.close();
                connection.close();
                return likeCount;
                
            }catch(Exception e)
            {
               System.out.println(e);
               return 0;
            }
            
            
            
        }
        public static boolean getLikedByUser(int tweetId, String username)
        {
             try
            {
                int userId = 0;
                Connection connection = DBConnection.getDBConnection();
                String query = "select id FROM user where"
                        + "username = ?";
                
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                ResultSet results = statement.executeQuery(); 
                while(results.next())
                {
                    try
                    {
                        userId = results.getInt("id");
                        boolean likedByUser = false;
                        Connection connection2 = DBConnection.getDBConnection();
                        String query2 = "select id, tweet_id, user_id FROM liked_tweet where"
                                + "tweet_id = ?";

                        PreparedStatement statement2 = connection2.prepareStatement(query2);
                        statement2.setInt(1, tweetId);
                        ResultSet results2 = statement2.executeQuery(); 
                        while(results2.next())
                        {
                            if(results2.getInt("user_id") == userId)
                            {
                                likedByUser = true;
                            }


                        }
                        results.close();
                        statement.close();
                        connection.close();
                        return likedByUser;

                    }catch(Exception e)
                    {
                       System.out.println(e);
                       return false;
                    }

                    
                    
                }
                results.close();
                statement.close();
                connection.close();
                return false;
                
            }catch(Exception e)
            {
               System.out.println(e);
               return false;
            }
        }
        //Like and unlike
        public static void unLike(int tweetId, String userName)
        {
             try
            {
                int userId = 0;
                Connection connection = DBConnection.getDBConnection();
                String query = "select id FROM user where"
                        + "username = ?";
                
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, userName);
                ResultSet results = statement.executeQuery(); 
                while(results.next())
                {
                    try
                    {
                        userId = results.getInt("id");
                        
                        Connection connection2 = DBConnection.getDBConnection();
                        String query2 = "delete from liked_tweet (tweet_id, user_id)"
                                 + " values ( ?, ?)";
                                

                        PreparedStatement statement2 = connection2.prepareStatement(query2);
                        statement2.setInt(1, tweetId);
                        statement2.setInt(2, userId);
                        statement2.executeQuery(); 
                        
                        
                        statement2.close();
                        connection2.close();
                        

                    }catch(Exception e)
                    {
                       System.out.println(e);
                       
                    }

                    
                    
                }
                results.close();
                statement.close();
                connection.close();
                
            }catch(Exception e)
            {
               System.out.println(e);
               
            }
            
        }
        public static void Like(int tweetId, String userName)
        {
             try
            {
                int userId = 0;
                Connection connection = DBConnection.getDBConnection();
                String query = "select id from user where "
                        + " username = ?";
                
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, userName);
                ResultSet results = statement.executeQuery(); 
                while(results.next())
                {
                    try
                    {
                        userId = results.getInt("id");
                        
                        Connection connection2 = DBConnection.getDBConnection();
                        String query2 = "insert into liked_tweet ( tweet_id, user_id ) "
                                 + " values ( ?, ? )";
                                

                        PreparedStatement statement2 = connection2.prepareStatement(query2);
                        statement2.setInt(1, tweetId);
                        statement2.setInt(2, userId);
                        statement2.execute();
                        
                        
                        statement2.close();
                        connection2.close();
                        

                    }catch(Exception e)
                    {
                       System.out.println(e);
                       
                    }

                    
                    
                }
                results.close();
                statement.close();
                connection.close();
                
            }catch(Exception e)
            {
               System.out.println(e);
               
            }
        }
        //Make Tweet text only
        public static void makeTweet(String text, String username)
        {
            try
            {
                
                Connection connection = DBConnection.getDBConnection();
                String query = "select id FROM user where "
                        + " username = ?";
                
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                ResultSet results = statement.executeQuery(); 
                while(results.next())
                {
                    int userid = results.getInt("id");
                    Tweet newTweet = new Tweet(text, userid);
                    try
                    {
                        Connection connection2 = DBConnection.getDBConnection();
                        String query2 = "insert into tweet ( text, user_id ) "
                            + " values ( ?, ? )";
                        PreparedStatement statement2 = connection2.prepareStatement(query2);
                        statement2.setString(1, newTweet.getText());
                        statement2.setInt(2, userid);
                        statement2.execute();
                        
                        statement2.close();
                        connection2.close();
                    }catch(Exception ex)
                    {
                        
                    }
                    
                    
                }
                results.close();
                statement.close();
                connection.close();
                
                
            }catch(Exception e)
            {
               System.out.println(e);
           
            }
            
        }
                
}
