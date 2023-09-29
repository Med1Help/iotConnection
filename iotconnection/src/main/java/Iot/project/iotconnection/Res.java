package Iot.project.iotconnection;

public class Res {
    private String response;
    private boolean succes;

    private String email;
    private String name;

    public Res(String response, boolean succes, String email, String name) {
        this.response = response;
        this.succes = succes;
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isSucces() {
        return succes;
    }

    public void setSucces(boolean succes) {
        this.succes = succes;
    }

    public Res(String response, boolean succes) {
        this.response = response;
        this.succes = succes;
    }
}
