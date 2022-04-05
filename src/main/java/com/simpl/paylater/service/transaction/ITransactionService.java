package com.simpl.paylater.service.transaction;

import com.simpl.paylater.request.TransactionRequest;
import org.springframework.stereotype.Service;

@Service
public interface ITransactionService
{
    TransactionState processTransaction(TransactionRequest transactionRequest);
}
