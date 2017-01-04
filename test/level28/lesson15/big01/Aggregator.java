package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.*;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;

/**
 * Created by Алина on 06.12.2016.
 */
public class Aggregator
{
    public static void main(String[]args){
        View view=new HtmlView();
        Provider provider = new Provider(new HHStrategy());
        Provider providerMoi=new Provider(new MoikrugStrategy());
        Model model=new Model(view, new Provider[]{provider, providerMoi});
        Controller controller=new Controller(model);
        view.setController(controller);
        ((HtmlView)view).userCitySelectEmulationMethod();
    }
}
