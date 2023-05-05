package br.rc.imdb.main.model;

import br.rc.imdb.main.repository.Content;
import java.lang.Comparable;

public class Movie implements Content {

	private String title;
	
	private String image;
	
	private String imDbRating;
	
	private String year;

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
	public String rating() {
		return imDbRating;
	}

	@Override
	public String year() {
		
		return year;
	}

	@Override
	public int compareTo(Content other) {
		return this.rating().compareTo(other.rating());
	}


	
	
		
}
