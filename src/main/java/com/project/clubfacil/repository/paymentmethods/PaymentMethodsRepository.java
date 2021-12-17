package com.project.clubfacil.repository.paymentmethods;


import com.project.clubfacil.model.paymentMethods.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {
}
