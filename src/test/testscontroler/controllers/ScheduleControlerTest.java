package controllers;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.testfx.framework.junit.ApplicationTest;
import users.BSchedule;
import users.Client;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

import static org.junit.Assert.*;

public class ScheduleControlerTest extends ApplicationTest {
    public final String TEST_LUNI = "Testluni";
    public final String TEST_MARTI = "Testmarti";
    public final String TEST_MIERCURI ="testmiercuri";
    public final String TEST_JOI = "Testjoi";
    public final String TEST_VINERI = "testvineri";
    public final String TEST_SAMBATA = "Testsambata";
    public final String TEST_DUMINICA = "Testduminica";
    public  final String TEST_TIME = "Testduminica";

    private ScheduleControler control;

    @Before
    public void Setup(){
        control = new ScheduleControler();
        control.tableView = new TableView<BSchedule>();
        control.TimeTextField = new TextField();
        control.LuniTextField = new TextField();
        control.MartiTextField = new TextField();
        control.MiercuriTextField = new TextField();
        control.JoiTextField = new TextField();
        control.VineriTextField = new TextField();
        control.SambataTextField = new TextField();
        control.DuminicaTextField = new TextField();

        control.TimeTextField.setText(TEST_TIME);
        control.LuniTextField.setText(TEST_LUNI);
        control.MartiTextField.setText(TEST_MARTI);
        control.MiercuriTextField.setText(TEST_MIERCURI);
        control.JoiTextField.setText(TEST_JOI);
        control.VineriTextField.setText(TEST_VINERI);
        control.SambataTextField.setText(TEST_SAMBATA);
        control.DuminicaTextField.setText(TEST_DUMINICA);

        control.pathFinder = "src/test/resources/bigSchedule.json";
    }

    @Test
    public void AddToScheduleTest(){
        control.AddToSchedule();
        JSONObject objb = new JSONObject();
        objb.put("Time",TEST_TIME);
        objb.put("Luni",TEST_LUNI);
        objb.put("Marti",TEST_MARTI);
        objb.put("Miercuri",TEST_MIERCURI);
        objb.put("Joi", TEST_JOI);
        objb.put("Viner",TEST_VINERI);
        objb.put("Sambata",TEST_SAMBATA);
        objb.put("Duminica",TEST_DUMINICA);
        BSchedule b = new BSchedule((String) ((JSONObject) objb).get("Time"),(String) ((JSONObject) objb).get("Luni"),
                (String) ((JSONObject) objb).get("Marti"),(String) ((JSONObject) objb).get("Miercuri"),
                (String) ((JSONObject) objb).get("Joi"),(String) ((JSONObject) objb).get("Vineri"),
                (String) ((JSONObject) objb).get("Sambata"),(String) ((JSONObject) objb).get("Duminica"));
        assertEquals(true,control.tableView.getItems().add(b));
    }
    @Test
    public void testdelete() throws IOException, ParseException {

        JSONObject objb = new JSONObject();
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(control.pathFinder));

        objb.put("Time",TEST_TIME);
        objb.put("Luni",TEST_LUNI);
        objb.put("Marti",TEST_MARTI);
        objb.put("Miercuri",TEST_MIERCURI);
        objb.put("Joi", TEST_JOI);
        objb.put("Viner",TEST_VINERI);
        objb.put("Sambata",TEST_SAMBATA);
        objb.put("Duminica",TEST_DUMINICA);

        assertEquals(5, control.Sterge(array,TEST_LUNI,TEST_MARTI,TEST_MIERCURI,TEST_JOI,TEST_VINERI,TEST_SAMBATA,TEST_DUMINICA,TEST_TIME ).size());

    }
    @Test
    public void Testscrie() throws IOException, ParseException {
        JSONObject objb = new JSONObject();
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray) parser.parse(new FileReader(control.pathFinder));
        objb.put("Time",TEST_TIME);
        objb.put("Luni",TEST_LUNI);
        objb.put("Marti",TEST_MARTI);
        objb.put("Miercuri",TEST_MIERCURI);
        objb.put("Joi", TEST_JOI);
        objb.put("Viner",TEST_VINERI);
        objb.put("Sambata",TEST_SAMBATA);
        objb.put("Duminica",TEST_DUMINICA);
        array.add(objb);

        assertEquals(6, control.Scrie(array).size());

    }

}