package com.questionary.questionary.models.answerTypes;

import com.questionary.questionary.models.Answer;
import com.questionary.questionary.models.Form;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "answer_scale")
public class Scale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 1, max = 5)
    @Column(name = "value")
    Integer value;

    @OneToMany(mappedBy = "scale")
    List<Answer> answers;

    public Scale() {
    }

    public Scale(Long id, @Size(min = 1, max = 5) Integer value, List<Answer> answers) {
        this.id = id;
        this.value = value;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
