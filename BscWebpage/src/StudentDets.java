import dbConn.UserrDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "StudentDets")
public class StudentDets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String am = (String) request.getParameter("am");
        PrintWriter writer = response.getWriter();
        ResultSet rs = UserrDAO.GetSuperReport(am);

        writer.println("<!DOCTYPE html><html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\" />");
        writer.println("<title>UniPi-CS: Bcs Thesis Status: Student's Details</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Student "+am+" </h1>");
        writer.println("<table>");
        writer.println("<tr><td><b>Fullname</b></td>");
        writer.println("<td><b>E-mail</b></td>");
        writer.println("<td><b>Orientation</b></td>");
        writer.println("<td><b>Bachelor Thesis</b></td>");
        writer.println("<td><b>Starting Date</b></td>");
        writer.println("<td><b>Programming Language</b></td>");
        writer.println("<td><b>Tools</b></td></tr>");

        try {
            while (rs.next()) {
                writer.println("<tr><td>" + rs.getString("fullname") + "</td>");
                writer.println("<td>" + rs.getString("email") + "</td>");
                writer.println("<td>" + rs.getString("orientation") + "</td>");
                writer.println("<td>" + rs.getString("bsc_thesis") + "</td>");
                writer.println("<td>" + rs.getString("start_date") + "</td>");
                writer.println("<td>" + rs.getString("prog_languages") + "</td>");
                writer.println("<td>" + rs.getString("tools") + "</td>");
                if(request.getParameter("btn1")!=null){
                    System.out.println(request.getParameter("btn1"));
                    writer.println("<td>"+rs.getString("progress")+"</td></tr>");}
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



 }
