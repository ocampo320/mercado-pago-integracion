package com.project.clubfacil.repository.preferences;

import com.project.clubfacil.model.preferences.Identification;
import com.project.clubfacil.model.preferences.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdetentificationPreferencesRepository extends JpaRepository<Identification, Integer> {

    Optional<Identification> findAllByType(String type);
}
