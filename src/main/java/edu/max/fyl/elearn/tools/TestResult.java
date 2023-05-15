package edu.max.fyl.elearn.tools;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestResult {
    private String question_1_1;
    private String question_1_2;
    private String question_1_3;
    private String question_2_1;
    private String question_2_2;
    private String question_2_3;
    private String question_3_1;
    private String question_3_2;
    private String question_3_3;
    private String question_4_1;
    private String question_4_2;
    private String question_4_3;
    private String question_5_1;
    private String question_5_2;
    private String question_5_3;

    private Integer answer_1;
    private Integer answer_2;
    private Integer answer_3;
    private Integer answer_4;
    private Integer answer_5;

    private int count;

    public int calculateResult() {
        count = getCount(question_1_1, question_1_2, question_1_3, answer_1);
        count = getCount(question_2_1, question_2_2, question_2_3, answer_2);
        count = getCount(question_3_1, question_3_2, question_3_3, answer_3);
        count = getCount(question_4_1, question_4_2, question_4_3, answer_4);
        count = getCount(question_5_1, question_5_2, question_5_3, answer_5);

        return count;
    }

    private int getCount(String question_1_1, String question_1_2,
                         String question_1_3, Integer answer) {
        if (question_1_1 != null && answer == 1) {
            count++;
        } else if (question_1_2 != null && answer == 2) {
            count++;
        } else if (question_1_3 != null && answer == 3) {
            count++;
        }

        return count;
    }
}
