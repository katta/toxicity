package org.katta.labs.metrics.toxicity.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "checkstyle")
public class Checkstyle {

    @XmlElement(name = "file")
    protected CheckstyleFiles checkstyleFiles;

    @XmlAttribute
    protected String version;

    public CheckstyleFiles getFiles() {
        if (checkstyleFiles == null) {
            checkstyleFiles = new CheckstyleFiles();
        }
        return this.checkstyleFiles;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String value) {
        this.version = value;
    }

    public List<CheckstyleError> findErrorsOfType(String check) {
        ArrayList<CheckstyleError> checkstyleErrors = new ArrayList<CheckstyleError>();

        for (CheckstyleFile file : checkstyleFiles) {
            checkstyleErrors.addAll(file.getErrorsOfType(check));
        }
        return checkstyleErrors;
    }
}
