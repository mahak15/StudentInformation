package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RollNoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        servletResponse.getWriter().write("filter is invoked before\n");
        String rollNo = servletRequest.getParameter("RollNo");
        char first = rollNo.charAt(0);
        char second = rollNo.charAt(1);
        int flag = 0;

        if (first == 'R' || first == 'r' && second == 'N' || second == 'n') {

            for (int i = 2; i < rollNo.length(); i++) {

                if (rollNo.charAt(i) >= '0' && rollNo.charAt(i) <= '9') {
                    continue;
                } else {
                    servletResponse.getWriter().write("Invalid RollNo please enter valid roll no.\n");
                    flag = 1;
                    break;
                }
            }

        } else {

            servletResponse.getWriter().write("Invalid RollNo please enter valid roll no.\n");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.getWriter().write("filter is invoked after\n");


    }


    @Override
    public void destroy() {

    }
}
