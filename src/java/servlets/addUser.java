/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author I342042
 */
@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
public class addUser extends HttpServlet {

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
        
         HttpSession session = request.getSession();
        
        ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
        
        String mail = request.getParameter("mail");
          if(mail.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("addUser.html");
            rd.forward(request, response);
        }
          else
        list.add(mail);
        
      
        try (PrintWriter out = response.getWriter()) {
            
            RequestDispatcher rd = request.getRequestDispatcher("displayList.jsp");
            
            rd.forward(request, response);
        }
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
         HttpSession session = request.getSession();
         ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
        
        String mail = request.getParameter("mail");
          if(mail.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("addUser.html");
            rd.forward(request, response);
        }
          else
        list.add(mail);
          
         RequestDispatcher rd = request.getRequestDispatcher("displayList.jsp");
            rd.forward(request, response);
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

    
     private boolean test(String mail) {
       if(mail.length() > 0){
           return true;
       }
       return false;
     }
     
}
