package com.spring.taskschedule.entity;

import com.spring.taskschedule.lv1.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user")

public class User extends BaseEntity {

    //아이디 이름 이메일 패스워드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String eMail;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String username, String eMail, String password) {
        this.username = username;
        this.eMail = eMail;
        this.password = password;
    }
}
