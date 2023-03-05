package org.example;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TimezoneValidateFilter extends HttpFilter {
@Override
    public void doFilter(HttpServletRequest request,
                         HttpServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        String timezone = request.getParameter("timezone");

        if (timezone != null && !TimeZone.isValidTimezone(timezone)) {
            response.setStatus(400);
            response.getWriter().println("<style>body {font-size: 30px;  text-align: center;}</style>");
            response.getWriter().write("Invalid timezone");
            response.getWriter().close();
        } else {
            chain.doFilter(request, response);
        }
    }
}
