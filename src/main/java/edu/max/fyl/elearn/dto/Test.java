package edu.max.fyl.elearn.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Test {
    private int id;
    private String helpSentence;
    private List<Question> questionList;
}