package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class DesicionDto {
    private int decisionId;
    private String decisionName;

    public DesicionDto() {
    }

    public DesicionDto(int decisionId, String decisionName) {
        this.decisionId = decisionId;
        this.decisionName = decisionName;
    }

    public DesicionDto(String decisionName) {
        this.decisionName = decisionName;
    }
}
