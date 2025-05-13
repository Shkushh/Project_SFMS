import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String course = request.getParameter("course");
        String rating = request.getParameter("rating");
        String[] aspectsArray = request.getParameterValues("aspects");
        String feedback = request.getParameter("feedback");

        String aspects = String.join(",", aspectsArray);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_feedback", "root", "your_password");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO feedbacks (course, rating, aspects, message) VALUES (?, ?, ?, ?)");

            ps.setString(1, course);
            ps.setInt(2, Integer.parseInt(rating));
            ps.setString(3, aspects);
            ps.setString(4, feedback);

            ps.executeUpdate();

            response.sendRedirect("thankyou.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
