package com.spring.taskschedule.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "schedule2")
public class ScheduleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String todo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ScheduleEntity() {
    }

    public ScheduleEntity(String title, String todo){
        this.title = title;
        this.todo = todo;
    }

}
