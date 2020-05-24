package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import users.Table;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PersonalScheduleController implements Initializable {

    public VBox Vbox;
    public Label text;

    @FXML
    private HBox HBox;

    @FXML
    private TextField dayInput;

    @FXML
    private TextField trainingInput;

    @FXML
    private TableView<Table> TableView;

    @FXML
    private TextField timeInput;

    @FXML
    private TableColumn<Table, String> day;

    @FXML
    private TableColumn<Table, String> trainings;

    @FXML
    private TableColumn<Table, String> time;

    @FXML
    private Button AddButton;

    @FXML
    private Button DeleteButton;
    @FXML
    private Button returnButton;

    @FXML
    private Button saveButton;

    //Add button clicked
    @FXML
    void handleButtonAction(){}

    //Delete button clicked
    @FXML
    void handleDetele(){}

    @Override
    public void initialize(URL location, ResourceBundle resources) { }


    //save the data
    public void saveEvent(){}

    //return to the previous scene
    @FXML
    void handleActionButton(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/homescreen.fxml")));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();
    }
}

