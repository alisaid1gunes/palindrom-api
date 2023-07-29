package com.asg.palindrom.trials.service;

import com.asg.palindrom.trials.dto.TrialDTO;

import java.util.List;

public interface TrailService {
    TrialDTO save(TrialDTO trialDTO);
    List<TrialDTO> getAllTrials();
}
