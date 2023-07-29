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
    public boolean check(TrialDTO trialDTO) {
        String cleanedText = trialDTO.getTrialValue().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean isPalindrome = isPalindrome(cleanedText);
        Trial trial = new Trial();
        trial.setTrialValue(trialDTO.getTrialValue());
        trial.setIsPalindrome(isPalindrome);
        this.trialRepository.save(trial);

        return isPalindrome;
    }

    @Override
    public List<TrialDTO> getAllTrials() {
        List<Trial> trials = this.trialRepository.findAll();
        List<TrialDTO> trialDTOs = new ArrayList<>();

        for (Trial trial : trials) {
            trialDTOs.add(new TrialDTO(trial.getId(), trial.getTrialValue(), trial.getIsPalindrome(), trial.getCreatedAt(), trial.getUpdatedAt()));
        }

        return trialDTOs;
    }

    private boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
