package com.asg.palindrom.trials.controller;


import com.asg.palindrom.trials.dto.TrialDTO;
import com.asg.palindrom.trials.service.TrailService;
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
    public boolean saveTrail(@RequestBody TrialDTO trailDto) {

        return this.trailService.check(trailDto);
    }

    @GetMapping("/")
    public List<TrialDTO> getAllTrials(
            @RequestParam(required = false) String searchKeyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Sort sortObj = Sort.by(Sort.Direction.DESC, "createdAt");
        if (page>0) page--;
        Pageable pageable = PageRequest.of(page, pageSize, sortObj);
        return this.trailService.getAllTrials(pageable, searchKeyword);
    }

}
