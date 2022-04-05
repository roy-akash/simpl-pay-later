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
package com.simpl.paylater.request;

import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.Merchant;

public class TransactionRequest
{

    private String user;
    private String merchant;
    private double amount;

    public TransactionRequest(String user, String merchant, double amount)
    {
        this.user = user;
        this.merchant = merchant;
        this.amount = amount;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getMerchant()
    {
        return merchant;
    }

    public void setMerchant(String merchant)
    {
        this.merchant = merchant;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public static TransactionRequest build(String... args){
        String user = args[2];
        String merchant = args[3];
        double transactionAmount;
        try {
            transactionAmount = Double.parseDouble(args[4]);
        } catch (NumberFormatException e) {
            throw new PayLaterException("Invalid Request! transaction amount is not valid");
        }
        if(transactionAmount < 0){
            throw new PayLaterException("Invalid Request! transaction amount should be positive");
        }
        return new TransactionRequest(user,merchant,transactionAmount);
    }

    @Override
    public String toString()
    {
        return "TransactionRequest{" +
                "user='" + user + '\'' +
                ", merchant='" + merchant + '\'' +
                ", amount=" + amount +
                '}';
    }
}