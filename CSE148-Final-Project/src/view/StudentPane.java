package view;

import java.util.Optional;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.College;

public class StudentPane {
	private VBox studentBox;
	private Button insertBtn;
	private Button searchBtn;

	public StudentPane(College college) {
		studentBox = new VBox(30);
		studentBox.setAlignment(Pos.CENTER);
		TextField nameField = new TextField();
		nameField.setMaxWidth(200);
		TextField phoneField = new TextField();
		phoneField.setMaxWidth(200);

		HBox buttonBox = new HBox(30);
		
		insertBtn = new Button("INSERT");
		insertBtn.setOnAction(e -> {
			String name = nameField.getText();
			String phone = phoneField.getText();
//			college.getPersonBag().insert(name, phone);
		});
		

		searchBtn = new Button("SEARCH");
		searchBtn.setOnAction(e -> {

			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("ID NUMBER");
			dialog.setContentText("Please enter a student ID");
			dialog.setHeaderText("Student ID Please");
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(idNumber -> {
				System.out.println(idNumber);

			});

			String name = nameField.getText();
			String phone = phoneField.getText();
//			college.getPersonBag().insert(name, phone);
		});
		
		buttonBox.getChildren().addAll(insertBtn, searchBtn);
		buttonBox.setAlignment(Pos.CENTER);
		studentBox.getChildren().addAll(nameField, phoneField, buttonBox);
	}

	public VBox getStudentBox() {
		return studentBox;
	}

	public Button getOkBtn() {
		return insertBtn;
	}
}
