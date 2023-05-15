package edu.max.fyl.elearn.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {
    private int id;
    private String text;
    private String topic;
}
