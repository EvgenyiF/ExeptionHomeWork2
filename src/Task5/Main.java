import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1)
            throw new RuntimeException("Не указан путь к файлу");
        DownloadService service = new DownloadService();
        String url = args[0];
        System.out.println(url);

        Path downloadedFile;
        try {
            downloadedFile = service.downloadFile(url);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка скачивания файла" + e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        People[] myObject = new People[0];
        try {
            myObject = objectMapper.readValue(Paths.get("src/main/resources/People.json").toFile(), People[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(myObject));
    }
}
