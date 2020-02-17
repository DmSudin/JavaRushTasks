package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType(name = "shop")
public class Shop {
    public Goods goods;

    @XmlElement
    public int count;

    @XmlElement
    public double profit;

    @XmlElement
    public String[] secretData;

    static class Goods {
        public List<String> names;
    }
}
