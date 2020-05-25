package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class SpecializedDto {
    private int specializedId;
    private String specializedName;

    public SpecializedDto(int specializedId, String specializedName) {
        this.specializedId = specializedId;
        this.specializedName = specializedName;
    }
}
