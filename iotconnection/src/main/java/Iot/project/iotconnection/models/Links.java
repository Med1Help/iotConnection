package Iot.project.iotconnection.models;

import jakarta.persistence.*;

@Entity
@Table(name="Links")
public class Links {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany
    private User user;

    @OneToMany
    private Device device;

    public Links() {
    }

    public Links(User user, Device device) {
        this.user = user;
        this.device = device;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
