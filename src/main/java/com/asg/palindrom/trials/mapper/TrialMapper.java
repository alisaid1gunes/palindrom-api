package com.asg.palindrom.trials.mapper;

import com.asg.palindrom.trials.dto.TrialDTO;
import com.asg.palindrom.trials.entity.Trial;

public class TrialMapper implements AutoTrialMapper{
    @Override
    public TrialDTO mapToTrialDto(Trial trial) {
        return new TrialDTO(
                trial.getId(),
                trial.getTrialValue(),
                trial.getIsPalindrome(),
                trial.getCreatedAt(),
                trial.getUpdatedAt()
        );
    }

    @Override
    public Trial mapToTrial(TrialDTO trialDTO) {
       return new Trial(
               trialDTO.getId(),
               trialDTO.getTrialValue(),
               trialDTO.getIsPalindrome(),
               trialDTO.getCreatedAt(),
               trialDTO.getUpdatedAt()
       );
    }
}
