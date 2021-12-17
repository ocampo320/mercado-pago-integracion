package com.project.clubfacil.repository.paymentmethods;

import com.project.clubfacil.model.paymentMethods.CardNumber;
import com.project.clubfacil.model.paymentMethods.FinancialInstitution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardNumberRepository extends JpaRepository<CardNumber, Integer> {
}
