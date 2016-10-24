package no.agricult.agrihub.infrastructure.web;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: vda
 */
public class StaticContentFilter implements Filter {

    public static final String STATIC_CONTENT_PARAM = "static-content";
    public static final String APP_CONTENT_PARAM = "app-content";
    private String staticUrl = "/static";
    private String appUrl = "/app";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String surl = filterConfig.getInitParameter(STATIC_CONTENT_PARAM);
        if (surl != null) {
            staticUrl = surl;
        }
        String aurl = filterConfig.getInitParameter(APP_CONTENT_PARAM);
        if (aurl != null) {
            appUrl = aurl;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length());

        if (path.startsWith(staticUrl)) {
            chain.doFilter(request, response);
        } else {
            request.getRequestDispatcher(appUrl + path).forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}