package at.iteratec.graphqldemo.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Ben on 2017-06-13.
 */
@RestController
public class GraphQlController {

    @Autowired
    private GraphQLSchema graphQLSchema;

    @GetMapping("/")
    public Map<?, ?> testEndpoint(@RequestParam String name) {
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult execute = graphQL.execute("{ person(name: \"" + name + "\") {id, name, roles{name}, friends{id, name, roles{name}, friends{id, name, roles{name}}} } }");
        Map<?, ?> data = execute.getData();
        System.out.println(data);
        return data;
    }
}
