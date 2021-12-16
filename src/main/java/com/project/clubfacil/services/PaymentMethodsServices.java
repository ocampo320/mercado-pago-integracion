package com.project.clubfacil.services;

import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.model.paymentMethods.*;
import com.project.clubfacil.repository.PaymentMethodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class PaymentMethodsServices {


    @Autowired
    PaymentMethodsRepository paymentMethodsRepository;


    @Autowired
    RestTemplate restTemplate;

    public List<PaymentMethods> getPaymentMethods() {
        List<ProcessingModes> processingModesList = new ArrayList<>();
        List<AdditionalInfoNeeded> additionalInfoNeededList = new ArrayList<>();
        CardNumber cardNumberNew = new CardNumber();
        Bin binNew = new Bin();
        SecurityCode securityCodeNew = new SecurityCode();
        List<FinancialInstitution> financialInstitutionList = new ArrayList<>();


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer APP_USR-3951552830330174-121221-5adc5eb48689499ac13c310710d71299-109891437");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<IdentificationTypes> entity = new HttpEntity<IdentificationTypes>(headers);
        ResponseEntity<PaymentMethods[]> paymentMethodsList = restTemplate.exchange("https://api.mercadopago.com/v1/payment_methods", HttpMethod.GET, entity, PaymentMethods[].class);


        if (paymentMethodsList.getStatusCode().equals(HttpStatus.OK)) {


            /**
             * Recorre el objeto de metodos de pago de mercado pago, y si tiene datos crea el objeto para guardar en la BD
             */
            Arrays.stream(paymentMethodsList.getBody()).forEach(paymentMethods -> {
                PaymentMethods paymentMethodsNew = new PaymentMethods();

                /**
                 * Se crea AdditionalInfoNeeded
                 */
                if (paymentMethods.getAdditional_info_needed() != null || paymentMethods.getAdditional_info_needed().size() > 0) {

                    paymentMethods.getAdditional_info_needed().forEach(additionalInfoNeeded -> {
                        AdditionalInfoNeeded additionalInfoNeededNew = new AdditionalInfoNeeded();
                        additionalInfoNeededNew.setInfo(additionalInfoNeeded.getInfo());
                        additionalInfoNeededNew.setId(additionalInfoNeeded.getId());
                        additionalInfoNeededList.add(additionalInfoNeededNew);
                    });


                    /**
                     * Se crea Setting
                     */
                    List<Setting> settingList = new ArrayList<>();
                    if (paymentMethods.getSettings().size() > 0) {
                        Setting settingNew = new Setting();
                        paymentMethods.getSettings().forEach(setting -> {


                            /**
                             * Se crea CardNumber
                             */
                            if (setting.getCard_number() != null) {
                                cardNumberNew.setValidation(setting.getCard_number().getValidation());
                                cardNumberNew.setLength(setting.getCard_number().getLength());
                                settingNew.setCard_number(cardNumberNew);
                            }

                            /**
                             * Se crea Bin
                             */
                            if (setting.getBin() != null) {
                                binNew.setPattern(setting.getBin().getPattern());
                                binNew.setInstallments_pattern(setting.getBin().getInstallments_pattern());
                                binNew.setExclusion_pattern(setting.getBin().getExclusion_pattern());
                                settingNew.setBin(binNew);
                            }

                            /**
                             * Se crea SecurityCode
                             */
                            if (setting.getSecurity_code() != null) {
                                securityCodeNew.setLength(setting.getSecurity_code().getLength());
                                securityCodeNew.setCard_location(setting.getSecurity_code().getCard_location());
                                securityCodeNew.setMode(setting.getSecurity_code().getMode());
                                settingNew.setSecurity_code(securityCodeNew);
                            }

                            /**
                             * Se crea processMode
                             */
                            if (paymentMethods.getProcessing_modes().size() > 0) {
                                paymentMethods.getProcessing_modes().forEach(processingModes -> {
                                    ProcessingModes processModeNew = new ProcessingModes();
                                    processModeNew.setInfo(processModeNew.getInfo());
                                    processingModesList.add(processModeNew);

                                });
                                paymentMethodsNew.setProcessing_modes(processingModesList);
                            }
                            /**
                             * Se crea la lista de bancos
                             */

                            if (paymentMethods.getFinancial_institutions().size() > 0) {

                                FinancialInstitution financialInstitutionNew = new FinancialInstitution();
                                paymentMethods.getFinancial_institutions().forEach(financialInstitution -> {
                                    financialInstitutionNew.setDescription(financialInstitution.getDescription());
                                    financialInstitutionNew.setId(financialInstitution.getId());
                                    financialInstitutionList.add(financialInstitutionNew);
                                });
                                paymentMethodsNew.setFinancial_institutions(financialInstitutionList);
                            }

                            /**
                             * Se arma el objeto completo
                             */

                            settingList.add(settingNew);

                            paymentMethodsNew.setId(paymentMethods.getId());
                            paymentMethodsNew.setName(paymentMethods.getName());
                            paymentMethodsNew.setPayment_type_id(paymentMethods.getPayment_type_id());
                            paymentMethodsNew.setStatus(paymentMethods.getStatus());
                            paymentMethodsNew.setSecure_thumbnail(paymentMethods.getSecure_thumbnail());
                            paymentMethodsNew.setThumbnail(paymentMethods.getThumbnail());
                            paymentMethodsNew.setDeferred_capture(paymentMethods.getDeferred_capture());


                            paymentMethodsNew.setSettings(settingList);


                            paymentMethodsNew.setMin_allowed_amount(paymentMethods.getMin_allowed_amount());
                            paymentMethodsNew.setMax_allowed_amount(paymentMethods.getMax_allowed_amount());
                            paymentMethodsNew.setAccreditation_time(paymentMethods.getAccreditation_time());


                        });

                    }
                }

            });

        }


        return null;
        //  return identificationTypesRepository.findAll();
    }
}
