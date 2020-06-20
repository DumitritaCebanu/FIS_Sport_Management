package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomescreenController implements Initializable {

    public ImageView image;
    public Button accesSchedule;
    public Button accesPersonalSchedule;



    // deschide pagina cu orarul principal
    @FXML
    void accesButton(ActionEvent event) throws IOException {
        Parent viewParent  = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/ScheduleScreenClient.fxml")));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }


    // deschide pagina cu orarul clientuluia
    @FXML
    boolean handleActionButton() {
        if (LoginController.verify.equals("9clt"))
            try {
                Parent viewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/personalSchedule.fxml")));
                Scene viewScene = new Scene(viewParent);
                Stage window = (Stage) accesPersonalSchedule.getScene().getWindow();

                window.setScene(viewScene);
                window.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        else if (LoginController.verify.equals("4clt"))
            try {
                Parent viewParent = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/personalSchedule2.fxml")));
                Scene viewScene = new Scene(viewParent);
                Stage window = (Stage) accesPersonalSchedule.getScene().getWindow();

                window.setScene(viewScene);
                window.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    return true;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}