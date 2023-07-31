package com.asg.palindrom.trials.mapper;

import com.asg.palindrom.trials.dto.TrialDTO;
import com.asg.palindrom.trials.entity.Trial;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoTrialMapper {
    AutoTrialMapper MAPPER = Mappers.getMapper(AutoTrialMapper.class);
    TrialDTO mapToTrialDto(Trial trial);
    Trial mapToTrial(TrialDTO trialDTO);
}
