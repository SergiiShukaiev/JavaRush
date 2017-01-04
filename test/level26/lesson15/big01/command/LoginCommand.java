package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Алина on 30.11.2016.
 */
class LoginCommand implements Command
{
    private ResourceBundle validCreditCards=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+ "verifiedCards");
    ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+ "login_en");


  //  private static final String numberCard="123456789012";
   // private static final String pin="1234";

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        boolean isAlive=false;
        Matcher m1;
        Matcher m2;
        String numer = null;


        while(!isAlive){
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            numer=ConsoleHelper.readString();
            String pIN=ConsoleHelper.readString();

         /*   String[] array=ConsoleHelper.readString().split(" ");
            String numer=array[0];
            String pIN=array[1]; */

           //     long numer=Long.parseLong(array[0]);
             //   int pIN=Integer.parseInt(array[1]);
            Pattern p1 = Pattern.compile("^\\d{12}$");
            m1 = p1.matcher(numer);
            Pattern p2 = Pattern.compile("^\\d{4}$");
            m2 = p2.matcher(pIN);
            if (!m1.matches() || !m2.matches())
                {
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    continue;
                }
            try
            {
                isAlive = validCreditCards.getString(numer).equals(pIN);
            }catch (MissingResourceException e){}

                if (!isAlive){
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), numer));
                    continue;

                }
        }
        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), numer));

    }
}
