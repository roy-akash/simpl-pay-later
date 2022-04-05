
package com.simpl.paylater.repository;

import com.simpl.paylater.model.Merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMerchantRepository
        extends JpaRepository<Merchant, String> {
}
