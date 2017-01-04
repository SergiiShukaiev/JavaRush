package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Алина on 29.11.2016.
 */
class WithdrawCommand implements Command
{
    ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+ "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        boolean isValid = true;
        while (isValid)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String amount = ConsoleHelper.readString();
            if ((!amount.matches("\\d+")))
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (Integer.parseInt(amount) == 0)
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            if (currencyManipulator.isAmountAvailable(Integer.parseInt(amount)))
            {
                try
                {
                    Map<Integer, Integer> map = currencyManipulator.withdrawAmount(Integer.parseInt(amount));

                    for (Map.Entry<Integer, Integer> pair : map.entrySet())
                    {
                        ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                    }
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.valueOf(amount), currencyManipulator.getCurrencyCode()));
                    isValid = false;
                }
                catch (NotEnoughMoneyException ignore)
                {
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                }

            } else
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }


        }


    }
}