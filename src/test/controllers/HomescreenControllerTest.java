package controllers;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomescreenControllerTest {

    HomescreenController controller;

    @Before
    public void setUp() throws Exception {
        controller = new HomescreenController();

        JFXPanel panel = new JFXPanel();
        controller.accesPersonalSchedule = new Button();
    }

    @Test
    public void test_handleActionButton() {
        assertTrue(controller.handleActionButton());
    }

}