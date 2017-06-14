package at.iteratec.graphqldemo.service;

import at.iteratec.graphqldemo.controller.GraphQlException;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by Ben on 14.06.2017.
 */
@Component
public class GraphQlService {

    @Autowired
    private GraphQLSchema graphQLSchema;

    @Transactional
    public Map<?, ?> executeQuery(String query) {
        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        ExecutionResult result = graphQL.execute(query);
        if (!result.getErrors().isEmpty()) {
            throw GraphQlException.create(result.getErrors());
        }
        return result.getData();
    }
}
