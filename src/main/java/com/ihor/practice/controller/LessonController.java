package com.ihor.practice.controller;

import com.ihor.practice.dto.LessonDTO;
import com.ihor.practice.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@Validated
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/schedule")
    @ResponseStatus(HttpStatus.OK)
    public List<LessonDTO> getSchedule() {
        return lessonService.getSchedule();
    }

    @PostMapping("/lessons")
    @ResponseStatus(HttpStatus.CREATED)
    public LessonDTO createLesson(@Valid @RequestBody LessonDTO lessonDTO) {
        return lessonService.createLesson(lessonDTO);
    }
}
