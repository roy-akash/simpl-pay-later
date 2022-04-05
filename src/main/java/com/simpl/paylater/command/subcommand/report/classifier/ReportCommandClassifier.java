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
package com.simpl.paylater.command.subcommand.report.classifier;

import com.simpl.paylater.command.classifier.CommandClassifier;
import com.simpl.paylater.command.ICommand;
import com.simpl.paylater.command.subcommand.report.ReportAllUsersAtCreditLimitCommand;
import com.simpl.paylater.command.subcommand.report.ReportMerchantDiscountCommand;
import com.simpl.paylater.command.subcommand.report.ReportTotalDuesCommand;
import com.simpl.paylater.command.subcommand.report.ReportUserDuesCommand;
import com.simpl.paylater.exception.PayLaterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ReportCommandClassifier")
public class ReportCommandClassifier
{

    @Autowired ReportAllUsersAtCreditLimitCommand reportAllUsersAtCreditLimitCommand;

    @Autowired ReportMerchantDiscountCommand reportMerchantDiscountCommand;

    @Autowired ReportTotalDuesCommand reportTotalDues;

    @Autowired ReportUserDuesCommand reportUserDuesCommand;

    public ICommand getRequiredCommand(String... args){

        if(args.length == 1){
            throw new PayLaterException(" Create Command (New) is incomplete! ");
        }

        ReportCommandType newCommandType = ReportCommandType.fromName(args[1]);
        ICommand command;
        switch (newCommandType) {
            case REPORT_MERCHANT_DISCOUNT :
                command = reportMerchantDiscountCommand;
                break;
            case REPORT_USER_DUES:
                command = reportUserDuesCommand;
                break;
            case REPORT_USER_AT_CREDIT_LIMIT:
                command = reportAllUsersAtCreditLimitCommand;
                break;
            case REPORT_TOTAL_DUES:
                command = reportTotalDues;
                break;
            default:
                throw new PayLaterException(String.format("Invalid Command : %s ", newCommandType.getName()));
        }
        return command;
    }
}