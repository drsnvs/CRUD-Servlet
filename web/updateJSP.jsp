<%-- 
    Document   : updateJSP
    Created on : 17 Mar, 2024, 7:52:32 AM
    Author     : DARSHAN
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                width:50%;
                height: 100px;
                margin-top: 100px;
                font-size: 25px;
            }
            input{
                padding: 10px;
                margin: 10px;
                background-color: aquamarine;
            }
            
            td,th{
                background-color: aqua;
            }
            body{
                background-color: antiquewhite;
            }
        </style>
    </head>
    <body>
        <h1 align="center">Update</h1>
        
        <form  action="updateServlet2" method="POST" onsubmit="return validation()">
            <table cellspacing = 0 align="center" border="1">
                <tr>
                    <td>Roll No: </td>
                    <td><input type="number" id="roll_no" value=<% out.println(request.getParameter("roll_no")); %> name="roll_no" readonly></td>
                </tr>
                <%
                    Connection con = null;
//            ResultSet rs = null;  
                    Statement st = null;
                    ServletContext sc = getServletContext();
                    String url = null;
                    PreparedStatement p = null;
                    Class.forName("com.mysql.jdbc.Driver");
                    url = sc.getInitParameter("url");
                    con = DriverManager.getConnection(url,"root","");
                    st = con.createStatement();
                    String query = "select * from student where roll_no = "+request.getParameter("roll_no")+";";
                    ResultSet rs =  st.executeQuery(query);
                    rs.next();
                    String fn = rs.getString("f_name");
                    String ln = rs.getString("l_name");
                    String s = rs.getString("stream");
                %>
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" id="first_name" name="fname" value=<% out.println(fn); %> ></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" id="last_name" name="lname" value=<% out.println(ln); %> ></td>
                </tr>
                <tr>
                    <td>Stream: </td>
                    <td><input type="text" id="stream" name="stream" value=<% out.println(s); %> ></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Submit" name="submit"></td>
                </tr>
            </table>
        </form>
                <script>
            function validation(){
                var rn = document.getElementById("roll_no").value;
                var fn = document.getElementById("first_name").value;
                var ln = document.getElementById("last_name").value;
                var s = document.getElementById("stream").value;
                if(rn == ""){
                    alert("Enter roll number");
                    return false;
                }
                if(fn == ""){
                    alert("Enter first name");
                    return false;
                }
                if(ln == ""){
                    alert("Enter last name");
                    return false;
                }
                if(s == ""){
                    alert("Enter stream");
                    return false;
                }
            }
        </script>
    </body>
</html>
