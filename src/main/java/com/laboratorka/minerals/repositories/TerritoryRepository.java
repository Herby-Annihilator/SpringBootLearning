package com.laboratorka.minerals.repositories;

import com.laboratorka.minerals.entities.Territory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoryRepository extends JpaRepository<Territory, Integer> {
}
