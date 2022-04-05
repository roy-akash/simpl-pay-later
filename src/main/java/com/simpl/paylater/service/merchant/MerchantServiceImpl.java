/**
 * Licensed to the Airtel International LLP (AILLP) under one
 * or more contributor license agreements.
 * The AILLP licenses this file to you under the AA License, Version 1.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Akash Roy
 * @department Big Data Analytics Airtel Africa
 * @since Mon, 04-04-2022
 */
package com.simpl.paylater.service.merchant;

import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.model.User;
import com.simpl.paylater.repository.IMerchantRepository;
import com.simpl.paylater.request.MerchantEditDiscountRequest;
import com.simpl.paylater.request.MerchantOnBoardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantServiceImpl implements IMerchantService
{

    @Autowired IMerchantRepository merchantRepository;

    @Override
    public Merchant onboardNewMerchant(MerchantOnBoardRequest merchantOnBoardRequest)
    {
        Optional<Merchant> merchant = merchantRepository.findById(merchantOnBoardRequest.getName());

        if (merchant.isPresent()){
            throw new PayLaterException("One merchant can not be registered multiple times");
        }

        Merchant merchantObj = new Merchant(merchantOnBoardRequest.getEmail(),merchantOnBoardRequest.getName(),merchantOnBoardRequest.getDiscountPercentage());
        return merchantRepository.save(merchantObj);
    }

    @Override
    public Merchant editDiscountForMerchant(MerchantEditDiscountRequest merchantEditDiscountRequest)
    {
        Optional<Merchant> merchant = merchantRepository.findById(merchantEditDiscountRequest.getMerchant());

        if(merchant.isPresent()){
            merchant.get().setDiscountPercentage(merchantEditDiscountRequest.getNewDiscountPercentage());
            return merchantRepository.save(merchant.get());
        }else {
            throw new PayLaterException("Merchant does not exist");
        }
    }

}