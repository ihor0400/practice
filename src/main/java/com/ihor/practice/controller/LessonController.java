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
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Validated
public class LessonController {

    private final LessonService lessonService;
    private final AuthController authController;

    @Autowired
    public LessonController(LessonService lessonService, AuthController authController) {
        this.lessonService = lessonService;
        this.authController = authController;
    }

    @GetMapping("/schedule")
    @ResponseStatus(HttpStatus.OK)
    public List<LessonDTO> getSchedule(HttpServletRequest request) {
        validateToken(request);
        return lessonService.getSchedule();
    }

    @PostMapping("/lessons")
    @ResponseStatus(HttpStatus.CREATED)
    public LessonDTO createLesson(@Valid @RequestBody LessonDTO lessonDTO, HttpServletRequest request) {
        validateToken(request);
        return lessonService.createLesson(lessonDTO);
    }

    private void validateToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ") || !authController.isTokenValid(token.substring(7))) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized: Invalid or expired token");
        }
    }
}
