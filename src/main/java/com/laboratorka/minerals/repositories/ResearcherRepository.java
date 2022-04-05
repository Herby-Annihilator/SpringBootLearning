package com.laboratorka.minerals.repositories;

import com.laboratorka.minerals.entities.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResearcherRepository extends JpaRepository<Researcher, Integer> {
}
