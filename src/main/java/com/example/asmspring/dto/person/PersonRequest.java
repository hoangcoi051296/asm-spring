package com.example.asmspring.dto.person;

public class PersonRequest {
    private String firstName;
    private String lastName;
    private String lastNameBirth;
    private String gender;
    private String search;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameBirth() {
        return lastNameBirth;
    }

    public void setLastNameBirth(String lastNameBirth) {
        this.lastNameBirth = lastNameBirth;
    }
}
