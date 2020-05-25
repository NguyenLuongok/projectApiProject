package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class NationDto {
    private int nationId;
    private String nationName;

    public NationDto() {
    }

    public NationDto(int nationId, String nationName) {
        this.nationId = nationId;
        this.nationName = nationName;
    }

    public NationDto(String nationName) {
        this.nationName = nationName;
    }
}
