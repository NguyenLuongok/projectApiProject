package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */

@Data
public class CampaigndetailDto {
    private int campaignDetailId;
    private int campaignId;
    private int facilityId;

    public CampaigndetailDto() {
    }

    public CampaigndetailDto(int campaignDetailId, int campaign, int facilityId) {
        this.campaignDetailId = campaignDetailId;
        this.campaignId = campaign;
        this.facilityId = facilityId;
    }

    public CampaigndetailDto(int campaign, int facilityId) {
        this.campaignId = campaign;
        this.facilityId = facilityId;
    }
}
