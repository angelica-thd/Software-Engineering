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

@WebServlet(name = "StudentUtil")
public class StudentUtil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        PrintWriter writer = response.getWriter();
        ResultSet rs = UserrDAO.GetStudentsWork(id);

        writer.println("<!DOCTYPE html><html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\" />");
        writer.println("<title>UniPi-CS: Bcs Thesis Status</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<style>") ;
        writer.println("body { font-family: Calibri; font-size: 18;}");
        writer.println("table, th, td { border: 1px solid black; border-collapse: collapse; padding: 15px; text-align: left;}" );
        writer.println("</style>");
        writer.println("<img src='${pageContext.request.contextPath}/unipi.jpg'  style='width: 430px; height: 150px;'>");
        writer.println("<table>");
        writer.println("<tr><td><b>Supervisor's Fullname</b></td>");
        writer.println("<td><b>Supervisor's E-mail</b></td>");
        writer.println("<td><b>Bachelor Thesis</b></td>");
        writer.println("<td><b>Starting Date</b></td>");
        writer.println("<td><b>Programming Language</b></td>");
        writer.println("<td><b>Tools</b></td>");
        writer.println("<td><b>Progress</b></td>");
        writer.println("<td><b>Grade</b></td></tr>");
        try {
            while (rs.next()) {
                 writer.println("<tr><td>" + rs.getString("fullname") + "</td>");
                writer.println("<td>" + rs.getString("email") + "</td>");
                writer.println("<td>" + rs.getString("bsc_thesis") + "</td>");
                writer.println("<td>" + rs.getString("start_date") + "</td>");
                writer.println("<td>" + rs.getString("prog_languages") + "</td>");
                writer.println("<td>" + rs.getString("tools") + "</td>");
                writer.println("<td>" + rs.getString("progress") + "</td>");
                writer.println("<td>" + rs.getString("grade") + "</td></tr>");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
