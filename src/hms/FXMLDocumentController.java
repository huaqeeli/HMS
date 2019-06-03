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
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

/**
 *
 * @author Administrator
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button EntedabButton;
    @FXML
    private AnchorPane EntedabPage;
    @FXML
    private AnchorPane MainPage;
    @FXML
    private AnchorPane TshkelPage;
    @FXML
    private ComboBox<String> PlaceOfAssignment;
    @FXML
    private ComboBox<String> militarytayp;
    @FXML
    private ComboBox<String> entayp;
    @FXML
    private ComboBox<String> day;
    @FXML
    private ComboBox<String> month;
    @FXML
    private ComboBox<String> yare;

    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private AnchorPane Header;
    @FXML
    private DatePicker orderdate;
    @FXML
    private Button TriningButton;
    @FXML
    private Button VacationButton;
    @FXML
    private Button TshkelButton;
    @FXML
    private Button save;
    @FXML
    private TextField orderid;
    @FXML
    private TextField enfrom;
    @FXML
    private TextField ento;

    ObservableList<String> list1 = FXCollections.observableArrayList("داخلي", "خارجي");
    ObservableList<String> list2 = FXCollections.observableArrayList("افراد", "ضباط");
    ObservableList<String> list3 = FXCollections.observableArrayList("عادي", "صيفية");
    ObservableList<String> daylist = FXCollections.observableArrayList();
    ObservableList<String> monthlist = FXCollections.observableArrayList();
    ObservableList<String> yearlist = FXCollections.observableArrayList();

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

    @FXML
    private void insertData(ActionEvent event) {
//        String feldName = "`ORDERID`,`ORDERDATE`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`,`ENPLASE`,`MILITARYTAYP`,`ENTAYP`";
        String feldName = "ORDERID,ORDERDATE,ENFROM,ENTO,ENDATEFROM,ENDATETO,ENPLASE,MILITARYTAYP,ENTAYP";
        String[] data = {orderid.getText(), ((TextField) orderdate.getEditor()).getText(), enfrom.getText(), ento.getText(),
            ((TextField) fromDate.getEditor()).getText(), ((TextField) toDate.getEditor()).getText(), PlaceOfAssignment.getValue(),
            militarytayp.getValue(), entayp.getValue()};
        String valuenumber = "?,?,?,?,?,?,?,?,?";
        DataMng.insert("entdabat", feldName, valuenumber, data);
    }

    @FXML
    private void dateFormat(DatePicker dpDate) {
//        dpDate.setValue(LocalDate.now());
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        dpDate.setChronology(HijrahChronology.INSTANCE);
        dpDate.setConverter(new StringConverter<LocalDate>() {

            @Override
            public String toString(LocalDate t) {
                if (t != null) {
                    return dateFormatter.format(t);
                }
                return null;
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.trim().isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                }
                return null;
            }
        });

    }

    @FXML
    private ObservableList fillDays(ObservableList daylist) {
        for (int i = 1; i <= 30; i++) {
            if (i <= 9) {
                daylist.add("0" + Integer.toString(i));
            } else {
                daylist.add(Integer.toString(i));
            }
        }
        return daylist;
    }

    @FXML
    private ObservableList fillMonth(ObservableList monthlist) {
        for (int i = 1; i <= 12; i++) {
            if (i <= 9) {
                monthlist.add("0" + Integer.toString(i));
            } else {
                monthlist.add(Integer.toString(i));
            }
        }
        return monthlist;
    }

    @FXML
    private ObservableList fillYare(ObservableList yarelist) {
        for (int i = 1420; i <= 1480; i++) {
            yarelist.add(Integer.toString(i));
        }
        return yarelist;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toDate.setChronology(HijrahChronology.INSTANCE);
        orderdate.setChronology(HijrahChronology.INSTANCE);
        PlaceOfAssignment.setItems(list1);
        militarytayp.setItems(list2);
        entayp.setItems(list3);
        dateFormat(fromDate);
        day.setItems(fillDays(daylist));
        month.setItems(fillMonth(monthlist));
        yare.setItems(fillYare(yearlist));
        day.setValue(Integer.toString(HijriCalendar.getSimpleDay()));
        month.setValue(Integer.toString(HijriCalendar.getSimpleMonth()));
        yare.setValue(Integer.toString(HijriCalendar.getSimpleYear()));
        String dat = day.getValue()+"-"+month.getValue()+"-"+yare.getValue();
        System.out.println(dat);
    }
}
