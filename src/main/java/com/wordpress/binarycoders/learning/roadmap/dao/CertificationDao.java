package com.wordpress.binarycoders.learning.roadmap.dao;

import com.wordpress.binarycoders.learning.roadmap.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationDao extends JpaRepository<Certification, Long> {
}
