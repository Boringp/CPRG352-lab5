package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import service.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.*;

/**
 *
 * @author bo
 */
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(request.getParameter("logout")!=null){
            session.invalidate();
            session = request.getSession();
            boolean justLogout=true;
            session.setAttribute("justLogout", justLogout);
            response.sendRedirect("login");
            
            return;
        }
        if((User)session.getAttribute("user")==null){
            
            getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
        }
        else{
            
             response.sendRedirect("home");
        }
         
         return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
        
       String username=request.getParameter("username");
       String password=request.getParameter("password");
        session.setAttribute("username", username);
         session.setAttribute("password", password);
       User user = null;
       if((username!=null||username!="")&&(password!=null||password!="")){
        
          AccountService as = new AccountService();
          user =as.login(username,password);
          
          if(user!=null){
               session.setAttribute("user", user);
               response.sendRedirect("home");
          }
          else{
              session.setAttribute("justLogout", false);
               boolean error = true;
               request.setAttribute("error", error);
               getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
            return;
          }
       }
       
       
    }


}
