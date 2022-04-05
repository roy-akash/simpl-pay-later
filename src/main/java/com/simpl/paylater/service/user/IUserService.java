package com.simpl.paylater.service.user;

import com.simpl.paylater.model.User;
import com.simpl.paylater.request.PayBackRequest;
import com.simpl.paylater.request.UserOnBoardRequest;
import org.springframework.stereotype.Service;

@Service
public interface IUserService
{

    User onboardNewUser(UserOnBoardRequest userOnBoardRequest);

    User payBackDues(PayBackRequest payBackRequest);

}
