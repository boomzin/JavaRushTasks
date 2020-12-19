package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.List;

public class HtmlView implements View {
    private final String filePath = (this.getClass().getPackage().toString()).replaceAll("\\.", "/").replaceFirst("package ", "./4.JavaCollections/src/") + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            getDocument();
            String newContent = getUpdatedFileContent(vacancies);
            updateFile(newContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        Document document =null;
        try {
            document = getDocument();

        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }

        Element templateElement = document.getElementsByClass("template").first();
        Element vacancyElement = templateElement.clone();
        vacancyElement.removeClass("template");
        vacancyElement.removeAttr("style");
        for (Element vacancy : document.getElementsByTag("tr")) {
            if (!"vacancy template".equals(vacancy.className())) {
                vacancy.remove();
            }
        }

        for (Vacancy vacancy : vacancies) {
            String tg;
            Element newElement = vacancyElement.clone();
            Elements elements = newElement.getAllElements();
            for (Element element : elements) {
                if ("city".equals(element.className())) {
                    element.append(vacancy.getCity());
                }
                if ("companyName".equals(element.className())) {
                    element.append(vacancy.getCompanyName());
                }
                if ("salary".equals(element.className())) {
                    element.html(vacancy.getSalary());
                }
                if ("a".equals(element.tagName())) {
                    element.attr("href", vacancy.getUrl()).append(vacancy.getTitle());
                }
            }
            document.getElementsByClass("template").first().before(newElement.outerHtml());
        }
        return document.outerHtml();
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private void updateFile(String fileContent) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        fileOutputStream.write(fileContent.getBytes());
        fileOutputStream.close();
    }

    public String getFilePath() {
        return filePath;
    }
}
