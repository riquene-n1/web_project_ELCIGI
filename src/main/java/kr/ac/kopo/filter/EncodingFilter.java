package kr.ac.kopo.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet filter ensuring UTF-8 encoding and exposing session user to requests.
 */
@WebFilter(value = "/*", initParams = {
    @WebInitParam(name = "encoding", value = "UTF-8")
})
public class EncodingFilter implements Filter {

    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (encoding != null) {
            request.setCharacterEncoding(encoding);
            response.setContentType("text/html; charset=" + encoding);
        }
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        if (session != null) {
            Object user = session.getAttribute("userVO");
            if (user != null) {
                request.setAttribute("loginMember", user);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
