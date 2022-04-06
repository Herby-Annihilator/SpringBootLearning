package com.laboratorka.minerals.repositories;

import com.laboratorka.minerals.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
