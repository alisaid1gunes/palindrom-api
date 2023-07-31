package com.asg.palindrom.trials.repository;

import com.asg.palindrom.trials.entity.Trial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrialRepository extends JpaRepository<Trial, Long> {


    Page<Trial> findByTrialValueContainingIgnoreCase(String searchKeyword, Pageable pageable);
}
