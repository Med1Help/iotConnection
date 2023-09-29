package Iot.project.iotconnection.models;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Entity
@Table(name="device")
public class Device {
    @Id
    @GeneratedValue
    private long id;
    private String topic;

    private String connectionStatus;


    public Device() {
    }

    public Device(String topic, String connectionStatus) {
        this.topic = topic;
        this.connectionStatus = connectionStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", connectionStatus='" + connectionStatus + '\'' +
                '}';
    }
}
