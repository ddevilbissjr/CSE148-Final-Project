package app;

import config.BagConfigurations;
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
import view.MenuBarPane;
import view.StudentPane;

public class App extends Application {

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		final int MAX_PERSONS = BagConfigurations.MAXPERSONS;
		final int MAX_TEXTBOOKS = BagConfigurations.MAXBOOKS;
		final int MAX_ROOMS = BagConfigurations.MAXROOMS;
		final int MAX_COURSES = BagConfigurations.MAXCOURSES;
		
		College college = new College(MAX_PERSONS, MAX_TEXTBOOKS, MAX_ROOMS, MAX_COURSES);
		Utils.restore(college);
		BorderPane root = new BorderPane();
		root.setTop(new MenuBarPane(college, root).getMenuBar());
		Scene scene = new Scene(root, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
