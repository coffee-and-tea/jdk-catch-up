package coffee_and_tea.jdk11.jep328_flight_recorder;

import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FlightRecorderAnalysis {

    public static void main(String[] args) throws IOException, URISyntaxException {

        var recordingURI = FlightRecorderAnalysis.class.getClassLoader().getResource("recording.jfr").toURI();
        Path recording = Paths.get(recordingURI);

        for(RecordedEvent e: RecordingFile.readAllEvents(recording)) {
            System.out.println(e.getStartTime() + " : " + e.getStackTrace());
        }
    }
}
