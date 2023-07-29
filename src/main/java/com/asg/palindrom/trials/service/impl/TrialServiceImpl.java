package com.asg.palindrom.trials.service.impl;

import com.asg.palindrom.trials.dto.TrialDTO;
import com.asg.palindrom.trials.entity.Trial;
import com.asg.palindrom.trials.repository.TrialRepository;
import com.asg.palindrom.trials.service.TrailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrialServiceImpl implements TrailService {
    private TrialRepository trialRepository;

    public TrialServiceImpl(TrialRepository trialRepository) {
        this.trialRepository = trialRepository;
    }

    @Override
    public TrialDTO save(TrialDTO trialDTO) {
        Trial trial = new Trial();
        trial.setText(trialDTO.getText());
        Trial savedTrial = this.trialRepository.save(trial);

        TrialDTO savedTrailDTO = new TrialDTO();
        savedTrailDTO.setCreatedAt(savedTrial.getCreatedAt());
        savedTrailDTO.setUpdatedAt(savedTrial.getUpdatedAt());
        savedTrailDTO.setId(savedTrial.getId());
        savedTrailDTO.setText(savedTrial.getText());

        return savedTrailDTO;
    }

    @Override
    public List<TrialDTO> getAllTrials() {
        List<Trial> trials = this.trialRepository.findAll();
        List<TrialDTO> trialDTOs = new ArrayList<>();

        for (Trial trial : trials) {
            trialDTOs.add(new TrialDTO(trial.getId(), trial.getText(), trial.getCreatedAt(), trial.getUpdatedAt()));
        }

        return trialDTOs;
    }
}
