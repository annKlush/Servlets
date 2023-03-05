package org.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class LocalTime extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LocalDateTime now;
        String time;

       resp.setContentType( "text/html; charset=utf-8");

       String timezone = req.getParameter("timezone");

        if (timezone == null || timezone.isEmpty()) {
            now = LocalDateTime.now(ZoneOffset.UTC);
            time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            time += " UTC";
        } else {
            ZoneId zone = ZoneId.of(timezone);
            now = LocalDateTime.now(zone);
            time = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            time += " " + zone;
        }

        // Отримуємо поток символів для відправки відповіді клієнту
        PrintWriter out = resp.getWriter();


        // Відправляємо HTML сторінку з поточним часом
        out.println("<html><head><title>TimeServlet</title></head><body>");
        out.println("<h1>Current Time</h1>");
        out.println("<p style=\"font-size: 30px;\">" + time + "</p>");
        out.println("</body></html>");

        resp.getWriter().close();
    }
}
