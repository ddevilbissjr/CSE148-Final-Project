package view;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class StudentPane {
	private GridPane grid;

	public StudentPane() {
		grid = new GridPane();
		grid.setVgap(20);
		grid.setHgap(50);
		grid.setPadding(new Insets(50));
		TextField firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		TextField lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		TextField gpaField = new TextField();
		gpaField.setEditable(false);
		TextField phoneField = new TextField();
		grid.add(firstNameField, 0, 0);
		grid.add(lastNameField, 1, 0);
		grid.add(gpaField, 0, 1);
		grid.add(phoneField, 1, 1);

	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}
	
	

}
