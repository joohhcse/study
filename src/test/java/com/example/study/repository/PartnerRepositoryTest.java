package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PartnerRepositoryTest extends StudyApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create() {
        Partner partner = new Partner();
        partner.setName("이정재");
        partner.setStatus("REGISTERED");
        partner.setCreatedAt(LocalDateTime.now());
        partner.setCreatedBy("PartnerServer");
//        partner.setCategoryId(1L);

        Partner newPartner = partnerRepository.save(partner);
        assertNotNull(newPartner);

    }
}
