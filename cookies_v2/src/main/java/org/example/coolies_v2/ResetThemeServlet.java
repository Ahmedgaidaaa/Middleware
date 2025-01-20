package org.example.coolies_v2;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
public class ResetThemeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie themeCookie = new Cookie("theme", "");
        themeCookie.setMaxAge(0); // Delete the cookie
        response.addCookie(themeCookie);
        response.sendRedirect("index.html");
    }
}