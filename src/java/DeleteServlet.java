/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class DeleteServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession ssn = request.getSession();
            if(!ssn.getId().equals(ssn.getAttribute("key"))){
                response.sendRedirect("index.jsp");
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet displayServlet</title>");            
            out.println("</head><style>\n" +
                        "            table{\n" +
                        "                width:50%;\n" +
                        "                height: 100px;\n" +
                        "                margin-top: 100px;\n" +
                        "                font-size: 25px;\n" +
                        "            }\n" +
                        "            input{\n" +
                        "                padding: 10px;\n" +
                        "                margin:0px;\n" +
                        "            }th{\n" +
                        "                background-color: aquamarine;\n" +
                        "            }td{\n" +
                        "                background-color: aqua;\n" +
                        "            }\n" +
                        "            body{\n" +
                        "                background-color: antiquewhite;\n" +
                        "            }\n" +
                        "            input{\n" +
                        "                background-color: aquamarine;\n" +
                        "            }\n" +
                        "        </style>");
            out.println("<body><h1 align='center'>Delete Data</h1><table border=1 cellspacing=0 align='center'><tr><th>Roll No</th><th>First Name</th><th>Last Name</th><th>Stream</th><th>Delete</th></tr></tr><tr>");
            
            Connection con = null;
//            ResultSet rs = null;
            Statement st = null;
            ServletContext sc = getServletContext();
            String url = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                url = sc.getInitParameter("url");
                con = DriverManager.getConnection(url,"root","");
                st = con.createStatement();
                ResultSet rs  = st.executeQuery("select * from student");
                String query = "DELETE FROM student WHERE roll_no = ?";
                PreparedStatement pst = con.prepareStatement(query);
                String rollNoParam = request.getParameter("roll_no");
                while(rs.next()){
                    // out.println("<td>"+rs.getInt("roll_no")+"</td><td>"+rs.getString("f_name")+"</td><td>"+rs.getString("l_name")+"</td><td>"+rs.getString("stream")+"</td><td><a href=\"DeleteServlet?roll_no=\" "+rs.getInt("roll_no")+">Delete</a></td></tr>");
                    out.println("<td>" + rs.getInt("roll_no") + "</td><td>" + rs.getString("f_name") + "</td><td>" + rs.getString("l_name") + "</td><td>" + rs.getString("stream") + "</td><td><a  href=\"DeleteServlet?roll_no=" + rs.getInt("roll_no") + "\">Delete</a></td></tr>");

                }
//                String query = "DELETE FROM student WHERE roll_no = ?";
//                PreparedStatement pst = con.prepareStatement(query);
//                String rollNoParam = request.getParameter("roll_no");
    
    // Convert roll_no parameter to integer
                if (rollNoParam != null && !rollNoParam.isEmpty()) {
                    try {
                        int rollNo = Integer.parseInt(rollNoParam);
                        pst.setInt(1, rollNo);
                // Execute the deletion query
                        pst.executeUpdate();
                    } catch (NumberFormatException e) {
                        e.printStackTrace(); // Handle parsing error
                    }}
                // int rollNo = Integer.parseInt(rollNoParam);
                //pst.setInt(1, rollNo);
                // Execute the deletion query
                //pst.executeUpdate();
//                int rss = st.executeUpdate("delete from student where roll_no=?");
                
//                String rollNoParam = request.getParameter("roll_no");
//                int rn = Integer.parseInt(rollNoParam);
//                String fn = request.getParameter("f_name");
//                String ln = request.getParameter("l_name");
//                String s = request.getParameter("stream");
//                
            }catch(Exception e){
                e.printStackTrace();
            }
            out.println("<script>"
                    + "function autoRefresh() {\n" +
                        "            window.location = window.location.href;\n" +
                        "        }\n" +
                        "        setInterval('autoRefresh()', 2000);"
                    + "</script>");
            out.println("</body>");
            out.println("</html>");
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
