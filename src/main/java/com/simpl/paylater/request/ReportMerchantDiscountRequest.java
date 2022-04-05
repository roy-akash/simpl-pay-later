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

public class ReportMerchantDiscountRequest
{
    private String merchant;

    public ReportMerchantDiscountRequest(String merchant)
    {
        this.merchant = merchant;
    }

    public String getMerchant()
    {
        return merchant;
    }

    public void setMerchant(String merchant)
    {
        this.merchant = merchant;
    }

    @Override
    public String toString()
    {
        return "ReportMerchantDiscountRequest{" +
                "merchant='" + merchant + '\'' +
                '}';
    }
}