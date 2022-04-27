/* Gets a database connection,
 * then returns it
 */
package notTwitter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Makes the conection to 
 *  Database and returns it
 * @author bgebo
 */
public class DBConnection 
{
    //Gets and returns the connection, basic driver force load like you showed us
    public static Connection getDBConnection()
            throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        String dbURL = "jdbc:mysql://localhost:3306/twitter_winter2022";
        String username = "store";
        String password = "test";
        Connection connection = DriverManager.getConnection(dbURL, username, password);
        return connection;
    }
}
