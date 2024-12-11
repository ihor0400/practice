package com.ihor.practice.controller;

import com.ihor.practice.dto.LessonDTO;
import com.ihor.practice.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LessonController {
    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/schedule")
    public List<LessonDTO> getSchedule() {
        return lessonService.getSchedule();
    }
}
