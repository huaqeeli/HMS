package hms;

import hms.models.EnDataModel;
import hms.models.NamesDataModel;
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
    private TableColumn<EnDataModel, String> en_update_col;
    private Accordion addnamepane;
    private TitledPane namepane;
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
    ObservableList<String> bloodTypeList = FXCollections.observableArrayList("O+", "A+", "B+", "AB+","O-", "A-", "B-", "AB-");
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
    @FXML
    private Button en_updateButton;
    @FXML
    private Button en_updateButton1;
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
    private Button save1;
    @FXML
    private Button en_updateButton2;
    @FXML
    private Button en_updateButton11;
    @FXML
    private Button ch_en_allofficers;
    @FXML
    private Button ch_en_allsoldiers;
    @FXML
    private TextField ennamelist;
    @FXML
    private TableColumn<?, ?> en_sq_col;
    @FXML
    private Button ch_en_button1;
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
    private Tab addhint1;
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
    private Tab chackingdata1;
    @FXML
    private TextField ch_enfrom1;
    @FXML
    private TextField ch_ento1;
    @FXML
    private ComboBox<?> ch_en_fromdateday1;
    @FXML
    private ComboBox<?> ch_en_fromdatemonth1;
    @FXML
    private ComboBox<?> ch_en_fromdateyear1;
    @FXML
    private ComboBox<?> ch_en_todateday1;
    @FXML
    private ComboBox<?> ch_en_todatemonth1;
    @FXML
    private ComboBox<?> ch_en_todateyear1;
    @FXML
    private TextField ch_mailitraynum1;
    @FXML
    private Button ch_en_allofficers1;
    @FXML
    private Button ch_en_allsoldiers1;
    @FXML
    private Button ch_en_button11;
    @FXML
    private TableView<?> chacktable1;
    @FXML
    private TableColumn<?, ?> en_ch_sq_col1;
    @FXML
    private TableColumn<?, ?> ch_mailitraynum_col1;
    @FXML
    private TableColumn<?, ?> ch_rank_col1;
    @FXML
    private TableColumn<?, ?> ch_name_col1;
    @FXML
    private TableColumn<?, ?> ch_en_from_col1;
    @FXML
    private TableColumn<?, ?> ch_en_to_col1;
    @FXML
    private TableColumn<?, ?> ch_en_fromdate_col1;
    @FXML
    private TableColumn<?, ?> ch_en_todate_col1;
    @FXML
    private ComboBox<?> ch_list_combobox1;
    @FXML
    private Label listnumber1;
    @FXML
    private Label excludedNumber1;
    @FXML
    private Tab en_update1;
    @FXML
    private TextField mandate_dec_militrayid1;
    @FXML
    private TableView<?> no_dec_table1;
    @FXML
    private TableColumn<?, ?> no_dec_sequence_col1;
    @FXML
    private TableColumn<?, ?> no_dec_militaryid_col1;
    @FXML
    private TableColumn<?, ?> no_dec_rank_col1;
    @FXML
    private TableColumn<?, ?> no_dec_name_col1;
    @FXML
    private TableView<?> dec_table1;
    @FXML
    private TableColumn<?, ?> dec_sequence_col1;
    @FXML
    private TableColumn<?, ?> dec_militaryid_col1;
    @FXML
    private TableColumn<?, ?> dec_rank_col1;
    @FXML
    private TableColumn<?, ?> dec_name_col1;
    @FXML
    private TextField mandate_ch_decnumber1;
    @FXML
    private ComboBox<?> mandate_ch_dec_fromday1;
    @FXML
    private ComboBox<?> mandate_ch_dec_frommonth1;
    @FXML
    private ComboBox<?> mandate_ch_dec_fromyear1;
    @FXML
    private ComboBox<?> mandate_ch_dec_today1;
    @FXML
    private ComboBox<?> mandate_ch_dec_tomonth1;
    @FXML
    private ComboBox<?> mandate_ch_dec_toyear1;
    @FXML
    private ComboBox<?> mandate_ch_decday1;
    @FXML
    private ComboBox<?> mandate_ch_decmonth1;
    @FXML
    private ComboBox<?> mandate_ch_decyear1;
    @FXML
    private Button save11;
    @FXML
    private Button en_updateButton21;
    @FXML
    private Button en_updateButton111;
    @FXML
    private TextField mandate_dec_orderid1;
    @FXML
    private Tab en_search1;

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
        System.out.println(days + 1);
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
                System.out.println(id + "/" + balance);
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

        String[] data = {orderid.getText(), orderdate, enfrom.getText(), ento.getText(), fromdate, todate, PlaceOfAssignment.getValue(), militarytayp.getValue(), entayp.getValue()};

        String fieldNameAndValue = "`ORDERID`= ?,`ORDERDATE`=?,`ENFROM`=?,`ENTO`= ?,`ENDATEFROM`=?,`ENDATETO`=?,`ENPLASE`=?,`MILITARYTAYP`= ?,`ENTAYP`= ?";

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

        boolean mandateUnique = FormValidation.dateChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ? AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean trainingUnique = FormValidation.dateChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSESTARTDATE` BETWEEN ? AND ?) OR ( `COURSENDDATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean enfromstate = FormValidation.textFieldNotEmpty(ch_enfrom, "ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ch_ento, "ادخل الجهة المنتدب اليها");

        if (mandateUnique && trainingUnique) {
            if (militaryidUnique && enfromstate && entostate) {
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

        boolean mandateUnique = FormValidation.dateChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ? AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean trainingUnique = FormValidation.dateChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSESTARTDATE` BETWEEN ? AND ?) OR ( `COURSENDDATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean enfromstate = FormValidation.textFieldNotEmpty(ch_enfrom, "ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ch_ento, "ادخل الجهة المنتدب اليها");

        if (mandateUnique && trainingUnique) {
            if (militaryidUnique && enfromstate && entostate) {
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
        System.out.println(mandateDecListNumber);
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
            DataMng.updat("nameslist", "`DICISIONNUMBER` = ? ,`DECISIONDATE` = ?,`ENDATEFROM`= ? ,`ENDATETO` = ? ,`DECISIONSTATUS` = 'true'", data, "`LISTNUMBER` =? AND `MILITARYID` = ?");
            refreshDecTables();
            increaseBalance(mandate_dec_militrayid.getText());
            mandate_dec_militrayid.setText("");
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
        String fieldName = "`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`BIRTH_DATE`,`BIRTH_PLACE`,`SPECIALIZATION`,`UNIT_IN_FORCE`,`UNIT_BEFOR_FORCE`,`BANKNAME`,`IBANNUMBER`,`BLOODTYPE`,`DATE_OF_PROMOTION`,`DATE_OF_NEXT_PROMOTION`,`PASSPORTID`,`END_DATE_OFPASSPORT`,`MOBILENUMBER`,`MOBILENUMBER_OFCOUSIN`,`QUALIFICATION`,`MILITARYTYPE`";
        String[] data = {for_militaryid.getText(), for_name.getText(), for_rank.getValue(), for_idnumber.getText(), prthDate, for_birth_place.getText(), for_speclaization.getValue(),
            for_unitinforce.getValue(), for_unitbeforforce.getText(), for_bankname.getText(), for_ibannumber.getText(), for_bloodtype.getValue(), promotionDate, nextpromotionDate, for_passportid.getText(),
            passportDate, for_mobilenumber.getText(), for_mobilenumber_ofcousin.getText(), for_qualification.getValue(), for_militarytayp.getValue()};
        String valuenumbers = "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

        boolean militaryidNotEmpty = FormValidation.textFieldNotEmpty(for_militaryid, "ادخل الرقم العسكري");
        boolean nameNotEmpty = FormValidation.textFieldNotEmpty(for_name, "ادخل الاسم");
        boolean rankNotEmpty = FormValidation.comboBoxNotEmpty(for_rank, "اختر الرتبة");
        boolean idNumberNotEmpty = FormValidation.textFieldNotEmpty(for_idnumber, "ادخل رقم الهوية");
        boolean unitInForceNotEmpty = FormValidation.comboBoxNotEmpty(for_unitinforce, "اختر الوحدة داخل القوة");
        boolean unitBeforForceNotEmpty = FormValidation.textFieldNotEmpty(for_unitbeforforce, "ادخل الوحدة قبل القوة");
        boolean bankNameNotEmpty = FormValidation.textFieldNotEmpty(for_bankname, "ادخل اسم البنك");
        boolean ibanNumberNotEmpty = FormValidation.textFieldNotEmpty(for_ibannumber, "ادخل رقم الايبان");
        boolean mobileNumberNotEmpty = FormValidation.textFieldNotEmpty(for_mobilenumber, "ادخل رقم الجوال");
        boolean militaryidUnique = FormValidation.unique("formation", "`MILITARYID`", "`MILITARYID` = '" + data[0] + "'", "تم ادخال الرقم العسكري مسبقا");
        boolean idNumberUnique = FormValidation.unique("formation", "`IDNAMBER`", "`IDNAMBER` = '" + data[3] + "'", "تم ادخال رقم الهوية مسبقا");
        boolean ibanNumberUnique = FormValidation.unique("formation", "`IBANNUMBER`", "`IBANNUMBER` = '" + data[10] + "'", "تم ادخال رقم الايبان مسبقا");
        boolean mobilNumberUnique = FormValidation.unique("formation", "`MOBILENUMBER`", "`MOBILENUMBER` = '" + data[16] + "'", "تم ادخال رقم الجوال مسبقا");

        if (militaryidNotEmpty && nameNotEmpty && rankNotEmpty && idNumberNotEmpty && unitInForceNotEmpty && unitBeforForceNotEmpty && bankNameNotEmpty
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
    }

    @FXML
    private void deleteFormaitionData(ActionEvent event) {
    }
    
    public void getFormaitionDatabyMilitryid(){
        try {
            String tableName = "formation";
            String fieldName = "`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`BIRTH_DATE`,`BIRTH_PLACE`,`SPECIALIZATION`,`UNIT_IN_FORCE`,`UNIT_BEFOR_FORCE`,`BANKNAME`,`IBANNUMBER`,`BLOODTYPE`,`DATE_OF_PROMOTION`,`DATE_OF_NEXT_PROMOTION`,`PASSPORTID`,`END_DATE_OFPASSPORT`,`MOBILENUMBER`,`MOBILENUMBER_OFCOUSIN`,`QUALIFICATION`,`MILITARYTYPE`";
            ResultSet rs = DataMng.getDataWithCondition(tableName, fieldName, "`MILITARYID` = '"+for_militaryid.getText()+"'");
            if (rs.next()) {
               for_name.setText(rs.getString("NAME"));
               for_rank.setValue(rs.getString("RANK"));
               for_idnumber.setText(rs.getString("IDNAMBER"));
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
            String fromDate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
            String toDate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
            String tableName = "nameslist";
            String fieldName = "`MILITARYID`,`LISTNUMBER`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`";
            String valuenumbers = "?,?,?,?,?,?";
            String[] data = new String[6];
            String[] excluded = new String[2];

            try {
                ResultSet rs = DataMng.getAllQuiry("SELECT MILITARYID,NAME FROM formation WHERE MILITARYTYPE = '" + militaryType + "'");
                while (rs.next()) {
                    boolean mandateUnique = FormValidation.dateAllChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ? AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", rs.getString("MILITARYID"), listnumber.getText(), fromDate, toDate);
                    boolean trainingUnique = FormValidation.dateAllChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSESTARTDATE` BETWEEN ? AND ?) OR ( `COURSENDDATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", rs.getString("MILITARYID"), listnumber.getText(), fromDate, toDate);
                    boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + rs.getString("MILITARYID") + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
                    boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + rs.getString("MILITARYID") + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");

                    data[0] = rs.getString("MILITARYID");
                    data[1] = listnumber.getText();
                    data[2] = ch_enfrom.getText();
                    data[3] = ch_ento.getText();
                    data[4] = fromDate;
                    data[5] = toDate;

                    excluded[0] = listnumber.getText();
                    excluded[1] = rs.getString("MILITARYID");

                    if (mandateUnique && trainingUnique) {
                        if (militaryidUnique) {
                            DataMng.insert(tableName, fieldName, valuenumbers, data);
                        }
                    } else {
                        if (exuludedUnique) {
                            DataMng.insert("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excluded);
                        }
                    }
                    refreshChacktable();
                }

            } catch (IOException | SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
        String s = Integer.toString(getExcludededSum(listnumber.getText()));
        excludedNumber.setText(s);
    }

    private void chackTableViewData() {
        try {
            ResultSet rs = DataMng.getDataWithCondition("formation", "`MILITARYID`,`RANK`,`NAME`", "`MILITARYID` = '" + ch_mailitraynum.getText() + "'");
            ResultSet rss = DataMng.getDataWithCondition("nameslist", "`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`", "`MILITARYID` = '" + ch_mailitraynum.getText() + "'AND `LISTNUMBER` = '" + listnumber.getText() + "'");
            int sq = 0;
            while (rs.next() && rss.next()) {
                sq++;
                chacktablelist.add(new NamesDataModel(
                        rs.getString("MILITARYID"),
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        no_dec_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
        no_dec_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        no_dec_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        no_dec_sequence_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        no_dec_table.setItems(no_declist);
    }

    private void namesWithDcTableViewData() {
        try {
            ResultSet rs = DataMng.getDataJoinTable("SELECT formation.MILITARYID,formation.RANK,formation.NAME FROM mandate,nameslist,formation WHERE  mandate.ENNAMELISTNUMBER = nameslist.LISTNUMBER AND nameslist.MILITARYID = formation.MILITARYID AND mandate.ORDERID = '" + mandate_dec_orderid.getText() + "'AND nameslist.DECISIONSTATUS='true'");
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*select mandatenames.MILITARYID,mandatenames.ENDATEFROM,mandatenames.ENDATETO, formation.NAME, formation.RANK 
     from mandatenames ,formation 
     where  mandatenames.MILITARYID = formation.MILITARYID AND mandatenames.DECISIONSTATUS = '0' AND mandatenames.ORDERID = '574857'*/
    private void mandatesChackTableViewData() {
//        ResultSet rs = DataMng.getDataJoinTable("mandatenames", "formation", "mandatenames.MILITARYID,formation.RANK,formation.NAME", "mandatenames.MILITARYID = formation.MILITARYID AND mandatenames.ORDERID ='" + ch_mailitraynum.getText() + "'");
////       
////        try {
////            while (rs.next() && rss.next()) {
////                chacktablelist.add(new NamesDataModel(
////                        rs.getString("MILITARYID"),
////                        rs.getString("RANK"),
////                        rs.getString("NAME"),
////                        rss.getString("ENFROM"),
////                        rss.getString("ENTO"),
////                        rss.getDate("ENDATEFROM").toString(),
////                        rss.getDate("ENDATETO").toString()
////                ));
////            }
////            rs.close();
////            rss.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        ch_mailitraynum_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
        ch_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        ch_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        ch_en_from_col.setCellValueFactory(new PropertyValueFactory<>("enfrom"));
        ch_en_to_col.setCellValueFactory(new PropertyValueFactory<>("ento"));
        ch_en_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("enfromdate"));
        ch_en_todate_col.setCellValueFactory(new PropertyValueFactory<>("entodate"));

        chacktable.setItems(chacktablelist);
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
                            sq
                    ));
                }
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
            en_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

            Callback<TableColumn<EnDataModel, String>, TableCell<EnDataModel, String>> cellfactory = (param) -> {
                final TableCell<EnDataModel, String> cell = new TableCell<EnDataModel, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            final CheckBox chbox = new CheckBox();
                            chbox.setOnAction(e -> {
                                EnDataModel m = getTableView().getItems().get(getIndex());
                                if (chbox.isSelected()) {
                                    orderid.setText(m.getOrderid());
                                    orderdateday.setValue(getDay(m.getOrderdate()));
                                    orderdatemonth.setValue(getMonth(m.getOrderdate()));
                                    orderdateyear.setValue(getYear(m.getOrderdate()));
                                    enfrom.setText(m.getEnfrom());
                                    ento.setText(m.getEnto());
                                    fromDateday.setValue(getDay(m.getEndatefrom()));
                                    fromDatemonth.setValue(getMonth(m.getEndatefrom()));
                                    fromDateyear.setValue(getYear(m.getEndatefrom()));
                                    toDateday.setValue(getDay(m.getEndateto()));
                                    toDatemonth.setValue(getMonth(m.getEndateto()));
                                    toDateyear.setValue(getYear(m.getEndateto()));
                                    PlaceOfAssignment.setValue(m.getEnplase());
                                    militarytayp.setValue(m.getMilitarytype());
                                    entayp.setValue(m.getEntype());
                                    updatOrderId = m.getOrderid();
                                    updatFromDate = m.getEndatefrom();
                                    updatToDate = m.getEndateto();
                                } else {
                                    chbox.setSelected(false);
                                }
                            });
                            setGraphic(chbox);
                            setText(null);
                        }
                    }
                ;
                };
                return cell;
            };

            en_update_col.setCellFactory(cellfactory);

            en_table.setItems(tablelist);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getDay(String date) {
        String[] parts = date.split("-");
        String day = parts[2];
        return day;
    }

    private String getMonth(String date) {
        String[] parts = date.split("-");
        String month = parts[1];
        return month;
    }

    private String getYear(String date) {
        String[] parts = date.split("-");
        String year = parts[0];
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
        for (int i = 1420; i <= 1480; i++) {
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
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        

        refreshListCombobox(fillListCombobox(ch_comboBoxlist));
        enTableViewData();
        mainePageOpenAction();
        
        for_militarytayp.setItems(list2);
        for_qualification.setItems(qualificationlist);
        for_rank.setItems(ranklist);
        for_speclaization.setItems(setSpecializListCombobox(specialiazList));
        for_unitinforce.setItems(setUnitListCombobox(unitNameList));
        for_bloodtype.setItems(bloodTypeList);

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

    }

}
