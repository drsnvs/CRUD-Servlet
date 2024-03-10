<%-- 
    Document   : insertJSP
    Created on : 8 Mar, 2024, 6:17:14 PM
    Author     : DARSHAN
--%>
<%@page import="java.sql.*"%>
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
            }
        </style>
    </head>
    <body>
        
        
        <form  action="insertServlet" method="POST">
            <table cellspacing = 0 align="center" border="1">
                <tr>
                    <td>Roll No: </td>
                    <td><input type="number" name="roll_no"></td>
                </tr>
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="f_name"></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="l_name"></td>
                </tr>
                <tr>
                    <td>Stream: </td>
                    <td><input type="text" name="stream"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Submit" name="submit"></td>
                    <td></td>
                </tr>
                
                
            </table>
        </form> 
    </body>
</html>


<!--CREATE TABLE `darshan_14`.`student` (
  `roll_no` INT NOT NULL,
  `f_name` VARCHAR(45) NOT NULL,
  `l_stream` VARCHAR(45) NOT NULL,
  `stream` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roll_no`));-->
