package com.laboratorka.minerals.repositories;

import com.laboratorka.minerals.entities.Ore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OreRepository extends JpaRepository<Ore, Integer> {
}
