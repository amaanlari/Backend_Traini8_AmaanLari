package com.lari.trainingcenter.dtos;

import com.lari.trainingcenter.models.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TrainingCenterDto {

    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name should not exceed 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is required")
    @Size(min = 12, max = 12, message = "Center code should be 12 characters long")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code should contain only alphanumeric characters")
    private String centerCode;

    @Valid
    private Address address;

    @Positive
    private Integer studentCapacity;

    private List<String> coursesOffered;

    private LocalDateTime createdOn;

    @Email(message = "Invalid email")
    private String contactEmail;

    @Pattern(regexp = "\\d{10}$", message = "Invalid phone number, must be 10 digits")
    private String contactPhone;

}
