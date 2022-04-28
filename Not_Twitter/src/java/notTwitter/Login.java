/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notTwitter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import notTwitter.models.UserModel;
/** Login page controler
 *
 * @author bgebo
 */
public class Login extends HttpServlet
{
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
      {
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "";
        }
        switch(action)
        {
            case "Login":
            {
                String UsernameOrEmail = request.getParameter("username_email");
                String Password = request.getParameter("password");
                //Check for a null
                if(Password == null || UsernameOrEmail == null)
                {
                    String Error = "You must enter both a username/email, and "
                            + "password.";
                    request.setAttribute("Error", Error);
                    String url = "/error.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                }
                //Try catch for checking if the username/email and the password match the DB
                try
                {
                     String hashedPassword = hash(Password);
                     User primaryUser = new User(0, UsernameOrEmail, hashedPassword);
                     //Check if the login works
                     if(UserModel.login(primaryUser))
                     {
                         HttpSession session = request.getSession();
                         session.setAttribute("username", primaryUser.getUsername());
                         session.setAttribute("hasImage", UserModel.hasImage(primaryUser.getUsername()));
                         response.sendRedirect("Not_Twitter");
                     }
                     else
                     {
                         String error = "invalid username or password";
                         request.setAttribute("error", error);
                         String url = "/error.jsp";
                         getServletContext().getRequestDispatcher(url).forward(request, response);
                     }
                }catch(Exception ex)
                {
                     exceptionPage(ex, request, response);
                }
                break;
            }
            case "Make_New":
            {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");

                if ( username == null || password == null || email == null)
                {
                    String error = "username or password missing";
                    request.setAttribute("error", error);
                    String url = "/error.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    
                }
                try
                {
                    String hashedPassword = hash(password);
                
                    User newUser = new User(0, username, hashedPassword, email);
                
                    UserModel.addUser(newUser);
                    HttpSession session = request.getSession();
                    session.setAttribute("username", newUser.getUsername());
                    session.setAttribute("hasImage", UserModel.hasImage(newUser.getUsername()));
                    response.sendRedirect("Not_Twitter");
                    
                }catch(Exception ex)
                {
                    exceptionPage(ex, request, response);
                }
               
            }
            default:
            {
                String url = "/login.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);   
                  
            }
        }
        
         
        
        
      }
      
    //Hashes password with SHA, only page which does this
    private static String hash(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA 
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] byteHash = md.digest(input.getBytes(StandardCharsets.UTF_8));
        //Convert to hex string
        BigInteger number = new BigInteger(1, byteHash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
    
    
    //Exception page initiator in the case it is needed
    private void exceptionPage(Exception ex, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
      String error = ex.toString();
      request.setAttribute("error", error);
      String url = "/error.jsp";
      getServletContext().getRequestDispatcher(url).forward(request, response);
    }
    //Checks if user is logged in and returns a bool
    public static boolean checkUserIsLoggedIn( HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String sessionUserName = (String)session.getAttribute("username");
        return sessionUserName != null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
