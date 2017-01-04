package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Алина on 06.12.2016.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath="./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";


    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {
            updateFile(getUpdatedFileContent(vacancies));
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller=controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }



    private String getUpdatedFileContent(List<Vacancy> list){
        String fileContent = null;
        try {
            Document doc = getDocument();
            Element elTemplate = doc.select(".template").first();

            Element elPattern = elTemplate.clone();
            elPattern.removeClass("template").removeAttr("style");
            doc.getElementsByAttributeValue("class", "vacancy").remove();
            //elPattern.removeAttr("style");
            //elPattern.removeAttr("template");
            //elPattern.toggleClass("template");

            //doc.select("tr[class=vacancy]").remove();

            for (Vacancy vacancy : list) {
                Element elVacancy = elPattern.clone();
                elVacancy.getElementsByClass("city").first().text(vacancy.getCity());
                elVacancy.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                elVacancy.getElementsByClass("salary").first().text(vacancy.getSalary());
                Element link = elVacancy.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());

                elTemplate.before(elVacancy.outerHtml());
            }
            fileContent = doc.html();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
        return fileContent;
    }


    private void updateFile(String data){
        try
        {
           BufferedWriter writer=new BufferedWriter(new FileWriter(filePath));
            writer.write(data);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
