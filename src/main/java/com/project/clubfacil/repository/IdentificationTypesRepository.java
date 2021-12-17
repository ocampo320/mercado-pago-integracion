package com.project.clubfacil.repository;

import com.project.clubfacil.model.IdentificationTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationTypesRepository extends JpaRepository<IdentificationTypes, Integer> {
}
