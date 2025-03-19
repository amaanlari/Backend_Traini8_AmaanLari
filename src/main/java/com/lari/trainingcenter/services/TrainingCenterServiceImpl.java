package com.lari.trainingcenter.services;

import com.lari.trainingcenter.dtos.TrainingCenterDto;
import com.lari.trainingcenter.models.TrainingCenter;
import com.lari.trainingcenter.repositories.TrainingCenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainingCenterServiceImpl implements TrainingCenterService {

    private final TrainingCenterRepository trainingCenterRepository;


    @Override
    public TrainingCenterDto createTrainingCenter(TrainingCenterDto trainingCenterDto) {
        log.info("Creating a new training center with name: {}", trainingCenterDto.getCenterName());
        TrainingCenter trainingCenter = new TrainingCenter();
        BeanUtils.copyProperties(trainingCenterDto, trainingCenter);
        trainingCenter = trainingCenterRepository.save(trainingCenter);
        log.info("Training center created with ID: {}", trainingCenter.getId());
        BeanUtils.copyProperties(trainingCenterDto, trainingCenterDto);
        return trainingCenterDto;
    }

    @Override
    public List<TrainingCenterDto> getAllTrainingCenters() {
        log.info("Fetching all training centers");
        List<TrainingCenterDto> trainingCenterDtos = trainingCenterRepository.findAll().stream()
                .map(trainingCenter -> {
                    TrainingCenterDto trainingCenterDto = new TrainingCenterDto();
                    BeanUtils.copyProperties(trainingCenter, trainingCenterDto);
                    return trainingCenterDto;
                }).toList();
        log.info("Fetched {} training centers", trainingCenterDtos.size());
        return List.of();
    }
}
