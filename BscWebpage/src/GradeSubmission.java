import mainPkg.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GradeSubmission")
public class GradeSubmission extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String am = (String) request.getAttribute("am");
        System.out.println("am"+am);
        System.out.println(request.getParameter("id"));
        double grade = Double.parseDouble(request.getParameter("changeGrade"));
        System.out.println(grade);
        User user = new User(am,request.getParameter("password"));
        user.submitGrade(grade,am);
        PrintWriter writer = response.getWriter();
        writer.print("<script>alert('Success');window.history.back();</script>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
