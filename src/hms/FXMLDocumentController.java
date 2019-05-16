/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 *
 * @author Administrator
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button EntedabButton;
    @FXML
    private AnchorPane EntedabPage;
    @FXML
    private AnchorPane MainPage;
    @FXML
    private AnchorPane TshkelPage;

    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;

    @FXML
    private void mainePageOpenAction(ActionEvent event) {
            MainPage.setVisible(true);
            EntedabPage.setVisible(false);
            TshkelPage.setVisible(false);
    }
    @FXML
    private void entedabOpenAction(ActionEvent event) {
            MainPage.setVisible(false);
            EntedabPage.setVisible(true);
            TshkelPage.setVisible(false);
    }
    @FXML
    private void tshkelOpenAction(ActionEvent event) {
            MainPage.setVisible(false);
            EntedabPage.setVisible(false);
            TshkelPage.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fromDate.setChronology(HijrahChronology.INSTANCE);
        toDate.setChronology(HijrahChronology.INSTANCE);
    }
}
