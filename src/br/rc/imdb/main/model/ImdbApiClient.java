	package br.rc.imdb.main.model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class ImdbApiClient {
	
	private String apiUri;
	
	private String key;

	public ImdbApiClient(String apiUri, String key) {
		this.key = key;
		this.apiUri = apiUri;
	}

	public String getRequestBody() throws Exception {
		
		HttpRequest getRequest = HttpRequest.newBuilder().
				uri(new URI(this.apiUri + this.key))
				.build();
		
		HttpClient client = HttpClient.newHttpClient();
		
		return client.send(getRequest,BodyHandlers.ofString()).body();
	}
	
	
}
