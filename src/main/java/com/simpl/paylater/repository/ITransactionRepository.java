
package com.simpl.paylater.repository;

import com.simpl.paylater.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository
        extends JpaRepository<Transaction, String> {
}
