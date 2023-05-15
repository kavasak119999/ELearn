package edu.max.fyl.elearn.service;

import edu.max.fyl.elearn.dto.Lesson;
import edu.max.fyl.elearn.entity.LessonEntity;
import edu.max.fyl.elearn.repository.LessonRepository;
import edu.max.fyl.elearn.tools.EntityToDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService{

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Lesson getLessonById(int id) {
        LessonEntity lessonEntity = lessonRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Лекцію із номером - '" + id + "' не знайдено."));
        return EntityToDto.lessonEntityToDto(lessonEntity);
    }

    @Override
    public List<Lesson> getAllLessons() {
        List<LessonEntity> entities = lessonRepository.findAll();
        return entities.stream().map(EntityToDto::lessonEntityToDto).toList();
    }
}
