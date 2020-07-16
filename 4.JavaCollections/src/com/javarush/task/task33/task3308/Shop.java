package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType
public class Shop {

    @XmlElementWrapper(name = "goods", nillable = true)
    public List<String> names = new ArrayList<>();

    @XmlElement()
    public int count;

    @XmlElement()
    public int profit;

    @XmlElement()
    public List<String> secretData = new ArrayList<>();

    @Override
    public String toString() {
        System.out.println(profit);
        StringBuilder stringBuilder = new StringBuilder();
        names.forEach(a -> stringBuilder.append(a + System.lineSeparator()));
        stringBuilder.append(count + System.lineSeparator());
        stringBuilder.append(profit + System.lineSeparator());
        secretData.forEach(s -> stringBuilder.append(s + System.lineSeparator()));
        return stringBuilder.toString();
    }
}
