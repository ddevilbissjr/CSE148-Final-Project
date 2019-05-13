package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.College;
import utils.Utils;
import view.BottomPane;
import view.StudentPane;

public class App extends Application {

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		College college = new College(2020, 1000, 2000, 200);
		Utils.restore(college);	
		BorderPane root = new BorderPane();
		BottomPane bottomPane = new BottomPane();
		root.setBottom(bottomPane.getBtnBox());
		Button studentBtn = bottomPane.getStudentBtn();
		
		studentBtn.setOnAction(e -> {
			root.setCenter(new StudentPane().getGrid());
		});
		
		VBox centerBox = new VBox(20);
		TextField titleField = new TextField();
		TextField isbnField = new TextField();
		TextField priceField = new TextField();
		centerBox.getChildren().addAll(titleField, isbnField, priceField);
		
//		addButton.setOnAction(e -> {
//			String title = titleField.getText();
//			String isbn = isbnField.getText();
//			double price = Double.parseDouble(priceField.getText());
//			textbookBag.insert(title, isbn, price);
//		});
		
//		root.setTop(restoreButton);
//		root.setBottom(backupButton);
//		root.setRight(addButton);
//		root.setLeft(removeButton);
		root.setCenter(centerBox);
		Scene scene = new Scene(root, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("College Management System");
		primaryStage.show();
	}

}
