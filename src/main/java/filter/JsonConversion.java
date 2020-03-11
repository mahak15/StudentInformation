package filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class JsonConversion implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse res=(HttpServletResponse) servletResponse;
        String content=req.getHeader("Accept");

        Object data =  servletRequest.getAttribute("data");
        servletResponse.getWriter().write((data.toString()));
        if(content.equals("application/json"))
        {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(data);
            servletResponse.setContentType(content);
            res.getWriter().write(json);
        }
        else if(content.equals("application/xml"))
        {
            XmlMapper mapper = new XmlMapper();
            String xml = mapper.writeValueAsString(data);
            servletResponse.setContentType(content);
            res.getWriter().write(xml);
        }
        else
        {
            res.getWriter().write("Alive");
        }
    }
    @Override
    public void destroy() {
    }
}



