/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 *
 */
/** Ari Comments,
 *  This is the primary controller, it is also the welcome app, so it is an auto 
 *  redirect whenever servlet is called.
 * 
 *  loads header
 * 
 *  This pacakge serves as the main controller for the package
 */
package notTwitter;

import java.io.IOException;
import java.io.PrintWriter;



import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import notTwitter.Tweet;
import notTwitter.User;
import notTwitter.models.UserModel;
import notTwitter.models.Tweet_Model;
/**
 *
 * @author icoza
 */
public class Not_Twitter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        //Make null become "" so switch doesnt bug out
        if(action == null)
        {
            action = "Home";
        }
        
        //Check if logged in
        if (Login.checkUserIsLoggedIn(request))
        {
            // would be nice to have a message
           
            request.setAttribute("logged_in", true);
        } 
        else
        {
            request.setAttribute("logged_in", false);
            action = "Login";
        }
        /* Whenever one of these happens, it will redirect to the controller
         * The controller will do stuff like printing out all the tweets
         * Then the controller will pull up the jsp page, which has bits to 
         * defer back to this main controller file
         */
        switch(action)
        {
            //Placeholder, will do a thing to display proper tweets
            case "Home":
            {
                HttpSession session = request.getSession();
                String username = session.getAttribute("username").toString();
                ArrayList<Tweet> allTweet = Tweet_Model.getHomeTweet(username);
                request.setAttribute("allTweets", allTweet);
                String url = "/homepage.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            }
            case "Explore":
            {
                ArrayList<Tweet> allTweet = Tweet_Model.getAllTweet();
                request.setAttribute("allTweets", allTweet);
                String url = "/explore.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
                
            }
            case "All_Users":
            {
                break;
            }
            case "User":
            {
                HttpSession session = request.getSession();
                String username = session.getAttribute("username").toString();
                String searchUsername = request.getParameter("search");
                ArrayList<Tweet> allTweet = Tweet_Model.getAllTweetUser(searchUsername);
                request.setAttribute("allTweets", allTweet);
                User user = UserModel.getUser(searchUsername, username);
                String displayUsername = user.getUsername();
                request.setAttribute("displayUserName", user);
                request.setAttribute("displayUser", user);
                String url = "/user.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            }
            case "Login":
            {
                response.sendRedirect("Login");
                
                break;
            }
            case "Logout":
            {
                HttpSession session = request.getSession();
                session.setAttribute("username",  null);
                
                response.sendRedirect("Not_Twitter");
                break;
            }
            case "Like":
            {
                 int tweetId = Integer.parseInt(request.getParameter("tweetId"));
               
                 String username = request.getParameter("username");
                 Tweet_Model.Like(tweetId, username);
                 response.sendRedirect("Not_Twitter");
                break;
            }
            case "unLike":
            {
                int tweetId = Integer.parseInt(request.getParameter("tweetId"));
                String username = request.getParameter("username");
                Tweet_Model.unLike(tweetId, username);
                response.sendRedirect("Not_Twitter");
                break;
            }
            
            case "Tweet":
            {
                String text = request.getParameter("tweet_text");
                //Since it is a session attribute which means it is an object
                //and also in order to be a bit more responsive
                //I pass the curent username in the jsp as a param
                //and pull the param, I should instead cat to string however
                String username = request.getParameter("userName");
                Tweet_Model.makeTweet(text, username);
                response.sendRedirect("Not_Twitter");
                break;
                
            }
            case "follow":
            {
                String folowee = request.getParameter("folowee");
                String currentUser = request.getParameter("currentUser");
                UserModel.followUser(folowee, currentUser);
                response.sendRedirect("Not_Twitter");
                break;
            }
            case "unFollow":
            {
                String folowee = request.getParameter("folowee");
                String currentUser = request.getParameter("currentUser");
                UserModel.unfollowUser(folowee, currentUser);
                
                response.sendRedirect("Not_Twitter");
                break;
            }
            default:
            {
                String url = "/homepage.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;       
            }
              
            
        }
        
        //Case statment to check the action
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
