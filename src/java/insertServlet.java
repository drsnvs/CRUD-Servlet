/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
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
public class insertServlet extends HttpServlet {

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
        session.setAttribute("name", "Darshan");
        try (PrintWriter out = response.getWriter()) {
            
            
            if(!session.getId().equals(session.getAttribute("key"))){
                response.sendRedirect("index.jsp");
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet insertServlet</title>");      
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
            
            Connection con = null;
//            ResultSet rs = null;
            Statement st = null;
            ServletContext sc = getServletContext();
            String url = null;
            PreparedStatement p = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                url = sc.getInitParameter("url");
                con = DriverManager.getConnection(url,"root","");
                st = con.createStatement();
                String rollNoParam = request.getParameter("roll_no");
                int rn = Integer.parseInt(rollNoParam);
                String fn = request.getParameter("f_name");
                String ln = request.getParameter("l_name");
                String s = request.getParameter("stream");
                ResultSet r = st.executeQuery("select roll_no from student where roll_no="+rollNoParam+"");
                if(r.next()){
                    out.println("<tr><td>Already inserted!</td></tr>");
                    out.println("<tr><td align='center'><button onclick=\"document.location='index.jsp'\">Home</button></td></tr>");
                }else{
                    String query = "INSERT INTO student(roll_no, f_name, l_name, stream) VALUES(?,?,?,?)";
                    p = con.prepareStatement(query);
                    p.setInt(1, rn);
                    p.setString(2, fn);
                    p.setString(3, ln);
                    p.setString(4, s);
                    int rows = p.executeUpdate();
                    if(rows>=1){
                        out.println("<tr><td>Insert Successfully!</td></tr>");
                        out.println("<tr><td align='center'><button onclick=\"document.location='index.jsp'\">Home</button></td></tr>");
                    }
//                    else{
//                        out.println("<tr><td>Insert Unuccessfull!<td></tr>");
//                    }
                }
                out.println("</table></body>");
                out.println("</html>");
            }catch(Exception e){
                e.printStackTrace();
            }
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
