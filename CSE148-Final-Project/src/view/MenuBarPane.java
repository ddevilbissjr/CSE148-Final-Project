package view;

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
	
	private College college;
	private BorderPane root;
	
	public MenuBarPane(College college, BorderPane root) {
		this.college = college;
		this.root = root;
		this.menuBar = new MenuBar();
		buildFileMenu();
		buildStudentMenu();
		menuBar.getMenus().addAll(fileMenu, studentMenu);
	}
	
	public MenuBar getMenuBar() {
		return menuBar;
	}

	private void buildStudentMenu() {
		studentMenu = new Menu("Student");
		
		MenuItem insertItem = new MenuItem("Insert");
		insertItem.setOnAction(e -> {
			StudentPane studentPane = new StudentPane(insertItem.getText());
			root.setCenter(studentPane.getStudentGrid());
		});
		
		MenuItem searchItem = new MenuItem("Search");
		searchItem.setOnAction(e -> {
			StudentPane studentPane = new StudentPane(searchItem.getText(), root);
			root.setCenter(studentPane.getStudentGrid());
		});
		
		MenuItem removeItem = new MenuItem("Remove");
		removeItem.setOnAction(e -> {
			StudentPane studentPane = new StudentPane(removeItem.getText());
			root.setCenter(studentPane.getStudentGrid());
		});
		
		MenuItem updateItem = new MenuItem("Update");
		
		studentMenu.getItems().addAll(insertItem, searchItem, removeItem, updateItem);
	}

	private void buildFileMenu() {
		fileMenu = new Menu("File");
		
		MenuItem restoreItem = new MenuItem("Restore");
		restoreItem.setOnAction(e -> {
			Utils.restore(college);
		});
		
		MenuItem exitItem = new MenuItem("Exit");
		exitItem.setOnAction(e -> {
			Utils.backup(college);
			Platform.exit();
		});
		
		fileMenu.getItems().addAll(restoreItem, exitItem);
	}
	
	
}
