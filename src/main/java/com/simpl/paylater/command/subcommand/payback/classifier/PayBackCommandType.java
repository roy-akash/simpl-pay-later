package com.simpl.paylater.command.subcommand.payback.classifier;

import com.simpl.paylater.exception.PayLaterException;

public enum PayBackCommandType
{

    PAYBACK("payback");

    private final String name;

    PayBackCommandType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static PayBackCommandType fromName(String name)
    {
        PayBackCommandType type;
        switch (name) {
            case "payback":
                type = PAYBACK;
                break;
            default:
                throw new PayLaterException(String.format("Invalid Command : %s ", name));
        }
        return type;
    }

}
