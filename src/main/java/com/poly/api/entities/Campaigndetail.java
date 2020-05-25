package com.poly.api.entities;

import lombok.Data;

import javax.persistence.*;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Entity
@Table(name = "campaigndetail")
@Data
public class Campaigndetail {
    @Id
    private int campaignDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaignId")
    private Campaign campaign;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facilityId")
    private Facility facility;

    public Campaigndetail() {

    }

    public Campaigndetail(int campaignDetailId, Campaign campaign, Facility facilityId) {
        this.campaignDetailId = campaignDetailId;
        this.campaign = campaign;
        this.facility = facilityId;
    }

    public Campaigndetail(Campaign campaign, Facility facilityId) {
        this.campaign = campaign;
        this.facility = facilityId;
    }


}
