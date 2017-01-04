package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream output;

    AdapterFileOutputStream(FileOutputStream output){
        this.output=output;
    }


    @Override
    public void flush() throws IOException
    {
        output.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        output.write(s.getBytes());

    }

    @Override
    public void close() throws IOException
    {
        output.close();

    }
}

