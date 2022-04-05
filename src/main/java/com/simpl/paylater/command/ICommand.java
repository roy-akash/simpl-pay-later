package com.simpl.paylater.command;

public interface ICommand
{

    public void validateInput(String... arguments);

    public String run(String... arguments);

}
