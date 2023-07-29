package com.asg.palindrom.trials.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class TrialDTO {
    private Long id;
    @NotEmpty
    @NotNull
    @NotBlank
    @Size(min = 1, message = "text field should have at least 1 characters")
    private String trialValue;

    @NotNull
    private boolean isPalindrome;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TrialDTO(Long id, String trialValue,  boolean isPalindrome, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.isPalindrome = isPalindrome;
        this.trialValue = trialValue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TrialDTO() {
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

    public void setIsPalindrome(boolean isPalindrome) {
        this.isPalindrome = isPalindrome;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "TrialDTO{" +
                "id=" + id +
                ", trialValue='" + trialValue + '\'' +
                ", isPalindrome=" + isPalindrome +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
