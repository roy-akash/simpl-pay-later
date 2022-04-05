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
package com.simpl.paylater.service.transaction;

import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.Merchant;
import com.simpl.paylater.model.Transaction;
import com.simpl.paylater.model.User;
import com.simpl.paylater.repository.IMerchantRepository;
import com.simpl.paylater.repository.ITransactionRepository;
import com.simpl.paylater.repository.IUserRepository;
import com.simpl.paylater.request.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements ITransactionService
{
    @Autowired IUserRepository userRepository;

    @Autowired IMerchantRepository merchantRepository;

    @Autowired ITransactionRepository transactionRepository;

    @Override
    @Transactional
    public TransactionState processTransaction(TransactionRequest transactionRequest)
    {
        Optional<User> user = userRepository.findById(transactionRequest.getUser());
        if(!user.isPresent()){
            throw new PayLaterException("user is not registered");
        }

        Optional<Merchant> merchant = merchantRepository.findById(transactionRequest.getMerchant());
        if(!merchant.isPresent()){
            throw new PayLaterException("merchant is not registered");
        }

        double totalAmount = transactionRequest.getAmount();
        double discount = (totalAmount * merchant.get().getDiscountPercentage()) / 100D;

        double availableCreditForUser = user.get().getCreditLimit() - user.get().getDues();

        if(availableCreditForUser < totalAmount - discount){
            return TransactionState.INSUFFICIENT_CREDIT;
        }

        user.get().setDues(user.get().getDues() + (totalAmount - discount));
        userRepository.save(user.get());

        Transaction transaction = new Transaction(transactionRequest.getAmount(),discount,user.get().getName(),merchant.get().getName());
        transactionRepository.save(transaction);

        merchant.get().setTotalDiscountAmount(merchant.get().getTotalDiscountAmount() + discount);
        merchantRepository.save(merchant.get());

        return TransactionState.SUCCESS;

    }
}