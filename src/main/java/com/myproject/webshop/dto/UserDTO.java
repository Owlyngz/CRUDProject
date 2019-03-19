package com.myproject.webshop.dto;

public class UserDTO {

    private Long id;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String password;

    public UserDTO(Long id, String userName, String userSurname, String userEmail, String password) {
        this.id = id;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
