package com.MqAndCammel.MqAndCammel.predicates;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.stereotype.Component;


@Component
public class Predicate001  implements Predicate {


    @Override
    public boolean matches(Exchange exchange) {
            int strValue = (Integer) exchange.getProperty("strValue");
            return strValue % 2 == 0;
        }

    }

