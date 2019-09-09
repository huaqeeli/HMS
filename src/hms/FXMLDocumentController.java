package hms;

import hms.models.EnDataModel;
import hms.models.ErorreMesageModel;
import hms.models.NamesDataModel;
import java.io.IOException;
import java.util.List;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Callback;

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
    ObservableList<String> daylist = FXCollections.observableArrayList();
    ObservableList<String> monthlist = FXCollections.observableArrayList();
    ObservableList<String> yearlist = FXCollections.observableArrayList();
    ObservableList<EnDataModel> tablelist = FXCollections.observableArrayList();
    ObservableList<NamesDataModel> chacktablelist = FXCollections.observableArrayList();
    ObservableList<String> ch_comboBoxlist = FXCollections.observableArrayList();
    @FXML
    private Label listnumber;
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
    private TextField mandate_ch_militrayid;
    @FXML
    private TableView<?> no_dec_table;
    @FXML
    private TableColumn<?, ?> no_dec_militaryid_col;
    @FXML
    private TableColumn<?, ?> no_dec_rank_col;
    @FXML
    private TableColumn<?, ?> no_dec_name_col;
    @FXML
    private TableView<?> dec_table;
    @FXML
    private TableColumn<?, ?> dec_militaryid_col;
    @FXML
    private TableColumn<?, ?> dec_rank_col;
    @FXML
    private TableColumn<?, ?> dec_name_col;
    @FXML
    private TextField mandate_ch_decnumber;
    @FXML
    private ComboBox<?> mandate_ch_dec_fromday;
    @FXML
    private ComboBox<?> mandate_ch_dec_frommonth;
    @FXML
    private ComboBox<?> mandate_ch_dec_fromyear;
    @FXML
    private ComboBox<?> mandate_ch_dec_today;
    @FXML
    private ComboBox<?> mandate_ch_dec_tomonth;
    @FXML
    private ComboBox<?> mandate_ch_dec_toyear;
    @FXML
    private ComboBox<?> mandate_ch_decday;
    @FXML
    private ComboBox<?> mandate_ch_decmonth;
    @FXML
    private ComboBox<?> mandate_ch_decyear;
    @FXML
    private Button save1;
    @FXML
    private Button en_updateButton2;
    @FXML
    private Button en_updateButton11;
    @FXML
    private TextField mandate_ch_orderid;
    @FXML
    private ComboBox<?> mandate_ch_fromday;
    @FXML
    private ComboBox<?> mandate_ch_frommonth;
    @FXML
    private ComboBox<?> mandate_ch_fromyear;
    @FXML
    private ComboBox<?> mandate_ch_today;
    @FXML
    private ComboBox<?> mandate_ch_tomonth;
    @FXML
    private ComboBox<?> mandate_ch_toyear;
    @FXML
    private Button ch_en_allofficers;
    @FXML
    private Button ch_en_allsoldiers;
    @FXML
    private TextField ennamelist;
    @FXML
    private TableColumn<?, ?> en_sq_col;
    @FXML
    private AnchorPane En_addName;
    @FXML
    private Label name_ordreid;
    @FXML
    private Label name_endate_from;
    @FXML
    private Label name_endate_to;
    @FXML
    private TextField name_militaryid;
    @FXML
    private TableView<?> names_table;
    @FXML
    private TableColumn<?, ?> name_militaryid_col;
    @FXML
    private TableColumn<?, ?> name_rank_col;
    @FXML
    private TableColumn<?, ?> name_name_col;
    @FXML
    private Pane progressPane;
    @FXML
    private Button ch_en_button1;
    DataMng dataMang = new DataMng();
    @FXML
    private ListView<?> dataShow;
    
    @FXML
    private void mainePageOpenAction(ActionEvent event) {
        MainPage.setVisible(true);
        EntedabPage.setVisible(false);
        TshkelPage.setVisible(false);
    }
    
    private void tabhint(ActionEvent event) {
        final Tooltip tooltip = new Tooltip();
        tooltip.setText("hussein");
    }
    
    private void mainePageOpenAction() {
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
    
    private int getDateDifference() {
        int d1 = Integer.parseInt(fromDateday.getValue());
        int m1 = Integer.parseInt(fromDatemonth.getValue());
        int y1 = Integer.parseInt(fromDateyear.getValue());
        int d2 = Integer.parseInt(toDateday.getValue());
        int m2 = Integer.parseInt(toDatemonth.getValue());
        int y2 = Integer.parseInt(toDateyear.getValue());
        int difference = 0;
        
        int diffDays = d2 - d1;
        int diffMonths = m2 - m1;
        int diffYears = y2 - y1;
        
        difference = diffDays + (diffMonths * 30) + (diffYears * 360);
        
        return difference;
    }
    
    private void increaseBalance(String id) {
        try {
            ResultSet rs = DataMng.getDataWithCondition("mandate_balance", "`BALANCE`", "`MILITARYID` = '" + id + "'");
            int balance = 0;
            try {
                if (rs.next()) {
                    balance = rs.getInt("BALANCE");
                }
                balance = balance - getDateDifference();
                DataMng.updat("mandate_balance", "`BALANCE` = '" + balance + "'", "`MILITARYID` = '" + id + "'");
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        if (mandateUnique && trainingUnique) {
            if (militaryidUnique) {
                try {
                    DataMng.insert(tableName, fieldName, valuenumbers, data);
                    chackTableViewData();
                    ch_mailitraynum.setText("");
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            if (exuludedUnique) {
                try {
                    DataMng.insert("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excluded);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        if (mandateUnique && trainingUnique) {
            if (militaryidUnique) {
                try {
                    DataMng.insert(tableName, fieldName, valuenumbers, data);
                    chackTableViewData();
                    ch_mailitraynum.setText("");
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            if (exuludedUnique) {
                try {
                    DataMng.insert("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excluded);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @FXML
    private void chackAllOfficers(ActionEvent event) {
        try {
            ResultSet rs = DataMng.getAllQuiry("SELECT MILITARYID FROM formation WHERE MILITARYTYPE = 'ضابط'");
            String fromDate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
            String toDate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
            String tableName = "nameslist";
            String fieldName = "`MILITARYID`,`LISTNUMBER`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`";
            String valuenumbers = "?,?,?,?,?,?";
            List millest = new ArrayList();
            String[] excluded = {listnumber.getText(), ch_mailitraynum.getText()};
            try {
                while (rs.next()) {
                    millest.add(rs.getString("MILITARYID"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < millest.size(); i++) {
                String[] data = {millest.get(i).toString(), listnumber.getText(), ch_enfrom.getText(), ch_ento.getText(), fromDate, toDate};
                //Validation
                boolean mandateUnique = FormValidation.dateChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ? AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
                boolean trainingUnique = FormValidation.dateChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSESTARTDATE` BETWEEN ? AND ?) OR ( `COURSENDDATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
                boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
                boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
                
                Task<Parent> yourTaskName = new Task<Parent>() {
                    @Override
                    public Parent call() {
                        if (mandateUnique && trainingUnique) {
                            if (militaryidUnique) {
                                try {
                                    DataMng.insert(tableName, fieldName, valuenumbers, data);
                                } catch (IOException ex) {
                                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            if (exuludedUnique) {
                                try {
                                    DataMng.insert("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excluded);
                                } catch (IOException ex) {
                                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        return null;
                    }
                };
                Thread loadingThread = new Thread(yourTaskName);
                loadingThread.start();
            }
            chackTableViewAllSoldiers();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void chackAllSoldiers(ActionEvent event) {
        
        String fromDate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
        String toDate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
        String tableName = "nameslist";
        String fieldName = "`MILITARYID`,`LISTNUMBER`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`";
        String valuenumbers = "?,?,?,?,?,?";
        List millest = new ArrayList();
        String[] data = new String[6];
        String[] excluded = new String[2];
        
        try {
            ResultSet rs = DataMng.getAllQuiry("SELECT MILITARYID,NAME FROM formation WHERE MILITARYTYPE = 'فرد'");
            
            while (rs.next()) {
//                millest.add(rs.getString("MILITARYID"));
                
               
                dataShow.getItems().add(rs.getString("NAME"));

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
            }
            
            chackTableViewAllSoldiers();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//        for (int i = 0; i < millest.size(); i++) {
////            String[] data = {millest.get(i).toString(), listnumber.getText(), ch_enfrom.getText(), ch_ento.getText(), fromDate, toDate};
////            String[] excluded = {listnumber.getText(), millest.get(i).toString()};
//            //Validation
//            boolean mandateUnique = FormValidation.dateAllChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ? AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", millest.get(i).toString(), listnumber.getText(), fromDate, toDate);
//            boolean trainingUnique = FormValidation.dateAllChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSESTARTDATE` BETWEEN ? AND ?) OR ( `COURSENDDATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", millest.get(i).toString(), listnumber.getText(), fromDate, toDate);
//            boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + millest.get(i).toString() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
//            boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + millest.get(i).toString() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
//
//            Task<Parent> yourTaskName = new Task<Parent>() {
//                @Override
//                public Parent call() {
//                    if (mandateUnique && trainingUnique) {
//                        if (militaryidUnique) {
//                            try {
//                                DataMng.insert(tableName, fieldName, valuenumbers, data);
//                            } catch (IOException ex) {
//                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                        }
//                    } else {
//                        if (exuludedUnique) {
//                            try {
//                                DataMng.insert("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excluded);
//                            } catch (IOException ex) {
//                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                        }
//                    }
//                    return null;
//                }
//            };
//            Thread loadingThread = new Thread(yourTaskName);
//            loadingThread.start();
//        }
    @FXML
    private void deleteFromNamelist(ActionEvent event
    ) {
        try {
            String condition = "`MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `LISTNUMBER`='" + listnumber.getText() + "'";
            DataMng.delete("nameslist", condition);
            refreshEnChackTable();
            chackTableListView(listnumber.getText());
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
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
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void deleteListName(ActionEvent event
    ) {
        try {
            DataMng.delete("DELETE `nameslist`, `mandatelists` FROM `nameslist` inner join  `mandatelists` on `nameslist`.`LISTNUMBER` = `mandatelists`.`LISTNUMBER`"
                    + "WHERE `nameslist`.`LISTNUMBER` = '" + listnumber.getText() + "'AND mandatelists.LISTNUMBER='" + listnumber.getText() + "'");
            refreshEnChackTable();
            ch_comboBoxlist.clear();
            refreshListCombobox(fillListCombobox(ch_comboBoxlist));
            chackTableListView(listnumber.getText());
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void refreshNameTable() {
//        nametablelist.clear();
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
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void chackTableViewAllSoldiers() {
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
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        refreshListCombobox(fillListCombobox(ch_comboBoxlist));
        enTableViewData();
        mainePageOpenAction();
        
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
        
    }
    
    @FXML
    private void insertName(ActionEvent event) {
    }
    
}
