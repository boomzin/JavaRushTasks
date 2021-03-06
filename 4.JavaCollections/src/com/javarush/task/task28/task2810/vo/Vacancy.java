package com.javarush.task.task28.task2810.vo;

import java.util.Objects;

public class Vacancy {
    String title;
    String salary;
    String city;
    String companyName;
    String siteName;
    String url;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return title.equals(vacancy.title) &&
                Objects.equals(salary, vacancy.salary) &&
                city.equals(vacancy.city) &&
                companyName.equals(vacancy.companyName) &&
                Objects.equals(siteName, vacancy.siteName) &&
                Objects.equals(url, vacancy.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, salary, city, companyName, siteName, url);
    }
}
