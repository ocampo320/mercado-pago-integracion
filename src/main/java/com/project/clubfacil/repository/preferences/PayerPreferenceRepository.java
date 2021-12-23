package com.project.clubfacil.repository.preferences;

import com.project.clubfacil.model.preferences.Payer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayerPreferenceRepository extends JpaRepository<Payer, Integer> {
}
