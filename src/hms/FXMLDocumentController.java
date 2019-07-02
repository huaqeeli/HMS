/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import hms.models.EnDataModel;
import hms.models.NamesDataModel;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private Tab addhint;
    @FXML
    private Tab chackingdata;
    @FXML
    private Tab en_update;
    @FXML
    private Tab en_delete;
    @FXML
    private Tab en_search;
    @FXML
    private TextField ento;
    @FXML
    private TableView<EnDataModel> en_table;
    @FXML
    private TableColumn<EnDataModel, String> en_orderid_col;
    @FXML
    private TableColumn<EnDataModel, String> en_orderdate_col;
    @FXML
    private TableColumn<EnDataModel, String> en_from_col;
    @FXML
    private TableColumn<EnDataModel, String> en_to_col;
    @FXML
    private TableColumn<EnDataModel, String> en_datefrom_col;
    @FXML
    private TableColumn<EnDataModel, String> en_dateto_col;
    @FXML
    private TableColumn<EnDataModel, String> en_plase_col;
    @FXML
    private TableColumn<EnDataModel, String> en_militarytype_col;
    @FXML
    private TableColumn<EnDataModel, String> en_type_col;

    ObservableList<String> list1 = FXCollections.observableArrayList("داخلي", "خارجي");
    ObservableList<String> list2 = FXCollections.observableArrayList("افراد", "ضباط");
    ObservableList<String> list3 = FXCollections.observableArrayList("عادي", "صيفية");
    ObservableList<String> daylist = FXCollections.observableArrayList();
    ObservableList<String> monthlist = FXCollections.observableArrayList();
    ObservableList<String> yearlist = FXCollections.observableArrayList();
    ObservableList<EnDataModel> tablelist = FXCollections.observableArrayList();
    ObservableList<NamesDataModel> nametablelist = FXCollections.observableArrayList();
    @FXML
    private AnchorPane En_addName;
    @FXML
    private ComboBox<?> orderdateday1;
    @FXML
    private ComboBox<?> orderdatemonth1;
    @FXML
    private ComboBox<?> orderdateyear1;
    @FXML
    private ComboBox<?> orderdateday11;
    @FXML
    private ComboBox<?> orderdatemonth11;
    @FXML
    private ComboBox<?> orderdateyear11;
    @FXML
    private Label name_ordreid;
    @FXML
    private Label name_endate_from;
    @FXML
    private Label name_endate_to;
    @FXML
    private TextField name_militaryid;
    @FXML
    private TableView<NamesDataModel> names_table;
    @FXML
    private TableColumn<?, ?> name_militaryid_col;
    @FXML
    private TableColumn<?, ?> name_rank_col;
    @FXML
    private TableColumn<?, ?> name_name_col;

    @FXML
    private void mainePageOpenAction(ActionEvent event) {
        MainPage.setVisible(true);
        EntedabPage.setVisible(false);
        TshkelPage.setVisible(false);
        En_addName.setVisible(false);
    }

    private void tabhint(ActionEvent event) {
        final Tooltip tooltip = new Tooltip();
        tooltip.setText("hussein");
    }

    private void mainePageOpenAction() {
        MainPage.setVisible(true);
        EntedabPage.setVisible(false);
        TshkelPage.setVisible(false);
        En_addName.setVisible(false);
    }

    @FXML
    private void entedabOpenAction(ActionEvent event) {
        MainPage.setVisible(false);
        EntedabPage.setVisible(true);
        TshkelPage.setVisible(false);
        En_addName.setVisible(false);
    }

    @FXML
    private void tshkelOpenAction(ActionEvent event) {
        MainPage.setVisible(false);
        EntedabPage.setVisible(false);
        TshkelPage.setVisible(true);
        En_addName.setVisible(false);
    }

    @FXML
    private void addNameOpenAction(ActionEvent event) {
        MainPage.setVisible(false);
        EntedabPage.setVisible(false);
        TshkelPage.setVisible(false);
        En_addName.setVisible(true);
        name_ordreid.setText(orderid.getText());
        name_endate_from.setText(setDate(fromDateday.getValue(), fromDatemonth.getValue(), fromDateyear.getValue()));
        name_endate_to.setText(setDate(toDateday.getValue(), toDatemonth.getValue(), toDateyear.getValue()));
    }

    private void OpenAction(ActionEvent event) {
        Stage stage = null;
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        try {
            root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void insertData(ActionEvent event) {
        String fieldName = "`ORDERID`,`ORDERDATE`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`,`ENPLASE`,`MILITARYTAYP`,`ENTAYP`";
        String[] data = {orderid.getText(), setDate(orderdateday.getValue(), orderdatemonth.getValue(), orderdateyear.getValue()), enfrom.getText(), ento.getText(),
            setDate(fromDateday.getValue(), fromDatemonth.getValue(), fromDateyear.getValue()), setDate(toDateday.getValue(), toDatemonth.getValue(), toDateyear.getValue()),
            PlaceOfAssignment.getValue(), militarytayp.getValue(), entayp.getValue()};
        String valuenumbers = "?,?,?,?,?,?,?,?,?";
        DataMng.insert("entdabat", fieldName, valuenumbers, data);
        refreshEnTable();
    }
    @FXML
    private void insertName(ActionEvent event) {
        String tableName ="namesdata";
        String fieldName = "`MILITARYID`,`ORDERID`,`ENDATEFROM`,`ENDATETO`";
        String[] data = {name_militaryid.getText(),name_ordreid.getText(),name_endate_from.getText(),name_endate_to.getText()};
        String valuenumbers = "?,?,?,?";
        DataMng.insert(tableName, fieldName, valuenumbers, data);
        refreshNameTable();
    }

    private String setDate(String day, String month, String year) {
        String date = year + "-" + month + "-" + day;
        return date;
    }

    private void refreshEnTable() {
        tablelist.clear();
        enTableViewData();
    }
    private void refreshNameTable() {
        nametablelist.clear();
        nameTableViewData();
    }

    private void nameTableViewData() {
        ResultSet rs = DataMng.getDataWithCondition("namesdata", "MILITARYID,RANK,NAME", "MILITARYID ="+name_militaryid.getText());
        try {
            while (rs.next()) {
                nametablelist.add(new NamesDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME")
                ));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        name_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
        name_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        name_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));

        names_table.setItems(nametablelist);
    }
    
    private void enTableViewData() {
        ResultSet rs = DataMng.getAllData("entdabat");
        try {
            while (rs.next()) {
                tablelist.add(new EnDataModel(
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
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        en_orderid_col.setCellValueFactory(new PropertyValueFactory<>("orderid"));
        en_orderdate_col.setCellValueFactory(new PropertyValueFactory<>("orderdate"));
        en_from_col.setCellValueFactory(new PropertyValueFactory<>("enfrom"));
        en_to_col.setCellValueFactory(new PropertyValueFactory<>("ento"));
        en_datefrom_col.setCellValueFactory(new PropertyValueFactory<>("endatefrom"));
        en_dateto_col.setCellValueFactory(new PropertyValueFactory<>("endateto"));
        en_plase_col.setCellValueFactory(new PropertyValueFactory<>("enplase"));
        en_militarytype_col.setCellValueFactory(new PropertyValueFactory<>("militarytype"));
        en_type_col.setCellValueFactory(new PropertyValueFactory<>("entype"));

        en_table.setItems(tablelist);
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
        enTableViewData();
        mainePageOpenAction();

        addhint.setTooltip(new Tooltip("اضافة طلب انتداب"));
        chackingdata.setTooltip(new Tooltip("تدقيق البيانات"));
        en_update.setTooltip(new Tooltip("تحديث البيانات"));
        en_search.setTooltip(new Tooltip("البحث واستعراض البيانات"));
        en_delete.setTooltip(new Tooltip("حذف البيانات"));
    }
}
