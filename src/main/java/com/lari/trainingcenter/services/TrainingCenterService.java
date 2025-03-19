package com.lari.trainingcenter.services;

import com.lari.trainingcenter.dtos.TrainingCenterDto;

import java.util.List;

public interface TrainingCenterService {

    TrainingCenterDto createTrainingCenter(TrainingCenterDto trainingCenterDto);

    List<TrainingCenterDto> getAllTrainingCenters(String centerName, String city, String state,
                                                  Integer minCapacity, Integer maxCapacity,
                                                  String courseOffered);
}
