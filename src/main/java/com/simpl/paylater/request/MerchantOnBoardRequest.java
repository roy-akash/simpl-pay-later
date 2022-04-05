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

import java.util.List;

public class MerchantOnBoardRequest
{

    private String name;
    private String email;
    private double discountPercentage;

    public MerchantOnBoardRequest(String name, String email, double discountPercentage)
    {
        this.name = name;
        this.email = email;
        this.discountPercentage = discountPercentage;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public double getDiscountPercentage()
    {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage)
    {
        this.discountPercentage = discountPercentage;
    }

    public static MerchantOnBoardRequest build(String... args) {
        String name = args[2];
        String email = args[3];
        String discount = args[4];

        if(discount.charAt(discount.length()-1) != '%'){
            throw new PayLaterException("Invalid Request! % missing");
        }

        double discountPercentage;

        try {
            discountPercentage = Double.parseDouble(discount.substring(0,discount.length()-1));
        } catch (NumberFormatException e) {
            throw new PayLaterException("Invalid Request!");
        }

        if(discountPercentage < 0){
            throw new PayLaterException("Invalid Request! discount percentage should be positive");
        }

        return new MerchantOnBoardRequest(name, email, discountPercentage);
    }

    @Override
    public String toString()
    {
        return "MerchantOnBoardRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", discountPercentage=" + discountPercentage +
                '}';
    }
}