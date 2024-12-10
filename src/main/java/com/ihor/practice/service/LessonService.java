package com.ihor.practice.service;

import com.ihor.practice.dto.LessonDTO;
import com.ihor.practice.model.Lesson;
import com.ihor.practice.repository.LessonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;
    private final ModelMapper modelMapper;

    public LessonService(LessonRepository lessonRepository, ModelMapper modelMapper) {
        this.lessonRepository = lessonRepository;
        this.modelMapper = modelMapper;
    }


    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Lesson lesson = modelMapper.map(lessonDTO, Lesson.class);
        lesson = lessonRepository.save(lesson);
        return modelMapper.map(lesson, LessonDTO.class);
    }


    public List<LessonDTO> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(lesson -> modelMapper.map(lesson, LessonDTO.class))
                .collect(Collectors.toList());
    }
}
