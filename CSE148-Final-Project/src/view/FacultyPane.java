package view;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Department;
import model.Faculty;
import model.Major;
import model.MiniStudentCourseInfo;
import model.Person;
import model.Student;
import model.Title;
import utils.PersonFactory;

public class FacultyPane {
	public GridPane pane;

	public FacultyPane(String action, Object... args) {
		if(action.equals("Insert")) {
			insertAction();
		}
		if(action.equals("Search")) {
			searchAction((BorderPane)args[0]);
		}
		if(action.equals("Remove")) {
			removeAction();
		}
	}
	
	private void insertAction () {
		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(10);
		pane.setHgap(30);
		
		Text name = new Text("Name: ");
		TextField nameField = new TextField();
		nameField.setMaxWidth(200);
		pane.add(name, 0, 0);
		pane.add(nameField, 1, 0);
		
		CheckBox randName = new CheckBox("Use random name?");
		pane.add(randName, 1, 1);
		
		Text id = new Text("ID: ");
		TextField idField = new TextField();
		idField.setMaxWidth(200);
		pane.add(id, 0, 2);
		pane.add(idField, 1, 2);
		
		CheckBox randID = new CheckBox("Use random ID?");
		pane.add(randID, 1, 3);
		
		Text title = new Text("Title: ");
		ComboBox titleField = new ComboBox(FXCollections.observableArrayList(Title.values()));
		pane.add(title, 0, 4);
		pane.add(titleField, 1, 4);
		
		Text department = new Text("Department: ");
		ComboBox departmentField = new ComboBox(FXCollections.observableArrayList(Department.values()));
		pane.add(department, 0, 5);
		pane.add(departmentField, 1, 5);
		
		Text phone = new Text("Phone Number: ");
		TextField phoneField = new TextField();
		phoneField.setMaxWidth(200);
		pane.add(phone, 0, 6);
		pane.add(phoneField, 1, 6);
		
		Text salary = new Text("Salary: ");
		TextField salaryField = new TextField();
		salaryField.setMaxWidth(200);
		pane.add(salary, 0, 7);
		pane.add(salaryField, 1, 7);
		
		Button insertBtn = new Button("INSERT");
		insertBtn.setOnAction(e -> {
			PersonFactory.createFaculty(
					randName.isSelected() ? "-1" : nameField.getText(),
					randID.isSelected() ? "-1" : idField.getText(), 
					(Title)titleField.getValue(),
					(Department)departmentField.getValue(),
					phoneField.getText(),
					Double.parseDouble(salaryField.getText())
			);
		});
		pane.add(insertBtn, 1, 8);
	}
	
	private void searchAction (BorderPane args) {
		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(10);
		pane.setHgap(30);
		
		Text id = new Text("Search by ID: ");
		TextField idField = new TextField();
		idField.setMaxWidth(200);
		pane.add(id, 0, 0);
		pane.add(idField, 1, 0);
		
		Button searchBtn = new Button("SEARCH");
		searchBtn.setOnAction(e -> {
			searchResult(PersonFactory.getPersonByID(idField.getText()), args);
		});
		pane.add(searchBtn, 1, 1);
	}
	
	private void searchResult (Person person, BorderPane args) {
		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(10);
		pane.setHgap(30);
		
		Text title = new Text("Search Results:");
		pane.add(title, 1, 0);
		
		Text nameTitle = new Text("Name:");
		TextField name = new TextField(person.getFirstName() + " " + person.getLastName());
		pane.add(nameTitle, 0, 1);
		pane.add(name, 2, 1);
		
		Text idTitle = new Text("ID:");
		TextField id = new TextField(person.getId());
		pane.add(idTitle, 0, 2);
		pane.add(id, 2, 2);
		
		Faculty f = (Faculty)person;
		
		Text majorText = new Text("Title:");
		TextField major = new TextField(f.getCurrentTitle().toString());
		pane.add(majorText, 0, 3);
		pane.add(major, 2, 3);
		
		Text gpaTitle = new Text("GPA:");
		TextField gpa = new TextField(f.getCurrentDepartment().toString());
		pane.add(gpaTitle, 0, 4);
		pane.add(gpa, 2, 4);
		
		Text phone = new Text("Phone Number:");
		TextField phoneField = new TextField(f.getOfficePhone());
		pane.add(phone, 0, 5);
		pane.add(phoneField, 2, 5);
		
		Text salary = new Text("Salary:");
		TextField salaryField = new TextField("" + f.getSalary());
		pane.add(salary, 0, 6);
		pane.add(salaryField, 2, 6);
	
		Button updateBtn = new Button("UPDATE");
		updateBtn.setOnAction(e -> {
			String[] split = name.getText().split(" ");
			f.setFirstName(split[0]);
			f.setLastName(split[1]);
			
			f.setId(id.getText());
			f.setCurrentTitle(Title.valueOf(title.getText()));
			f.setCurrentDepartment(Department.valueOf(gpa.getText()));
			f.setOfficePhone(phoneField.getText());
			f.setSalary(Double.parseDouble(salary.getText()));
		});
		pane.add(updateBtn, 2, 7);
		
		args.setCenter(pane);
	}
	
	private void removeAction () {
		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setVgap(10);
		pane.setHgap(30);
		
		Text id = new Text("Delete by ID:");
		TextField idField = new TextField();
		idField.setMaxWidth(200);
		pane.add(id, 0, 0);
		pane.add(idField, 1, 0);
		
		Button removeBtn = new Button("REMOVE");
		removeBtn.setOnAction(e -> {
			PersonFactory.deleteByID(idField.getText());
		});
		pane.add(removeBtn, 1, 1);
	}
	
	public Alert newAlert () {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Look, an Error Dialog");
		alert.setContentText("Ooops, there was an error!");

		alert.showAndWait();
		return alert;
	}

	public GridPane getPane() {
		return pane;
	}
	
	/*
	 * TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Remove by ID");
			dialog.setContentText("Please enter a student ID");
			dialog.setHeaderText("Student ID Please");
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(idNumber -> {
				PersonFactory.deleteByID((String) args);
			});
	*/
}
