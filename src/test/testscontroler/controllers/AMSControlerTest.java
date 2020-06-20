package controllers;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javafx.embed.swing.JFXPanel;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.testfx.framework.junit.ApplicationTest;
import users.Client;

import java.io.IOException;
import java.util.concurrent.Callable;

import static org.junit.Assert.*;

public class AMSControlerTest extends ApplicationTest {
    public static final String TEST_CLIENT = "testUser";
    public static final String TEST_SPORT = "testSport";
    public static final String TEST_WEEK = "testWeek";
    public static final String TEST_TIME = "testTime";
    private AMSControler controller;

    @Before
    public void setUp() throws Exception {
        controller = new AMSControler();
        controller.tableView = new TableView<>();
        controller.ClientTextField = new TextField();
        controller.SportTypeField = new TextField();
        controller.WeekTypeField = new TextField();
        controller.TimeTypeField = new TextField();

        controller.ClientTextField.setText(TEST_CLIENT);
        controller.SportTypeField.setText(TEST_SPORT);
        controller.WeekTypeField.setText(TEST_WEEK);
        controller.TimeTypeField.setText(TEST_TIME);
        controller.dndpath = "src/test/resources/clientTabel.json";
    }

    @Test
    public void testpushButtonforClient(){
        controller.pushButtonforClient();
        JSONObject objc = new JSONObject();
        objc.put("Client",TEST_CLIENT);
        objc.put("Sport",TEST_SPORT);
        objc.put("WeekDay",TEST_WEEK);
        objc.put("Time",TEST_TIME);
        Client c = new Client((String) ((JSONObject) objc).get("Client"), (String) ((JSONObject) objc).get("Sport"),
                (String) ((JSONObject) objc).get("WeekDay"), (String) ((JSONObject) objc).get("Time"));

        assertEquals(true,controller.tableView.getItems().add(c));
    }

    @Test
    public void testdelete() throws IOException, ParseException {

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(controller.dndpath));

        obj.put("Client",TEST_CLIENT);
        obj.put("Sport",TEST_SPORT);
        obj.put("WeekDay",TEST_WEEK);
        obj.put("Time",TEST_TIME);

        assertEquals(3, controller.Sterge(array,TEST_CLIENT,TEST_SPORT,TEST_WEEK,TEST_TIME ).size());

    }
    @Test
    public void Scrietest() throws IOException, ParseException {
        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(controller.dndpath));
        obj.put("Client",TEST_CLIENT);
        obj.put("Sport",TEST_SPORT);
        obj.put("WeekDay",TEST_WEEK);
        obj.put("Time",TEST_TIME);
        array.add(obj);

        assertEquals(4, controller.Scrie(array).size());
    }


}

