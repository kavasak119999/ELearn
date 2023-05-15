package edu.max.fyl.elearn.service;

import edu.max.fyl.elearn.dto.Lesson;

import java.util.List;

public interface LessonService {
    Lesson getLessonById(int id);
    List<Lesson> getAllLessons();
}
