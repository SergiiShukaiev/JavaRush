package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Алина on 29.11.2016.
 */
public class CurrencyManipulatorFactory
{
    private static HashMap<String, CurrencyManipulator> currencyManipulators = new HashMap<>();



    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (currencyManipulators.get(currencyCode) != null)
            return currencyManipulators.get(currencyCode);
        else {
            CurrencyManipulator newCurrencyManipulator = new CurrencyManipulator(currencyCode);
            currencyManipulators.put(currencyCode, newCurrencyManipulator);
            return newCurrencyManipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return currencyManipulators.values();
    }
}
