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
 * @since Sun, 03-04-2022
 */
package com.simpl.paylater.command.subcommand.update;

import com.simpl.paylater.command.ICommand;
import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.request.MerchantEditDiscountRequest;
import com.simpl.paylater.service.merchant.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantEditDiscountCommand implements ICommand
{

    @Autowired IMerchantService merchantService;

    @Override
    public void validateInput(String... args)
    {
        if(args.length < 4){
            throw new PayLaterException("Incomplete arguments for merchant discount update command");
        }
    }

    @Override
    public String run(String... args)
    {
        Merchant merchant = merchantService.editDiscountForMerchant(MerchantEditDiscountRequest.build(args));
        return merchant.getName() + "("+ merchant.getDiscountPercentage() +"%)" ;
    }
}