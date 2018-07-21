package com.nishant.timeline.unit;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.time.LocalDateTime;

@Immutable
public class TimelineEvent {
    private int id;
    private LocalDateTime eventTime;
    private String title;
    private TimeLineContent content;

    public TimelineEvent(int id, LocalDateTime eventTime, String title, TimeLineContent content) {
        this.id = id;
        this.eventTime = eventTime;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public String getTitle() {
        return title;
    }

    public TimeLineContent getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "TimelineEvent{" +
                "id=" + id +
                ", eventTime=" + eventTime +
                ", title='" + title + '\'' +
                ", content=" + content +
                '}';
    }
}