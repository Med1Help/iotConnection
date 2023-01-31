package Iot.project.iotconnection.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="HutempTopic")
public class HutempTopic {
    @Id
    @GeneratedValue
    private Long id;
    private String humidity;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private String temperature;
    private String topic;

    public HutempTopic() {
    }

    public HutempTopic(String humidity, String temperature, String topic) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "HutempTopic{" +
                "humidity='" + humidity + '\'' +
                ", temperature='" + temperature + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getTopic() {
        return topic;
    }
}
