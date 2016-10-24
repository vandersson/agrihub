package no.agricult.agrihub.primary_ports.http;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.enterprise.inject.Produces;
import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @Author: vda
 */
@ApplicationPath("/app")
public class JAXRSConfiguration extends Application {

    @javax.ws.rs.core.Context
    ServletContext context;

    @Produces
    public TemplateEngine templateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(context);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        // Set template cache TTL to 1 hour. If not set, entries would live in cache until expelled by LRU
        templateResolver.setCacheTTLMs(Long.valueOf(3600000L));
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

}
