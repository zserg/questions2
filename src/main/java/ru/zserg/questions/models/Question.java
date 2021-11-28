package ru.zserg.questions.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    private String question;
    private String answer;

    public void update(Question q){
        if(q.question != null){
            this.question = q.getQuestion();
        }
        if(q.answer != null){
            this.answer = q.getAnswer();
        }
    }
}
