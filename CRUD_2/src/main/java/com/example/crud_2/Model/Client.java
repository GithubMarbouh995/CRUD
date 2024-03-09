package com.example.crud_2.Model;

public class Client {
    private String name;
    private String email;
    private String telephone;
    private String type;

    public Client(String name, String email, String telephone, String type) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.type = type;
    }

    public Client() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
