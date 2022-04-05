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

public class UserOnBoardRequest
{
    private String name;
    private String email;
    private double creditLimit;

    public UserOnBoardRequest(String name, String email, double creditLimit)
    {
        this.name = name;
        this.email = email;
        this.creditLimit = creditLimit;
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

    public double getCreditLimit()
    {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit)
    {
        this.creditLimit = creditLimit;
    }

    public static UserOnBoardRequest build(String... args){
        String name = args[2];
        String email = args[3];
        double creditLimit;

        try {
            creditLimit = Double.parseDouble(args[4]);
        } catch (NumberFormatException e) {
            throw new PayLaterException("Invalid Request!");
        }

        return new UserOnBoardRequest(name, email, creditLimit);
    }


    @Override
    public String toString()
    {
        return "UserOnBoardRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", creditLimit=" + creditLimit +
                '}';
    }
}