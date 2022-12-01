package fr.triedge.core.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String pseudo;
    private String email;
    private String password;
    private String description;
    private String image;

    private Eye eyeColor;
    private Role role;
    private Sex sex;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User(){}

    public Eye getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Eye eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
