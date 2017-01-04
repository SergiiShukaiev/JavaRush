package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алина on 06.12.2016.
 */
public class HHStrategy implements Strategy
{
    //private static final String URL_FORMAT = "http://javarush.ru/testdata/big28data.html";
    private final static String URL_FORMAT="http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String userAgent="Chrome/46.0.2490.76 Mobile Safari/537.36";
    private static final String referrer="http://google.ru";
    private static final int timeOut=5*1000;

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        int nom=0;
        List<Vacancy> listVacancy=new ArrayList<Vacancy>();

        try
        {
            while(true)
            {
                Document doc = getDocument(searchString, nom++);

                Elements elements=(Elements) doc.select("[data-qa=vacancy-serp__vacancy]");
                if (elements.size()==0) break;

                for(Element element: elements){
                    //title
                    Element titleElement=element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title=titleElement.text();

                    //salary
                    Element salaryElement=element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary="";
                    if (salaryElement!=null){
                        salary=salaryElement.text();
                    }

                    //city
                    String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();

                    //company
                    String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();

                    //site
                    String siteName = "http://hh.ua/";

                    // url
                    String url = titleElement.attr("href");

                    //add vacancy
                    Vacancy vacancy=new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    listVacancy.add(vacancy);
                }

            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return listVacancy;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        String url=String.format(URL_FORMAT, searchString, page);

        try
        {
            Document doc = Jsoup.connect(url).userAgent(userAgent).referrer(referrer).timeout(timeOut).get();
            return doc;
        }catch(IOException ex){
            return null;
        }

    }
}
