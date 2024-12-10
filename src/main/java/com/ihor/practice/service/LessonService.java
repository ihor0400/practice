package com.ihor.practice.service;

import com.ihor.practice.dto.LessonDTO;
import com.ihor.practice.model.Lesson; // Використовуємо правильну сутність
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

    // Метод для створення нового уроку
    public LessonDTO createLesson(LessonDTO lessonDTO) {
        Lesson lesson = modelMapper.map(lessonDTO, Lesson.class);  // Перетворюємо DTO в сутність Lesson
        lesson = lessonRepository.save(lesson); // Зберігаємо в репозиторії
        return modelMapper.map(lesson, LessonDTO.class);  // Повертаємо DTO
    }

    // Метод для отримання всіх уроків
    public List<LessonDTO> getAllLessons() {
        return lessonRepository.findAll().stream()
                .map(lesson -> modelMapper.map(lesson, LessonDTO.class))  // Перетворюємо кожен урок на DTO
                .collect(Collectors.toList());
    }
}
