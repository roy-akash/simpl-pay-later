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
package com.simpl.paylater.command.subcommand.report;

import com.simpl.paylater.command.ICommand;
import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.User;
import com.simpl.paylater.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportAllUsersAtCreditLimitCommand implements ICommand {

    private static final String END_LINE = "\n";

    @Autowired IReportService reportService;

    @Override
    public void validateInput(String... args)
    {
        if(args.length < 2){
            throw new PayLaterException("Incomplete arguments for Report All Users At Credit Limit Command");
        }
    }

    @Override
    public String run(String... args)
    {
        List<User> users = reportService.usersAtCreditLimit();
        StringBuilder result = new StringBuilder();

        users.forEach(user -> result.append(user.getName()).append(END_LINE));

        return result.toString();
    }
}