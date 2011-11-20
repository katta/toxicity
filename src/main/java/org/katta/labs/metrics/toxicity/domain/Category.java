package org.katta.labs.metrics.toxicity.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @XmlAttribute(name = "check")
    private String check;

    @XmlAttribute(name = "threshold")
    private int threshold;

    public int getThreshold() {
        return threshold;
    }

    public String getCheck() {
        return check;
    }

    @Override
    public String toString() {
        return "Category{" +
                "check='" + check + '\'' +
                '}';
    }
}
