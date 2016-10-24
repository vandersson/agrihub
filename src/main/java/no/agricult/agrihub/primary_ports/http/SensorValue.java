package no.agricult.agrihub.primary_ports.http;

/**
 * @Author: vda
 */
public class SensorValue {
    long timestamp;
    String sensorName;
    double sensorValue;

    public SensorValue() {
    }

    public SensorValue(long timestamp, String sensorName, double sensorValue) {
        this.timestamp = timestamp;
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getSensorName() {
        return sensorName;
    }

    public double getSensorValue() {
        return sensorValue;
    }


    @Override
    public String toString() {
        return "SensorValue{" +
                "timestamp=" + timestamp +
                ", sensorName='" + sensorName + '\'' +
                ", sensorValue=" + sensorValue +
                '}';
    }
}
