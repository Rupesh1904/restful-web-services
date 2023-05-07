package com.rupesh.webservices.restfulwebservices.User;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_detail")
public class User {

    @GeneratedValue
    @Id
    private Integer id;

    @Size(min = 2)
    private String name;
    @Past
    private LocalDate birthdate;

    @OneToMany (mappedBy = "user")
    @JsonIgnore
    private List<Post> post;

    public User(Integer id, String name, LocalDate birthdate) {
        super();
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public List<Post> getPost() {
        return post;
    }
    public void setPost(List<Post> post) {
        this.post = post;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
    }


}
