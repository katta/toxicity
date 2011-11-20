package org.katta.labs.metrics.toxicity.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collection;


@XmlAccessorType(XmlAccessType.FIELD)
public class CheckstyleFile {

    @XmlElement(name = "error")
    protected CheckstyleErrors checkstyleErrors;

    @XmlAttribute
    protected String name;

    public CheckstyleErrors getCheckstyleErrors() {
        if (checkstyleErrors == null) {
            checkstyleErrors = new CheckstyleErrors();
        }
        return this.checkstyleErrors;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Collection<? extends CheckstyleError> getErrorsOfType(String check) {
        ArrayList<CheckstyleError> filteredCheckstyleErrors = new ArrayList<CheckstyleError>();

        for (CheckstyleError checkstyleError : getCheckstyleErrors()) {
            if(checkstyleError.getSource().endsWith(check+"Check")) {
                filteredCheckstyleErrors.add(checkstyleError);
            }
        }
        return filteredCheckstyleErrors;
    }

    public void addError(CheckstyleError checkstyleError) {
        this.getCheckstyleErrors().add(checkstyleError);
    }

    public CheckstyleErrors errorsOfType(String checkName) {
        CheckstyleErrors errors = new CheckstyleErrors();

        for (CheckstyleError error : getCheckstyleErrors()) {
            if(error.getSource().endsWith(checkName)) {
                errors.add(error);
            }
        }
        return errors;
    }

    @Override
    public String toString() {
        return "CheckstyleFile{" +
                "checkstyleErrors=" + getCheckstyleErrors() +
                ", name='" + name + '\'' +
                '}';
    }
}
