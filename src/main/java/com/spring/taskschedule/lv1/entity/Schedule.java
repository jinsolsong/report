package com.spring.taskschedule.lv1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String todo;

    public Schedule() {
    }

    public Schedule(String userName, String title, String todo) {
        this.userName = userName;
        this.title = title;
        this.todo = todo;
    }
}
