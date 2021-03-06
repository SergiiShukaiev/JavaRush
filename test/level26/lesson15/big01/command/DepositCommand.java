package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Алина on 29.11.2016.
 */
class DepositCommand implements Command
{
    private ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+ "deposit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        String[] denominationAndAmmount = ConsoleHelper.getValidTwoDigits(currencyCode);
        try
        {
            int denomination = Integer.parseInt(denominationAndAmmount[0]);
            int denomination_count = Integer.parseInt(denominationAndAmmount[1]);
            manipulator.addAmount(denomination, denomination_count);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), denomination, currencyCode));
        } catch(NumberFormatException e){
            ConsoleHelper.writeMessage("Invalid data");
        }

    }
}
