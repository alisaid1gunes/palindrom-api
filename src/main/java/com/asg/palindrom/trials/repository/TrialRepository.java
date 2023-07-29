package com.asg.palindrom.trials.repository;

import com.asg.palindrom.trials.entity.Trial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrialRepository extends JpaRepository<Trial, Long> { }
