package at.iteratec.graphqldemo.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Ben on 2017-06-13.
 */
@RestController
public class GraphQlController {

    @Autowired
    private GraphQLSchema graphQLSchema;

    @PostMapping("/graphql")
    public Map<?, ?> executeQuery(@RequestBody String requestBody) {
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult execute = graphQL.execute(requestBody);
        if (!execute.getErrors().isEmpty()) {
            throw GraphQlException.create(execute.getErrors());
        }
        Map<?, ?> data = execute.getData();
        return data;
    }
}
