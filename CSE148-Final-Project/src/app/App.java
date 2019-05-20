package app;

import config.BagConfigurations;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.College;
import utils.Utils;
import view.MenuBarPane;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final int MAX_STUDENTS = BagConfigurations.MAXSTUDENTS;
		final int MAX_FACULTY = BagConfigurations.MAXFACULTY;
		final int MAX_TEXTBOOKS = BagConfigurations.MAXBOOKS;
		final int MAX_CLASSROOMS = BagConfigurations.MAXCLASSROOMS;
		
		College college = new College(MAX_STUDENTS, MAX_FACULTY, MAX_TEXTBOOKS, MAX_CLASSROOMS);
		Utils.restore(college);
		BorderPane root = new BorderPane();
		root.setTop(new MenuBarPane(college, root).getMenuBar());
		Scene scene = new Scene(root, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
