package edu.max.fyl.elearn.repository;

import edu.max.fyl.elearn.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<LessonEntity, Integer> {
}
