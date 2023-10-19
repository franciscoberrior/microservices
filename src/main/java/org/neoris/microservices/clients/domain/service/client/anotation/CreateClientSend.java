package org.neoris.microservices.clients.domain.service.client.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.neoris.microservices.clients.domain.entity.enums.ProcessClientTypeEnum;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateClientSend {

  ProcessClientTypeEnum type();
}