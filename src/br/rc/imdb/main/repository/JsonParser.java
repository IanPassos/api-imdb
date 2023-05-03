package br.rc.imdb.main.repository;

import java.util.List;

public interface JsonParser {

	public List<? extends Content> parse();
}
