package hms;

import hms.models.EnDataModel;
import hms.models.NamesDataModel;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

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
    private TableView<NamesDataModel> names_table;
    @FXML
    private TableColumn<?, ?> name_militaryid_col;
    @FXML
    private TableColumn<?, ?> name_rank_col;
    @FXML
    private TableColumn<?, ?> name_name_col;
    @FXML
    private Accordion addnamepane;
    @FXML
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
    ObservableList<NamesDataModel> nametablelist = FXCollections.observableArrayList();
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
    private ComboBox<String> ch_list_combobox;

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

    private int getDateDifference() {
        int d1 = Integer.parseInt(fromDateday.getValue());
        int m1 = Integer.parseInt(fromDatemonth.getValue());
        int y1 = Integer.parseInt(fromDateyear.getValue());
        int d2 = Integer.parseInt(toDateday.getValue());
        int m2 = Integer.parseInt(toDatemonth.getValue());
        int y2 = Integer.parseInt(toDateyear.getValue());
        int diffDays = d2 - d1;
        int diffMonths = m2 - m1;
        int diffYears = y2 - y1;

        int difference = diffDays + (diffMonths * 30) + (diffYears * 360);

        return difference;
    }

    private void increaseBalance(String id) {
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
    }

    @FXML
    private void insertData(ActionEvent event) {
        String fieldName = "`ORDERID`,`ORDERDATE`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`,`ENPLASE`,`MILITARYTAYP`,`ENTAYP`";
        String[] data = {orderid.getText(), setDate(orderdateday.getValue(), orderdatemonth.getValue(), orderdateyear.getValue()), enfrom.getText(), ento.getText(),
            setDate(fromDateday.getValue(), fromDatemonth.getValue(), fromDateyear.getValue()), setDate(toDateday.getValue(), toDatemonth.getValue(), toDateyear.getValue()),
            PlaceOfAssignment.getValue(), militarytayp.getValue(), entayp.getValue()};
        String valuenumbers = "?,?,?,?,?,?,?,?,?";

        boolean numberOnly = FormValidation.textFieldTypeNumber(orderid, "استخدم الارقام فقط");
        boolean orderidstate = FormValidation.textFieldNotEmpty(orderid, "  ادخل رقم الطب ارقام فقط");
        boolean enfromstate = FormValidation.textFieldNotEmpty(enfrom, " ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ento, " ادخل الجهة المنتدب لها");
        boolean placestate = FormValidation.comboBoxNotEmpty(PlaceOfAssignment, " اختر مكان الانتداب");
        boolean militarytaypstate = FormValidation.comboBoxNotEmpty(militarytayp, " اختر نوع المستفيد");
        boolean entaypstate = FormValidation.comboBoxNotEmpty(entayp, " اختر مكان الانتداب");
        boolean orderidUnique = FormValidation.unique("entdabat", "`ORDERID`", "`ORDERID` = '" + data[0] + "'AND `ENDATEFROM`='" + data[4] + "' AND `ENDATETO` = '" + data[5] + "'", "تم ادخال الطلب مسبقا الرجاء التاجد من رقم الطلب");

        if (numberOnly && orderidUnique && orderidstate && enfromstate && entostate && placestate && militarytaypstate && entaypstate) {
            DataMng.insert("entdabat", fieldName, valuenumbers, data);
            refreshEnTable();
        }
    }

    @FXML
    private void insertName(ActionEvent event) {
        String tableName = "namesdata";
        String fieldName = "`MILITARYID`,`ORDERID`,`ENDATEFROM`,`ENDATETO`";
        String[] data = {name_militaryid.getText(), orderid.getText(), setDate(fromDateday.getValue(), fromDatemonth.getValue(), fromDateyear.getValue()), setDate(toDateday.getValue(), toDatemonth.getValue(), toDateyear.getValue())};
        String valuenumbers = "?,?,?,?";

        boolean orderidstate = FormValidation.textFieldNotEmpty(orderid, "  ادخل رقم الطب ارقام فقط");
        boolean numberOnly = FormValidation.textFieldTypeNumber(orderid, "استخدم الارقام فقط");
        boolean orderidUnique = FormValidation.unique("namesdata", "`MILITARYID`", " `MILITARYID` = '" + data[0] + "'AND `ORDERID` = '" + data[1] + "'AND `ENDATEFROM`='" + data[2] + "' AND `ENDATETO` = '" + data[3] + "'", "تم اضافة الاسم مسبقا تاكد من الرقم العسكري");

        if (orderidstate && orderidUnique&&numberOnly) {
            DataMng.insert(tableName, fieldName, valuenumbers, data);
            nameTableViewData();
            increaseBalance(name_militaryid.getText());
            name_militaryid.setText("");
        }
    }

    private void insertName() {//هذي الدالة تعمل نفس عمل الدالة السابقة عند الضغط على انتر
        String tableName = "namesdata";
        String fieldName = "`MILITARYID`,`ORDERID`,`ENDATEFROM`,`ENDATETO`";
        String[] data = {name_militaryid.getText(), orderid.getText(), setDate(fromDateday.getValue(), fromDatemonth.getValue(), fromDateyear.getValue()), setDate(toDateday.getValue(), toDatemonth.getValue(), toDateyear.getValue())};
        String valuenumbers = "?,?,?,?";

        boolean orderidstate = FormValidation.textFieldNotEmpty(orderid, "  ادخل رقم الطب ارقام فقط");
        boolean numberOnly = FormValidation.textFieldTypeNumber(orderid, "استخدم الارقام فقط");
        boolean orderidUnique = FormValidation.unique("namesdata", "`MILITARYID`", " `MILITARYID` = '" + data[0] + "'AND `ORDERID` = '" + data[1] + "'AND `ENDATEFROM`='" + data[2] + "' AND `ENDATETO` = '" + data[3] + "'", "تم اضافة الاسم مسبقا تاكد من الرقم العسكري");

        if (orderidstate && orderidUnique&&numberOnly) {
            DataMng.insert(tableName, fieldName, valuenumbers, data);
            nameTableViewData();
        }
    }

    @FXML
    private void creatNewList(ActionEvent event) {
         ResultSet rs = DataMng.getAllData("lists");
         int lastNumber = 0;
        try {
            if(rs.next()){
                lastNumber = rs.getInt("LISTID");
            }
            String newListNumber = FormValidation.creatList(lastNumber);
            listnumber.setText(newListNumber);
            ch_comboBoxlist.clear();
            ch_list_combobox.setItems(fillListCombobox(ch_comboBoxlist));
            ch_mailitraynum.setDisable(false);
            ch_en_button.setDisable(false);
            DataMng.updat("`lists`", "`LISTID` = '"+Integer.parseInt(newListNumber)+"' ", "`LISTID`= '"+lastNumber+"'");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    @FXML
    private void chackData(ActionEvent event) {
        String fromDate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
        String toDate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
        String tableName = "nameslist";
        String fieldName = "`MILITARYID`,`LISTNUMBER`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`";
        String[] data = {ch_mailitraynum.getText(), listnumber.getText(),ch_enfrom.getText(),ch_ento.getText(),fromDate,toDate};
        String valuenumbers = "?,?,?,?,?,?";
        
        boolean orderidUnique = FormValidation.unique("namesdata", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `ENDATEFROM` >='" + fromDate + "' AND `ENDATETO` <= '" + toDate + "'", "لديه انتداب خلال فترة الانتداب الحالية");
        boolean trainingUnique = FormValidation.unique("training", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `COURSESTARTDATE` >='" + fromDate + "' AND `COURSENDDATE` <= '" + toDate + "'", "لديه دورة  خلال فترة الانتداب الحالية");
        boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '"+listnumber.getText()+"'", "تم ادراج الاسم في القائمة مسبقا");
        
        if (orderidUnique && trainingUnique&& militaryidUnique) {
            DataMng.insert(tableName, fieldName, valuenumbers, data);
            chackTableViewData();
            ch_mailitraynum.setText("");
        }
    }

    private void chackData() {
        String fromDate = setDate(ch_en_fromdateday.getValue(), ch_en_fromdatemonth.getValue(), ch_en_fromdateyear.getValue());
        String toDate = setDate(ch_en_todateday.getValue(), ch_en_todatemonth.getValue(), ch_en_todateyear.getValue());
        String tableName = "nameslist";
        String fieldName = "`MILITARYID`,`LISTNUMBER`,`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`";
        String[] data = {ch_mailitraynum.getText(), listnumber.getText(),ch_enfrom.getText(),ch_ento.getText(),fromDate,toDate};
        String valuenumbers = "?,?,?,?,?,?";
        
        boolean orderidUnique = FormValidation.unique("namesdata", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `ENDATEFROM` >='" + fromDate + "' AND `ENDATETO` <= '" + toDate + "'", "لديه انتداب خلال فترة الانتداب الحالية");
        boolean trainingUnique = FormValidation.unique("training", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `COURSESTARTDATE` >='" + fromDate + "' AND `COURSENDDATE` <= '" + toDate + "'", "لديه دورة  خلال فترة الانتداب الحالية");
        boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '"+listnumber.getText()+"'", "تم ادراج الاسم في القائمة مسبقا");
        
        if (orderidUnique && trainingUnique && militaryidUnique) {
            DataMng.insert(tableName, fieldName, valuenumbers, data);
            chackTableViewData();
        }
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
    }

    private void nameTableViewData() {
        ResultSet rs = DataMng.getDataWithCondition("formation", "`MILITARYID`,`RANK`,`NAME`", "`MILITARYID` = '" + name_militaryid.getText() + "'");
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

    private void chackTableViewData() {
        ResultSet rs = DataMng.getDataWithCondition("formation", "`MILITARYID`,`RANK`,`NAME`", "`MILITARYID` = '" + ch_mailitraynum.getText() + "'");
        ResultSet rss = DataMng.getDataWithCondition("nameslist", "`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`", "`MILITARYID` = '" + ch_mailitraynum.getText() + "'AND `LISTNUMBER` = '"+listnumber.getText()+"'");
        try {
            while (rs.next() && rss.next()) {
                chacktablelist.add(new NamesDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rss.getString("ENFROM"),
                        rss.getString("ENTO"),
                        rss.getDate("ENDATEFROM").toString(),
                        rss.getDate("ENDATETO").toString()
                ));
            }
            rs.close();
            rss.close();
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

        chacktable.setItems(chacktablelist);
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
    
    private ObservableList fillListCombobox(ObservableList list) {
        ResultSet rs = DataMng.getAllData("nameslist");
        try {
            while (rs.next()) {
                list.add(rs.getString("LISTNUMBER"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
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
        ch_en_fromdateday.setItems(fillDays(daylist));
        ch_en_fromdatemonth.setItems(fillMonth(monthlist));
        ch_en_fromdateyear.setItems(fillYare(yearlist));
        ch_en_fromdateday.setValue(Integer.toString(HijriCalendar.getSimpleDay()));
        ch_en_fromdatemonth.setValue(Integer.toString(HijriCalendar.getSimpleMonth()));
        ch_en_fromdateyear.setValue(Integer.toString(HijriCalendar.getSimpleYear()));
        ch_en_todateday.setItems(fillDays(daylist));
        ch_en_todatemonth.setItems(fillMonth(monthlist));
        ch_en_todateyear.setItems(fillYare(yearlist));
        ch_en_todateday.setValue(Integer.toString(HijriCalendar.getSimpleDay()));
        ch_en_todatemonth.setValue(Integer.toString(HijriCalendar.getSimpleMonth()));
        ch_en_todateyear.setValue(Integer.toString(HijriCalendar.getSimpleYear()));
        
        ch_list_combobox.setItems(fillListCombobox(ch_comboBoxlist));

        enTableViewData();
        mainePageOpenAction();

        addhint.setTooltip(new Tooltip("اضافة طلب انتداب"));
        chackingdata.setTooltip(new Tooltip("تدقيق البيانات"));
        en_update.setTooltip(new Tooltip("تحديث البيانات"));
        en_search.setTooltip(new Tooltip("البحث واستعراض البيانات"));
        en_delete.setTooltip(new Tooltip("حذف البيانات"));

        addnamepane.setExpandedPane(namepane);

        name_militaryid.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                insertName();
                 name_militaryid.setText("");
            }
        });
        ch_mailitraynum.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                chackData();
                ch_mailitraynum.setText("");
            }
        });
    }
}
