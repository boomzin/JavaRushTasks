package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType
public class Shop {

//    @XmlElementWrapper(name = "goods", nillable = true)

    @XmlElement()
    public Goods goods;

    @XmlElement()
    public int count;

    @XmlAttribute(name="data")
    private final static String DATA = "whatever";


    @XmlElement()
    public double profit;

    @XmlElement()
    public String[] secretData = new String[5];

    @Override
    public String toString() {
//        System.out.println(profit);
        StringBuilder stringBuilder = new StringBuilder();
        goods.names.forEach(a -> stringBuilder.append(a + System.lineSeparator()));
        stringBuilder.append(count + System.lineSeparator());
        stringBuilder.append(profit + System.lineSeparator());
//        secretData.forEach(s -> stringBuilder.append(s + System.lineSeparator()));
        return stringBuilder.toString();
    }

    public static class Goods{
        public List<String> names = new ArrayList<>();
    }

}
