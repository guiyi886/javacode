package javaHigh.exp10.second;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    // 读取并解析文件
    public List<Integer> parseFile(String filePath) throws FileNotFoundException, InvalidContentException, EmptyFileException {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder content = new StringBuilder();

            // 读取文件内容
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

            if (content.length() == 0) {
                throw new EmptyFileException("File is empty.");
            }

            // 解析文件内容
            String[] tokens = content.toString().split(",");
            for (String token : tokens) {
                token = token.trim();
                try {
                    numbers.add(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new InvalidContentException("Invalid content: " + token);
                }
            }
        } catch (IOException e) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        return numbers;
    }
}

