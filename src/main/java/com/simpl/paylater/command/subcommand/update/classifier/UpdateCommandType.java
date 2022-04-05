package com.simpl.paylater.command.subcommand.update.classifier;

import com.simpl.paylater.exception.PayLaterException;

public enum UpdateCommandType
{

    UPDATE("update");

    private final String name;

    UpdateCommandType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static UpdateCommandType fromName(String name)
    {
        UpdateCommandType type;
        switch (name) {
            case "update":
                type = UPDATE;
                break;
            default:
                throw new PayLaterException(String.format("Invalid Command : %s ", name));
        }
        return type;
    }

}
