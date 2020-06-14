package controllers;
import javafx.collections.FXCollections;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import users.BSchedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.control.TableColumn.CellEditEvent;
import users.Client;

public class ScheduleControler implements Initializable {
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
    private TextField TimeTextField;
    @FXML
    private TextField LuniTextField;
    @FXML
    private TextField MartiTextField;
    @FXML
    private TextField MiercuriTextField;
    @FXML
    private TextField JoiTextField;
    @FXML
    private TextField VineriTextField;
    @FXML
    private TextField SambataTextField;
    @FXML
    private TextField DuminicaTextField;


    @FXML
    public void AddToSchedule(){
        JSONObject objs = new JSONObject();
        JSONParser parsers = new JSONParser();
        Object or;
        JSONArray arrays = new JSONArray();
        try {
            FileReader read = new FileReader("src/main/resources/bigSchedule.json");
            BufferedReader buffer = new BufferedReader(read);
            or = parsers.parse(buffer);
            if (or instanceof JSONArray) {
                arrays = (JSONArray) or;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        objs.put("Time",TimeTextField.getText());
        objs.put("Luni",LuniTextField.getText());
        objs.put("Marti",MartiTextField.getText());
        objs.put("Miercuri",MiercuriTextField.getText());
        objs.put("Joi",JoiTextField.getText());
        objs.put("Viner",VineriTextField.getText());
        objs.put("Sambata",SambataTextField.getText());
        objs.put("Duminica",DuminicaTextField.getText());
        arrays.add(objs);

        try{
            File file = new File("src/main/resources/bigSchedule.json");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            fw.write(arrays.toJSONString());
            fw.close();


        }catch(IOException e) {
            e.printStackTrace();
        }
        BSchedule ns = new BSchedule((String) ((JSONObject) objs).get("Time"),(String) ((JSONObject) objs).get("Luni"),
                (String) ((JSONObject) objs).get("Marti"),(String) ((JSONObject) objs).get("Miercuri"),
                (String) ((JSONObject) objs).get("Joi"),(String) ((JSONObject) objs).get("Vineri"),
                (String) ((JSONObject) objs).get("Sambata"),(String) ((JSONObject) objs).get("Duminica"));
        tableView.getItems().add(ns);
    }
    @Override
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
    public void DBschedule() throws IOException, ParseException {
        String s1 = TimeTextField.getText();
        String s2 = LuniTextField.getText();
        String s3 = MartiTextField.getText();
        String s4 = MiercuriTextField.getText();
        String s5 = JoiTextField.getText();
        String s6 = VineriTextField.getText();
        String s7 = SambataTextField.getText();
        String s8 = DuminicaTextField.getText();


        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/main/resources/bigSchedule.json"));

        Iterator<Object> is = jsonArray.iterator();
        while (is.hasNext()) {
            JSONObject js = (JSONObject) is.next();
            if (js.get("Time").equals(s1) && js.get("Luni").equals(s2) && js.get("Marti").equals(s3)
                    && js.get("Miercuri").equals(s4) && js.get("Joi").equals(s5) && js.get("Vineri").equals(s6) && js.get("Sambata").equals(s7) && js.get("Duminica").equals(s8)) ;

            is.remove();
        }
            try {
                File file = new File("src/main/resources/bigSchedule.json");
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                fw.write(jsonArray.toJSONString());
                fw.close();
                fw.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


    }
    @FXML
    void GoBackActionButton(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/MainPage.fxml")));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();
    }
}