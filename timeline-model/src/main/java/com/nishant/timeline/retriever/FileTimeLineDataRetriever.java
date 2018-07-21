package com.nishant.timeline.retriever;

import com.nishant.timeline.unit.TimelineEvent;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/*
TODO: log exception
 */

public class FileTimeLineDataRetriever implements TimeLineDataRetriever {

    private final String FILE_FORMAT_SUPPORTED = "csv";
    private final List<TimelineEvent> timeLineData;


    public FileTimeLineDataRetriever(String dataFilePath) {
        timeLineData = readData(dataFilePath);
        timeLineData.sort(Comparator.comparing(TimelineEvent::getEventTime));
    }

    private List<TimelineEvent> readData(String filePath) {
        if (!filePath.endsWith(FILE_FORMAT_SUPPORTED)) {
            throw new IllegalArgumentException(String.format("File format not supported for %s", filePath));
        }
        List<TimelineEvent> timelineEventData = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {
                String[] timelineEvent = line.split(cvsSplitBy);
                timelineEventData.add(new TimelineEvent(Integer.parseInt(timelineEvent[0]), LocalDateTime.parse(timelineEvent[1]), timelineEvent[2], null));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return timelineEventData;

    }


    @Override
    public List<TimelineEvent> getTimeLine(LocalDateTime startTime, Optional<LocalDateTime> endTime) {
         return timeLineData;
    }
}
