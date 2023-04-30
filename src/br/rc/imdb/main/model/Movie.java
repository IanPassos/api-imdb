package br.rc.imdb.main.model;

public class Movie {

	private String title;
	
	private String image;
	
	private float imDbRating;
	
	private int year;


	public String getTitle() {
		return title;
	}

	public String getimage() {
		return image;
	}

	public float getimDbRating() {
		return imDbRating;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", image=" + image + ", imDbRating=" + imDbRating + ", year=" + year + "]";
	}
	
	
		
}
