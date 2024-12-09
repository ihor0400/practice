package com.ihor.practice;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;
    private int lessonNumber;
    private LocalDate date;
    private String coachName;
    private int poolNumber;


}
