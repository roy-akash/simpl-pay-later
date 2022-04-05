package com.simpl.paylater.command.subcommand.report.classifier;

import com.simpl.paylater.exception.PayLaterException;

public enum ReportCommandType
{
    REPORT_MERCHANT_DISCOUNT("discount"),
    REPORT_USER_DUES("dues"),
    REPORT_USER_AT_CREDIT_LIMIT("users-at-credit-limit"),
    REPORT_TOTAL_DUES("total-dues");

    private final String name;

    ReportCommandType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public static ReportCommandType fromName(String name)
    {
        ReportCommandType type;
        switch (name) {
            case "discount":
                type = REPORT_MERCHANT_DISCOUNT;
                break;
            case "dues":
                type = REPORT_USER_DUES;
                break;
            case "users-at-credit-limit":
                type = REPORT_USER_AT_CREDIT_LIMIT;
                break;
            case "total-dues":
                type = REPORT_TOTAL_DUES;
                break;
            default:
                throw new PayLaterException(String.format("Invalid Command : %s ", name));
        }
        return type;
    }
}
