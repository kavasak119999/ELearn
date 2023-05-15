package edu.max.fyl.elearn.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lessons")
@Builder
public class LessonEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "topic")
    private String topic;
}
