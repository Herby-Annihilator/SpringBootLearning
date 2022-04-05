package com.laboratorka.minerals.repositories;

import com.laboratorka.minerals.entities.Mineral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MineralRepository extends JpaRepository<Mineral, Integer> {
}
