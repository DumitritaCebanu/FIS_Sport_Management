package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class LoginController {

    public Text LoginMessage;
    public static String verify = "";

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    public Button LoginButton;


    @FXML
    void initialize() {
        LoginButton.setOnAction(event -> {
            try {
                handleLoginButtonAction();
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        });
    }
    @FXML
    public boolean handleLoginButtonAction() throws ParseException, IOException {
        LoginButton.setOnAction(event -> {

            String un = usernameField.getText();
            String pw = passwordField.getText();
            String client = un.substring(un.length() - 3);
            verify = un.substring(un.length() - 4);

            JSONArray userList = readFile("src/main/resources/users.json");

            assert userList != null;
            for (Object o : userList) {
                JSONObject jsonObject = (JSONObject) o;
                String user = (String) jsonObject.get("User");
                JSONArray credentials = (JSONArray) jsonObject.get("Credentials");
                StringTokenizer tokenizer = new StringTokenizer((String) credentials.get(0));
                tokenizer.nextElement();
                tokenizer.nextElement();
                String username = (String) tokenizer.nextElement();
                tokenizer = new StringTokenizer((String) credentials.get(1));
                tokenizer.nextElement();
                tokenizer.nextElement();
                String password = (String) tokenizer.nextElement();

                if (username.equals(un) && password.equals(pw)) {
                    Stage appStage = (Stage) LoginButton.getScene().getWindow();
                    Parent root;
                    if (client.equals("clt"))
                        try {
                            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/homescreen.fxml")));
                            Scene scene = new Scene(root);
                            appStage.setScene(scene);
                            appStage.show();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    else if (client.equals("adm"))
                        try {
                            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/MainPage.fxml")));
                            Scene scene = new Scene(root);
                            appStage.setScene(scene);
                            appStage.show();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                } else LoginMessage.setText("Log in failed, wrong credentials");
            }
        });
        return  true;
    }

    public JSONArray readFile(String sourceFilePath){

        JSONParser parser = new JSONParser();
        Object obj = null;

        try {
            obj = parser.parse(new FileReader(sourceFilePath));
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }
        JSONArray userList = (JSONArray) obj;
    return userList;
    }
}