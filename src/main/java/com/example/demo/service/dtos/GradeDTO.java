package com.example.demo.service.dtos;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GradeDTO {
    @NotBlank(message = "Course Code can not be empty")
    private String code;

    @NotNull(message = "Grade value is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Grade value must be greater than 0")
    @DecimalMax(value = "100.0", inclusive = true, message = "Grade value must be less than or equal to 100")
    private Double value;

    public GradeDTO(String code, Double value) {
        this.code = code;
        this.value = value;
    }
    public GradeDTO(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
