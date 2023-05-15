package edu.max.fyl.elearn.tools;

import edu.max.fyl.elearn.dto.Lesson;
import edu.max.fyl.elearn.dto.Question;
import edu.max.fyl.elearn.dto.Test;
import edu.max.fyl.elearn.dto.User;
import edu.max.fyl.elearn.entity.LessonEntity;
import edu.max.fyl.elearn.entity.QuestionEntity;
import edu.max.fyl.elearn.entity.TestEntity;
import edu.max.fyl.elearn.entity.UserEntity;

public class EntityToDto {

    public static Lesson lessonEntityToDto(LessonEntity entity){
        return Lesson.builder()
                .id(entity.getId())
                .text(entity.getText())
                .topic(entity.getTopic())
                .build();
    }

    public static Test testEntityToDto(TestEntity entity){
        return Test.builder()
                .id(entity.getId())
                .helpSentence(entity.getHelpSentence())
                .questionList(entity.getQuestionEntityList().stream()
                        .map(EntityToDto::questionEntityToDto).toList())
                .build();
    }

    public static Question questionEntityToDto(QuestionEntity question){
        return Question.builder()
                .id(question.getId())
                .answer(question.getAnswer())
                .question(question.getQuestion())
                .firstOption(question.getFirstOption())
                .secondOption(question.getSecondOption())
                .thirdOption(question.getThirdOption())
                .build();
    }

    public static User userEntityToDto(UserEntity userEntity){
        return User.builder()
                .username(userEntity.getId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .build();
    }
}
