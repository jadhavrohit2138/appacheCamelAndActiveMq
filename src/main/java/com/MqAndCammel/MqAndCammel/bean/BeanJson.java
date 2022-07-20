package com.MqAndCammel.MqAndCammel.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "DecisionNumber")


public class BeanJson {
    @JacksonXmlProperty(localName = "Number")

    int number;

    public BeanJson() {
    }

    public BeanJson(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
