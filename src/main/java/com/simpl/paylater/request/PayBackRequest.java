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

public class PayBackRequest
{

    private String user;
    private double amount;

    public PayBackRequest(String user, double amount)
    {
        this.user = user;
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

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public static PayBackRequest build(String... args){
        String user = args[1];

        double paybackAmount;

        try {
            paybackAmount = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            throw new PayLaterException("Invalid Request! paybackAmount is not a number");
        }
        if(paybackAmount < 0){
            throw new PayLaterException("Invalid Request! discount percentage should be positive");
        }

        return new PayBackRequest(user,paybackAmount);
    }

    @Override
    public String toString()
    {
        return "PayBackRequest{" +
                "user='" + user + '\'' +
                ", amount=" + amount +
                '}';
    }
}