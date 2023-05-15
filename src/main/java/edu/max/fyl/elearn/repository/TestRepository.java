package edu.max.fyl.elearn.repository;

import edu.max.fyl.elearn.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {
}
