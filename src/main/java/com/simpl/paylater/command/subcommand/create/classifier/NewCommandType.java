package com.simpl.paylater.command.subcommand.create.classifier;

import com.simpl.paylater.exception.PayLaterException;

public enum NewCommandType
{
    USER("user"),
    MERCHANT("merchant"),
    TRANSACTION("txn");

    private final String name;

    NewCommandType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static NewCommandType fromName(String name)
    {
        NewCommandType type;
        switch (name) {
            case "user":
                type = USER;
                break;
            case "merchant":
                type = MERCHANT;
                break;
            case "txn":
                type = TRANSACTION;
                break;
            default:
                throw new PayLaterException(String.format("Invalid Command : %s ", name));
        }
        return type;
    }
}
