<%--
  Created by IntelliJ IDEA.
  User: ageli
  Date: 12-Sep-20
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UniPi-CS: Bcs Thesis Status: Student's Details</title>
  <body>
<style>
    body { font-family: Calibri; }
    table,th,td { border: 0px; padding: 0px;}
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
</style>
<img src="${pageContext.request.contextPath}/unipi.jpg"  style="width: 430px; height: 150px;"><br>
</head>
<jsp:include page="/StudentDets"></jsp:include>

<script>
    function meeting(){
        document.getElementById("meeting").hidden = false;
        document.getElementById("label").hidden = false; }
    function finalGrd() {
        document.getElementById("grade").hidden = true;
        document.getElementById("changeGrade").hidden = false;
        document.getElementById("changeBtn").hidden = true;
        document.getElementById("submitBtn").hidden = false;}


</script>
    <table>
    <br>
    <tr>
        <td>
            <input type='submit' value='Arrange meeting' class= 'button' onclick="meeting()"/><br>
        </td>
        <td></td>
        <td>
            <input type = 'submit' class= 'button' id = 'changeBtn' value = 'Change grade' onclick="finalGrd()">
            <form method="post" action="submission.jsp" >
                <input type='submit' class='button' onclick="" id = 'submitBtn' value = 'Submit grade' hidden>
            </form>
        </td>

      </tr>
        <div id = "date"></div>
        <tr>
            <td>
                <label id = "label" for="date" hidden>Meeting on date: </label>
            </td>
            <td></td>
            <td>
                <input type='date' id = 'meeting'  hidden/>
            </td>
        </tr>
        </div>
    <tr>
         <td>
            <form action="index.jsp">
                <input type='submit' class = 'button' value='Logout'>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
