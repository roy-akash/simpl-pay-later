package com.simpl.paylater.service.report;

import com.simpl.paylater.model.User;
import com.simpl.paylater.request.ReportMerchantDiscountRequest;
import com.simpl.paylater.request.ReportUserDuesRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IReportService
{

    List<User> usersAtCreditLimit();

    List<User> totalDuesForAllUsers();

    double duesForAUser(ReportUserDuesRequest reportUserDuesRequest);

    double totalDiscountProvidedByMerchant(ReportMerchantDiscountRequest reportMerchantDiscountRequest);

}
