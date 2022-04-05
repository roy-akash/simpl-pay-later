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

public class MerchantEditDiscountRequest
{

    private String merchant;
    private double newDiscountPercentage;

    public MerchantEditDiscountRequest(String merchant, double newDiscountPercentage)
    {
        this.merchant = merchant;
        this.newDiscountPercentage = newDiscountPercentage;
    }

    public String getMerchant()
    {
        return merchant;
    }

    public void setMerchant(String merchant)
    {
        this.merchant = merchant;
    }

    public double getNewDiscountPercentage()
    {
        return newDiscountPercentage;
    }

    public void setNewDiscountPercentage(double newDiscountPercentage)
    {
        this.newDiscountPercentage = newDiscountPercentage;
    }

    public static MerchantEditDiscountRequest build(String... args){
        String merchantName = args[2];
        String discount = args[3];

        if(discount.charAt(discount.length()-1) != '%'){
            throw new PayLaterException("Invalid Request! % missing");
        }

        double updatedDiscountPercentage;
        try {
            updatedDiscountPercentage = Double.parseDouble(discount.substring(0,discount.length()-1));
        } catch (NumberFormatException e) {
            throw new PayLaterException("Invalid Request!");
        }

        if(updatedDiscountPercentage < 0){
            throw new PayLaterException("Invalid Request! discount percentage should be positive");
        }

        return new MerchantEditDiscountRequest(merchantName,updatedDiscountPercentage);
    }

    @Override
    public String toString()
    {
        return "MerchantEditDiscountRequest{" +
                "merchant='" + merchant + '\'' +
                ", newDiscountPercentage=" + newDiscountPercentage +
                '}';
    }
}