package com.simpl.paylater.service.transaction;

public enum TransactionState
{

    SUCCESS("success!"),
    INSUFFICIENT_CREDIT("rejected! (reason: credit limit)");

    private String message;

    TransactionState(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
