package com.nishant.timeline.view;

import com.nishant.timeline.unit.TimelineEvent;
import io.dropwizard.views.View;

import java.util.List;

public class TimelineView extends View {
    private final List<TimelineEvent> timelineEvents;

    public TimelineView(List<TimelineEvent> timelineEvents) {
        super("TemplateView.ftl");
        this.timelineEvents = timelineEvents;
    }

    public List<TimelineEvent> getTimelineEvents() {
        return timelineEvents;
    }
}
