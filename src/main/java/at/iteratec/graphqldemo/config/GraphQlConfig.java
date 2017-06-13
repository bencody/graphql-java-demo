package at.iteratec.graphqldemo.config;

import at.iteratec.graphqldemo.service.PersonDataFetcher;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Ben on 2017-06-13.
 */
@Configuration
public class GraphQlConfig {

    @Autowired
    private PersonDataFetcher personDataFetcher;

    @Bean
    public GraphQLSchema graphQLSchema() throws IOException {
        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        String schemaFileContent = readSchemaFileContent();
        TypeDefinitionRegistry typeRegistry = schemaParser.parse(schemaFileContent);
        RuntimeWiring wiring = buildRuntimeWiring();
        return schemaGenerator.makeExecutableSchema(typeRegistry, wiring);
    }

    private String readSchemaFileContent() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("demoSchema.graphqls");
        try (InputStream inputStream = classPathResource.getInputStream()) {
            return CharStreams.toString(new InputStreamReader(inputStream, Charsets.UTF_8));
        }
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("QueryType", typeWiring -> typeWiring
                        .dataFetcher("person", personDataFetcher)
                )
                .build();
    }
}
