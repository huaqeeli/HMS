package hms;

import hms.models.CheckAllDataModel;
import hms.models.EnDataModel;
import hms.models.NamesDataModel;
import hms.models.TestModel;
import hms.models.TransportDataModel;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainController implements Initializable {

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
    @FXML
    private TableColumn<EnDataModel, String> en_listnumber_col;
    @FXML
    private ComboBox<String> ch_en_fromdateday;
    @FXML
    private ComboBox<String> ch_en_fromdatemonth;
    @FXML
    private ComboBox<String> ch_en_fromdateyear;
    @FXML
    private TextField ch_mailitraynum;
    @FXML
    private ComboBox<String> ch_en_todateday;
    @FXML
    private ComboBox<String> ch_en_todatemonth;
    @FXML
    private ComboBox<String> ch_en_todateyear;
    @FXML
    private TableView<NamesDataModel> chacktable;
    @FXML
    private TableColumn<?, ?> ch_mailitraynum_col;
    @FXML
    private TableColumn<?, ?> ch_rank_col;
    @FXML
    private TableColumn<?, ?> ch_name_col;
    @FXML
    private TableColumn<?, ?> ch_en_fromdate_col;
    @FXML
    private TableColumn<?, ?> ch_en_todate_col;

    ObservableList<String> list1 = FXCollections.observableArrayList("داخلي", "خارجي");
    ObservableList<String> list2 = FXCollections.observableArrayList("افراد", "ضباط");
    ObservableList<String> list3 = FXCollections.observableArrayList("عادي", "صيفية");
    ObservableList<String> ranklist = FXCollections.observableArrayList("الفريق اول", "الفريق", "الواء", "العميد", "العقيد", "المقدم", "النقيب", "الملازم أول", "رئيس رقباء", "رقيب أول", "رقيب", "وكيل رقيب", "عريف", "جندي أول", "جندي");
    ObservableList<String> qualificationlist = FXCollections.observableArrayList("جامعي", "ثانوية عامة", "الكفاءة المتوسطة", "الابتدائية");
    ObservableList<String> bloodTypeList = FXCollections.observableArrayList("O+", "A+", "B+", "AB+", "O-", "A-", "B-", "AB-");
    ObservableList<String> daylist = FXCollections.observableArrayList();
    ObservableList<String> specialiazList = FXCollections.observableArrayList();
    ObservableList<String> unitNameList = FXCollections.observableArrayList();
    ObservableList<String> monthlist = FXCollections.observableArrayList();
    ObservableList<String> yearlist = FXCollections.observableArrayList();
    ObservableList<EnDataModel> tablelist = FXCollections.observableArrayList();
    ObservableList<NamesDataModel> chacktablelist = FXCollections.observableArrayList();
    ObservableList<NamesDataModel> excludedtablelist = FXCollections.observableArrayList();
    ObservableList<String> ch_comboBoxlist = FXCollections.observableArrayList();
    ObservableList<String> reasonlist = FXCollections.observableArrayList();
    ObservableList<NamesDataModel> no_declist = FXCollections.observableArrayList();
    ObservableList<NamesDataModel> declist = FXCollections.observableArrayList();
    ObservableList<TransportDataModel> forTransportlist = FXCollections.observableArrayList();
    @FXML
    private Label listnumber;
    @FXML
    private Label excludedNumber;
    @FXML
    private Button ch_en_button;
    @FXML
    private TextField ch_enfrom;
    @FXML
    private TextField ch_ento;
    @FXML
    private TableColumn<?, ?> ch_en_from_col;
    @FXML
    private TableColumn<?, ?> ch_en_to_col;
    @FXML
    private TableColumn<?, ?> en_ch_sq_col;
    @FXML
    private ComboBox<String> ch_list_combobox;
    private String updatOrderId = null;
    private String updatFromDate = null;
    private String updatToDate = null;
    private String inTransPortMilitaryid = null;
    private String inTransPortId = null;
    private String outTransPortMilitaryid = null;
    private String outTransPortId = null;
    @FXML
    private TableView<NamesDataModel> no_dec_table;
    @FXML
    private TableColumn<?, ?> no_dec_militaryid_col;
    @FXML
    private TableColumn<?, ?> no_dec_rank_col;
    @FXML
    private TableColumn<?, ?> no_dec_name_col;
    @FXML
    private TableColumn<?, ?> no_dec_sequence_col;
    @FXML
    private TableView<NamesDataModel> dec_table;
    @FXML
    private TableColumn<?, ?> dec_militaryid_col;
    @FXML
    private TableColumn<?, ?> dec_rank_col;
    @FXML
    private TableColumn<?, ?> dec_name_col;
    @FXML
    private TableColumn<?, ?> dec_sequence_col;
    @FXML
    private TextField mandate_ch_decnumber;
    @FXML
    private ComboBox<String> mandate_ch_dec_fromday;
    @FXML
    private ComboBox<String> mandate_ch_dec_frommonth;
    @FXML
    private ComboBox<String> mandate_ch_dec_fromyear;
    @FXML
    private ComboBox<String> mandate_ch_dec_today;
    @FXML
    private ComboBox<String> mandate_ch_dec_tomonth;
    @FXML
    private ComboBox<String> mandate_ch_dec_toyear;
    @FXML
    private ComboBox<String> mandate_ch_decday;
    @FXML
    private ComboBox<String> mandate_ch_decmonth;
    @FXML
    private ComboBox<String> mandate_ch_decyear;

    @FXML
    private Button ch_en_allofficers;
    @FXML
    private Button ch_en_allsoldiers;

    @FXML
    private TableColumn<?, ?> en_sq_col;

    DataMng dataMang = new DataMng();
    @FXML
    private AnchorPane ExcludedPage;
    @FXML
    private TableView<NamesDataModel> ex_tableview;
    @FXML
    private TableColumn<?, ?> ex_sequence_col;
    @FXML
    private TableColumn<?, ?> ex_militaryid_col;
    @FXML
    private TableColumn<?, ?> ex_rank_col;
    @FXML
    private TableColumn<?, ?> ex_name_col;
    @FXML
    private ListView<String> ex_reasonListView;

    private Stage stage;
    @FXML
    private TextField mandate_dec_orderid;

    private String mandateDecListNumber = null;
    @FXML
    private TextField mandate_dec_militrayid;
    @FXML
    private AnchorPane FormationPage;
    @FXML
    private TextField for_militaryid;
    @FXML
    private TextField for_unitbeforforce;
    @FXML
    private TextField for_idnumber;
    @FXML
    private ComboBox<String> for_breth_day;
    @FXML
    private ComboBox<String> for_breth_month;
    @FXML
    private ComboBox<String> for_breth_year;
    @FXML
    private ComboBox<String> for_nextpromotion_day;
    @FXML
    private ComboBox<String> for_nextpromotion_month;
    @FXML
    private ComboBox<String> for_nextpromotion_year;
    @FXML
    private ComboBox<String> for_speclaization;
    @FXML
    private ComboBox<String> for_unitinforce;
    @FXML
    private ComboBox<String> for_bloodtype;
    @FXML
    private TextField for_bankname;
    @FXML
    private TextField for_ibannumber;
    @FXML
    private TextField for_passportid;
    @FXML
    private TextField for_mobilenumber;
    @FXML
    private TextField for_mobilenumber_ofcousin;
    @FXML
    private ComboBox<String> for_militarytayp;
    @FXML
    private ComboBox<String> for_qualification;
    @FXML
    private ComboBox<String> for_rank;
    @FXML
    private ComboBox<String> for_passport_day;
    @FXML
    private ComboBox<String> for_passport_month;
    @FXML
    private ComboBox<String> for_passport_year;
    @FXML
    private ComboBox<String> for_promotion_day;
    @FXML
    private ComboBox<String> for_promotion_month;
    @FXML
    private ComboBox<String> for_promotion_year;
    @FXML
    private TextField for_name;
    @FXML
    private TextField for_birth_place;
    @FXML
    private AnchorPane Header;
    @FXML
    private Button TriningButton;
    @FXML
    private Button VacationButton;
    @FXML
    private Button TshkelButton;
    @FXML
    private Button EntedabButton;
    @FXML
    private Button ch_en_button1;
    @FXML
    private TextField ennamelist;
    @FXML
    private Button save;
    @FXML
    private Button en_updateButton;
    @FXML
    private Button en_updateButton1;
    @FXML
    private Button save1;
    @FXML
    private Button en_updateButton2;
    @FXML
    private Button en_updateButton11;
    @FXML
    private Tab add_employee;
    @FXML
    private Button en_updateButton112;
    @FXML
    private Tab inland_transport;
    @FXML
    private TextField for_intra_militaryid;
    @FXML
    private ComboBox<String> for_intra_transportday;
    @FXML
    private ComboBox<String> for_intra_transportmonth;
    @FXML
    private ComboBox<String> for_intra_transportyear;
    @FXML
    private ComboBox<String> for_intra_fromday;
    @FXML
    private ComboBox<String> for_intra_frommonth;
    @FXML
    private ComboBox<String> for_intra_fromyear;
    @FXML
    private TextField for_intra_transportid;
    @FXML
    private ComboBox<String> for_intra_newunit;
    @FXML
    private TableView<TransportDataModel> transportView;
    @FXML
    private TableColumn<?, ?> for_intra_sq_col;
    @FXML
    private TableColumn<?, ?> for_intra_militaryid_col;
    @FXML
    private TableColumn<?, ?> for_intra_rank_col;
    @FXML
    private TableColumn<?, ?> for_intra_name_col;
    @FXML
    private TableColumn<?, ?> for_intra_newunit_col;
    @FXML
    private TableColumn<?, ?> for_intra_transportid_col;
    @FXML
    private TableColumn<?, ?> for_intra_transportdate_col;
    @FXML
    private TableColumn<?, ?> for_intra_fromdate_col;
    @FXML
    private Label excludedNumber1;
    @FXML
    private Tab external_transport;
    @FXML
    private TextField for_outtra_militaryid;
    @FXML
    private ComboBox<String> for_outtra_transportday;
    @FXML
    private ComboBox<String> for_outtra_transportmonth;
    @FXML
    private ComboBox<String> for_outtra_transportyear;
    @FXML
    private ComboBox<String> for_outtra_fromday;
    @FXML
    private ComboBox<String> for_outtra_frommonth;
    @FXML
    private ComboBox<String> for_outtra_fromyear;
    @FXML
    private TextField for_outtra_transportid;
    @FXML
    private TextField for_outtra_newunit;
    @FXML
    private TableView<TransportDataModel> outTransportView;
    @FXML
    private TableColumn<?, ?> for_outtra_sq_col;
    @FXML
    private TableColumn<?, ?> for_outtra_militaryid_col;
    @FXML
    private TableColumn<?, ?> for_outtra_rank_col;
    @FXML
    private TableColumn<?, ?> for_outtra_name_col;
    @FXML
    private TableColumn<?, ?> for_outtra_newunit_col;
    @FXML
    private TableColumn<?, ?> for_outtra_transportid_col;
    @FXML
    private TableColumn<?, ?> for_outtra_transportdate_col;
    @FXML
    private TableColumn<?, ?> for_outtra_fromdate_col;
    @FXML
    private Label excludedNumber11;
    @FXML
    private Tab retirement;
    @FXML
    private Tab termination;
    @FXML
    private Tab reports;
    @FXML
    private TextField for_outtra_leavingid;
    @FXML
    private ComboBox<String> for_outtra_leavingday;
    @FXML
    private ComboBox<String> for_outtra_leavingmonth;
    @FXML
    private ComboBox<String> for_outtra_leavingyear;
    @FXML
    private ComboBox<String> for_outtra_leavingfromday;
    @FXML
    private ComboBox<String> for_outtra_leavingfrommonth;
    @FXML
    private ComboBox<String> for_outtra_leavingfromyear;
    @FXML
    private ComboBox<String> for_employment_day;
    @FXML
    private ComboBox<String> for_employment_month;
    @FXML
    private ComboBox<String> for_employment_year;
    @FXML
    private TextField for_transportid;
    @FXML
    private ComboBox<String> for_transport_day;
    @FXML
    private ComboBox<String> for_transport_month;
    @FXML
    private ComboBox<String> for_transport_year;
    @FXML
    private ComboBox<String> for_workstarting_day;
    @FXML
    private ComboBox<String> for_workstarting_month;
    @FXML
    private ComboBox<String> for_workstarting_year;
    @FXML
    private TableColumn<?, ?> for_outtra_leavingid_col;
    @FXML
    private TableColumn<?, ?> for_outtra_leavingdate_col;
    @FXML
    private TableColumn<?, ?> for_outtra_leavingfromdate_col;

    @FXML
    private void mainePageOpenAction(ActionEvent event) {
        MainPage.setVisible(true);
        EntedabPage.setVisible(false);
        FormationPage.setVisible(false);
    }

    private void tabhint(ActionEvent event) {
        final Tooltip tooltip = new Tooltip();
        tooltip.setText("hussein");
    }

    private void mainePageOpenAction() {
        MainPage.setVisible(true);
        EntedabPage.setVisible(false);
        FormationPage.setVisible(false);
    }

    @FXML
    private void entedabOpenAction(ActionEvent event) {
        MainPage.setVisible(false);
        EntedabPage.setVisible(true);
        FormationPage.setVisible(false);
    }

    @FXML
    private void tshkelOpenAction(ActionEvent event) {
        MainPage.setVisible(false);
        EntedabPage.setVisible(false);
        FormationPage.setVisible(true);
    }

    private int getDateDifference() {
        int d1 = Integer.parseInt(mandate_ch_dec_fromday.getValue());
        int m1 = Integer.parseInt(mandate_ch_dec_frommonth.getValue());
        int y1 = Integer.parseInt(mandate_ch_dec_fromyear.getValue());
        int d2 = Integer.parseInt(mandate_ch_dec_today.getValue());
        int m2 = Integer.parseInt(mandate_ch_dec_tomonth.getValue());
        int y2 = Integer.parseInt(mandate_ch_dec_toyear.getValue());

        int diffDays = d2 - d1;
        int diffMonths = m2 - m1;
        int diffYears = y2 - y1;

        LocalDate date1 = LocalDate.of(y1, m1, d1);
        LocalDate date2 = LocalDate.of(y2, m2, d2);

        int days = (int) ChronoUnit.DAYS.between(date1, date2);
        int difference = diffDays + (diffMonths * 30) + (diffYears * 360);
        return days + 1;
    }

    private void increaseBalance(String id) {
        try {
            ResultSet rs = DataMng.getDataWithCondition("mandate_balance", "`BALANCE`", "`MILITARYID` = '" + id + "'");
            int balance = 0;
            try {
                if (rs.next()) {
                    balance = rs.getInt("BALANCE");
                }
                balance = balance + getDateDifference();
                DataMng.updat("mandate_balance", "`BALANCE` = '" + balance + "'", "`MILITARYID` = '" + id + "'");

            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void insertData(ActionEvent event) {
        String fromyear = fromDateyear.getValue();
        String frommonth = fromDatemonth.getValue();
        String fromday = fromDateday.getValue();
        String toyear = toDateyear.getValue();
        String tomonth = toDatemonth.getValue();
        String today = toDateday.getValue();
        String fieldName = "`ORDERID`,`ORDERDATE`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`,`ENPLASE`,`MILITARYTAYP`,`ENTAYP`";
        String[] data = {orderid.getText(), setDate(orderdateday.getValue(), orderdatemonth.getValue(), orderdateyear.getValue()), enfrom.getText(), ento.getText(),
            setDate(fromDateday.getValue(), fromDatemonth.getValue(), fromDateyear.getValue()), setDate(toDateday.getValue(), toDatemonth.getValue(), toDateyear.getValue()),
            PlaceOfAssignment.getValue(), militarytayp.getValue(), entayp.getValue()};
        String valuenumbers = "?,?,?,?,?,?,?,?,?";
        boolean enfromstate = FormValidation.textFieldNotEmpty(enfrom, " ادخل الجهة المنتدب منها");
        boolean numberOnly = FormValidation.textFieldTypeNumber(orderid, "استخدم الارقام فقط");
        boolean orderidstate = FormValidation.textFieldNotEmpty(orderid, "  ادخل رقم الطب ارقام فقط");
        boolean entostate = FormValidation.textFieldNotEmpty(ento, " ادخل الجهة المنتدب لها");
        boolean placestate = FormValidation.comboBoxNotEmpty(PlaceOfAssignment, " اختر مكان الانتداب");
        boolean militarytaypstate = FormValidation.comboBoxNotEmpty(militarytayp, " اختر نوع المستفيد");
        boolean entaypstate = FormValidation.comboBoxNotEmpty(entayp, " اختر مكان الانتداب");
        boolean orderidUnique = FormValidation.unique("mandate", "`ORDERID`", "`ORDERID` = '" + data[0] + "'AND `ENDATEFROM`='" + data[4] + "' AND `ENDATETO` = '" + data[5] + "'", "تم ادخال الطلب مسبقا الرجاء التاجد من رقم الطلب");
        boolean toDateCheck = FormValidation.checkDate(Integer.parseInt(fromyear), Integer.parseInt(frommonth), Integer.parseInt(fromday),
                Integer.parseInt(toyear), Integer.parseInt(tomonth), Integer.parseInt(today), "تاكد من تاريخ نهاية الانتداب");

        if (numberOnly && orderidUnique && orderidstate && enfromstate && entostate && placestate && militarytaypstate && entaypstate && toDateCheck) {

            try {
                DataMng.insert("mandate", fieldName, valuenumbers, data);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshEnTable();
        }
    }

    @FXML
    private void updateData(ActionEvent event) {
        String orderdate = setDate(orderdateday.getValue(), orderdatemonth.getValue(), orderdateyear.getValue());
        String fromdate = setDate(fromDateday.getValue(), fromDatemonth.getValue(), fromDateyear.getValue());
        String todate = setDate(toDateday.getValue(), toDatemonth.getValue(), toDateyear.getValue());

        String[] data = {orderid.getText(), orderdate, enfrom.getText(), ento.getText(), fromdate, todate, PlaceOfAssignment.getValue(), militarytayp.getValue(), entayp.getValue(), ennamelist.getText()};

        String fieldNameAndValue = "`ORDERID`= ?,`ORDERDATE`=?,`ENFROM`=?,`ENTO`= ?,`ENDATEFROM`=?,`ENDATETO`=?,`ENPLASE`=?,`MILITARYTAYP`= ?,`ENTAYP`= ?,`ENNAMELISTNUMBER`=?";

        String condition = "`ORDERID` = '" + updatOrderId + "'AND `ENDATEFROM`='" + updatFromDate + "' AND `ENDATETO` = '" + updatToDate + "'";

        boolean numberOnly = FormValidation.textFieldTypeNumber(orderid, "استخدم الارقام فقط");
        boolean orderidstate = FormValidation.textFieldNotEmpty(orderid, "  ادخل رقم الطب ارقام فقط");
        boolean enfromstate = FormValidation.textFieldNotEmpty(enfrom, " ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ento, " ادخل الجهة المنتدب لها");
        boolean placestate = FormValidation.comboBoxNotEmpty(PlaceOfAssignment, " اختر مكان الانتداب");
        boolean militarytaypstate = FormValidation.comboBoxNotEmpty(militarytayp, " اختر نوع المستفيد");
        boolean entaypstate = FormValidation.comboBoxNotEmpty(entayp, " اختر مكان الانتداب");

        if (numberOnly && orderidstate && enfromstate && entostate && placestate && militarytaypstate && entaypstate) {
            try {
                DataMng.updat("mandate", fieldNameAndValue, data, condition);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshEnTable();
        }
    }

    @FXML
    private void deleteData(ActionEvent event) {
        String condition = "`ORDERID` = '" + updatOrderId + "' AND `ENDATEFROM`='" + updatFromDate + "' AND `ENDATETO` = '" + updatToDate + "'";
        try {
            DataMng.delete("mandate", condition);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshEnTable();
    }

    @FXML
    private void creatNewList(ActionEvent event) {
        try {
            ResultSet rs = DataMng.getAllData("listcounter");
            int lastNumber = 0;
            try {
                if (rs.next()) {
                    lastNumber = rs.getInt("LISTID");
                }
                String newListNumber = FormValidation.creatList(lastNumber);
                listnumber.setText(newListNumber);

                ch_mailitraynum.setDisable(false);
                ch_en_button.setDisable(false);
                ch_en_allsoldiers.setDisable(false);
                ch_en_allofficers.setDisable(false);
                DataMng.updat("`listcounter`", "`LISTID` = '" + Integer.parseInt(newListNumber) + "' ", "`LISTID`= '" + lastNumber + "'");

                String tableName = "mandatelists";
                String fieldName = "`LISTNUMBER`";
                String[] data = {newListNumber};
                String valuenumbers = "?";
                DataMng.insert(tableName, fieldName, valuenumbers, data);
                ch_comboBoxlist.clear();
                refreshListCombobox(fillListCombobox(ch_comboBoxlist));
            } catch (SQLException | IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void chackData(ActionEvent event) {
        String fromDate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
        String toDate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
        String tableName = "nameslist";
        String fieldName = "`MILITARYID`,`LISTNUMBER`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`";
        String[] data = {ch_mailitraynum.getText(), listnumber.getText(), ch_enfrom.getText(), ch_ento.getText(), fromDate, toDate};
        String[] excluded = {listnumber.getText(), ch_mailitraynum.getText()};
        String valuenumbers = "?,?,?,?,?,?";

        boolean mandateUnique = FormValidation.dateChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ?  AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean trainingUnique = FormValidation.dateChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSESTARTDATE` BETWEEN ? AND ?) OR ( `COURSENDDATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean enfromstate = FormValidation.textFieldNotEmpty(ch_enfrom, "ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ch_ento, "ادخل الجهة المنتدب اليها");
        boolean transportstet = FormValidation.transporState("formation", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `TRANSPORTSTATE`= 'true'", "لا توجد بيانات ");

        if (mandateUnique && trainingUnique) {
            if (militaryidUnique && enfromstate && entostate && transportstet) {
                try {
                    DataMng.insert(tableName, fieldName, valuenumbers, data);
                    chackTableViewData();
                    ch_mailitraynum.setText("");
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            if (exuludedUnique) {
                try {
                    DataMng.insert("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excluded);
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    private void chackData() {
        String fromDate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
        String toDate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
        String tableName = "nameslist";
        String fieldName = "`MILITARYID`,`LISTNUMBER`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`";
        String[] data = {ch_mailitraynum.getText(), listnumber.getText(), ch_enfrom.getText(), ch_ento.getText(), fromDate, toDate};
        String[] excluded = {listnumber.getText(), ch_mailitraynum.getText()};
        String valuenumbers = "?,?,?,?,?,?";

        boolean mandateUnique = FormValidation.dateChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ?  AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean trainingUnique = FormValidation.dateChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSESTARTDATE` BETWEEN ? AND ?) OR ( `COURSENDDATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean enfromstate = FormValidation.textFieldNotEmpty(ch_enfrom, "ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ch_ento, "ادخل الجهة المنتدب اليها");
        boolean transportstet = FormValidation.transporState("formation", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `TRANSPORTSTATE`= 'true'", "لا توجد بيانات ");

        if (mandateUnique && trainingUnique) {
            if (militaryidUnique && enfromstate && entostate && transportstet) {
                try {
                    DataMng.insert(tableName, fieldName, valuenumbers, data);
                    chackTableViewData();
                    ch_mailitraynum.setText("");
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            if (exuludedUnique) {
                try {
                    DataMng.insert("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excluded);
                } catch (IOException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @FXML
    private void excludedNameShow(ActionEvent event) {
        ExcludedPage.setVisible(true);
        reasonlist.clear();
        excludedTableViewData();
    }

    @FXML
    private void ex_exit(ActionEvent event) {
        ExcludedPage.setVisible(false);
        excludedtablelist.clear();
        reasonlist.clear();
    }

    @FXML
    private void showReason(MouseEvent event) {
        try {
            reasonlist.clear();
            String militryid = ex_tableview.getSelectionModel().getSelectedItem().getFo_militaryid();
            ResultSet rs = DataMng.getDataWithCondition("exclusionmessage", "REASON", "`MILITARYID` = '" + militryid + "' AND `LISTNUMBER` = '" + listnumber.getText() + "'");
            while (rs.next()) {
                reasonlist.add(rs.getString("REASON"));
            }
            ex_reasonListView.setItems(reasonlist);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showMainItems() throws IOException {
//        Stage stage = new Stage();
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.fxml"));
//        Parent root =(Parent) fxmlLoader.load();
//       
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.show();

    }

    @FXML
    private void getExcelSheet(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(stage);
            String savefile = null;
            if (file != null) {
                savefile = file.toString();
            }
            ResultSet rs = DataMng.getDataJoinTable("select nameslist.MILITARYID,nameslist.ENDATEFROM,nameslist.ENDATETO,nameslist.ENFROM,nameslist.ENTO, formation.NAME, formation.RANK from nameslist ,formation  where  nameslist.MILITARYID = formation.MILITARYID  AND nameslist.LISTNUMBER ='" + listnumber.getText() + "'");
            String[] feild = {"MILITARYID", "RANK", "NAME", "ENFROM", "ENTO", "ENDATEFROM", "ENDATETO"};
            String[] titel = {"الرقم العسكري", "الرتبة", "الاسم", "الانتداب من", "الانتداب الى", "تاريخ بداية الانتداب", "تاريخ نهاية الانتداب"};
            ExporteExcelSheet exporter = new ExporteExcelSheet(rs, feild, titel);
            ArrayList<Object[]> dataList = exporter.getTableData();
            if (dataList != null && dataList.size() > 0) {
                exporter.doExport(dataList, savefile);
            } else {
                System.out.println("There is no data available in the table to export");
            }
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void init(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void getListNames(ActionEvent event) {
        namesWithoutDcTableViewData();
        namesWithDcTableViewData();
    }

    private void getListNames() {
        namesWithoutDcTableViewData();
        namesWithDcTableViewData();
    }

    private void refreshDecTables() {
        no_declist.clear();
        declist.clear();
        namesWithoutDcTableViewData();
        namesWithDcTableViewData();
    }

    @FXML
    private void updateDecState(ActionEvent event) {
        try {
            String decDate = setDate(mandate_ch_decday.getValue(), mandate_ch_decmonth.getValue(), mandate_ch_decyear.getValue());
            String decfromDate = setDate(mandate_ch_dec_fromday.getValue(), mandate_ch_dec_frommonth.getValue(), mandate_ch_dec_fromyear.getValue());
            String dectoDate = setDate(mandate_ch_dec_today.getValue(), mandate_ch_dec_tomonth.getValue(), mandate_ch_dec_toyear.getValue());
            String[] data = {mandate_ch_decnumber.getText(), decDate, decfromDate, dectoDate, mandateDecListNumber, mandate_dec_militrayid.getText()};

            boolean militaryidNotEmpty = FormValidation.textFieldNotEmpty(mandate_dec_militrayid, "ادخل الرقم العسكري");
            boolean decNumberNotEmpty = FormValidation.textFieldNotEmpty(mandate_ch_decnumber, "ادخل رقم القرار");

            if (decNumberNotEmpty && militaryidNotEmpty && mandateDecListNumber != null) {
                DataMng.updat("nameslist", "`DICISIONNUMBER` = ? ,`DECISIONDATE` = ?,`ENDATEFROM`= ? ,`ENDATETO` = ? ,`DECISIONSTATUS` = 'true'", data, "`LISTNUMBER` =? AND `MILITARYID` = ?");
                refreshDecTables();
                increaseBalance(mandate_dec_militrayid.getText());
                mandate_dec_militrayid.setText("");
            }
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateDecState() {
        try {
            String decDate = setDate(mandate_ch_decday.getValue(), mandate_ch_decmonth.getValue(), mandate_ch_decyear.getValue());
            String decfromDate = setDate(mandate_ch_dec_fromday.getValue(), mandate_ch_dec_frommonth.getValue(), mandate_ch_dec_fromyear.getValue());
            String dectoDate = setDate(mandate_ch_dec_today.getValue(), mandate_ch_dec_tomonth.getValue(), mandate_ch_dec_toyear.getValue());
            String[] data = {mandate_ch_decnumber.getText(), decDate, decfromDate, dectoDate, mandateDecListNumber, mandate_dec_militrayid.getText()};

            boolean militaryidNotEmpty = FormValidation.textFieldNotEmpty(mandate_dec_militrayid, "ادخل الرقم العسكري");
            boolean decNumberNotEmpty = FormValidation.textFieldNotEmpty(mandate_ch_decnumber, "ادخل رقم القرار");

            if (decNumberNotEmpty && militaryidNotEmpty && mandateDecListNumber != null) {
                DataMng.updat("nameslist", "`DICISIONNUMBER` = ? ,`DECISIONDATE` = ?,`ENDATEFROM`= ? ,`ENDATETO` = ? ,`DECISIONSTATUS` = 'true'", data, "`LISTNUMBER` =? AND `MILITARYID` = ?");
                refreshDecTables();
                increaseBalance(mandate_dec_militrayid.getText());
                mandate_dec_militrayid.setText("");
            }
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void insertFormaitionData(ActionEvent event) {
        String prthDate = setDate(for_breth_day.getValue(), for_breth_month.getValue(), for_breth_year.getValue());
        String promotionDate = setDate(for_promotion_day.getValue(), for_promotion_month.getValue(), for_promotion_year.getValue());
        String nextpromotionDate = setDate(for_nextpromotion_day.getValue(), for_nextpromotion_month.getValue(), for_nextpromotion_year.getValue());
        String passportDate = setDate(for_passport_day.getValue(), for_passport_month.getValue(), for_passport_year.getValue());
        String tableName = "formation";
        String fieldName = "`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`BIRTH_DATE`,`BIRTH_PLACE`,`SPECIALIZATION`,`UNIT_IN_FORCE`,`UNIT_BEFOR_FORCE`,`BANKNAME`,`IBANNUMBER`,`BLOODTYPE`,`DATE_OF_PROMOTION`,`DATE_OF_NEXT_PROMOTION`,`PASSPORTID`,`END_DATE_OFPASSPORT`,`MOBILENUMBER`,`MOBILENUMBER_OFCOUSIN`,`QUALIFICATION`,`MILITARYTYPE`,`TRANSPORTSTATE`";
        String[] data = {for_militaryid.getText(), for_name.getText(), for_rank.getValue(), for_idnumber.getText(), prthDate, for_birth_place.getText(), for_speclaization.getValue(),
            for_unitinforce.getValue(), for_unitbeforforce.getText(), for_bankname.getText(), for_ibannumber.getText(), for_bloodtype.getValue(), promotionDate, nextpromotionDate, for_passportid.getText(),
            passportDate, for_mobilenumber.getText(), for_mobilenumber_ofcousin.getText(), for_qualification.getValue(), for_militarytayp.getValue(), "false"};
        String valuenumbers = "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

        boolean militaryidNotEmpty = FormValidation.textFieldNotEmpty(for_militaryid, "ادخل الرقم العسكري");
        boolean nameNotEmpty = FormValidation.textFieldNotEmpty(for_name, "ادخل الاسم");
        boolean rankNotEmpty = FormValidation.comboBoxNotEmpty(for_rank, "اختر الرتبة");
        boolean idNumberNotEmpty = FormValidation.textFieldNotEmpty(for_idnumber, "ادخل رقم الهوية");
        boolean unitInForceNotEmpty = FormValidation.comboBoxNotEmpty(for_unitinforce, "اختر الوحدة داخل القوة");
        boolean bankNameNotEmpty = FormValidation.textFieldNotEmpty(for_bankname, "ادخل اسم البنك");
        boolean ibanNumberNotEmpty = FormValidation.textFieldNotEmpty(for_ibannumber, "ادخل رقم الايبان");
        boolean mobileNumberNotEmpty = FormValidation.textFieldNotEmpty(for_mobilenumber, "ادخل رقم الجوال");
        boolean militaryidUnique = FormValidation.unique("formation", "`MILITARYID`", "`MILITARYID` = '" + data[0] + "'", "تم ادخال الرقم العسكري مسبقا");
        boolean idNumberUnique = FormValidation.unique("formation", "`IDNAMBER`", "`IDNAMBER` = '" + data[3] + "'", "تم ادخال رقم الهوية مسبقا");
        boolean ibanNumberUnique = FormValidation.unique("formation", "`IBANNUMBER`", "`IBANNUMBER` = '" + data[10] + "'", "تم ادخال رقم الايبان مسبقا");
        boolean mobilNumberUnique = FormValidation.unique("formation", "`MOBILENUMBER`", "`MOBILENUMBER` = '" + data[16] + "'", "تم ادخال رقم الجوال مسبقا");

        if (militaryidNotEmpty && nameNotEmpty && rankNotEmpty && idNumberNotEmpty && unitInForceNotEmpty && bankNameNotEmpty
                && ibanNumberNotEmpty && mobileNumberNotEmpty && militaryidUnique && idNumberUnique && ibanNumberUnique && mobilNumberUnique) {
            try {
                DataMng.insert(tableName, fieldName, valuenumbers, data);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void updateFormaitionData(ActionEvent event) {
        String prthDate = setDate(for_breth_day.getValue(), for_breth_month.getValue(), for_breth_year.getValue());
        String promotionDate = setDate(for_promotion_day.getValue(), for_promotion_month.getValue(), for_promotion_year.getValue());
        String nextpromotionDate = setDate(for_nextpromotion_day.getValue(), for_nextpromotion_month.getValue(), for_nextpromotion_year.getValue());
        String passportDate = setDate(for_passport_day.getValue(), for_passport_month.getValue(), for_passport_year.getValue());
        String tableName = "formation";
        String fieldName = "`MILITARYID`=?,`NAME`=?,`RANK`=?,`IDNAMBER`=?,`BIRTH_DATE`=?,`BIRTH_PLACE`=?,`SPECIALIZATION`=?,"
                + "`UNIT_IN_FORCE`=?,`UNIT_BEFOR_FORCE`=?,`BANKNAME`=?,`IBANNUMBER`=?,`BLOODTYPE`=?,`DATE_OF_PROMOTION`=?,`DATE_OF_NEXT_PROMOTION`=?,"
                + "`PASSPORTID`=?,`END_DATE_OFPASSPORT`=?,`MOBILENUMBER`=?,`MOBILENUMBER_OFCOUSIN`=?,`QUALIFICATION`=?,`MILITARYTYPE`=?";
        String[] data = {for_militaryid.getText(), for_name.getText(), for_rank.getValue(), for_idnumber.getText(), prthDate, for_birth_place.getText(), for_speclaization.getValue(),
            for_unitinforce.getValue(), for_unitbeforforce.getText(), for_bankname.getText(), for_ibannumber.getText(), for_bloodtype.getValue(), promotionDate, nextpromotionDate, for_passportid.getText(),
            passportDate, for_mobilenumber.getText(), for_mobilenumber_ofcousin.getText(), for_qualification.getValue(), for_militarytayp.getValue()};

        boolean nameNotEmpty = FormValidation.textFieldNotEmpty(for_name, "ادخل الاسم");
        boolean rankNotEmpty = FormValidation.comboBoxNotEmpty(for_rank, "اختر الرتبة");
        boolean unitInForceNotEmpty = FormValidation.comboBoxNotEmpty(for_unitinforce, "اختر الوحدة داخل القوة");
        boolean speclaizationNotEmpty = FormValidation.comboBoxNotEmpty(for_speclaization, "اختر التخصص");
        boolean bankNameNotEmpty = FormValidation.textFieldNotEmpty(for_bankname, "ادخل اسم البنك");
        boolean ibanNumberNotEmpty = FormValidation.textFieldNotEmpty(for_ibannumber, "ادخل رقم الايبان");
        boolean mobileNumberNotEmpty = FormValidation.textFieldNotEmpty(for_mobilenumber, "ادخل رقم الجوال");

        if (nameNotEmpty && rankNotEmpty && unitInForceNotEmpty && speclaizationNotEmpty && bankNameNotEmpty && ibanNumberNotEmpty && mobileNumberNotEmpty) {
            try {
                DataMng.updat(tableName, fieldName, data, "`MILITARYID` ='" + data[0] + "'");
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void deleteFormaitionData(ActionEvent event) {
        try {
            DataMng.delete("formation", "`MILITARYID` ='" + for_militaryid.getText() + "'");
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getFormaitionDatabyMilitryid() {
        try {
            String tableName = "formation";
            String fieldName = "`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`EMPLOYMENTDATE`,`BIRTH_DATE`,`BIRTH_PLACE`,`SPECIALIZATION`,`UNIT_IN_FORCE`,`UNIT_BEFOR_FORCE`,`BANKNAME`,`IBANNUMBER`,`BLOODTYPE`,`DATE_OF_PROMOTION`,`DATE_OF_NEXT_PROMOTION`,`PASSPORTID`,`END_DATE_OFPASSPORT`,`MOBILENUMBER`,`MOBILENUMBER_OFCOUSIN`,`QUALIFICATION`,`MILITARYTYPE`,`TRANSPORTID`,`TRANSPORTDATE`,`WORKSTARTINGDATE`";
            ResultSet rs = DataMng.getDataWithCondition(tableName, fieldName, "`MILITARYID` = '" + for_militaryid.getText() + "'");
            if (rs.next()) {
                for_name.setText(rs.getString("NAME"));
                for_rank.setValue(rs.getString("RANK"));
                for_idnumber.setText(rs.getString("IDNAMBER"));
                for_employment_day.setValue(getDay(rs.getString("EMPLOYMENTDATE")));
                for_employment_month.setValue(getMonth(rs.getString("EMPLOYMENTDATE")));
                for_employment_year.setValue(getYear(rs.getString("EMPLOYMENTDATE")));
                for_breth_day.setValue(getDay(rs.getString("BIRTH_DATE")));
                for_breth_month.setValue(getMonth(rs.getString("BIRTH_DATE")));
                for_breth_year.setValue(getYear(rs.getString("BIRTH_DATE")));
                for_birth_place.setText(rs.getString("BIRTH_PLACE"));
                for_speclaization.setValue(rs.getString("SPECIALIZATION"));
                for_unitinforce.setValue(rs.getString("UNIT_IN_FORCE"));
                for_unitbeforforce.setText(rs.getString("UNIT_BEFOR_FORCE"));
                for_bankname.setText(rs.getString("BANKNAME"));
                for_ibannumber.setText(rs.getString("IBANNUMBER"));
                for_bloodtype.setValue(rs.getString("BLOODTYPE"));
                for_promotion_day.setValue(getDay(rs.getString("DATE_OF_PROMOTION")));
                for_promotion_month.setValue(getMonth(rs.getString("DATE_OF_PROMOTION")));
                for_promotion_year.setValue(getYear(rs.getString("DATE_OF_PROMOTION")));
                for_nextpromotion_day.setValue(getDay(rs.getString("DATE_OF_NEXT_PROMOTION")));
                for_nextpromotion_month.setValue(getMonth(rs.getString("DATE_OF_NEXT_PROMOTION")));
                for_nextpromotion_year.setValue(getYear(rs.getString("DATE_OF_NEXT_PROMOTION")));
                for_passportid.setText(rs.getString("PASSPORTID"));
                for_passport_day.setValue(getDay(rs.getString("END_DATE_OFPASSPORT")));
                for_passport_month.setValue(getMonth(rs.getString("END_DATE_OFPASSPORT")));
                for_passport_year.setValue(getYear(rs.getString("END_DATE_OFPASSPORT")));
                for_mobilenumber.setText(rs.getString("MOBILENUMBER"));
                for_mobilenumber_ofcousin.setText(rs.getString("MOBILENUMBER_OFCOUSIN"));
                for_qualification.setValue(rs.getString("QUALIFICATION"));
                for_militarytayp.setValue(rs.getString("MILITARYTYPE"));
                for_transportid.setText(rs.getString("TRANSPORTID"));
                for_transport_day.setValue(getDay(rs.getString("TRANSPORTDATE")));
                for_transport_month.setValue(getMonth(rs.getString("TRANSPORTDATE")));
                for_transport_year.setValue(getYear(rs.getString("TRANSPORTDATE")));
                for_workstarting_day.setValue(getDay(rs.getString("WORKSTARTINGDATE")));
                for_workstarting_month.setValue(getMonth(rs.getString("WORKSTARTINGDATE")));
                for_workstarting_year.setValue(getYear(rs.getString("WORKSTARTINGDATE")));
            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clearFiled(ActionEvent event) {
        for_militaryid.setText("");
        for_name.setText("");
        for_rank.setValue("");
        for_idnumber.setText("");
        for_breth_day.setValue("");
        for_breth_month.setValue("");
        for_breth_year.setValue("");
        for_birth_place.setText("");
        for_speclaization.setValue("");
        for_unitinforce.setValue("");
        for_unitbeforforce.setText("");
        for_bankname.setText("");
        for_ibannumber.setText("");
        for_bloodtype.setValue("");
        for_promotion_day.setValue("");
        for_promotion_month.setValue("");
        for_promotion_year.setValue("");
        for_nextpromotion_day.setValue("");
        for_nextpromotion_month.setValue("");
        for_nextpromotion_year.setValue("");
        for_passportid.setText("");
        for_passport_day.setValue("");
        for_passport_month.setValue("");
        for_passport_year.setValue("");
        for_mobilenumber.setText("");
        for_mobilenumber_ofcousin.setText("");
        for_qualification.setValue("");
        for_militarytayp.setValue("");
    }

    private void refreshInTransportTables() {
        forTransportlist.clear();
        forInTransporTableViewAll();
    }

    @FXML
    private void addTransport(ActionEvent event) {
        String transportDate = setDate(for_intra_transportday.getValue(), for_intra_transportmonth.getValue(), for_intra_transportyear.getValue());
        String transportFromDate = setDate(for_intra_fromday.getValue(), for_intra_frommonth.getValue(), for_intra_fromyear.getValue());

        String tableName = "transport";
        String fieldName = "`MILITARYID`,`NEWUNIT`,`TRANSPORTID`,`TRANSPORTDATE`,`TRANSPORTFROMDATE`,`TRANSPORTTYPE`";
        String[] data = {for_intra_militaryid.getText(), for_intra_newunit.getValue(), for_intra_transportid.getText(), transportDate, transportFromDate, "داخلي"};
        String valuenumbers = "?,?,?,?,?,?";

        boolean militaryid = FormValidation.textFieldNotEmpty(for_intra_militaryid, "ادخل الرقم العسكري");
        boolean transportId = FormValidation.textFieldNotEmpty(for_intra_transportid, "ادخل رقم القرار");
        boolean nuwUnit = FormValidation.comboBoxNotEmpty(for_intra_newunit, "اختر الوحدة");

        if (militaryid && transportId && nuwUnit) {
            try {
                DataMng.insert(tableName, fieldName, valuenumbers, data);
                DataMng.updat("formation", "`UNIT_IN_FORCE`='" + data[1] + "'", "`MILITARYID`='" + data[0] + "'");
                refreshInTransportTables();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void updateTransport(ActionEvent event) {
        String transportDate = setDate(for_intra_transportday.getValue(), for_intra_transportmonth.getValue(), for_intra_transportyear.getValue());
        String transportFromDate = setDate(for_intra_fromday.getValue(), for_intra_frommonth.getValue(), for_intra_fromyear.getValue());

        String tableName = "transport";
        String fieldName = "`MILITARYID`=?,`NEWUNIT`=?,`TRANSPORTID`=?,`TRANSPORTDATE`=?,`TRANSPORTFROMDATE`=?,`TRANSPORTTYPE`=?";
        String[] data = {for_intra_militaryid.getText(), for_intra_newunit.getValue(), for_intra_transportid.getText(), transportDate, transportFromDate, "داخلي"};

        boolean militaryid = FormValidation.textFieldNotEmpty(for_intra_militaryid, "ادخل الرقم العسكري");
        boolean transportId = FormValidation.textFieldNotEmpty(for_intra_transportid, "ادخل رقم القرار");
        boolean nuwUnit = FormValidation.comboBoxNotEmpty(for_intra_newunit, "اختر الوحدة");

        if (militaryid && transportId && nuwUnit) {
            try {
                DataMng.updat(tableName, fieldName, data, "`MILITARYID`='" + inTransPortMilitaryid + "' AND `TRANSPORTID`= '" + inTransPortId + "'");
                DataMng.updat("formation", "`UNIT_IN_FORCE`='" + data[1] + "'", "`MILITARYID`='" + data[0] + "'");
                refreshInTransportTables();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void deleteTransport(ActionEvent event) {
        try {
            String condition = "`MILITARYID`='" + inTransPortMilitaryid + "' AND `TRANSPORTID`= '" + inTransPortId + "'";
            DataMng.delete("transport", condition);
            refreshInTransportTables();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshOutTransportTables() {
        forTransportlist.clear();
        forOutTransporTableViewAll();
    }

    @FXML
    private void addOutTransport(ActionEvent event) {

        String transportDate = setDate(for_outtra_transportday.getValue(), for_outtra_transportmonth.getValue(), for_outtra_transportyear.getValue());
        String transportFromDate = setDate(for_outtra_fromday.getValue(), for_outtra_frommonth.getValue(), for_outtra_fromyear.getValue());
        String leavingDate = setDate(for_outtra_leavingday.getValue(), for_outtra_leavingmonth.getValue(), for_outtra_leavingyear.getValue());
        String leavingFromDate = setDate(for_outtra_leavingfromday.getValue(), for_outtra_leavingfrommonth.getValue(), for_outtra_leavingfromyear.getValue());

        String tableName = "transport";
        String fieldName = "`MILITARYID`,`NEWUNIT`,`TRANSPORTID`,`TRANSPORTDATE`,`TRANSPORTFROMDATE`,`TRANSPORTTYPE`,`LEAVINGID`,`LEAVINGDATE`,`LEAVINGFROMDATE`";
        String[] data = {for_outtra_militaryid.getText(), for_outtra_newunit.getText(), for_outtra_transportid.getText(), transportDate, transportFromDate, "خارجي", for_outtra_leavingid.getText(), leavingDate, leavingFromDate};
        String valuenumbers = "?,?,?,?,?,?,?,?,?";

        boolean militaryid = FormValidation.textFieldNotEmpty(for_outtra_militaryid, "ادخل الرقم العسكري");
        boolean transportId = FormValidation.textFieldNotEmpty(for_outtra_transportid, "ادخل رقم القرار");
        boolean nuwUnit = FormValidation.textFieldNotEmpty(for_outtra_newunit, "ادخل الوحدة");

        if (militaryid && transportId && nuwUnit) {
            try {
                DataMng.insert(tableName, fieldName, valuenumbers, data);
                DataMng.updat("formation", "`TRANSPORTSTATE`='true'", "`MILITARYID` = '" + data[0] + "'");
                refreshOutTransportTables();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void updateOutTransport(ActionEvent event) {
        String transportDate = setDate(for_outtra_transportday.getValue(), for_outtra_transportmonth.getValue(), for_outtra_transportyear.getValue());
        String transportFromDate = setDate(for_outtra_fromday.getValue(), for_outtra_frommonth.getValue(), for_outtra_fromyear.getValue());
        String leavingDate = setDate(for_outtra_leavingday.getValue(), for_outtra_leavingmonth.getValue(), for_outtra_leavingyear.getValue());
        String leavingFromDate = setDate(for_outtra_leavingfromday.getValue(), for_outtra_leavingfrommonth.getValue(), for_outtra_leavingfromyear.getValue());

        String tableName = "transport";
        String fieldName = "`MILITARYID`=?,`NEWUNIT`=?,`TRANSPORTID`=?,`TRANSPORTDATE`=?,`TRANSPORTFROMDATE`=?,`TRANSPORTTYPE`=?,`LEAVINGID`=?,`LEAVINGDATE`=?,`LEAVINGFROMDATE`=?";
        String[] data = {for_outtra_militaryid.getText(), for_outtra_newunit.getText(), for_outtra_transportid.getText(), transportDate, transportFromDate, "خارجي", for_outtra_leavingid.getText(), leavingDate, leavingFromDate};
        String condition = "`MILITARYID`='" + outTransPortMilitaryid + "' AND `TRANSPORTID`= '" + outTransPortId + "'";

        boolean militaryid = FormValidation.textFieldNotEmpty(for_outtra_militaryid, "ادخل الرقم العسكري");
        boolean transportId = FormValidation.textFieldNotEmpty(for_outtra_transportid, "ادخل رقم القرار");
        boolean nuwUnit = FormValidation.textFieldNotEmpty(for_outtra_newunit, "ادخل الوحدة");

        if (militaryid && transportId && nuwUnit) {
            try {
                DataMng.updat(tableName, fieldName, data, condition);
                refreshOutTransportTables();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void deleteOutTransport(ActionEvent event) {
        try {
            String condition = "`MILITARYID`='" + outTransPortMilitaryid + "' AND `TRANSPORTID`= '" + outTransPortId + "'";
            DataMng.delete("transport", condition);
            refreshOutTransportTables();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkAllData(String militaryType) {
        String fromDate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
        String toDate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
        String tableName = "nameslist";
        String fieldName = "`MILITARYID`,`LISTNUMBER`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`";
        String valuenumbers = "?,?,?,?,?,?";

        ObservableList<CheckAllDataModel> lodedData = FXCollections.observableArrayList();
        ObservableList<CheckAllDataModel> passData = FXCollections.observableArrayList();
        ObservableList<CheckAllDataModel> excludData = FXCollections.observableArrayList();

        try {
            ResultSet rs = DataMng.getAllQuiry("SELECT `MILITARYID`,`RANK`,`NAME` FROM formation WHERE `MILITARYTYPE` = '" + militaryType + "' AND `TRANSPORTSTATE` = 'false'");
            while (rs.next()) {
                lodedData.add(new CheckAllDataModel(rs.getString("MILITARYID"), rs.getString("RANK"), rs.getString("NAME")));
            }
            for (int i = 0; i < lodedData.size(); i++) {
                boolean mandateUnique = FormValidation.dateAllChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ? AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", lodedData.get(i).getMilitaryId(), listnumber.getText(), fromDate, toDate);
                boolean trainingUnique = FormValidation.dateAllChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSESTARTDATE` BETWEEN ? AND ?) OR ( `COURSENDDATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", lodedData.get(i).getMilitaryId(), listnumber.getText(), fromDate, toDate);
                if (trainingUnique && mandateUnique) {
                    passData.add(new CheckAllDataModel(
                            lodedData.get(i).getMilitaryId(),
                            listnumber.getText(),
                            ch_enfrom.getText(),
                            ch_ento.getText(),
                            fromDate,
                            toDate
                    ));
                    chacktablelist.add(new NamesDataModel(
                            lodedData.get(i).getMilitaryId(),
                            lodedData.get(i).getRank(),
                            lodedData.get(i).getName(),
                            ch_enfrom.getText(),
                            ch_ento.getText(),
                            fromDate,
                            toDate,
                            i + 1
                    ));
                    for (int j = 0; j < passData.size(); j++) {
                        boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + passData.get(j).getMilitaryId() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
                        if (militaryidUnique) {
                            DataMng.insertPassData(tableName, fieldName, valuenumbers, passData, j);
                            ch_mailitraynum_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
                            ch_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
                            ch_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
                            ch_en_from_col.setCellValueFactory(new PropertyValueFactory<>("enfrom"));
                            ch_en_to_col.setCellValueFactory(new PropertyValueFactory<>("ento"));
                            ch_en_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("enfromdate"));
                            ch_en_todate_col.setCellValueFactory(new PropertyValueFactory<>("entodate"));
                            en_ch_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

                            chacktable.setItems(chacktablelist);
                        }
                    }
                } else {
                    excludData.add(new CheckAllDataModel(
                            listnumber.getText(),
                            lodedData.get(i).getMilitaryId()
                    ));
                    for (int j = 0; j < excludData.size(); j++) {
                        boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + excludData.get(j).getMilitaryId() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
                        if (exuludedUnique) {
                            DataMng.insertExcludedData("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excludData, j);
                        }
                    }
                }
            }

        } catch (IOException | SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public class ChackAll extends Thread {

        String militaryType;

        public ChackAll(String militaryType) {
            this.militaryType = militaryType;
        }

        @Override
        public void run() {
            checkAllData(militaryType);
//            String fromDate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
//            String toDate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
//            String tableName = "nameslist";
//            String fieldName = "`MILITARYID`,`LISTNUMBER`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`";
//            String valuenumbers = "?,?,?,?,?,?";
//            String[] data = new String[6];
//            String[] excluded = new String[2];
//
//            try {
//                ResultSet rs = DataMng.getAllQuiry("SELECT MILITARYID,NAME FROM formation WHERE MILITARYTYPE = '" + militaryType + "' AND TRANSPORTSTATE = 'false'");
//                while (rs.next()) {
//                    boolean mandateUnique = FormValidation.dateAllChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ? AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", rs.getString("MILITARYID"), listnumber.getText(), fromDate, toDate);
//                    boolean trainingUnique = FormValidation.dateAllChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSESTARTDATE` BETWEEN ? AND ?) OR ( `COURSENDDATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", rs.getString("MILITARYID"), listnumber.getText(), fromDate, toDate);
//                    boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + rs.getString("MILITARYID") + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
//                    boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + rs.getString("MILITARYID") + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
//
//                    data[0] = rs.getString("MILITARYID");
//                    data[1] = listnumber.getText();
//                    data[2] = ch_enfrom.getText();
//                    data[3] = ch_ento.getText();
//                    data[4] = fromDate;
//                    data[5] = toDate;
//
//                    excluded[0] = listnumber.getText();
//                    excluded[1] = rs.getString("MILITARYID");
//
//                    if (mandateUnique && trainingUnique) {
//                        if (militaryidUnique) {
//                            DataMng.insert(tableName, fieldName, valuenumbers, data);
//                        }
//                    } else {
//                        if (exuludedUnique) {
//                            DataMng.insert("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excluded);
//                        }
//                    }
//                    Thread.sleep(1000);
//                    refreshChacktable();
//
//                }
//
//            } catch (IOException | SQLException | InterruptedException ex) {
//                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    public int getExcludededSum(String listnumber) {
        int total = 0;
        try {
            ResultSet rs = DataMng.getAllQuiry("SELECT COUNT(MILITARYID) AS TotalExcluded FROM excluded WHERE LISTNUMBER='" + listnumber + "'");
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("TotalExcluded"));

            }
        } catch (IOException | SQLException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    @FXML
    private void chackAllOfficers(ActionEvent event) {
        boolean enfromstate = FormValidation.textFieldNotEmpty(ch_enfrom, "ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ch_ento, "ادخل الجهة المنتدب اليها");
        if (enfromstate && entostate) {
            ChackAll task = new ChackAll("ضابط");
            task.start();

        }

    }

    @FXML
    private void chackAllSoldiers(ActionEvent event) {
        boolean enfromstate = FormValidation.textFieldNotEmpty(ch_enfrom, "ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ch_ento, "ادخل الجهة المنتدب اليها");
        if (enfromstate && entostate) {
            ChackAll task = new ChackAll("فرد");
            task.start();

        }
    }

    @FXML
    private void deleteFromNamelist(ActionEvent event) {
        try {
            String condition = "`MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `LISTNUMBER`='" + listnumber.getText() + "'";
            DataMng.delete("nameslist", condition);
            refreshEnChackTable();
            chackTableListView(listnumber.getText());

        } catch (IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateListName(ActionEvent event
    ) {
        try {
            ResultSet rs = DataMng.getAllQuiry("SELECT MILITARYID FROM nameslist where `LISTNUMBER`='" + listnumber.getText() + "'");
            String fromdate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
            String todate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
            String[] data = {ch_enfrom.getText(), ch_ento.getText(), fromdate, todate};
            List millest = new ArrayList();

            try {
                while (rs.next()) {
                    millest.add(rs.getString("MILITARYID"));

                }
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            String militeryid = null;
            for (int i = 0; i < millest.size(); i++) {
                militeryid = millest.get(i).toString();
                //Validation
                boolean orderidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + millest.get(i) + "' AND `ENDATEFROM` >='" + fromdate + "' AND `ENDATETO` <= '" + todate + "'", "لديه انتداب خلال فترة الانتداب الحالية");;

                Task<Parent> yourTaskName = new Task<Parent>() {
                    @Override
                    public Parent call() {
                        if (orderidUnique) {
                            try {
                                DataMng.updat("nameslist", "`ENFROM`=?,`ENTO`=?,`ENDATEFROM`=?,`ENDATETO`=?", data, "`LISTNUMBER`='" + listnumber.getText() + "' AND `MILITARYID` = '" + listnumber.getText() + "'");

                            } catch (IOException ex) {
                                Logger.getLogger(MainController.class
                                        .getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        return null;
                    }
                };
                Thread loadingThread = new Thread(yourTaskName);
                loadingThread.start();
            }

            refreshEnChackTable();
            chackTableListView(listnumber.getText());

        } catch (IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteListName(ActionEvent event) {
        try {
            DataMng.delete("DELETE `nameslist`, `mandatelists` FROM `nameslist` inner join  `mandatelists` on `nameslist`.`LISTNUMBER` = `mandatelists`.`LISTNUMBER` WHERE `nameslist`.`LISTNUMBER` = '" + listnumber.getText() + "'AND mandatelists.LISTNUMBER='" + listnumber.getText() + "'");
            refreshEnChackTable();
            ch_comboBoxlist.clear();
            refreshListCombobox(fillListCombobox(ch_comboBoxlist));
            chackTableListView(listnumber.getText());

        } catch (IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String setDate(String day, String month, String year) {
        String date = year + "-" + month + "-" + day;
        return date;
    }

    private void refreshEnTable() {
        tablelist.clear();
        enTableViewData();
    }

    private void refreshEnChackTable() {
        chacktablelist.clear();
    }

    private void refreshChacktable() {
        chacktablelist.clear();
        chackTableViewAll();

//        excludedNumber.setText(s);
    }

    private void chackTableViewData() {
        try {
            ResultSet rs = DataMng.getDataWithCondition("formation", "`RANK`,`NAME`", "`MILITARYID` = '" + ch_mailitraynum.getText() + "'");
            ResultSet rss = DataMng.getDataWithCondition("nameslist", "`MILITARYID`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`", "`MILITARYID` = '" + ch_mailitraynum.getText() + "'AND `LISTNUMBER` = '" + listnumber.getText() + "'");
            int sq = 0;
            while (rs.next() && rss.next()) {
                sq++;
                chacktablelist.add(new NamesDataModel(
                        rss.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rss.getString("ENFROM"),
                        rss.getString("ENTO"),
                        rss.getDate("ENDATEFROM").toString(),
                        rss.getDate("ENDATETO").toString(),
                        sq
                ));
            }
            rs.close();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ch_mailitraynum_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
        ch_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        ch_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        ch_en_from_col.setCellValueFactory(new PropertyValueFactory<>("enfrom"));
        ch_en_to_col.setCellValueFactory(new PropertyValueFactory<>("ento"));
        ch_en_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("enfromdate"));
        ch_en_todate_col.setCellValueFactory(new PropertyValueFactory<>("entodate"));
        en_ch_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        chacktable.setItems(chacktablelist);
    }

    private void excludedTableViewData() {
        try {
            ResultSet rs = DataMng.getDataJoinTable("select excluded.MILITARYID , formation.NAME, formation.RANK from excluded ,formation  "
                    + "where  excluded.MILITARYID = formation.MILITARYID  AND excluded.LISTNUMBER ='" + listnumber.getText() + "'");
            int sq = 0;
            while (rs.next()) {
                sq++;
                excludedtablelist.add(new NamesDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        sq
                ));
            }
            rs.close();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ex_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
        ex_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        ex_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        ex_sequence_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        ex_tableview.setItems(excludedtablelist);
    }

    private void namesWithoutDcTableViewData() {
        try {
            ResultSet rs = DataMng.getDataJoinTable("SELECT formation.MILITARYID,formation.RANK,formation.NAME,nameslist.LISTNUMBER FROM mandate,nameslist,formation WHERE  mandate.ENNAMELISTNUMBER = nameslist.LISTNUMBER AND nameslist.MILITARYID = formation.MILITARYID AND mandate.ORDERID = '" + mandate_dec_orderid.getText() + "'AND nameslist.DECISIONSTATUS='false'");
            int sq = 0;
            while (rs.next()) {
                sq++;
                no_declist.add(new NamesDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        sq
                ));
            }

            rs.close();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        no_dec_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
        no_dec_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        no_dec_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        no_dec_sequence_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        no_dec_table.setItems(no_declist);
    }

    private void namesWithDcTableViewData() {
        try {
            ResultSet rs = DataMng.getDataJoinTable("SELECT formation.MILITARYID,formation.RANK,formation.NAME,nameslist.LISTNUMBER FROM mandate,nameslist,formation WHERE  mandate.ENNAMELISTNUMBER = nameslist.LISTNUMBER AND nameslist.MILITARYID = formation.MILITARYID AND mandate.ORDERID = '" + mandate_dec_orderid.getText() + "'AND nameslist.DECISIONSTATUS='true'");
            int sq = 0;
            while (rs.next()) {
                sq++;
                declist.add(new NamesDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        sq
                ));
                mandateDecListNumber = rs.getString("LISTNUMBER");
            }
            rs.close();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        dec_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
        dec_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        dec_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        dec_sequence_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        dec_table.setItems(declist);
    }

    private void chackTableViewAll() {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select nameslist.MILITARYID,nameslist.ENDATEFROM,nameslist.ENDATETO,nameslist.ENFROM,nameslist.ENTO, formation.NAME, formation.RANK from nameslist ,formation  where  nameslist.MILITARYID = formation.MILITARYID  AND nameslist.LISTNUMBER ='" + listnumber.getText() + "'");
            while (rs.next()) {
                sq++;
                chacktablelist.add(new NamesDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("ENFROM"),
                        rs.getString("ENTO"),
                        rs.getDate("ENDATEFROM").toString(),
                        rs.getDate("ENDATETO").toString(),
                        sq
                ));
            }
            rs.close();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        ch_mailitraynum_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
        ch_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        ch_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        ch_en_from_col.setCellValueFactory(new PropertyValueFactory<>("enfrom"));
        ch_en_to_col.setCellValueFactory(new PropertyValueFactory<>("ento"));
        ch_en_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("enfromdate"));
        ch_en_todate_col.setCellValueFactory(new PropertyValueFactory<>("entodate"));
        en_ch_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        chacktable.setItems(chacktablelist);
    }

    private void forInTransporTableViewAll() {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select transport.MILITARYID ,transport.NEWUNIT,transport.TRANSPORTID,transport.TRANSPORTDATE,transport.TRANSPORTFROMDATE, formation.NAME, formation.RANK from transport ,formation  where  transport.MILITARYID = formation.MILITARYID  AND transport.TRANSPORTTYPE ='داخلي'");
            while (rs.next()) {
                sq++;
                forTransportlist.add(new TransportDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("NEWUNIT"),
                        rs.getString("TRANSPORTID"),
                        rs.getDate("TRANSPORTDATE").toString(),
                        rs.getDate("TRANSPORTFROMDATE").toString(),
                        sq
                ));
            }
            rs.close();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        for_intra_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("militaryid"));
        for_intra_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        for_intra_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        for_intra_newunit_col.setCellValueFactory(new PropertyValueFactory<>("newunit"));
        for_intra_transportid_col.setCellValueFactory(new PropertyValueFactory<>("transportid"));
        for_intra_transportdate_col.setCellValueFactory(new PropertyValueFactory<>("transportdate"));
        for_intra_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("fromdate"));
        for_intra_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        transportView.setItems(forTransportlist);
    }

    private void forOutTransporTableViewAll() {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select transport.MILITARYID ,transport.NEWUNIT,transport.TRANSPORTID,transport.TRANSPORTDATE,transport.TRANSPORTFROMDATE,transport.LEAVINGID,transport.LEAVINGDATE,transport.LEAVINGFROMDATE, formation.NAME, formation.RANK from transport ,formation  where  transport.MILITARYID = formation.MILITARYID  AND transport.TRANSPORTTYPE ='خارجي'");
            while (rs.next()) {
                sq++;
                forTransportlist.add(new TransportDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("NEWUNIT"),
                        rs.getString("TRANSPORTID"),
                        rs.getDate("TRANSPORTDATE").toString(),
                        rs.getDate("TRANSPORTFROMDATE").toString(),
                        rs.getString("LEAVINGID"),
                        rs.getDate("LEAVINGDATE").toString(),
                        rs.getDate("LEAVINGFROMDATE").toString(),
                        sq
                ));
            }
            rs.close();

        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        for_outtra_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("militaryid"));
        for_outtra_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        for_outtra_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        for_outtra_newunit_col.setCellValueFactory(new PropertyValueFactory<>("newunit"));
        for_outtra_transportid_col.setCellValueFactory(new PropertyValueFactory<>("transportid"));
        for_outtra_transportdate_col.setCellValueFactory(new PropertyValueFactory<>("transportdate"));
        for_outtra_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("fromdate"));
        for_outtra_leavingid_col.setCellValueFactory(new PropertyValueFactory<>("leavingid"));
        for_outtra_leavingdate_col.setCellValueFactory(new PropertyValueFactory<>("leavingdate"));
        for_outtra_leavingfromdate_col.setCellValueFactory(new PropertyValueFactory<>("leavingfromdate"));
        for_outtra_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        outTransportView.setItems(forTransportlist);
    }

    private void chackTableListView(String listnum) {
        try {
            ResultSet rs = DataMng.getDataJoinTable("select nameslist.MILITARYID,nameslist.ENDATEFROM,nameslist.ENDATETO,nameslist.ENFROM,nameslist.ENTO, formation.NAME, formation.RANK from nameslist ,formation  where  nameslist.MILITARYID = formation.MILITARYID  AND nameslist.LISTNUMBER ='" + listnum + "'");
            int sq = 0;
            try {
                while (rs.next()) {
                    sq++;
                    chacktablelist.add(new NamesDataModel(
                            rs.getString("MILITARYID"),
                            rs.getString("RANK"),
                            rs.getString("NAME"),
                            rs.getString("ENFROM"),
                            rs.getString("ENTO"),
                            rs.getDate("ENDATEFROM").toString(),
                            rs.getDate("ENDATETO").toString(),
                            sq
                    ));
                    listnumber.setText(ch_list_combobox.getValue());
                    ch_mailitraynum.setDisable(false);
                    ch_en_button.setDisable(false);
                    ch_en_allsoldiers.setDisable(false);
                    ch_en_allofficers.setDisable(false);
                }
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(MainController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            ch_mailitraynum_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
            ch_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
            ch_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
            ch_en_from_col.setCellValueFactory(new PropertyValueFactory<>("enfrom"));
            ch_en_to_col.setCellValueFactory(new PropertyValueFactory<>("ento"));
            ch_en_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("enfromdate"));
            ch_en_todate_col.setCellValueFactory(new PropertyValueFactory<>("entodate"));
            en_ch_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

            chacktable.setItems(chacktablelist);

        } catch (IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void enTableViewData() {
        try {
            ResultSet rs = DataMng.getAllData("mandate");
            int sq = 0;
            try {
                while (rs.next()) {
                    sq++;
                    tablelist.add(new EnDataModel(
                            rs.getString("ORDERID"),
                            rs.getString("ORDERDATE"),
                            rs.getString("ENFROM"),
                            rs.getString("ENTO"),
                            rs.getString("ENDATEFROM"),
                            rs.getString("ENDATETO"),
                            rs.getString("ENPLASE"),
                            rs.getString("MILITARYTAYP"),
                            rs.getString("ENTAYP"),
                            rs.getString("ENNAMELISTNUMBER"),
                            sq
                    ));
                }
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(MainController.class
                        .getName()).log(Level.SEVERE, null, ex);
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
            en_listnumber_col.setCellValueFactory(new PropertyValueFactory<>("listNumber"));
            en_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

            en_table.setItems(tablelist);

        } catch (IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getDay(String date) {
        String day = null;
        if (date != null) {
            String[] parts = date.split("-");
            day = parts[2];
        }
        return day;
    }

    private String getMonth(String date) {
        String month = null;
        if (date != null) {
            String[] parts = date.split("-");
            month = parts[1];
        }
        return month;
    }

    private String getYear(String date) {
        String year = null;
        if (date != null) {
            String[] parts = date.split("-");
            year = parts[0];
        }
        return year;
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
        for (int i = 1390; i <= 1480; i++) {
            yarelist.add(Integer.toString(i));
        }
        return yarelist;
    }

    private ObservableList fillListCombobox(ObservableList list) {
        try {
            ResultSet rs = DataMng.getAllData("mandatelists");
            try {
                while (rs.next()) {
                    list.add(rs.getString("LISTNUMBER"));
                }
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(MainController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private ObservableList setSpecializListCombobox(ObservableList list) {
        try {
            ResultSet rs = DataMng.getAllData("specialization");
            try {
                while (rs.next()) {
                    list.add(rs.getString("SPECIALIZ_NAME"));
                }
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(MainController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private ObservableList setUnitListCombobox(ObservableList list) {
        try {
            ResultSet rs = DataMng.getAllData("unitname");
            try {
                while (rs.next()) {
                    list.add(rs.getString("UNIT_NAME"));
                }
                rs.close();

            } catch (SQLException ex) {
                Logger.getLogger(MainController.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private void refreshListCombobox(ObservableList list) {
        ch_list_combobox.setItems(list);
    }

    private void dateOfCombobox(ComboBox com, ObservableList list, String typ) {
        com.setItems(list);
        switch (typ) {
            case "day":
                com.setValue(Integer.toString(HijriCalendar.getSimpleDay()));
                break;
            case "month":
                com.setValue(Integer.toString(HijriCalendar.getSimpleMonth()));
                break;
            case "year":
                com.setValue(Integer.toString(HijriCalendar.getSimpleYear()));
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PlaceOfAssignment.setItems(list1);
        militarytayp.setItems(list2);
        entayp.setItems(list3);

        dateOfCombobox(orderdateday, fillDays(daylist), "day");
        dateOfCombobox(orderdatemonth, fillMonth(monthlist), "month");
        dateOfCombobox(orderdateyear, fillYare(yearlist), "year");

        dateOfCombobox(fromDateday, fillDays(daylist), "day");
        dateOfCombobox(fromDatemonth, fillMonth(monthlist), "month");
        dateOfCombobox(fromDateyear, fillYare(yearlist), "year");

        dateOfCombobox(toDateday, fillDays(daylist), "day");
        dateOfCombobox(toDatemonth, fillMonth(monthlist), "month");
        dateOfCombobox(toDateyear, fillYare(yearlist), "year");

        dateOfCombobox(ch_en_fromdateday, fillDays(daylist), "day");
        dateOfCombobox(ch_en_fromdatemonth, fillMonth(monthlist), "month");
        dateOfCombobox(ch_en_fromdateyear, fillYare(yearlist), "year");

        dateOfCombobox(ch_en_todateday, fillDays(daylist), "day");
        dateOfCombobox(ch_en_todatemonth, fillMonth(monthlist), "month");
        dateOfCombobox(ch_en_todateyear, fillYare(yearlist), "year");

        dateOfCombobox(mandate_ch_decday, fillDays(daylist), "day");
        dateOfCombobox(mandate_ch_decmonth, fillMonth(monthlist), "month");
        dateOfCombobox(mandate_ch_decyear, fillYare(yearlist), "year");

        dateOfCombobox(mandate_ch_dec_fromday, fillDays(daylist), "day");
        dateOfCombobox(mandate_ch_dec_frommonth, fillMonth(monthlist), "month");
        dateOfCombobox(mandate_ch_dec_fromyear, fillYare(yearlist), "year");

        dateOfCombobox(mandate_ch_dec_today, fillDays(daylist), "day");
        dateOfCombobox(mandate_ch_dec_tomonth, fillMonth(monthlist), "month");
        dateOfCombobox(mandate_ch_dec_toyear, fillYare(yearlist), "year");

        dateOfCombobox(for_breth_day, fillDays(daylist), "day");
        dateOfCombobox(for_breth_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_breth_year, fillYare(yearlist), "year");

        dateOfCombobox(for_promotion_day, fillDays(daylist), "day");
        dateOfCombobox(for_promotion_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_promotion_year, fillYare(yearlist), "year");

        dateOfCombobox(for_nextpromotion_day, fillDays(daylist), "day");
        dateOfCombobox(for_nextpromotion_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_nextpromotion_year, fillYare(yearlist), "year");

        dateOfCombobox(for_passport_day, fillDays(daylist), "day");
        dateOfCombobox(for_passport_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_passport_year, fillYare(yearlist), "year");

        dateOfCombobox(for_intra_transportday, fillDays(daylist), "day");
        dateOfCombobox(for_intra_transportmonth, fillMonth(monthlist), "month");
        dateOfCombobox(for_intra_transportyear, fillYare(yearlist), "year");

        dateOfCombobox(for_intra_fromday, fillDays(daylist), "day");
        dateOfCombobox(for_intra_frommonth, fillMonth(monthlist), "month");
        dateOfCombobox(for_intra_fromyear, fillYare(yearlist), "year");

        dateOfCombobox(for_outtra_transportday, fillDays(daylist), "day");
        dateOfCombobox(for_outtra_transportmonth, fillMonth(monthlist), "month");
        dateOfCombobox(for_outtra_transportyear, fillYare(yearlist), "year");

        dateOfCombobox(for_outtra_fromday, fillDays(daylist), "day");
        dateOfCombobox(for_outtra_frommonth, fillMonth(monthlist), "month");
        dateOfCombobox(for_outtra_fromyear, fillYare(yearlist), "year");

        dateOfCombobox(for_outtra_leavingday, fillDays(daylist), "day");
        dateOfCombobox(for_outtra_leavingmonth, fillMonth(monthlist), "month");
        dateOfCombobox(for_outtra_leavingyear, fillYare(yearlist), "year");

        dateOfCombobox(for_outtra_leavingfromday, fillDays(daylist), "day");
        dateOfCombobox(for_outtra_leavingfrommonth, fillMonth(monthlist), "month");
        dateOfCombobox(for_outtra_leavingfromyear, fillYare(yearlist), "year");

        dateOfCombobox(for_transport_day, fillDays(daylist), "day");
        dateOfCombobox(for_transport_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_transport_year, fillYare(yearlist), "year");

        dateOfCombobox(for_employment_day, fillDays(daylist), "day");
        dateOfCombobox(for_employment_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_employment_year, fillYare(yearlist), "year");

        dateOfCombobox(for_workstarting_day, fillDays(daylist), "day");
        dateOfCombobox(for_workstarting_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_workstarting_year, fillYare(yearlist), "year");

        refreshListCombobox(fillListCombobox(ch_comboBoxlist));
        enTableViewData();
        mainePageOpenAction();
//        refreshInTransportTables();
//        refreshOutTransportTables();

//        for_militarytayp.setItems(list2);
//        for_qualification.setItems(qualificationlist);
//        for_rank.setItems(ranklist);
////        for_speclaization.setItems(setSpecializListCombobox(specialiazList));
//        for_unitinforce.setItems(setUnitListCombobox(unitNameList));
////        for_bloodtype.setItems(bloodTypeList);
//        for_intra_newunit.setItems(setUnitListCombobox(unitNameList));
        addhint.setTooltip(new Tooltip("اضافة طلب انتداب"));
        chackingdata.setTooltip(new Tooltip("تدقيق البيانات"));
        en_update.setTooltip(new Tooltip("تحديث البيانات"));
        en_search.setTooltip(new Tooltip("البحث واستعراض البيانات"));

//        name_militaryid.setOnAction(new EventHandler() {
//            @Override
//            public void handle(Event event) {
//                insertName();
//                name_militaryid.setText("");
//            }
//        });
        ch_mailitraynum.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                chackData();
                ch_mailitraynum.setText("");
            }

        });
        ch_list_combobox.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                refreshEnChackTable();
                chackTableListView(ch_list_combobox.getValue());
                listnumber.setText(ch_list_combobox.getValue());
                ch_mailitraynum.setDisable(false);
                ch_en_button.setDisable(false);
                ch_en_allsoldiers.setDisable(false);
                ch_en_allofficers.setDisable(false);
            }
        });
        mandate_dec_orderid.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                getListNames();
            }
        });
        mandate_dec_militrayid.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                updateDecState();
            }
        });

        for_militaryid.setOnKeyReleased(new EventHandler() {
            @Override
            public void handle(Event event) {
                getFormaitionDatabyMilitryid();
            }
        });

        transportView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<TransportDataModel> list = FXCollections.observableArrayList();
                list = transportView.getSelectionModel().getSelectedItems();
                for_intra_militaryid.setText(list.get(0).getMilitaryid());
                for_intra_newunit.setValue(list.get(0).getNewunit());
                for_intra_transportid.setText(list.get(0).getTransportid());
                for_intra_transportday.setValue(getDay(list.get(0).getTransportdate()));
                for_intra_transportmonth.setValue(getMonth(list.get(0).getTransportdate()));
                for_intra_transportyear.setValue(getYear(list.get(0).getTransportdate()));
                for_intra_transportday.setValue(getDay(list.get(0).getTransportdate()));
                for_intra_transportmonth.setValue(getMonth(list.get(0).getTransportdate()));
                for_intra_transportyear.setValue(getYear(list.get(0).getTransportdate()));
                for_intra_transportday.setValue(getDay(list.get(0).getTransportdate()));
                for_intra_transportmonth.setValue(getMonth(list.get(0).getTransportdate()));
                for_intra_transportyear.setValue(getYear(list.get(0).getTransportdate()));
                for_intra_fromday.setValue(getDay(list.get(0).getFromdate()));
                for_intra_frommonth.setValue(getMonth(list.get(0).getFromdate()));
                for_intra_fromyear.setValue(getYear(list.get(0).getFromdate()));
                inTransPortMilitaryid = list.get(0).getMilitaryid();
                inTransPortId = list.get(0).getTransportid();
            }
        });

        outTransportView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<TransportDataModel> outlist = FXCollections.observableArrayList();
                outlist = outTransportView.getSelectionModel().getSelectedItems();

                for_outtra_militaryid.setText(outlist.get(0).getMilitaryid());
                for_outtra_newunit.setText(outlist.get(0).getNewunit());
                for_outtra_transportid.setText(outlist.get(0).getTransportid());

                for_outtra_transportday.setValue(getDay(outlist.get(0).getTransportdate()));
                for_outtra_transportmonth.setValue(getMonth(outlist.get(0).getTransportdate()));
                for_outtra_transportyear.setValue(getYear(outlist.get(0).getTransportdate()));

                for_outtra_transportday.setValue(getDay(outlist.get(0).getTransportdate()));
                for_outtra_transportmonth.setValue(getMonth(outlist.get(0).getTransportdate()));
                for_outtra_transportyear.setValue(getYear(outlist.get(0).getTransportdate()));

                for_outtra_transportday.setValue(getDay(outlist.get(0).getTransportdate()));
                for_outtra_transportmonth.setValue(getMonth(outlist.get(0).getTransportdate()));
                for_outtra_transportyear.setValue(getYear(outlist.get(0).getTransportdate()));

                for_outtra_fromday.setValue(getDay(outlist.get(0).getFromdate()));
                for_outtra_frommonth.setValue(getMonth(outlist.get(0).getFromdate()));
                for_outtra_fromyear.setValue(getYear(outlist.get(0).getFromdate()));
                for_outtra_leavingid.setText(getYear(outlist.get(0).getLeavingid()));

                for_outtra_leavingday.setValue(getDay(outlist.get(0).getLeavingdate()));
                for_outtra_leavingmonth.setValue(getMonth(outlist.get(0).getLeavingdate()));
                for_outtra_leavingyear.setValue(getYear(outlist.get(0).getLeavingdate()));

                for_outtra_leavingfromday.setValue(getDay(outlist.get(0).getLeavingfromdate()));
                for_outtra_leavingfrommonth.setValue(getMonth(outlist.get(0).getLeavingfromdate()));
                for_outtra_leavingfromyear.setValue(getYear(outlist.get(0).getLeavingfromdate()));
                outTransPortMilitaryid = outlist.get(0).getMilitaryid();
                outTransPortId = outlist.get(0).getTransportid();
            }
        });

        en_table.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<EnDataModel> list = FXCollections.observableArrayList();
                list = en_table.getSelectionModel().getSelectedItems();
                orderid.setText(list.get(0).getOrderid());
                orderdateday.setValue(getDay(list.get(0).getOrderdate()));
                orderdatemonth.setValue(getMonth(list.get(0).getOrderdate()));
                orderdateyear.setValue(getYear(list.get(0).getOrderdate()));
                enfrom.setText(list.get(0).getEnfrom());
                ento.setText(list.get(0).getEnto());
                ennamelist.setText(list.get(0).getListNumber());
                fromDateday.setValue(getDay(list.get(0).getEndatefrom()));
                fromDatemonth.setValue(getMonth(list.get(0).getEndatefrom()));
                fromDateyear.setValue(getYear(list.get(0).getEndatefrom()));
                toDateday.setValue(getDay(list.get(0).getEndateto()));
                toDatemonth.setValue(getMonth(list.get(0).getEndateto()));
                toDateyear.setValue(getYear(list.get(0).getEndateto()));
                PlaceOfAssignment.setValue(list.get(0).getEnplase());
                militarytayp.setValue(list.get(0).getMilitarytype());
                entayp.setValue(list.get(0).getEntype());
                updatOrderId = list.get(0).getOrderid();
                updatFromDate = list.get(0).getEndatefrom();
                updatToDate = list.get(0).getEndateto();

            }
        });
    }

}
