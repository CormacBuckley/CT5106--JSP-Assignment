/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author I342042
 */
@WebServlet(name = "getList", urlPatterns = {"/getList"})
public class getList extends HttpServlet {

       ArrayList<String> mailList = new ArrayList<String>();
       

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
         
        session.setAttribute("list", mailList);
        
        String message = "<h2>The list is empty</h2>";
        
        ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
        
        if(list.size() == 0 || list.isEmpty()){
            session.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("message", message);
            rd.forward(request, response);
        }
        
        try (PrintWriter out = response.getWriter()) {
             RequestDispatcher rd = request.getRequestDispatcher("displayList.jsp");
            rd.forward(request, response);
            /* TODO output your page here. You may use following sample code. */
            
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
         
        session.setAttribute("list", mailList);
        
        ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
        
        if(list.size() == 0 || list.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        
      
             RequestDispatcher rd = request.getRequestDispatcher("displayList.jsp");
            rd.forward(request, response);
            /* TODO output your page here. You may use following sample code. */
            
        
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
