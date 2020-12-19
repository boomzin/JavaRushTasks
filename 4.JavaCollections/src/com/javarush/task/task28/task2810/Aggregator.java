package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.view.HtmlView;

public class Aggregator {

    public static void main(String[] args) {
        Provider provider = new Provider(new HHStrategy());
        HtmlView htmlView = new HtmlView();
        Model model = new Model(htmlView, provider);
        Controller controller = new Controller(model);
        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod();
        System.out.println(htmlView.getFilePath());

    }
}