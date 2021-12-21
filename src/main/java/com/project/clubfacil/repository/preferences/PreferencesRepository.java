package com.project.clubfacil.repository.preferences;

import com.project.clubfacil.model.preferences.Preferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences, Integer> {
}
