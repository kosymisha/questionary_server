package com.questionary.questionary.models;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "question", nullable = false)
    String question;

    @Column(name = "image")
    String image;

    @ManyToOne
    @JoinColumn(name = "form_id")
    Form form;

    public Question() {
    }

    public Question(Long id, String question, String image, Form form) {
        this.id = id;
        this.question = question;
        this.image = image;
        this.form = form;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
