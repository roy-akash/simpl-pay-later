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
package com.simpl.paylater.command.classifier;

import com.simpl.paylater.command.ICommand;
import com.simpl.paylater.command.subcommand.create.classifier.NewCommandClassifier;
import com.simpl.paylater.command.subcommand.payback.classifier.PayBackCommandClassifier;
import com.simpl.paylater.command.subcommand.report.classifier.ReportCommandClassifier;
import com.simpl.paylater.command.subcommand.update.classifier.UpdateCommandClassifier;
import com.simpl.paylater.exception.PayLaterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("CommandClassifier")
public class CommandClassifier
{

    @Autowired
    @Qualifier("NewCommandClassifier")
    NewCommandClassifier newCommandClassifier;

    @Autowired
    @Qualifier("ReportCommandClassifier")
    ReportCommandClassifier reportCommandClassifier;

    @Autowired
    @Qualifier("UpdateCommandClassifier")
    UpdateCommandClassifier updateCommandClassifier;

    @Autowired
    @Qualifier("PayBackCommandClassifier")
    PayBackCommandClassifier payBackCommandClassifier;

    public ICommand getRequiredCommand(String... args){

        if(args.length == 0){
            throw new PayLaterException("No input provided");
        }

        CommandType commandType = CommandType.fromName(args[0]);
        switch (commandType) {
            case NEW:
                return newCommandClassifier.getRequiredCommand(args);
            case UPDATE:
                return updateCommandClassifier.getRequiredCommand(args);
            case PAYBACK:
                return payBackCommandClassifier.getRequiredCommand(args);
            case REPORT:
                return reportCommandClassifier.getRequiredCommand(args);
            default:
                throw new PayLaterException(String.format("Invalid Command : %s ", commandType.getName()));
        }

    }

}