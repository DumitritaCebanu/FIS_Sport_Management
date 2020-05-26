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
public class MainPControlers implements Initializable {
    public void initialize(URL location, ResourceBundle resources) {

    }



    @FXML

    void AMSButton(ActionEvent event) throws IOException {
        Parent viewParent  = FXMLLoader.load(getClass().getResource("/fxmlFiles/AdminHomeScreen.fxml"));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }


    void MPButton(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("/resources/BigSchedule.fxml"));
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(viewScene);
        window.show();

    }
}