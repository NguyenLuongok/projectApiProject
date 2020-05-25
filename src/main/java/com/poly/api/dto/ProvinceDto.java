package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class ProvinceDto {
    private int provinceId;
    private String provinceName;

    public ProvinceDto(int provinceId, String provinceName) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

    public ProvinceDto(String provinceName) {
        this.provinceName = provinceName;
    }
}
