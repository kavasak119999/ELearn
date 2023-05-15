package edu.max.fyl.elearn.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    private int id;
    private String question;
    private String firstOption;
    private String secondOption;
    private String thirdOption;
    private int answer;
}
