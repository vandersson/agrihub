package no.agricult.agrihub.primary_ports.http;

/**
 * @Author: vda
 */
public class CurrentStatus {
    private String name;
    private double temperature;
    private double light;
    private double moisture;

    public CurrentStatus() {
    }

    public CurrentStatus(String name, double temperature, double light, double moisture) {
        this.name = name;
        this.temperature = temperature;
        this.light = light;
        this.moisture = moisture;
    }

    public String getName() {
        return name;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getLight() {
        return light;
    }

    public double getMoisture() {
        return moisture;
    }
}
