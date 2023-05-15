package edu.max.fyl.elearn.service;

import edu.max.fyl.elearn.dto.Test;
import edu.max.fyl.elearn.entity.TestEntity;
import edu.max.fyl.elearn.repository.TestRepository;
import edu.max.fyl.elearn.tools.EntityToDto;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public Test getTestById(int id) {
        TestEntity test = testRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Тест із номером - '" + id + "' не знайдено."));

        return EntityToDto.testEntityToDto(test);
    }
}
