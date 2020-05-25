package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class TrainingsystemDto {
    private int trainingSystemId;
    private String trainingSystemName;

    public TrainingsystemDto(int trainingSystemId, String trainingSystemName) {
        this.trainingSystemId = trainingSystemId;
        this.trainingSystemName = trainingSystemName;
    }

    public TrainingsystemDto(String trainingSystemName) {
        this.trainingSystemName = trainingSystemName;
    }
}
