package com.ihor.practice.service;

import com.ihor.practice.dto.LessonDTO;
import com.ihor.practice.model.Lesson;
import com.ihor.practice.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<LessonDTO> getSchedule() {
        return lessonRepository.findAll().stream()
                .map(lesson -> new LessonDTO(
                        lesson.getId(),
                        lesson.getName(),
                        lesson.getTime(),
                        lesson.getTeacher()
                ))
                .collect(Collectors.toList());
    }
}
