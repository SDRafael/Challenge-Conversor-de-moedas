import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCotacao {

    private static final String API_KEY = "";

    public DadosBuscaCotacao buscarCotacao(String moeda){

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+API_KEY+"/latest/"+moeda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), DadosBuscaCotacao.class);

        } catch (Exception e) {
            throw new RuntimeException("Finalizando o programa por IO ou Interrupted");
        }


    }
}
