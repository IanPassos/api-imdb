package br.rc.imdb.main.model;

import java.io.PrintWriter;
import java.util.List;

import br.rc.imdb.main.repository.Content;

// HTML file creation without external libraries for learning purposes

public class HTMLGenerator {

	private PrintWriter htmlWriter;
	
	public HTMLGenerator(PrintWriter htmlWriter){
		this.htmlWriter = htmlWriter;
	}
	
	public void generate(List<? extends Content> contents){
		
		String head = generateHead();
		String divClass = generateBody();
		
		htmlWriter.println(String.format(head));
		
		contents.forEach(m -> 
				htmlWriter.println(
						String.format(divClass, 
								m.title(),
								m.urlImage(),
								m.title(),
								m.rating(),
								m.year())
						)
				);
	}
	
	private String generateHead() {
		String head =
				"""
				<head>
					<meta charset=\"utf-8\">
					<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
					<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
						+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
					<title>Top 250 Filmes no IMDB</title>
					<link rel="stylesheet" href="style.css">
				</head>
				""";
		String header = 
				"""
				<Body>
				<h1>Top 250 Filmes no IMDB</h1>
				""";
		return header + head;
	}
	
	private String generateBody() {
		
		String divClass =
				"""
				<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 35rem;\">
					<h4 class=\"card-header\">%s</h4>
					<div class=\"card-body\">
						<img class=\"card-img\" src=\"%s\" alt=\"%s\">
						<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
					</div>
				</div>
				""";
		
		return divClass;
	}
	
}
