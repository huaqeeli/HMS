/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private ComboBox<String> orderdateday;
    @FXML
    private ComboBox<String> orderdatemonth;
    @FXML
    private ComboBox<String> orderdateyear;
    @FXML
    private ComboBox<String> fromDateday;
    @FXML
    private ComboBox<String> fromDatemonth;
    @FXML
    private ComboBox<String> fromDateyear;
    @FXML
    private ComboBox<String> toDateday;
    @FXML
    private ComboBox<String> toDatemonth;
    @FXML
    private ComboBox<String> toDateyear;
    @FXML
    private AnchorPane Header;
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
    private TableView <ModelTable > enTable;
    @FXML
    private TableColumn <ModelTable,String> orderidcol;
    @FXML
    private TableColumn <ModelTable,String> orderdatecol;
    @FXML
    private TableColumn <ModelTable,String> enfromcol;
    @FXML
    private TableColumn <ModelTable,String> entocol;
    @FXML
    private TableColumn <ModelTable,String> endatefromcol;
    @FXML
    private TableColumn <ModelTable,String> endatetocol;
    @FXML
    private TableColumn <ModelTable,String> enplasecol;
    @FXML
    private TableColumn <ModelTable,String> militarytypecol;
    @FXML
    private TableColumn <ModelTable,String> entypecol;

    ObservableList<String> list1 = FXCollections.observableArrayList("داخلي", "خارجي");
    ObservableList<String> list2 = FXCollections.observableArrayList("افراد", "ضباط");
    ObservableList<String> list3 = FXCollections.observableArrayList("عادي", "صيفية");
    ObservableList<String> daylist = FXCollections.observableArrayList();
    ObservableList<String> monthlist = FXCollections.observableArrayList();
    ObservableList<String> yearlist = FXCollections.observableArrayList();
    ObservableList<ModelTable> tablelist = null;
   
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
        String feldName = "`ORDERID`,`ORDERDATE`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`,`ENPLASE`,`MILITARYTAYP`,`ENTAYP`";
        String[] data = {orderid.getText(), setDate(orderdateday.getValue(), orderdatemonth.getValue(), orderdateyear.getValue()), enfrom.getText(), ento.getText(),
            setDate(fromDateday.getValue(), fromDatemonth.getValue(), fromDateyear.getValue()), setDate(toDateday.getValue(), toDatemonth.getValue(), toDateyear.getValue()),
            PlaceOfAssignment.getValue(), militarytayp.getValue(), entayp.getValue()};
        String valuenumbers = "?,?,?,?,?,?,?,?,?";
        DataMng.insert("entdabat", feldName, valuenumbers, data);
         tableViewData() ;
    }
//String dat = orderdateday.getValue()+"-"+orderdatemonth.getValue()+"-"+orderdateyare.getValue();

    private String setDate(String day, String month, String year) {
        String date = year + "-" + month + "-" + day;
        return date;
    }

    private void tableViewData() {
        ResultSet rs = DataMng.getAllData("entdabat");
        try {
            while (rs.next()) {
                tablelist.add(new ModelTable(
                        rs.getString("ORDERID"),
                        rs.getString("ORDERDATE"), 
                        rs.getString("ENFROM"),
                        rs.getString("ENTO"), 
                        rs.getString("ENDATEFROM"),
                        rs.getString("ENDATETO"), 
                        rs.getString("ENPLASE"), 
                        rs.getString("MILITARYTAYP"), 
                        rs.getString("ENTAYP")
                ));      
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        enTable.setItems(tablelist);
    }

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

    private ObservableList fillYare(ObservableList yarelist) {
        for (int i = 1420; i <= 1480; i++) {
            yarelist.add(Integer.toString(i));
        }
        return yarelist;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PlaceOfAssignment.setItems(list1);
        militarytayp.setItems(list2);
        entayp.setItems(list3);
        orderdateday.setItems(fillDays(daylist));
        orderdatemonth.setItems(fillMonth(monthlist));
        orderdateyear.setItems(fillYare(yearlist));
        orderdateday.setValue(Integer.toString(HijriCalendar.getSimpleDay()));
        orderdatemonth.setValue(Integer.toString(HijriCalendar.getSimpleMonth()));
        orderdateyear.setValue(Integer.toString(HijriCalendar.getSimpleYear()));
        fromDateday.setItems(fillDays(daylist));
        fromDatemonth.setItems(fillMonth(monthlist));
        fromDateyear.setItems(fillYare(yearlist));
        fromDateday.setValue(Integer.toString(HijriCalendar.getSimpleDay()));
        fromDatemonth.setValue(Integer.toString(HijriCalendar.getSimpleMonth()));
        fromDateyear.setValue(Integer.toString(HijriCalendar.getSimpleYear()));
        toDateday.setItems(fillDays(daylist));
        toDatemonth.setItems(fillMonth(monthlist));
        toDateyear.setItems(fillYare(yearlist));
        toDateday.setValue(Integer.toString(HijriCalendar.getSimpleDay()));
        toDatemonth.setValue(Integer.toString(HijriCalendar.getSimpleMonth()));
        toDateyear.setValue(Integer.toString(HijriCalendar.getSimpleYear()));
        tablelist = FXCollections.observableArrayList();
//        orderidcol.setCellValueFactory(new PropertyValueFactory<>("orderid"));
//        orderdatecol.setCellValueFactory(new PropertyValueFactory<>("orderdate"));
//        enfromcol.setCellValueFactory(new PropertyValueFactory<>("enfrom"));
//        entocol.setCellValueFactory(new PropertyValueFactory<>("entocol"));
//        endatefromcol.setCellValueFactory(new PropertyValueFactory<>("endatefrom"));
//        endatetocol.setCellValueFactory(new PropertyValueFactory<>("endateto"));
//        enplasecol.setCellValueFactory(new PropertyValueFactory<>("enplase"));
//        militarytypecol.setCellValueFactory(new PropertyValueFactory<>("militarytype"));
//        entypecol.setCellValueFactory(new PropertyValueFactory<>("entype"));
        tableViewData();
    }
}
