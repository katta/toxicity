package org.katta.labs.metrics.toxicity.domain;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "errorType", propOrder = {
    "value"
})
public class CheckstyleError {

    @XmlValue
    protected String value;
    @XmlAttribute
    protected String line;
    @XmlAttribute
    protected String severity;
    @XmlAttribute
    protected String message;
    @XmlAttribute
    protected String source;
    @XmlAttribute
    protected String column;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String value) {
        this.line = value;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String value) {
        this.severity = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String value) {
        this.source = value;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String value) {
        this.column = value;
    }

    @Override
    public String toString() {
        return "Error{" +
                "value='" + value + '\'' +
                ", line='" + line + '\'' +
                ", severity='" + severity + '\'' +
                ", message='" + message + '\'' +
                ", source='" + source + '\'' +
                ", column='" + column + '\'' +
                '}';
    }
}
