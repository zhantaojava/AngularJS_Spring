package dao;

import java.util.List;

import model.Suggestion;

public interface SuggestionDAO {
	// Create
	void addSuggestion(Suggestion sug);

	// Retrieve
	List<Suggestion> listSuggestion();

	Suggestion getById(int id);

	// Update
	void updateSuggestion(Suggestion sug);

	// Delete
	void deleteSuggestion(int id);

}
