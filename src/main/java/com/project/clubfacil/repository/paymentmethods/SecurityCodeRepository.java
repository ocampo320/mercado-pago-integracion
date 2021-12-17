package com.project.clubfacil.repository.paymentmethods;

import com.project.clubfacil.model.paymentMethods.PaymentMethods;
import com.project.clubfacil.model.paymentMethods.SecurityCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityCodeRepository extends JpaRepository<SecurityCode, Integer> {
}
