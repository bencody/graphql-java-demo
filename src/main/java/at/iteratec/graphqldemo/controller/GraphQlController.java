package at.iteratec.graphqldemo.controller;

import at.iteratec.graphqldemo.service.GraphQlService;
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
    private GraphQlService service;

    @PostMapping("/graphql")
    public Map<?, ?> executeQuery(@RequestBody String query) {
        return service.executeQuery(query);
    }
}
