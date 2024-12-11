package com.ihor.practice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;

public class LessonDTO {

    @NotNull(message = "Group name cannot be null")
    @Size(min = 1, max = 100, message = "Group name must be between 1 and 100 characters")
    private String groupName;

    @NotNull(message = "Lesson number cannot be null")
    @Min(value = 1, message = "Lesson number must be at least 1")
    @Max(value = 10, message = "Lesson number cannot exceed 10")
    private Integer lessonNumber;

    @NotNull(message = "Date cannot be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in format YYYY-MM-DD")
    private String date;

    @NotNull(message = "Instructor name cannot be null")
    @Size(min = 1, max = 100, message = "Instructor name must be between 1 and 100 characters")
    private String instructor;

    @NotNull(message = "Day of the week cannot be null")
    @Pattern(regexp = "(Monday|Tuesday|Wednesday|Thursday|Friday)", message = "Day must be a weekday (Monday to Friday)")
    private String dayOfWeek;

    public LessonDTO(String groupName, Integer lessonNumber, String date, String instructor, String dayOfWeek) {
        this.groupName = groupName;
        this.lessonNumber = lessonNumber;
        this.date = date;
        this.instructor = instructor;
        this.dayOfWeek = dayOfWeek;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(Integer lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
