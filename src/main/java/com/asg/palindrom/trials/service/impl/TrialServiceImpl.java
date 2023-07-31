package com.asg.palindrom.trials.service.impl;

import com.asg.palindrom.trials.dto.TrialDTO;
import com.asg.palindrom.trials.entity.Trial;
import com.asg.palindrom.trials.mapper.AutoTrialMapper;
import com.asg.palindrom.trials.repository.TrialRepository;
import com.asg.palindrom.trials.service.TrailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        trialDTO.setIsPalindrome(isPalindrome);
        Trial trial = AutoTrialMapper.MAPPER.mapToTrial(trialDTO);
        this.trialRepository.save(trial);

        return isPalindrome;
    }

    @Override
    public List<TrialDTO> getAllTrials(Pageable pageable, String searchKeyword) {

        Page<Trial> trialPage;
        if (searchKeyword == null) {
            trialPage = this.trialRepository.findAll(pageable);
        } else {
            trialPage = this.trialRepository.findByTrialValueContainingIgnoreCase(searchKeyword, pageable);
        }

        return trialPage.getContent()
                .stream()
                .map(AutoTrialMapper.MAPPER::mapToTrialDto)
                .collect(Collectors.toList());
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
