package com.example.schedule.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class LessonDTO {
    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    private LocalDateTime time;

    @NotNull
    @Size(min = 2, max = 100)
    private String teacher;

    // Getters, setters, constructors
}
