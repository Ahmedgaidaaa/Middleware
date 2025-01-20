package org.example.coolies_v2;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/SetTheme")
public class SetThemeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String theme = request.getParameter("theme");
        Cookie themeCookie = new Cookie("theme", theme);
        themeCookie.setMaxAge(7 * 24 * 60 * 60); // 1 week
        response.addCookie(themeCookie);
        response.sendRedirect("ShowTheme");
    }
}
