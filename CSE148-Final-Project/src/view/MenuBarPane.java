package view;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.College;
import utils.PersonFactory;
import utils.Utils;

public class MenuBarPane {
	private MenuBar menuBar;
	private Menu fileMenu;
	private Menu studentMenu;
	private Menu facultyMenu;
	private Menu textbookMenu;
	private Menu classroomMenu;
	
	private College college;
	private BorderPane root;
	
	public MenuBarPane(College college, BorderPane root) {
		this.college = college;
		this.root = root;
		this.menuBar = new MenuBar();
		buildFileMenu();
		buildStudentMenu();
		buildFacultyMenu();
		buildTextbookMenu();
		buildClassroomMenu();
		menuBar.getMenus().addAll(fileMenu, studentMenu, facultyMenu, textbookMenu, classroomMenu);
	}
	
	public MenuBar getMenuBar() {
		return menuBar;
	}
	
	private void buildFileMenu() {
		fileMenu = new Menu("File");
		
		MenuItem restoreItem = new MenuItem("Restore");
		restoreItem.setOnAction(e -> {
			try {
				Utils.restore(college);
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		});
		
		MenuItem exitItem = new MenuItem("Exit");
		exitItem.setOnAction(e -> {
			try {
				Utils.backup(college);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Platform.exit();
		});
		
		fileMenu.getItems().addAll(restoreItem, exitItem);
	}

	private void buildStudentMenu() {
		studentMenu = new Menu("Student");
		
		MenuItem insertItem = new MenuItem("Insert");
		insertItem.setOnAction(e -> {
			StudentPane studentPane = new StudentPane(insertItem.getText());
			root.setCenter(studentPane.getPane());
		});
		
		MenuItem searchItem = new MenuItem("Search");
		searchItem.setOnAction(e -> {
			StudentPane studentPane = new StudentPane(searchItem.getText(), root);
			root.setCenter(studentPane.getPane());
		});
		
		MenuItem removeItem = new MenuItem("Remove");
		removeItem.setOnAction(e -> {
			StudentPane studentPane = new StudentPane(removeItem.getText());
			root.setCenter(studentPane.getPane());
		});
		
		studentMenu.getItems().addAll(insertItem, searchItem, removeItem);
	}
	
	private void buildFacultyMenu() {
		facultyMenu = new Menu("Faculty");
		
		MenuItem insertItem = new MenuItem("Insert");
		insertItem.setOnAction(e -> {
			FacultyPane facultyPane = new FacultyPane(insertItem.getText());
			root.setCenter(facultyPane.getPane());
		});
		
		MenuItem searchItem = new MenuItem("Search");
		searchItem.setOnAction(e -> {
			FacultyPane facultyPane = new FacultyPane(searchItem.getText(), root);
			root.setCenter(facultyPane.getPane());
		});
		
		MenuItem removeItem = new MenuItem("Remove");
		removeItem.setOnAction(e -> {
			FacultyPane facultyPane = new FacultyPane(removeItem.getText());
			root.setCenter(facultyPane.getPane());
		});
		
		facultyMenu.getItems().addAll(insertItem, searchItem, removeItem);
	}
	
	private void buildTextbookMenu() {
		textbookMenu = new Menu("Textbook");
		
		MenuItem insertItem = new MenuItem("Insert");
		insertItem.setOnAction(e -> {
			TextbookPane textbookPane = new TextbookPane(insertItem.getText());
			root.setCenter(textbookPane.getPane());
		});
		
		MenuItem searchItem = new MenuItem("Search");
		searchItem.setOnAction(e -> {
			TextbookPane textbookPane = new TextbookPane(searchItem.getText(), root);
			root.setCenter(textbookPane.getPane());
		});
		
		MenuItem removeItem = new MenuItem("Remove");
		removeItem.setOnAction(e -> {
			TextbookPane textbookPane = new TextbookPane(removeItem.getText());
			root.setCenter(textbookPane.getPane());
		});
		
		textbookMenu.getItems().addAll(insertItem, searchItem, removeItem);
	}
	
	private void buildClassroomMenu() {
		classroomMenu = new Menu("Classroom");
		
		MenuItem insertItem = new MenuItem("Insert");
		insertItem.setOnAction(e -> {
			ClassroomPane classroomPane = new ClassroomPane(insertItem.getText());
			root.setCenter(classroomPane.getPane());
		});
		
		MenuItem searchItem = new MenuItem("Search");
		searchItem.setOnAction(e -> {
			ClassroomPane classroomPane = new ClassroomPane(searchItem.getText(), root);
			root.setCenter(classroomPane.getPane());
		});
		
		MenuItem removeItem = new MenuItem("Remove");
		removeItem.setOnAction(e -> {
			ClassroomPane classroomPane = new ClassroomPane(removeItem.getText());
			root.setCenter(classroomPane.getPane());
		});
		
		classroomMenu.getItems().addAll(insertItem, searchItem, removeItem);
	}
}
