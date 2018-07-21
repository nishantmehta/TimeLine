package com.nishant.timeline;


import com.nishant.timeline.configuration.TimeLineConfguration;
import com.nishant.timeline.retriever.FileTimeLineDataRetriever;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class TimeLineApplication extends Application<TimeLineConfguration> {

    @Override
    public void initialize(Bootstrap<TimeLineConfguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(TimeLineConfguration configuration, Environment environment) throws Exception {
        String dataPath = Thread.currentThread().getContextClassLoader().getResource("TimeLineData.csv").getPath();
        environment.jersey().register(new TimeLineViewResource(
                new FileTimeLineDataRetriever(dataPath)));
    }

    public static void main(String[] args) throws Exception
    {
        new TimeLineApplication().run(args);
    }
}
