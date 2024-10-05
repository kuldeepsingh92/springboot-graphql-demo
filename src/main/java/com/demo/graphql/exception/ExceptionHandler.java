package com.demo.graphql.exception;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handle(NoRecordException exception) {
        return GraphQLError.newError()
                .message(exception.getMessage())
                .build();
    }
}
