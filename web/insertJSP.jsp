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
        
        
        <form  action="insertServlet" method="POST" onsubmit="return validation()">
            <table cellspacing = 0 align="center" border="1">
                <tr>
                    <th>Roll No </th>
                    <td><input type="number" id="roll_no" name="roll_no"></td>
                </tr>
                <tr>
                    <th>First Name </th>
                    <td><input type="text" id="first_name" name="f_name"></td>
                </tr>
                <tr>
                    <th>Last Name </th>
                    <td><input type="text" id="last_name" name="l_name"></td>
                </tr>
                <tr>
                    <th>Stream </th>
                    <td><input type="text" id="stream" name="stream"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Insert" name="submit"></td>
                    
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


<!--CREATE TABLE `darshan_14`.`student` (
  `roll_no` INT NOT NULL,
  `f_name` VARCHAR(45) NOT NULL,
  `l_stream` VARCHAR(45) NOT NULL,
  `stream` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`roll_no`));-->
