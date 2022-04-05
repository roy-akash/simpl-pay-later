package com.simpl.paylater.command.classifier;

import com.simpl.paylater.exception.PayLaterException;

public enum CommandType
{

    NEW("new"),
    UPDATE("update"),
    PAYBACK("payback"),
    REPORT("report");

    private final String name;

    CommandType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static CommandType fromName(String name)
    {
        CommandType type;
        switch (name) {
            case "new":
                type = NEW;
                break;
            case "update":
                type = UPDATE;
                break;
            case "payback":
                type = PAYBACK;
                break;
            case "report":
                type = REPORT;
                break;
            default:
                throw new PayLaterException(String.format("Invalid Command : %s ", name));
        }
        return type;
    }
}
