package graphql;
import graphql.kickstart.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.kickstart.servlet.GraphQLHttpServlet;
import graphql.kickstart.servlet.GraphQLConfiguration;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndPoint extends GraphQLHttpServlet {

    @Override
    protected GraphQLConfiguration getConfiguration() {
        return GraphQLConfiguration.with(buildSchema()).build();
    }

    private static GraphQLSchema buildSchema() {
        ModuleBusiness mb= new ModuleBusiness();
        UniteEnseignementBusiness ueb=new UniteEnseignementBusiness();
        return SchemaParser.newParser()
               .file("schema.graphql")
               .resolvers(new Query(mb, ueb), new Mutations(mb, ueb))
               .build()
               .makeExecutableSchema();

    }

}
