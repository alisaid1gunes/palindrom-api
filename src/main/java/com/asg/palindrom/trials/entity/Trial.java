package com.asg.palindrom.trials.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity

public class Trial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String trialValue;

    @Column(nullable = false)
    private boolean isPalindrome;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Trial() {
    }

    public Trial(Long id, String trialValue, boolean isPalindrome, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.trialValue = trialValue;
        this.isPalindrome= isPalindrome;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrialValue() {
        return trialValue;
    }

    public void setTrialValue(String trialValue) {
        this.trialValue = trialValue;
    }

    public boolean getIsPalindrome() {
        return isPalindrome;
    }

    public void setIsPalindrome(boolean palindrome) {
        isPalindrome = palindrome;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Trial{" +
                "id=" + id +
                ", trialValue='" + trialValue + '\'' +
                ", isPalindrome=" + isPalindrome +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}