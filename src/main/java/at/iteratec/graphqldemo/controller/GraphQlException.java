package at.iteratec.graphqldemo.controller;

import graphql.GraphQLError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bco on 14.06.2017.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GraphQlException extends RuntimeException {

    private final List<GraphQLError> errors;

    public GraphQlException(String message, List<GraphQLError> errors) {
        super(message);
        this.errors = errors;
    }

    public static GraphQlException create(List<GraphQLError> errors) {
        String message = errors.stream().map(error -> error.getMessage()).collect(Collectors.joining("; "));
        return new GraphQlException(message, errors);
    }

    public List<GraphQLError> getErrors() {
        return errors;
    }
}
