package com.nishant.timeline;

import com.nishant.timeline.retriever.TimeLineDataRetriever;
import com.nishant.timeline.view.TimelineView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.Optional;

@Path("/timeline")
@Produces(MediaType.TEXT_HTML)
public class TimeLineViewResource {
    private final TimeLineDataRetriever timeLineDataRetriever;
    public TimeLineViewResource(TimeLineDataRetriever timeLineDataRetriever) {
        this.timeLineDataRetriever = timeLineDataRetriever;
    }

    @GET
    public TimelineView getTimeLineView() {
        return new TimelineView(timeLineDataRetriever.getTimeLine(LocalDateTime.now(), Optional.empty()));
    }
}
