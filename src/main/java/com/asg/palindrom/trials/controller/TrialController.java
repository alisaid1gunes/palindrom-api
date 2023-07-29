package com.asg.palindrom.trials.controller;


import com.asg.palindrom.trials.dto.TrialDTO;
import com.asg.palindrom.trials.service.TrailService;
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
    public boolean saveTrail(@RequestBody TrialDTO trailDto) {

        return this.trailService.check(trailDto);
    }

    @GetMapping()
    public List<TrialDTO> getAllTrials(){
        return this.trailService.getAllTrials();
    }
}
