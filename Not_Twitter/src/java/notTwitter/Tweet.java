/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notTwitter;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 *
 * @author bgebo
 */
public class Tweet implements Serializable
{
    private int id;
    private String text;
    private int userid;
    private String filename;
    private Timestamp timestamp;

    public Tweet(String text, int userid) {
        this(0, text, userid, null, null);
    }
    
    public Tweet(String text, int userid, String filename) {
        this(0, text, userid, filename, null);
    }

    public Tweet(int id, String text, int userid, String filename, Timestamp timestamp) {
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
        return userid;
    }

    public String getFilename() {
        return filename;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    
    
}
