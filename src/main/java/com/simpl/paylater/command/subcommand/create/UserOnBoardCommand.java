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
package com.simpl.paylater.command.subcommand.create;

import com.simpl.paylater.command.ICommand;
import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.User;
import com.simpl.paylater.request.UserOnBoardRequest;
import com.simpl.paylater.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOnBoardCommand implements ICommand
{

    @Autowired IUserService userService;

    @Override
    public void validateInput(String... args)
    {
        if(args.length<5){
            throw new PayLaterException("Incomplete arguments for user on boarding request");
        }
    }

    @Override
    public String run(String... args)
    {
       User user = userService.onboardNewUser(UserOnBoardRequest.build(args));
       return user.getName() + "(" + user.getCreditLimit() + ")";
    }
}