<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content = "text/html; charset = ISO-8859-1">
    <title>UniPi-CS: Bsc Thesis Status</title>
  </head>
  <body>
  <style>
    body { font-family: Calibri;}

    /* Full-width input fields */
    input[type=text], input[type=password] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;

    }

    /* Set a style for all buttons */
    .button {
      background-color: #05125c;
      color: white;
      padding: 14px 20px;
      margin: 8px 0;
      border: none;
      cursor: pointer
    }

    .button:hover {
      opacity: 0.8;
    }

    /* Extra styles for the cancel button */
  </style>
    <form method ="post" action = "${pageContext.request.contextPath}/Login">
      <table>

            <td>Supervisor's ID </td>
            <td></td>
            <td><input type = "text" name = "id"></td>
          </tr>
          <tr>
            <td>Password</td>
              <td></td>
          <td><input type ="password" name = "password"></td>
        </tr>
        <tr>
          <td></td><td></td>
          <td><input type = "submit" value ="Login" class = "button" style = "font-family: Calibri">

</td>
        </tr>
      </table>
      </form>
  </body>
</html>