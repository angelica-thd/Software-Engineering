import dbConn.UserrDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SupReport", urlPatterns = {"/SupReport"})
public class SupReport extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        PrintWriter writer = response.getWriter();
        ResultSet rs = UserrDAO.GetAllStudentInfo(id);

        writer.println("<!DOCTYPE html><html>");
        writer.println("<head>");
        writer.println("<meta charset=\"UTF-8\" />");
        writer.println("<title>UniPi-CS: Bcs Thesis Status</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<style>") ;
        writer.println("body { font-family: Calibri; font-size: 18;}");
        writer.println("table, th, td { border: 1px solid black; border-collapse: collapse; padding: 15px; text-align: left;}" );
        writer.println("button {background-color: #FFFFFF; color: #000000; padding: 14px 20px; margin: 8px 0; border: none; cursor: pointer}");
        writer.println("button:hover {opacity: 0.8;}");
        writer.println("</style>");
        writer.println("<img src="+request.getContextPath()+"'/unipi.jpg'  style='width: 430px; height: 150px;'>");
        writer.println("<br><br><br><br>");
        writer.println("<table>");
        writer.println("<tr><td><b>AM</b></td>");
        writer.println("<td><b>Fullname</b></td>");
        writer.println("<td><b>E-mail</b></td>");
        writer.println("<td><b>Orientation</b></td>");
        writer.println("<td><b>Bachelor Thesis</b></td>");
        writer.println("<td><b>Starting Date</b></td>");
        writer.println("<td><b>Programming Language</b></td>");
        writer.println("<td><b>Tools</b></td></tr>");
        try {
            while (rs.next()) {
                request.setAttribute("am",rs.getString("am"));
                writer.println("<tr><td><form method = 'post' action = 'stuDetails.jsp'><input type='submit'  value ="+ rs.getString("am")+ "></form></td>");
                writer.println("<td>" + rs.getString("fullname") + "</td>");
                writer.println("<td>" + rs.getString("email") + "</td>");
                writer.println("<td>" + rs.getString("orientation") + "</td>");
                writer.println("<td>" + rs.getString("bsc_thesis") + "</td>");
                writer.println("<td>" + rs.getString("start_date") + "</td>");
                writer.println("<td>" + rs.getString("prog_languages") + "</td>");
                writer.println("<td>" + rs.getString("tools") + "</td>");

                      }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</table>");
        writer.println(request.getAttribute("am"));
        writer.println("</body>");
        writer.println("</html>");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response, String am) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath()+ "/stuDetails.jsp");
        rd.forward(request,response);
    }
}
