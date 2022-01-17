package com.project.clubfacil.repository.preferences;

import com.project.clubfacil.model.paymentMethods.BinEntity;
import com.project.clubfacil.model.preferences.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhonePreferenceRepository  extends JpaRepository<Phone, Integer> {

    Optional<Phone> findAllByNumber (String number);
}
