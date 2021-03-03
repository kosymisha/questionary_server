package com.questionary.questionary.models;

import com.questionary.questionary.models.answerTypes.AnswerType;
import com.questionary.questionary.models.answerTypes.Scale;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "answer")
    String answer;

    @Column(name = "answer_type")
    AnswerType answerType;

    @ManyToOne
    @JoinColumn(name = "ans_user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "ans_scale_id")
    Scale scale;

    public Answer() {
    }

    public Answer(Long id, String answer, AnswerType answerType, User user, Scale scale) {
        this.id = id;
        this.answer = answer;
        this.answerType = answerType;
        this.user = user;
        this.scale = scale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }
}
