package Iot.project.iotconnection.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="userDevice")
public class UserDevice {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    private User user;
    private String name;
    private String info;
    private int age;

    private Date created_at;
    private Date updated_at;
    @OneToOne
    private Device device;

    private String service;

    private String lit;

    private String num_patient;

    public UserDevice(User user, String name, String info, int age, Date created_at, Date updated_at, Device device, String service, String lit, String num_patient) {
        this.user = user;
        this.name = name;
        this.info = info;
        this.age = age;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.device = device;
        this.service = service;
        this.lit = lit;
        this.num_patient = num_patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
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

    @Override
    public String toString() {
        return "UserDevice{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", age=" + age +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", device=" + device +
                ", service='" + service + '\'' +
                ", lit='" + lit + '\'' +
                ", num_patient='" + num_patient + '\'' +
                '}';
    }
}
