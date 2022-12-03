import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;


public class DownloadService {
    HttpClient client = HttpClient.newBuilder().build();

    public Path downloadFile(String sourceUrl) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(new URI(sourceUrl))
                .GET()
                .build();
        String fileName = sourceUrl.substring(sourceUrl.lastIndexOf('/') + 1);

        HttpResponse<InputStream> httpResponse = client
                .send(httpRequest, responseInfo ->
                        HttpResponse.BodySubscribers.ofInputStream());

        if (httpResponse.statusCode() != 200) {
            throw new RuntimeException("Ошибка при скачивании файла");
        }

        Path targetPath = new File("src/main/resources/" + File.separator + fileName).toPath();
        Files.deleteIfExists(targetPath);
        Files.copy(httpResponse.body(), targetPath);

        return targetPath;
    }
}
