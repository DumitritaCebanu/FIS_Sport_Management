package controllers;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.IOException;

import static org.junit.Assert.*;

public class LoginControllerTest extends ApplicationTest {
    LoginController controller;

    @Before
    public void setUp() throws Exception {
        controller = new LoginController();

        //initializez JavaFX elements,altfel da nullPointerException....daca nu-s initializate daca nu e deschisa aplicatia ele nu exista
        JFXPanel panel = new JFXPanel();
        controller.LoginButton = new Button();
    }

    @Test
    public void Test_Login() throws IOException, ParseException {

        assertEquals(true,controller.handleLoginButtonAction());
    }


    @Test
    public void Read_emptyFile() {
        JSONArray expectedArray = new JSONArray();

        JSONArray resultedArray = controller.readFile("src/test/resources/empty.json");

        assertEquals(expectedArray, resultedArray);
    }

    @Test
    public void Read_n_ElementFile(){
        JSONArray resultedArray = controller.readFile("src/test/resources/users.json");

        assertEquals(4, resultedArray.size());
    }

}
