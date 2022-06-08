package edu.school21.cinema.model;

import javax.validation.constraints.NotBlank;

public class SearchCriteria {

    @NotBlank(message = "username can't be empty!")
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}