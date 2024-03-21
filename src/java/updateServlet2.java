/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DARSHAN
 */
public class updateServlet2 extends HttpServlet {

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
        
        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();
        if(!session.getId().equals(session.getAttribute("key"))){
            response.sendRedirect("index.jsp");
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Connection con = null;
            Statement st = null;
            
            String url = sc.getInitParameter("url");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
            
            PreparedStatement pr = con.prepareStatement("update student set f_name=?,l_name=?,stream=? where roll_no="+request.getParameter("roll_no")+";");
//            pr.setInt(1, Integer.parseInt((String) request.getParameter("roll_no")));
            pr.setString(1, (String) request.getParameter("fname"));
            pr.setString(2, (String) request.getParameter("lname"));
            pr.setString(3, (String) request.getParameter("stream"));
//            pr.setInt(4, Integer.parseInt((String) request.getParameter("roll_no")));
            int check = pr.executeUpdate();
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateServlet2</title>");            
            out.println("</head>");
            out.println("<body><style>"
                    + "th{\n" +
                        "                background-color: aquamarine;\n" +
                        "            }\n" +
                        "            td{\n" +
                        "                background-color: aqua;\n" +
                        "            }\n" +
                        "            body{\n" +
                        "                background-color: antiquewhite;\n" +
                        "            }\n" +
                        "            button{\n" +
                        "                background-color: aquamarine;\n" +
                        "            }"
                    + "</style>");
            out.println("<table border=1 cellspacing=0 align='center'>");
            if(check>=1){
                out.println("<tr><td>Data updated!</td></tr>");
                out.println("<tr><td align='center'><button onclick=\"document.location='index.jsp'\">Home</button></td></tr>");
                
            }else{
                out.println("<tr><td>"+request.getParameter("roll_no")+"Data cannot updated!</td></tr>");
            }
            
            out.println("</table></body>");
            out.println("</html>");
        }catch(Exception e){
            e.printStackTrace();
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
