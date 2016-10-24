package no.agricult.agrihub.domain;

import java.time.LocalDateTime;

/**
 * @Author: vda
 */
public class SensorReading {
    double readValue;
    String valueUnit;
    String sensorName;
    LocalDateTime timestamp;
    String nodeId;
}
