package br.rc.imdb.main.model;

import br.rc.imdb.main.repository.Content;

public class Movie implements Content {

	private String title;
	
	private String image;
	
	private float imDbRating;
	
	private int year;

	@Override
	public String toString() {
		return "Movie [title=" + title + ", image=" + image + ", imDbRating=" + imDbRating + ", year=" + year + "]";
	}

	@Override
	public String title() {
		
		return title;
	}

	@Override
	public String urlImage() {
		
		return image;
	}

	@Override
	public float rating() {
		
		return imDbRating;
	}

	@Override
	public int year() {
		
		return year;
	}
		
}
