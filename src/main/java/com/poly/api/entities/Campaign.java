package com.poly.api.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Entity
@Table(name = "campaign")
@Data
public class Campaign {
    @Id
    private int campaignId;
    private String campaignName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "campaign")
    private Set<Campaigndetail> districts = new HashSet<Campaigndetail>(0);

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "facilityId")
//    private Facility facility;

    public Campaign() {
    }

    public Campaign(int campaignId, String campaignName) {
        this.campaignId = campaignId;
        this.campaignName = campaignName;
    }

    public Campaign(String campaignName) {
        this.campaignName = campaignName;
    }


}
