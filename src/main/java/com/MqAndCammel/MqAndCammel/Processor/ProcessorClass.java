package com.MqAndCammel.MqAndCammel.Processor;

import com.MqAndCammel.MqAndCammel.bean.BeanJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import javax.net.ssl.X509KeyManager;

@Component
public class ProcessorClass implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String strValue = (String) exchange.getIn().getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();
        if (strValue.startsWith("{") || strValue.startsWith("[")){
            BeanJson beanJson = objectMapper.readValue(strValue,BeanJson.class); // jason to java object or Deserialization
            exchange.setProperty("strValue",beanJson.getNumber());
        }
        else if(strValue.startsWith("<")){
            BeanJson beanJson = xmlMapper.readValue(strValue,BeanJson.class);
            exchange.setProperty("strValue",beanJson.getNumber());
        }
        else{
            exchange.setProperty("strValue",Integer.parseInt(strValue));
        }
    }
}