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
import model.Major;
import model.MiniStudentCourseInfo;
import model.Person;
import model.Student;
import utils.PersonFactory;

public class TextbookPane {
	public GridPane pane;

	public TextbookPane(String action, Object... args) {
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
		
		Text major = new Text("Major: ");
		ComboBox majorField = new ComboBox(FXCollections.observableArrayList(Major.values()));
		pane.add(major, 0, 4);
		pane.add(majorField, 1, 4);
		
		Text numOfClasses = new Text("How many classes: ");
		String[] num = {"3", "4", "5", "6"};
		ComboBox numOfClassesField = new ComboBox(FXCollections.observableArrayList(num));
		pane.add(numOfClasses, 0, 5);
		pane.add(numOfClassesField, 1, 5);
		
		Button insertBtn = new Button("INSERT");
		insertBtn.setOnAction(e -> {
			PersonFactory.createStudent(
					randName.isSelected() ? "-1" : nameField.getText(),
					randID.isSelected() ? "-1" : idField.getText(), 
					(Major)majorField.getValue(), 
					Integer.parseInt(numOfClassesField.getValue().toString())
			);
		});
		pane.add(insertBtn, 1, 6);
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
		
		Student s = (Student)person;
		
		Text majorText = new Text("Major:");
		TextField major = new TextField(s.getCurrentMajor().toString());
		pane.add(majorText, 0, 3);
		pane.add(major, 2, 3);
		
		Text gpaTitle = new Text("GPA:");
		Text gpa = new Text("" + s.getGpa());
		pane.add(gpaTitle, 0, 4);
		pane.add(gpa, 2, 4);
		
		int count = 5;
		Text coursesTitle = new Text("Courses:");
		pane.add(coursesTitle, 0, count);
		for(MiniStudentCourseInfo i : s.getMiniStudentCourseBag().getMiniStudentInfo()) {
			Text course = new Text(
				"[" + i.getCourseNumber() + ": " + i.getNumberOfCredits() + ", " + i.getCurrentLetterGrade().toString() + ", " + i.getCurrentCourseStatus().toString() + "]"
			);
			pane.add(course, 2, count);
			count++;
		}
	
		Button updateBtn = new Button("UPDATE");
		updateBtn.setOnAction(e -> {
			String[] split = name.getText().split(" ");
			s.setFirstName(split[0]);
			s.setLastName(split[1]);
			
			s.setId(id.getText());
			s.setCurrentMajor(Major.valueOf(major.getText()));
		});
		pane.add(updateBtn, 2, count);
		
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
		
		TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price column
        TableColumn<Student, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //Quantity column
        TableColumn<Student, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);
	 */
}
