package util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

    private static final String LOG_FILE = "bank.log";

    private LoggerUtil() {
    }

    public static void log(String message) {

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {

            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            writer.write("[" + time + "] " + message + System.lineSeparator());

        } catch (IOException e) {

            System.out.println("Unable to write log.");
        }
    }
}