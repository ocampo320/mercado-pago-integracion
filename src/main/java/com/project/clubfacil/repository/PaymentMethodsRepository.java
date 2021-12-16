package com.project.clubfacil.repository;


import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.model.paymentMethods.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {
}
