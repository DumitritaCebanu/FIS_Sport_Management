package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import users.BSchedule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Objects;
import java.util.ResourceBundle;

public class ScheduleControlerClient implements Initializable {
    @FXML
    private TableView<BSchedule> tableView;
    @FXML
    private TableColumn<BSchedule, String> TimpColumn;
    @FXML
    private TableColumn<BSchedule, String> LuniColumn;
    @FXML
    private TableColumn<BSchedule, String> MartiColumn;
    @FXML
    private TableColumn<BSchedule, String> MiercuriColumn;
    @FXML
    private TableColumn<BSchedule, String> JoiColumn;
    @FXML
    private TableColumn<BSchedule, String> VineriColumn;
    @FXML
    private TableColumn<BSchedule, String> SambataColumn;
    @FXML
    private TableColumn<BSchedule, String> DuminicaColumn;
    @FXML

    public void initialize(URL location, ResourceBundle resources) {
        TimpColumn.setCellValueFactory(new PropertyValueFactory<BSchedule, String>("Time"));
        LuniColumn.setCellValueFactory(new PropertyValueFactory<BSchedule, String>("Luni"));
        MartiColumn.setCellValueFactory(new PropertyValueFactory<BSchedule, String>("Marti"));
        MiercuriColumn.setCellValueFactory(new PropertyValueFactory<BSchedule, String>("Miercuri"));
        JoiColumn.setCellValueFactory(new PropertyValueFactory<BSchedule, String>("Joi"));
        VineriColumn.setCellValueFactory(new PropertyValueFactory<BSchedule, String>("Vineri"));
        SambataColumn.setCellValueFactory(new PropertyValueFactory<BSchedule, String>("Sambata"));
        DuminicaColumn.setCellValueFactory(new PropertyValueFactory<BSchedule, String>("Duminica"));

        TimpColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        LuniColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        MartiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        MiercuriColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        JoiColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        VineriColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        SambataColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DuminicaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        JSONParser parser = new JSONParser();
        Object obj;
        JSONArray array = new JSONArray();

        try {
            FileReader readFile = new FileReader("src/main/resources/bigSchedule.json");
            BufferedReader buffer = new BufferedReader(readFile);
            obj = parser.parse(buffer);
            if (obj instanceof JSONArray) {
                array = (JSONArray) obj;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        for (JSONObject tabel : (Iterable<JSONObject>) array) {
            BSchedule bt = new BSchedule((String) ((JSONObject) tabel).get("Time"),(String) ((JSONObject) tabel).get("Luni"),
                    (String) ((JSONObject) tabel).get("Marti"),(String) ((JSONObject) tabel).get("Miercuri"),
                    (String) ((JSONObject) tabel).get("Joi"),(String) ((JSONObject) tabel).get("Vineri"),
                    (String) ((JSONObject) tabel).get("Sambata"),(String) ((JSONObject) tabel).get("Duminica"));
            tableView.getItems().add(bt);
        }
    }

    @FXML
    public void GoBackSChButton(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/homescreen.fxml")));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();
    }

}
