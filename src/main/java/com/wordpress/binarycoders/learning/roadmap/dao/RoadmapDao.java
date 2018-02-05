package com.wordpress.binarycoders.learning.roadmap.dao;

import com.wordpress.binarycoders.learning.roadmap.entity.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoadmapDao extends JpaRepository<Roadmap, Long> {
}
