package com.lari.trainingcenter.services;

import com.lari.trainingcenter.dtos.TrainingCenterDto;
import com.lari.trainingcenter.models.TrainingCenter;
import com.lari.trainingcenter.repositories.TrainingCenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainingCenterServiceImpl implements TrainingCenterService {

    private final TrainingCenterRepository trainingCenterRepository;
    private final ModelMapper modelMapper;


    @Override
    public TrainingCenterDto createTrainingCenter(TrainingCenterDto trainingCenterDto) {
        log.info("Creating a new training center with name: {}", trainingCenterDto.getCenterName());
        TrainingCenter trainingCenter = modelMapper.map(trainingCenterDto, TrainingCenter.class);
        BeanUtils.copyProperties(trainingCenterDto, trainingCenter);
        trainingCenter = trainingCenterRepository.save(trainingCenter);
        log.info("Training center created with ID: {}", trainingCenter.getId());
        trainingCenterDto = modelMapper.map(trainingCenter, TrainingCenterDto.class);
        return trainingCenterDto;
    }

    @Override
    public List<TrainingCenterDto> getAllTrainingCenters(String centerName, String city, String state,
                                                         Integer minCapacity, Integer maxCapacity,
                                                         String courseOffered) {
        log.info("Fetching all training centers");
        List<TrainingCenterDto> trainingCenterDtos = trainingCenterRepository.findAll().stream()
                .map(trainingCenter -> modelMapper.map(trainingCenter, TrainingCenterDto.class)).toList();
        log.info("Fetched {} training centers", trainingCenterDtos.size());
        return trainingCenterDtos;
    }
}
