<%-- 
    Document   : index
    Created on : 8 Mar, 2024, 11:31:00 AM
    Author     : DARSHAN
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Table</title>
        <style>
            table{
                width:50%;
                height: 100px;
                margin-top: 100px;
                font-size: 25px;
            }
            input{
                padding: 10px;
                margin:0px;
            }
            th{
                background-color: aquamarine;
            }
            td{
                background-color: aqua;
            }
            body{
                background-color: antiquewhite;
            }
            input{
                background-color: aquamarine;
            }
        </style>
    </head>
    <body>
        <%
            HttpSession ssn = request.getSession();
            ssn.setAttribute("key", ssn.getId());
        %>
        
        <table cellspacing = 0 align="center" border="1">
            <tr>
                <th colspan="4" >Student Table</th>
            </tr>
            <tr>
                <td align="center"><a href="insertJSP.jsp"><input type="button" value="Insert"/></a></td>
                <td align="center"><a href="updateServlet"><input type="button" value="Update"/></a></td>
                <td align="center"><a href="DeleteServlet"><input type="button" value="Delete"/></a></td>
                <td align="center"><a href="displayServlet"><input type="button" value="Display"/></a></td>
            </tr>
        </table>
    </body>
</html>
