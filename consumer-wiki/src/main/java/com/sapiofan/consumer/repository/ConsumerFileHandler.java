package com.sapiofan.consumer.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class ConsumerFileHandler {

    private static final String DATA_FILE = "consumer-wiki\\src\\main\\resources\\data.txt";

    private static final Logger log = LoggerFactory.getLogger(ConsumerFileHandler.class);

    public void writeWikiToFile(String data) {
        File file = new File(DATA_FILE);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                log.error("Can't create file for data: " + e);
            }
            log.info("File created: " + DATA_FILE);
        }

        try(FileWriter fileWriter = new FileWriter(DATA_FILE, true)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm.ss");
            fileWriter.write(dateFormat.format(new Date()) + " : " + data + "\n");
        } catch (IOException e) {
            log.error("Can't write data to file: " + e);
        }
    }
}
