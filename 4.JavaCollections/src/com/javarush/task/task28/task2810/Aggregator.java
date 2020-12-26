package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task38.task3806.MoikrugStrategy;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;

public class Aggregator {

    public static void main(String[] args) {
        Provider hhProvider = new Provider(new HHStrategy());
        Provider mkProvider = new Provider(new MoikrugStrategy());
        HtmlView htmlView = new HtmlView();
        Model model = new Model(htmlView, hhProvider, mkProvider);
        Controller controller = new Controller(model);
        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod();
        System.out.println(htmlView.getFilePath());

    }
}
