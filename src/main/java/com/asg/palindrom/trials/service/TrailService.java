package com.asg.palindrom.trials.service;

import com.asg.palindrom.trials.dto.TrialDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrailService {
    boolean check(TrialDTO trialDTO);
    List<TrialDTO> getAllTrials(Pageable pageable, String searchKeyword);
}
