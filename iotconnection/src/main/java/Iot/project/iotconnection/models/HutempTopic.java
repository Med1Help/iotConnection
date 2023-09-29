package Iot.project.iotconnection.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


public class HutempTopic {
    private String humidity;

    private String temperature;
    private String name;

    private String water;
    private String topic;

    public HutempTopic() {
    }

    public HutempTopic(String humidity, String temperature, String name, String water, String topic) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.name = name;
        this.water = water;
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    @Override
    public String toString() {
        return "HutempTopic{" +
                "humidity='" + humidity + '\'' +
                ", temperature='" + temperature + '\'' +
                ", name='" + name + '\'' +
                ", water='" + water + '\'' +
                '}';
    }
}
