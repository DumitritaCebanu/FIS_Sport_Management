import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static void copyPath(File source, File dest)throws IOException {
        FileUtils.copyFileToDirectory(source, dest);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        File from_user = new File("src/main/resources/users.json").getAbsoluteFile();
        File from_clientiTabel = new File("src/main/resources/clientTabel.json").getAbsoluteFile();
        File from_client1Tabel = new File("src/main/resources/client1_tabel.json").getAbsoluteFile();
        File from_client2Tabel = new File("src/main/resources/client2_tabel.json").getAbsoluteFile();

        File to = new File("target\\src\\main\\resources");
        try{
            copyPath(from_user, to);
            copyPath(from_clientiTabel, to);
            copyPath(from_client1Tabel, to);
            copyPath(from_client2Tabel, to);
            System.out.println("Files copied successfully");
        }catch (IOException e){
            e.printStackTrace();
        }

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxmlFiles/LoginScreen.fxml")));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 630, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);

    }
}