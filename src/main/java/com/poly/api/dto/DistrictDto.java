package com.poly.api.dto;

import com.poly.api.entities.Province;
import lombok.Data;

/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class DistrictDto {
    private int districtId;
    private String districtName;
    private int provinceId;

    public DistrictDto() {
    }

    public DistrictDto(int districtId, String districtName, int province) {
        this.districtId = districtId;
        this.districtName = districtName;
        this.provinceId = province;
    }

    public DistrictDto(String districtName, int province) {
        this.districtName = districtName;
        this.provinceId = province;
    }
}
