package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;
import java.util.ResourceBundle;

/**
 * Created by Алина on 29.11.2016.
 */
public class ConsoleHelper
{
    private static ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+ "common_en");
    private static BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message){
        System.out.println(message);
    }


    public static String readString() throws InterruptOperationException
    {
        String str="";
        try
        {
            str=reader.readLine();
            if (str.toLowerCase().equals("exit"))
                throw new InterruptOperationException();
        }
        catch(IOException e){
            ConsoleHelper.writeMessage(res.getString("the.end"));
        }
        return str;
    }


    public static String askCurrencyCode() throws InterruptOperationException
    {
        String currencyCode;
        while (true)
        {
            writeMessage(res.getString("choose.currency.code"));
            currencyCode = readString();
            if ((currencyCode.length() == 3) && (currencyCode.matches("(?i).*[a-zа-я].*")))
            {
                break;
            } else
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
        currencyCode = currencyCode.toUpperCase();
        return currencyCode;
    }


    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] digits;
        while (true)
        {

            writeMessage(res.getString("choose.denomination.and.count.format"));
            String str = readString();
            try
            {
                digits = str.split(" ");
                if (digits.length != 2)
                {
                    throw new Exception(res.getString("invalid.data"));
                }
                int denomination = Integer.parseInt(digits[0]);
                int count = Integer.parseInt(digits[1]);
                if (denomination <= 0 || count <= 0)
                {
                    throw new Exception(res.getString("invalid.data"));
                }
                break;
            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
            }

        }
        return digits;
    }


    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation"));
        StringBuilder opsString = new StringBuilder();
        for (Operation o : Operation.values()) {
            if (o != Operation.LOGIN)
                opsString.append(String.format("%d - %s, ", o.ordinal(), res.getString("operation." + o.name())));
        }


        opsString.delete(opsString.length() - 2, opsString.length());
        writeMessage(opsString.toString());



        Operation operationToUser = null;
        do{

        try
        {
                String operationIn = readString();

                int i = Integer.parseInt(operationIn);
                operationToUser = Operation.getAllowableOperationByOrdinal(i);
                break;

        }
        catch (IllegalFormatException e){
            writeMessage(res.getString("invalid.data"));
        }
        catch (IllegalArgumentException e)
        {
            writeMessage(res.getString("invalid.data"));
        }
        } while (true);

        return operationToUser;

    }

    public static void printExitMessage(){
        ConsoleHelper.writeMessage("Пока, Дэбил!");
    }


}
