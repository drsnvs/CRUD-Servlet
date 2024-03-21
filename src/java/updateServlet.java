/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DARSHAN
 */
public class updateServlet extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet displayServlet</title>");            
//            out.println("</head><style>\n" +
//                        "            table{\n" +
//                        "                width:50%;\n" +
//                        "                height: 100px;\n" +
//                        "                margin-top: 100px;\n" +
//                        "                font-size: 25px;\n" +
//                        "            }\n" +
//                        "            input{\n" +
//                        "                padding: 10px;\n" +
//                        "                margin:0px;\n" +
//                        "            }\n"
//                                            + "th{\n" +
//                        "                background-color: aquamarine;\n" +
//                        "            }\n" +
//                        "            td{\n" +
//                        "                background-color: aqua;\n" +
//                        "            }\n" +
//                        "            body{\n" +
//                        "                background-color: antiquewhite;\n" +
//                        "            }\n" +
//                        "            input{\n" +
//                        "                background-color: aquamarine;\n" +
//                        "            }" +
//                        "        </style>");
//            out.println("<body><h1 align='center'>Update Data</h1><table border=1 cellspacing=0 align='center'><tr><th>Roll No</th><th>First Name</th><th>Last Name</th><th>Stream</th><th>Update</th></tr><tr>");
//            
//            Connection con = null;
////            ResultSet rs = null;
//            Statement st = null;
//            ServletContext sc = getServletContext();
//            String url = null;
//            try{
//                Class.forName("com.mysql.jdbc.Driver");
//                url = sc.getInitParameter("url");
//                con = DriverManager.getConnection(url,"root","");
//                st = con.createStatement();
//                ResultSet rs  = st.executeQuery("select * from student");
//                while(rs.next()){
//                    out.println("<td>"+rs.getInt("roll_no")+"</td><td>"+rs.getString("f_name")+"</td><td>"+rs.getString("l_name")+"</td><td>"+rs.getString("stream") + "</td><td><a  href=\"updateJSP.jsp?roll_no=" + rs.getInt("roll_no") + "\">Edit</a></td></tr>");
//                    
//                }
////                String rollNoParam = request.getParameter("roll_no");
////                int rn = Integer.parseInt(rollNoParam);
////                String fn = request.getParameter("f_name");
////                String ln = request.getParameter("l_name");
////                String s = request.getParameter("stream");
////                
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//            
//            out.println("</body>");
//            out.println("</html>");
//        }

        try (PrintWriter out = response.getWriter()) {
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
                        "            }\n"
                                            + "th{\n" +
                        "                background-color: aquamarine;\n" +
                        "            }\n" +
                        "            td{\n" +
                        "                background-color: aqua;\n" +
                        "            }\n" +
                        "            body{\n" +
                        "                background-color: antiquewhite;\n" +
                        "            }\n" +
                        "            input{\n" +
                        "                width:100%;background-color: aquamarine;\n" +
                        "            }" +
                        "        </style>");
            out.println("<body><h1 align='center'>Update Data</h1><table border=1 cellspacing=0 align='center'><tr><th>Roll No</th><th>First Name</th><th>Last Name</th><th>Stream</th><th>Update</th></tr><tr>");
            
            Connection con = null;
            Statement st = null;
            ServletContext sc = getServletContext();
            String url = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                url = sc.getInitParameter("url");
                con = DriverManager.getConnection(url,"root","");
                st = con.createStatement();
                ResultSet rs  = st.executeQuery("select * from student");
                while(rs.next()){
                    out.println("<td>"+rs.getInt("roll_no")+"</td><td>"+rs.getString("f_name")+"</td><td>"+rs.getString("l_name")+"</td><td>"+rs.getString("stream") + "</td><td><form action=\"updateJSP.jsp\" method=\"post\"><input type=\"hidden\" name=\"roll_no\" value=\"" + rs.getInt("roll_no") + "\"><input type=\"submit\" value=\"Edit\"></form></td></tr>");
                }
            }catch(ClassNotFoundException | SQLException e){
            }
            
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
