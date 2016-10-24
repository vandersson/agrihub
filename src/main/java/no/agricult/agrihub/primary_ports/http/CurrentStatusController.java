package no.agricult.agrihub.primary_ports.http;

import no.agricult.agrihub.infrastructure.web.HtmlResponse;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @Author: vda
 */
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
public class CurrentStatusController {

    private static double currentTemperature = 20.0;
    private static double currentMoisture = 77.0;
    private static double currentLight = 0.0;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/current")
    public CurrentStatus getCurrent() {
        return new CurrentStatus("Avocado", currentTemperature, currentLight, currentMoisture);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/current")
    public HtmlResponse getCurrentHtml() {
        return new HtmlResponse("current")
                .add("current", new CurrentStatus("Avocado", currentTemperature, currentLight, currentMoisture));
    }

    @PUT
    @Path("/sensor")
    public void sensorInput(@NotNull SensorValue input) {
        if ("temperature".equals(input.getSensorName())) {
            currentTemperature = input.getSensorValue();
        } else if ("moisture".equals(input.getSensorName())) {
            currentMoisture = input.getSensorValue();
        } else if ("light".equals(input.getSensorName())) {
            currentLight = input.getSensorValue();
        }

    }

}
