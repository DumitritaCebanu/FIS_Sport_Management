package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import users.Table;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.Objects;
import java.util.ResourceBundle;

public class PersonalScheduleController implements Initializable {
    public Text DeleteMessage;
    public VBox Vbox;
    public Label text;
    public HBox HBox;

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

    @Override
    public void initialize(URL location, ResourceBundle rb) {
        DeleteButton.setOnAction(event -> {
            try {
                handleDetele();
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        });

        AddButton.setOnAction(event -> AddEvent());

        returnButton.setOnAction(event -> {
            try {
                handleActionButton(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //set up the columns
        day.setCellValueFactory(new PropertyValueFactory<>("day"));
        trainings.setCellValueFactory(new PropertyValueFactory<>("trainings"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));

        day.setCellFactory(TextFieldTableCell.forTableColumn());
        trainings.setCellFactory(TextFieldTableCell.forTableColumn());
        time.setCellFactory(TextFieldTableCell.forTableColumn());

        //Arata continutul fisierului im tabel
        JSONParser parser = new JSONParser();
        Object obj;
        JSONArray array = new JSONArray();

        try{
            FileReader readFile = new FileReader("src/main/resources/client1_tabel.json");
            BufferedReader buffread = new BufferedReader(readFile);
            obj = parser.parse(buffread);
            if(obj instanceof JSONArray){
                array = (JSONArray) obj;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        //Shows in tabel data from .json
        for (JSONObject detailes : (Iterable<JSONObject>) array){
            Table details = new Table((String) ((JSONObject) detailes).get("Day"), (String) ((JSONObject) detailes).get("Training"), (String) ((JSONObject) detailes).get("Time"));
            TableView.getItems().add(details);
        }
    }

    //Adauga datele din Textfield in .JSON
    @FXML
     void AddEvent() {
        JSONObject obj = new JSONObject();
        Object p;
        JSONParser parser = new JSONParser();
        JSONArray list = new JSONArray();

    //Copiere continut deja existent cu Parser
        try{
            FileReader readFile = new FileReader("src/main/resources/client1_tabel.json");
            BufferedReader read = new BufferedReader(readFile);
            p = parser.parse(read);
            if(p instanceof JSONArray)
            {
                list = (JSONArray) p;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    //Adauga datele
        obj.put("Day", dayInput.getText());
        obj.put("Training", trainingInput.getText());
        obj.put("Time", timeInput.getText());
        list.add(obj);

        //Scriere in fisier
            try {
                File file = new File("src/main/resources/client1_tabel.json");
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                fw.write(list.toJSONString());
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        //cand le adaug in fisier le arat si in tabel
        JSONParser parserr = new JSONParser();
        Object objj;
        JSONArray array = new JSONArray();
        try {
            FileReader readFile = new FileReader("src/main/resources/client1_tabel.json");
            BufferedReader buffread = new BufferedReader(readFile);
            objj = parserr.parse(buffread);
            if (objj instanceof JSONArray) {
                array = (JSONArray) objj;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        //Arata in tabel trainigul adaugat
        Table details = new Table((String) ((JSONObject) array.get(array.size() - 1)).get("Day"), (String) ((JSONObject) array.get(array.size() - 1)).get("Training"), (String) ((JSONObject) array.get(array.size() - 1)).get("Time"));
        TableView.getItems().add(details);

        dayInput.clear();
        trainingInput.clear();
        timeInput.clear();
    }

    //Delete button clicked
    @FXML
    void handleDetele() throws IOException, ParseException {

        // sterge elementele selectate din fisier
        String match1 = trainingInput.getText();
        String match2 = dayInput.getText();
        String match3 = timeInput.getText();

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("src/main/resources/client1_tabel.json"));

        Iterator<Object> iter = jsonArray.iterator();

        while (iter.hasNext()) {
            JSONObject jo = (JSONObject) iter.next();
            if(jo.get("Training").equals(match1) && jo.get("Time").equals(match3) && jo.get("Day").equals(match2))
                iter.remove();
            DeleteMessage.setText("Training deleted! Please go back and return to see the changes");
             }

        //Scriere in fisier
        try{
            File file = new File("src/main/resources/client1_tabel.json");
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            fw.write(jsonArray.toJSONString());
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        dayInput.clear();
        trainingInput.clear();
        timeInput.clear();

    }
    
    //return to the previous scene
    @FXML
    public void handleActionButton(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/homescreen.fxml")));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();
    }
}

