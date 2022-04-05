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
package com.simpl.paylater.command.subcommand.create.classifier;

import com.simpl.paylater.command.classifier.CommandClassifier;
import com.simpl.paylater.command.ICommand;
import com.simpl.paylater.command.subcommand.create.MerchantOnBoardCommand;
import com.simpl.paylater.command.subcommand.create.TransactionCommand;
import com.simpl.paylater.command.subcommand.create.UserOnBoardCommand;
import com.simpl.paylater.exception.PayLaterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("NewCommandClassifier")
public class NewCommandClassifier
{

    @Autowired
    UserOnBoardCommand userOnBoardCommand;

    @Autowired
    MerchantOnBoardCommand merchantOnBoardCommand;

    @Autowired
    TransactionCommand transactionCommand;

    public ICommand getRequiredCommand(String... args){

        if(args.length == 1){
            throw new PayLaterException(" Create Command (New) is incomplete! ");
        }

        NewCommandType newCommandType = NewCommandType.fromName(args[1]);
        ICommand command;
        switch (newCommandType) {
            case USER:
                command = userOnBoardCommand;
                break;
            case MERCHANT:
                command = merchantOnBoardCommand;
                break;
            case TRANSACTION:
                command = transactionCommand;
                break;
            default:
                throw new PayLaterException(String.format("Invalid Command : %s ", newCommandType.getName()));
        }
        return command;
    }
}