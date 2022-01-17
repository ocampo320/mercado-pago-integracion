package com.project.clubfacil.repository.preferences;

import com.project.clubfacil.model.preferences.Identification;
import com.project.clubfacil.model.preferences.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPreferenceRepository extends JpaRepository<Item, Integer> {
}
