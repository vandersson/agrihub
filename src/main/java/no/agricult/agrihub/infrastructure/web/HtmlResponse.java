package no.agricult.agrihub.infrastructure.web;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: vda
 */
public class HtmlResponse {
    String templateName;
    Map<String, Object> model = new HashMap<>();

    public HtmlResponse(String templateName) {
        this.templateName = templateName;
    }

    public HtmlResponse add(String modelName, Object model) {
        this.model.put(modelName, model);
        return this;
    }
}
