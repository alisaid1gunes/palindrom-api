package com.asg.palindrom.trials.service;

import com.asg.palindrom.trials.dto.CreateTrialDTO;
import com.asg.palindrom.trials.dto.TrialDTO;
import com.asg.palindrom.trials.entity.Trial;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TrailService {
    Trial check(CreateTrialDTO createTrialDTO);
    List<TrialDTO> getAllTrials(Pageable pageable, String searchKeyword);
}
