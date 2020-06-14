package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.Objects;
import java.util.StringTokenizer;

import users.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class AMSControler implements Initializable {

    @FXML
    private TableView<Client> tableView;
    @FXML
    private TableColumn<Client, String> Clientid;
    @FXML
    private TableColumn<Client, String> SportChoise;
    @FXML
    private TableColumn<Client, String> WeekList;
    @FXML
    private TableColumn<Client, String> Time;
    @FXML
    private TextField ClientTextField;
    @FXML
    private TextField SportTypeField;
    @FXML
    private TextField WeekTypeField;
    @FXML
    private TextField TimeTypeField;





    public void pushButtonforClient() {
        JSONObject objc = new JSONObject();
        JSONParser parsers = new JSONParser();
        Object or;
        JSONArray arrays = new JSONArray();
        try {
            FileReader read = new FileReader("src/main/resources/clientTabel.json");
            BufferedReader buffer = new BufferedReader(read);
            or = parsers.parse(buffer);
            if (or instanceof JSONArray) {
                arrays = (JSONArray) or;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        objc.put("Client",ClientTextField.getText());
        objc.put("Sport",SportTypeField.getText());
        objc.put("WeekDay",WeekTypeField.getText());
        objc.put("Time",TimeTypeField.getText());

        arrays.add(objc);
        //try(FileWriter file = new FileWriter("C:\\Users\\Shak_al_CR\\Desktop\\FIS_Sport_Management\\src\\main\\java\\sources\\clientiTabel.json")){
        try{
            File file = new File("src/main/resources/clientTabel.json");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            fw.write(arrays.toJSONString());
            fw.close();


        }catch(IOException e) {
            e.printStackTrace();
        }


        //for (JSONObject tb : (Iterable<JSONObject>) arrays) {
        Client nc = new Client((String) ((JSONObject) objc).get("Client"), (String) ((JSONObject) objc).get("Sport"), (String) ((JSONObject) objc).get("WeekDay"), (String) ((JSONObject) objc).get("Time"));
        tableView.getItems().add(nc);


    }




    @Override
    public void initialize(URL location, ResourceBundle resources){

        Clientid.setCellValueFactory(new PropertyValueFactory<Client, String>("ClientName"));
        SportChoise.setCellValueFactory(new PropertyValueFactory<Client, String>("SportType"));
        WeekList.setCellValueFactory(new PropertyValueFactory<Client, String>("Weekday"));
        Time.setCellValueFactory(new PropertyValueFactory<Client, String>("ClientTime"));
        //tableView.setItems(getClients());
        //tableView.setEditable(true);
        Clientid.setCellFactory(TextFieldTableCell.forTableColumn());
        SportChoise.setCellFactory(TextFieldTableCell.forTableColumn());
        WeekList.setCellFactory(TextFieldTableCell.forTableColumn());
        Time.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        JSONParser parser = new JSONParser();
        Object obj;
        JSONArray array = new JSONArray();

        try {
            FileReader readFile = new FileReader("src/main/resources/clientTabel.json");
            BufferedReader buffer = new BufferedReader(readFile);
            obj = parser.parse(buffer);
            if (obj instanceof JSONArray) {
                array = (JSONArray) obj;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        for (JSONObject tabel : (Iterable<JSONObject>) array) {
            Client ct = new Client((String) ((JSONObject) tabel).get("Client"),
                    (String) ((JSONObject) tabel).get("Sport"), (String) ((JSONObject) tabel).get("WeekDay"),
                    (String) ((JSONObject) tabel).get("Time"));
            tableView.getItems().add(ct);
        }

    }


    public void deleteclientbutton() throws IOException, ParseException  {
        String s1 = Clientid.getText();
        String s2 = SportChoise.getText();
        String s3 = WeekList.getText();
        String s4 = Time.getText();

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/main/resources/clientTabel.json"));

        Iterator<Object> i = jsonArray.iterator();

        while (i.hasNext()) {
            JSONObject jc = (JSONObject) i.next();
            if(jc.get("Client").equals(s1) && jc.get("Sport").equals(s2) && jc.get("WeekDay").equals(s3)
                && jc.get("Time").equals(s4));
            i.remove();
            //System.out.println(jsonArray);
        }

        try{
            File file = new File("src/main/resources/clientTabel.json");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            fw.write(jsonArray.toJSONString());
            fw.close();
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void GoBackButton(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/MainPage.fxml")));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();
    }

}
