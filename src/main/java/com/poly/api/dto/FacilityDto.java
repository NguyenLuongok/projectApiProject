package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class FacilityDto {
    private int facilityId;
    private String facilityName;

    public FacilityDto() {
    }

    public FacilityDto(int facilityId, String facilityName) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
    }

    public FacilityDto(String facilityName) {
        this.facilityName = facilityName;
    }
}
