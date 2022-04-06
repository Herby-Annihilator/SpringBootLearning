package com.laboratorka.minerals.repositories;

import com.laboratorka.minerals.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {
}
