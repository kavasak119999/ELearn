package edu.max.fyl.elearn.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tests")
@Builder
public class TestEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "help_sentence")
    private String helpSentence;

    @OneToMany(mappedBy = "test_id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<QuestionEntity> questionEntityList;
}
