package com.poly.api.dto;

import lombok.Data;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Data
public class CampaignDto {
    private int campaignId;
    private String campaignName;

    public CampaignDto() {
    }

    public CampaignDto(int campaignId, String campaignName) {
        this.campaignId = campaignId;
        this.campaignName = campaignName;
    }

    public CampaignDto(String campaignName) {
        this.campaignName = campaignName;
    }
}
