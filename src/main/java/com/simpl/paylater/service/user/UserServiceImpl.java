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
package com.simpl.paylater.service.user;

import com.simpl.paylater.exception.PayLaterException;
import com.simpl.paylater.model.User;
import com.simpl.paylater.repository.IUserRepository;
import com.simpl.paylater.request.PayBackRequest;
import com.simpl.paylater.request.UserOnBoardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService
{

    @Autowired IUserRepository userRepository;

    @Override
    public User onboardNewUser(UserOnBoardRequest userOnBoardRequest)
    {

        Optional<User> user = userRepository.findById(userOnBoardRequest.getName());

        if (user.isPresent()){
            throw new PayLaterException("One user can not be registered multiple times");
        }

        User userObj = new User(userOnBoardRequest.getName(),userOnBoardRequest.getEmail(),userOnBoardRequest.getCreditLimit());

        return userRepository.save(userObj);
    }

    @Override
    public User payBackDues(PayBackRequest payBackRequest)
    {
        Optional<User> user = userRepository.findById(payBackRequest.getUser());

        if (!user.isPresent()){
            throw new PayLaterException("User in not present");
        }

        if( payBackRequest.getAmount() > user.get().getDues()){
            throw new PayLaterException("One cannot pay what he has not yet spent!");
        }

        user.get().setDues(user.get().getDues() - payBackRequest.getAmount());
        return userRepository.save(user.get());
    }
}