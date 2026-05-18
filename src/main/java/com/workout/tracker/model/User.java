package com.workout.tracker.model;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String userToken;

    // Getters and setters
    public Long getUserId(){return id;}
    public void setid(Long userId){this.id = id;}

    public String getUsername(){return username;}
    public void setUsername(String username) {this.username = username;}

    public String getUserToken(){return userToken;}
    public void setUserToken(String userToken) {this.userToken = userToken;}
}
