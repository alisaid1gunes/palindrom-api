package com.asg.palindrom.trials.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



public class CreateTrialDTO {
    @NotNull
    @NotBlank
    @Size(min = 1, message = "text field should have at least 1 characters")
    private String trialValue;


    public CreateTrialDTO(String trialValue) {
        this.trialValue = trialValue;
    }

    public CreateTrialDTO() {
    }


    public String getTrialValue() {
        return trialValue;
    }

    public void setTrialValue(String trialValue) {
        this.trialValue = trialValue;
    }


    @Override
    public String toString() {
        return "CreateTrialDTO{" +
                "trialValue='" + trialValue + '\'' +
                '}';
    }
}