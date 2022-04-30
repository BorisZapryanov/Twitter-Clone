/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notTwitter;
import notTwitter.models.Tweet_Model;
import java.sql.Timestamp;

/**
 *
 * @author bgebo
 */
public class Tweet 
{
    private int id;
    private String text;
    private int userid;
    private String filename;
    private Timestamp timestamp;
    private boolean likedbyuser;
    private int likecount;

    

    public Tweet(String text, int userid) {
        this(0, text, userid, null, null, false, 0);
    }
    
    public Tweet(String text, int userid, String filename) {
        this(0, text, userid, filename, null, false, 0);
    }

    public Tweet(int id, String text, int userid, String filename, Timestamp timestamp, boolean likedByUser, int likeCount) {
        this.id = id;
        this.text = text;
        this.userid = userid;
        this.filename = filename;
        this.timestamp = timestamp;
    }

    
    
    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getUserid() {
        userid = Tweet_Model.getTweetUser(id);
        return userid;
    }

    public String getFilename() {
        return filename;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
    
   public boolean isLikedbyuser() {
        likedbyuser = Tweet_Model.getLikedByUser(id, "Ari");
        return likedbyuser;
    }
   public String getUserName()
   {
       String userName = Tweet_Model.getTweetUsername(userid);
       return userName;
   }
    public int getLikecount() 
    {
        likecount = Tweet_Model.getLikeCount(id);
        return likecount;
    }
    
}
