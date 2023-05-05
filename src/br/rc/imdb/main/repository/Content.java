package br.rc.imdb.main.repository;

public interface Content extends Comparable<Content>{

	public String title();
	
	public String urlImage();
	
	public String rating();
	
	public String year();
	
}
