package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Book;
import models.BookResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

public class BookApi {
    public List<Book> getBooksFromApi() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://demoqa.com/BookStore/v1/Books"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        ObjectMapper mapper = new ObjectMapper();
        BookResponse booksResponse = mapper.readValue(json, BookResponse.class);
        return booksResponse.getBooks();
    }

    public List<String> getBooksTitiles() throws IOException, InterruptedException {
        List<Book> apiBooks = this.getBooksFromApi();
        return apiBooks.stream()
                .map(Book::getTitle)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
