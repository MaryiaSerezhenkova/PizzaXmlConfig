package by.it_academy.jd2.Mk_JD2_92_22.pizza.controllers.filters;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        filterChain.doFilter(req, resp);
    }

  
    public void destroy() {

    }
}
