package com.simpl.paylater.service.merchant;

import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.request.MerchantEditDiscountRequest;
import com.simpl.paylater.request.MerchantOnBoardRequest;
import org.springframework.stereotype.Service;

@Service
public interface IMerchantService
{

    Merchant onboardNewMerchant(MerchantOnBoardRequest merchantOnBoardRequest);

    Merchant editDiscountForMerchant(MerchantEditDiscountRequest merchantEditDiscountRequest);

}
