package controllers;

import javafx.embed.swing.JFXPanel;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PersonalScheduleController2Test {

    PersonalScheduleController2 controller;


     private static final String TRAINING = "Jogging";
     private static final String DAY = "Miercuri";
     private static final String TIME = "18:00";

     @Before
      public void setUp() throws Exception {
         controller = new PersonalScheduleController2();
         controller.FilePath = "src/test/resources/client2_tabel.json";


            JFXPanel panel = new JFXPanel();
            controller.DeleteMessage = new Text();

        }
//testeaza daca se adauga un obiect
    @Test
    public void Test_Write() throws IOException, ParseException {
        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(controller.FilePath));

        obj.put("Training", TRAINING);
        obj.put("Day", DAY);
        obj.put("Time", TIME);
        array.add(obj);

        assertEquals(3, controller.Write(array).size());
    }

    @Test
    public void Test_handleDetele() throws IOException, ParseException {
        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(controller.FilePath));

        obj.put("Training", TRAINING);
        obj.put("Day", DAY);
        obj.put("Time", TIME);
        array.add(obj);

        assertEquals(2, controller.Delete(array, TRAINING, DAY, TIME).size());
    }

}