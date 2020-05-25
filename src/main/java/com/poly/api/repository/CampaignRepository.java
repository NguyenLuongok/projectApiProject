package com.poly.api.repository;

import com.poly.api.entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    Campaign findByCampaignId(int id);

    Campaign findCampaignByCampaignName(String name);
}
