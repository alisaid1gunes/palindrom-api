package com.asg.palindrom.trials.controller;

import com.asg.palindrom.trials.dto.CreateTrialDTO;
import com.asg.palindrom.trials.dto.TrialDTO;
import com.asg.palindrom.trials.entity.Trial;
import com.asg.palindrom.trials.service.TrailService;
import com.asg.palindrom.shared.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trials")
public class TrialController {
    private TrailService trailService;

    public TrialController(TrailService trailService) {
        this.trailService = trailService;
    }

    @PostMapping("/check")
    public ApiResponse<Trial> saveTrail(@RequestBody @Valid CreateTrialDTO createTrialDTO) {
        Trial trial = this.trailService.check(createTrialDTO);
        return new ApiResponse<>(true, trial, "Palindrome check successful.");
    }

    @GetMapping("/")
    public ApiResponse<List<TrialDTO>> getAllTrials(
            @RequestParam(required = false) String trialValue,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Sort sortObj = Sort.by(Sort.Direction.DESC, "createdAt");
        if (page>0) page--;
        Pageable pageable = PageRequest.of(page, pageSize, sortObj);
        List<TrialDTO> trials = this.trailService.getAllTrials(pageable, trialValue);
        return new ApiResponse<>(true, trials, "Trials fetched successfully.");
    }

}
