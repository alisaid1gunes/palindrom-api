package com.asg.palindrom.trials.entity;

import jakarta.persistence.*;

@Entity
@Table(indexes = @Index(columnList = "text"))
public class Trial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    public Trial() {}

    public Trial(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}