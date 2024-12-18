package com.spring.taskschedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user")

public class User extends BaseEntity{

    //아이디 이름 이메일 패스워드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String EMail;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String username, String EMail, String password) {
        this.username = username;
        this.EMail = EMail;
        this.password = password;
    }
}
