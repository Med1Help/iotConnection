package Iot.project.iotconnection.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;

    private String tokenFcm;
    private String password;

    private Date created_at = new Date();

    private Date updated_at = new Date();

    private boolean connected;

    public User() {
    }

    public User(String name, String email,String tokenFcm) {
        this.name = name;
        this.email = email;
        this.tokenFcm = tokenFcm;
    }

    public User(String name, String email, String tokenFcm, String password,boolean connected) {
        this.name = name;
        this.email = email;
        this.tokenFcm = tokenFcm;
        this.password = password;
        this.connected = connected;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTokenFcm(String tokenFcm) {
        this.tokenFcm = tokenFcm;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTokenFcm() {
        return tokenFcm;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }
}
