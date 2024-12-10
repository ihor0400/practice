package com.ihor.practice.repository;

import com.ihor.practice.model.Lesson;  // Використовуємо сутність Lesson
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    // Додаткові методи для роботи з даними можна додавати тут
}
