package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class SchoolDto {
    private int schoolId;
    private String schoolName;

    public SchoolDto(int schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }
}
