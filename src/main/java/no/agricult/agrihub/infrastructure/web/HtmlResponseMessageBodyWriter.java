package no.agricult.agrihub.infrastructure.web;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @Author: vda
 */
@Provider
@Produces(MediaType.TEXT_HTML)
public class HtmlResponseMessageBodyWriter implements MessageBodyWriter<HtmlResponse> {

    @Inject
    private TemplateEngine templateEngine;


    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return HtmlResponse.class.isAssignableFrom(aClass);
    }

    @Override
    public long getSize(HtmlResponse htmlResponse, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1; //return value is ignored by JAX-RS 2.0 and above
    }

    @Override
    public void writeTo(HtmlResponse response, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        Context context = new Context();
        response.model.forEach((k, v) -> context.setVariable(k, v));
        Writer writer = new OutputStreamWriter(entityStream);

        templateEngine.process(response.templateName, context, writer);
        writer.flush();
    }
}
