package org.example.coolies_v2;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ShowTheme")
public class ShowThemeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String theme = "light"; // Default theme
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("theme".equals(cookie.getName())) {
                    theme = cookie.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<title>Theme Applied</title>");
        out.println("<link rel='stylesheet' href='css/styles.css'>"); // Link to the CSS file
        out.println("</head>");
        out.println("<body class='" + theme + "'>"); // Add theme class to body
        out.println("<h1>" + theme.substring(0, 1).toUpperCase() + theme.substring(1) + " Theme Applied</h1>");
        out.println("<a href='index.html'>Change Theme</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
