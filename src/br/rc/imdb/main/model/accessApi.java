package br.rc.imdb.main.model;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import br.rc.imdb.main.utils.ConstantsEnum;

public class accessApi {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		
		//System.out.println(ConstantsEnum.API_KEY.getValue());
		HttpRequest getRequest = HttpRequest.newBuilder().
				uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + ConstantsEnum.API_KEY.getValue()))
				.GET()
				.build();
		 
		
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> getResponse = client.send(getRequest,BodyHandlers.ofString());
		
		System.out.println(getResponse.statusCode());
		System.out.println(getResponse.body());
	}
	
}
