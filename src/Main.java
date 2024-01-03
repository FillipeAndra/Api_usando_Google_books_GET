import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);
        System.out.printf("Digite o título livro que você quer pesquisar(sem acento): ");
        var livro = leitor.nextLine();
        livro = livro.replaceAll(" ","");
        var pesquisa = "https://www.googleapis.com/books/v1/volumes?q="+livro+
                "&projection=lite&maxResults=1&key=AIzaSyDN9KPgC4yh5Nc_gbIPacCx_4eHrmkpdgM";
        System.out.println(pesquisa);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(pesquisa)).build();
        HttpResponse<String> resposta = cliente
                .send(requisicao, HttpResponse.BodyHandlers.ofString());
        System.out.println(resposta.body());



    }
}