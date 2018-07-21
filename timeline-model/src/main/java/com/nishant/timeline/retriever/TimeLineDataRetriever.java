package com.nishant.timeline.retriever;

import com.nishant.timeline.unit.TimelineEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TimeLineDataRetriever {

    List<TimelineEvent> getTimeLine(LocalDateTime startTime, Optional<LocalDateTime> endTime);
}
