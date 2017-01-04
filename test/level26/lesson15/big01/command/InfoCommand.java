package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Алина on 29.11.2016.
 */
class InfoCommand implements Command
{
    private ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+ "info_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean money=false;
        for (CurrencyManipulator c : CurrencyManipulatorFactory.getAllCurrencyManipulators())
        {
            if (c.hasMoney())
            {
                ConsoleHelper.writeMessage(c.getCurrencyCode() + " - " + c.getTotalAmount());
                money=true;
            }
        }
        if (!money)
        {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
