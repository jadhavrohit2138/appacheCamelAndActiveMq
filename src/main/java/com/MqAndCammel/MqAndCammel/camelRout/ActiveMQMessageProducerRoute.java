package com.MqAndCammel.MqAndCammel.camelRout;

import com.MqAndCammel.MqAndCammel.Processor.ProcessorClass;
import com.MqAndCammel.MqAndCammel.predicates.Predicate001;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ActiveMQMessageProducerRoute extends RouteBuilder {

    @Autowired
    private Predicate001 predicate001;

    @Autowired
    private ProcessorClass processorClass;

    @Override
    public void configure() throws Exception {
        from("activemq:FirstMQProj")
                .process(processorClass)
                .choice()
                .when(predicate001)
                .log("even message")
                .to("activemq:testEven")
                .otherwise()
                .log("odd number")
                .to("activemq:testOdd")
                .end();
    }

}
