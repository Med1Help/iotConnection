package Iot.project.iotconnection.models;

import jakarta.persistence.OneToOne;

import java.util.Date;

public class FullRegistration {

    private String name;
    private String info;
    private int age;

    private String userEmail;

    private String service;

    private String lit;

    private String num_patient;

    private String topic;

    public FullRegistration(String name, String info, int age, String userEmail, String service, String lit, String num_patient, String topic) {
        this.name = name;
        this.info = info;
        this.age = age;
        this.userEmail = userEmail;
        this.service = service;
        this.lit = lit;
        this.num_patient = num_patient;
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLit() {
        return lit;
    }

    public void setLit(String lit) {
        this.lit = lit;
    }

    public String getNum_patient() {
        return num_patient;
    }

    public void setNum_patient(String num_patient) {
        this.num_patient = num_patient;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
