import com.nishant.timeline.retriever.FileTimeLineDataRetriever;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

public class FileTimeLineDataRetrieverTest {
    @Test
    public void testDataRetrieving() {
        LocalDateTime now = LocalDateTime.now();
        FileTimeLineDataRetriever dataRetriever = new FileTimeLineDataRetriever(this.getClass().getResource("TimeLineData.csv").getPath());

        System.out.println(dataRetriever.getTimeLine(LocalDateTime.now(), Optional.of(LocalDateTime.now())));
        System.out.println(now);
    }

}
