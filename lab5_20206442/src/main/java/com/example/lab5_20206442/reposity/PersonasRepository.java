package com.example.lab5_20206442.reposity;

import com.example.lab5_20206442.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<Persona, Integer> {
}
