
package com.simpl.paylater.repository;

import com.simpl.paylater.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository
        extends JpaRepository<User, String> {

  @Query("SELECT u FROM User u WHERE u.dues >= u.creditLimit")
  Optional<List<User>> fetchUsersAtCreditLimit();

}
