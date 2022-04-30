/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package notTwitter.models;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import notTwitter.DBConnection;
import notTwitter.models.UserModel;
import notTwitter.models.Tweet_Model;


/** Used to upload an image file
 *  Selected from computer with a prompt
 * @author bgebo
 */
@MultipartConfig(maxFileSize = 1000000)
public class TweetWithImg extends HttpServlet {

    /**This bit is for when used for user profile 
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

        InputStream inputStream = null; // input stream of the upload file
        String fileName = "";
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("file");
        if (filePart != null) {
            fileName = extractFileName(filePart);
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        try {
            HttpSession session = request.getSession();
            String username = session.getAttribute("username").toString();
            String text = request.getParameter("tweet_text");
            Connection connection2 = DBConnection.getDBConnection();
            String query2 = "select id FROM user where "
                        + " username = ?";
                
            PreparedStatement statement2 = connection2.prepareStatement(query2);
            statement2.setString(1, username);
            ResultSet results = statement2.executeQuery(); 
            while(results.next())
            {
                int userid = results.getInt("id");
                try
                {

                    Connection connection = DBConnection.getDBConnection();
                    String preparedSQL = "insert into tweet ( text, user_id, image, image_filename ) "
                            + " values ( ?, ?, ?, ? )";
                    PreparedStatement preparedStatement = connection.prepareStatement(preparedSQL);

                    // index starts at 1?
                    preparedStatement.setString(1, text);
                    preparedStatement.setInt(2, userid);
                    preparedStatement.setBlob(3, inputStream);
                    preparedStatement.setString(4, fileName);
                    

                    preparedStatement.execute();

                    preparedStatement.close();
                    connection.close();
                    

                    
                } catch (SQLException ex) {
                    request.setAttribute("error", ex.toString());
                    String url = "/error.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                } catch (ClassNotFoundException ex)
                {
                    request.setAttribute("error", ex.toString());
                    String url = "/error.jsp";
                    getServletContext().getRequestDispatcher(url).forward(request, response);



                }
            }
            results.close();
            statement2.close();
            connection2.close();
            String url = "/Not_Twitter";
            getServletContext().getRequestDispatcher(url).forward(request, response);
           
        }catch(Exception e)
        {
            
        }
    }

    public static String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
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
