package filter;
import filter.RollNoFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameFilter extends RollNoFilter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // super.doFilter(servletRequest, servletResponse, filterChain);
        if(((HttpServletRequest) servletRequest).getMethod().equals("POST")){
            String name = servletRequest.getParameter("Name");
            Pattern studentname = Pattern.compile("^[a-zA-Z]+");
            Matcher matcher = studentname.matcher(name);
            int flag=0;


            if (!matcher.matches()) {

                servletResponse.getWriter().write("Invalid Name Please Enter valid Name.");
                flag++;
            }
            if(flag==0)
                filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}



