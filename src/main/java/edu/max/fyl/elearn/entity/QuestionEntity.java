package edu.max.fyl.elearn.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
@Builder
public class QuestionEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "question")
    private String question;

    @Column(name = "first_option")
    private String firstOption;

    @Column(name = "second_option")
    private String secondOption;

    @Column(name = "third_option")
    private String thirdOption;

    @Column(name = "answer")
    private int answer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "test_id")
    private TestEntity test_id;


}
