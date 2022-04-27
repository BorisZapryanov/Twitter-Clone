/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notTwitter;

import java.io.Serializable;

/** User object
 *  Is serializable
 * @author bgebo
 */
public class User implements Serializable 
{
    private int id;
    private String username;
    private String password;
    private String filename;
    private String email;
    //For login
    public User(int id, String usernameOrEmail, String password) 
    {
        this(id, usernameOrEmail, password, null, usernameOrEmail);
    }
    //For register new user
    public User(int id, String username, String password, String email)
    {
         this(id, username, password, null, email);
    }
    //Main constructor
    public User(int id, String username, String password, String filename, String email) 
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.filename = filename;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
    
    

}
