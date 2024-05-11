package com.mpitu.adventofcodesolution.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<String> readInputLines(Integer year, Integer day) {
        List<String> parsedLines = new ArrayList<>();
        var filePath = String.format("./advent-of-code-solution/src/main/resources/%s/%s.txt", year, day);

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(dataInputStream));

            String lineRead;
            while((lineRead = br.readLine()) != null) {
                parsedLines.add(lineRead);
            }

            dataInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return parsedLines;
    }
}
