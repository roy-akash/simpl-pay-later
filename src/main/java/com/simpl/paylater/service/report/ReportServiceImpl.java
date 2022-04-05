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
package com.simpl.paylater.service.report;

import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.model.User;
import com.simpl.paylater.repository.IMerchantRepository;
import com.simpl.paylater.repository.IUserRepository;
import com.simpl.paylater.request.ReportMerchantDiscountRequest;
import com.simpl.paylater.request.ReportUserDuesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements IReportService
{

    @Autowired IUserRepository userRepository;

    @Autowired IMerchantRepository merchantRepository;

    @Override
    public List<User> usersAtCreditLimit()
    {
        return userRepository.fetchUsersAtCreditLimit().orElse(new ArrayList<>());
    }

    @Override
    public List<User> totalDuesForAllUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public double duesForAUser(ReportUserDuesRequest reportUserDuesRequest)
    {
        Optional<User> user = userRepository.findById(reportUserDuesRequest.getUser());
        if(!user.isPresent()){
            throw new PayLaterException("user does not exist");
        }

        return user.get().getDues();
    }

    @Override
    public double totalDiscountProvidedByMerchant(ReportMerchantDiscountRequest reportMerchantDiscountRequest)
    {
        Optional<Merchant> merchant = merchantRepository.findById(reportMerchantDiscountRequest.getMerchant());
        if(!merchant.isPresent()){
            throw new PayLaterException("merchant does not exist");
        }
        return merchant.get().getTotalDiscountAmount();
    }
}