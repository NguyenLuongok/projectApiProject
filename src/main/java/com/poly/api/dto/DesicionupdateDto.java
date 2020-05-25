package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class DesicionupdateDto {
    private int decisionUpdateId;
    private String namePdf;
    private int desiciondetailId;

    public DesicionupdateDto() {
    }

    public DesicionupdateDto(int decisionUpdateId, String namePdf, int desiciondetailId) {
        this.decisionUpdateId = decisionUpdateId;
        this.namePdf = namePdf;
        this.desiciondetailId = desiciondetailId;
    }
}
