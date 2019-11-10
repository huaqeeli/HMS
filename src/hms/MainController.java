package hms;

import hms.models.CasesDataModel;
import hms.models.CheckAllDataModel;
import hms.models.EnDataModel;
import hms.models.NamesDataModel;
import hms.models.TerminationDataModel;
import hms.models.TestModel;
import hms.models.TrainingDataModel;
import hms.models.TransportDataModel;
import hms.models.VacationDataModel;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
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
    ObservableList<String> ranklist = FXCollections.observableArrayList("الفريق أول", "الفريق", "الواء", "العميد", "العقيد", "المقدم", "النقيب", "الملازم أول", "الملازم", "رئيس رقباء", "رقيب أول", "رقيب", "وكيل رقيب", "عريف", "جندي أول", "جندي");
    ObservableList<String> qualificationlist = FXCollections.observableArrayList("جامعي", "ثانوية عامة", "الكفاءة المتوسطة", "الابتدائية");
    ObservableList<String> bloodTypeList = FXCollections.observableArrayList("O+", "A+", "B+", "AB+", "O-", "A-", "B-", "AB-");
    ObservableList<String> caseTypeList = FXCollections.observableArrayList("قضية جنائية", "ثبوت اجابية", "قضية حقوقية", "قضية مرورية", "اخرى");
    ObservableList<String> decreeTypeList = FXCollections.observableArrayList("معاملة بالمادة 13 من نضام خدمة الافراد", "ايقاف معاملة بالمادة 13", "صرف رواتب فرد معامل بالمادة 13", "قرار عسكري");
    ObservableList<String> vacationTypeList = FXCollections.observableArrayList("اجازة سنوية", "اجازة عرضية", "اجازة مرضية");
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
    ObservableList<CasesDataModel> caseslist = FXCollections.observableArrayList();
    ObservableList<TerminationDataModel> terminationlist = FXCollections.observableArrayList();
    ObservableList<TrainingDataModel> traininglist = FXCollections.observableArrayList();
    ObservableList<VacationDataModel> vacationlist = FXCollections.observableArrayList();
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
    private String Militaryid = null;
    private String outTransPortId = null;
    private String caseDecerrID = null;
    private String courseID = null;
    private String vacationID = null;
    private String mantateToDate = null;
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
    private Tab cases;
    @FXML
    private TextField for_cases_militaryid;
    @FXML
    private TextField for_cases_dec_id;
    @FXML
    private ComboBox<String> for_cases_decdate_day;
    @FXML
    private ComboBox<String> for_cases_decdate_month;
    @FXML
    private ComboBox<String> for_cases_decdate_year;
    @FXML
    private ComboBox<String> for_cases_decdatefrom_day;
    @FXML
    private ComboBox<String> for_cases_decdatefrom_month;
    @FXML
    private ComboBox<String> for_cases_decdatefrom_year;
    @FXML
    private TextField for_cases_casestate;
    @FXML
    private ComboBox<String> for_cases_startwork_day;
    @FXML
    private ComboBox<String> for_cases_startwork_month;
    @FXML
    private ComboBox<String> for_cases_startwork_year;
    @FXML
    private ComboBox<String> for_cases_dectype;
    @FXML
    private ComboBox<String> for_cases_casetype;
    @FXML
    private TableView<CasesDataModel> casesTableView;
    @FXML
    private TableColumn<?, ?> for_cases_sq_col;
    @FXML
    private TableColumn<?, ?> for_cases_militaryid_col;
    @FXML
    private TableColumn<?, ?> for_cases_rank_col;
    @FXML
    private TableColumn<?, ?> for_cases_name_col;
    @FXML
    private TableColumn<?, ?> for_cases_casetype_col;
    @FXML
    private TableColumn<?, ?> for_cases_decid_col;
    @FXML
    private TableColumn<?, ?> for_cases_decdate_col;
    @FXML
    private TableColumn<?, ?> for_cases_casefromdate_col;
    @FXML
    private TableColumn<?, ?> for_cases_dectype_col;
    @FXML
    private TableColumn<?, ?> for_cases_casestate_col;
    @FXML
    private TableColumn<?, ?> for_cases_startworkdate_col;
    @FXML
    private Label excludedNumber111;
    @FXML
    private Label excludedNumber112;
    @FXML
    private AnchorPane TrainingPage;
    @FXML
    private TextField tra_militaryid;
    @FXML
    private TextField tra_coursename;
    @FXML
    private TextField tra_courseid;
    @FXML
    private ComboBox<String> tra_coursedate_day;
    @FXML
    private ComboBox<String> tra_coursedate_month;
    @FXML
    private ComboBox<String> tra_coursedate_year;
    @FXML
    private ComboBox<String> tra_leavingdate_day;
    @FXML
    private ComboBox<String> tra_leavingdate_month;
    @FXML
    private ComboBox<String> tra_leavingdate_year;
    @FXML
    private ComboBox<String> tra_backdate_day;
    @FXML
    private ComboBox<String> tra_backdate_month;
    @FXML
    private ComboBox<String> tra_backdate_year;
    @FXML
    private ComboBox<String> tra_coursestartdate_day;
    @FXML
    private ComboBox<String> tra_coursestartdate_month;
    @FXML
    private ComboBox<String> tra_coursestartdate_year;
    @FXML
    private ComboBox<String> tra_courseenddate_day;
    @FXML
    private ComboBox<String> tra_courseenddate_month;
    @FXML
    private ComboBox<String> tra_courseenddate_year;
    @FXML
    private TableView<TrainingDataModel> trainingTableView;
    @FXML
    private TableColumn<?, ?> tra_sq_col;
    @FXML
    private TableColumn<?, ?> tra_militaryid_col;
    @FXML
    private TableColumn<?, ?> tra_rank_col;
    @FXML
    private TableColumn<?, ?> tra_name_col;
    @FXML
    private TableColumn<?, ?> tra_coursename_col;
    @FXML
    private TableColumn<?, ?> tra_courseid_col;
    @FXML
    private TableColumn<?, ?> tra_coursedate_col;
    @FXML
    private TableColumn<?, ?> tra_corsestartdate_col;
    @FXML
    private TableColumn<?, ?> tra_courseenddate_col;
    @FXML
    private TableColumn<?, ?> tra_leavingdate_col;
    @FXML
    private TableColumn<?, ?> tra_backdate_col;
    @FXML
    private Label excludedNumber113;
    @FXML
    private Tab reports11;
    @FXML
    private AnchorPane VacationsPage;
    @FXML
    private Tab inland_transport1;
    @FXML
    private TextField vac_militaryid;
    @FXML
    private ComboBox<String> vac_vacationtype;
    @FXML
    private TextField vac_vacation_decid;
    @FXML
    private ComboBox<String> vac_vacation_decdate_day;
    @FXML
    private ComboBox<String> vac_vacation_decdate_month;
    @FXML
    private ComboBox<String> vac_vacation_decdate_year;
    @FXML
    private ComboBox<String> vac_vacation_startdate_day;
    @FXML
    private ComboBox<String> vac_vacation_startdate_month;
    @FXML
    private ComboBox<String> vac_vacation_startdate_year;
    @FXML
    private ComboBox<String> vac_vacation_enddate_day;
    @FXML
    private ComboBox<String> vac_vacation_enddate_month;
    @FXML
    private ComboBox<String> vac_vacation_enddate_year;
    @FXML
    private TextField vac_vacation_duration;
    @FXML
    private TextField vac_vacation_place;
    @FXML
    private TableView<VacationDataModel> vacationTableView;
    @FXML
    private TableColumn<?, ?> vac_sq_col;
    @FXML
    private TableColumn<?, ?> vac_militaryid_col;
    @FXML
    private TableColumn<?, ?> vac_rank_col;
    @FXML
    private TableColumn<?, ?> vac_vacationtype_col;
    @FXML
    private TableColumn<?, ?> vac_decid_col;
    @FXML
    private TableColumn<?, ?> vac_vacation_duration_col;
    @FXML
    private TableColumn<?, ?> vac_vaction_place_col;
    @FXML
    private TableColumn<?, ?> vac_vacation_startdate_col;
    @FXML
    private TableColumn<?, ?> vac_vacation_enddate_col;
    @FXML
    private Tab reports1;
    @FXML
    private TextArea for_cases_casedescription;
    @FXML
    private ComboBox<String> vac_vacation_enddate_day11;
    @FXML
    private ComboBox<String> vac_vacation_enddate_month11;
    @FXML
    private ComboBox<String> vac_vacation_enddate_year11;
    @FXML
    private TableColumn<?, ?> vac_sq_col11;
    @FXML
    private TableColumn<?, ?> vac_militaryid_col11;
    @FXML
    private TableColumn<?, ?> vac_rank_col11;
    @FXML
    private TableColumn<?, ?> for_intra_name_col111;
    @FXML
    private TableColumn<?, ?> vac_vacationtype_col11;
    @FXML
    private TableColumn<?, ?> vac_decid_col11;
    @FXML
    private TableColumn<?, ?> vac_vacation_duration_col11;
    @FXML
    private TableColumn<?, ?> vac_vaction_place_col11;
    @FXML
    private TableColumn<?, ?> vac_vacation_startdate_col11;
    @FXML
    private TableColumn<?, ?> vac_vacation_enddate_col11;
    @FXML
    private Label excludedNumber1141;
    @FXML
    private Tab inland_transport12;
    @FXML
    private ComboBox<String> vac_vacationtype1;
    @FXML
    private TextField vac_vacation_decid1;
    @FXML
    private ComboBox<String> vac_vacation_decdate_day1;
    @FXML
    private ComboBox<String> vac_vacation_decdate_month1;
    @FXML
    private ComboBox<String> vac_vacation_decdate_year1;
    @FXML
    private ComboBox<String> vac_vacation_startdate_day1;
    @FXML
    private ComboBox<String> vac_vacation_startdate_month1;
    @FXML
    private ComboBox<String> vac_vacation_startdate_year1;
    @FXML
    private ComboBox<String> vac_vacation_enddate_day1;
    @FXML
    private ComboBox<String> vac_vacation_enddate_month1;
    @FXML
    private ComboBox<String> vac_vacation_enddate_year1;
    @FXML
    private TextField vac_vacation_duration1;
    @FXML
    private TextField vac_vacation_place1;
    @FXML
    private TableView<?> vacationTableView1;
    @FXML
    private TableColumn<?, ?> vac_sq_col1;
    @FXML
    private TableColumn<?, ?> vac_militaryid_col1;
    @FXML
    private TableColumn<?, ?> vac_rank_col1;
    @FXML
    private TableColumn<?, ?> for_intra_name_col11;
    @FXML
    private TableColumn<?, ?> vac_vacationtype_col1;
    @FXML
    private TableColumn<?, ?> vac_decid_col1;
    @FXML
    private TableColumn<?, ?> vac_vacation_duration_col1;
    @FXML
    private TableColumn<?, ?> vac_vaction_place_col1;
    @FXML
    private TableColumn<?, ?> vac_vacation_startdate_col1;
    @FXML
    private TableColumn<?, ?> vac_vacation_enddate_col1;
    @FXML
    private Label excludedNumber114;
    @FXML
    private TextField for_recovery;
    @FXML
    private TextField for_termination_militaryid;
    @FXML
    private TextField for_termination_reason;
    @FXML
    private TextField for_termination_decreeid;
    @FXML
    private ComboBox<String> for_termination_decree_day;
    @FXML
    private ComboBox<String> for_termination_decree_month;
    @FXML
    private ComboBox<String> for_termination_decree_year;
    @FXML
    private ComboBox<String> for_termination_from_day;
    @FXML
    private ComboBox<String> for_termination_from_month;
    @FXML
    private ComboBox<String> for_termination_from_year;
    @FXML
    private ComboBox<String> for_termination_leaving_day;
    @FXML
    private ComboBox<String> for_termination_leaving_month;
    @FXML
    private ComboBox<String> for_termination_leaving_year;
    @FXML
    private TableView<TerminationDataModel> terminationView;
    @FXML
    private TableColumn<?, ?> for_termination_sq_col;
    @FXML
    private TableColumn<?, ?> for_termination_militaryid_col;
    @FXML
    private TableColumn<?, ?> for_termination_rank_col;
    @FXML
    private TableColumn<?, ?> for_termination_name_col;
    @FXML
    private TableColumn<?, ?> for_termination_reason_col;
    @FXML
    private TableColumn<?, ?> for_termination_decreeid_col;
    @FXML
    private TableColumn<?, ?> for_termination_decreedate_col;
    @FXML
    private TableColumn<?, ?> for_termination_fromdate_col;
    @FXML
    private TableColumn<?, ?> for_termination_leavingdate_col;
    String decreeid = null;
    @FXML
    private Tab add_trainging;
    @FXML
    private TableColumn<?, ?> vac_name_col;
    @FXML
    private Tab newVacation;
    @FXML
    private TextField vac_new_militaryid;
    @FXML
    private ComboBox<?> vac_new_vacationtype;
    @FXML
    private ComboBox<?> vac_new_vacation_startdate_day;
    @FXML
    private ComboBox<?> vac_new_vacation_startdate_month;
    @FXML
    private ComboBox<?> vac_new_vacation_startdate_year;
    @FXML
    private TextField vac_new_vacation_duration;
    @FXML
    private TextField vac_new_vacation_place;
    @FXML
    private TextField vac_sickleave_militaryid;
    @FXML
    private TableColumn<?, ?> vac_decdate_col;
    @FXML
    private TableView<?> newVacationTableView;
    @FXML
    private TextField mandate_ch_number_of_nights;
    @FXML
    private TableColumn<?, ?> ch_en_balance_col;

    @FXML
    private void mainePageOpenAction(ActionEvent event) {
        MainPage.setVisible(true);
        EntedabPage.setVisible(false);
        FormationPage.setVisible(false);
        TrainingPage.setVisible(false);
        VacationsPage.setVisible(false);
    }

    private void tabhint(ActionEvent event) {
        final Tooltip tooltip = new Tooltip();
        tooltip.setText("hussein");
    }

    private void mainePageOpenAction() {
        MainPage.setVisible(true);
        EntedabPage.setVisible(false);
        FormationPage.setVisible(false);
        TrainingPage.setVisible(false);
        VacationsPage.setVisible(false);
    }

    @FXML
    private void entedabOpenAction(ActionEvent event) {
        MainPage.setVisible(false);
        EntedabPage.setVisible(true);
        FormationPage.setVisible(false);
        TrainingPage.setVisible(false);
        VacationsPage.setVisible(false);
    }

    @FXML
    private void tshkelOpenAction(ActionEvent event) {
        MainPage.setVisible(false);
        EntedabPage.setVisible(false);
        FormationPage.setVisible(true);
        TrainingPage.setVisible(false);
        VacationsPage.setVisible(false);
    }

    @FXML
    private void triningOpenAction(ActionEvent event) {
        MainPage.setVisible(false);
        EntedabPage.setVisible(false);
        FormationPage.setVisible(false);
        TrainingPage.setVisible(true);
        VacationsPage.setVisible(false);
    }

    @FXML
    private void vacationOpenAction(ActionEvent event) {
        MainPage.setVisible(false);
        EntedabPage.setVisible(false);
        FormationPage.setVisible(false);
        TrainingPage.setVisible(false);
        VacationsPage.setVisible(true);
    }

    private void increaseBalance(String id, int addedBalance) {
        try {
            ResultSet rs = DataMng.getDataWithCondition("mandate_balance", "`BALANCE`", "`MILITARYID` = '" + id + "'");
            int balance = 0;
            try {
                if (rs.next()) {
                    balance = rs.getInt("BALANCE");
                }
                balance = balance + addedBalance;
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
            if (rs.next()) {
                lastNumber = rs.getInt("LISTID");
            }
            String newListNumber = FormValidation.creatList(lastNumber);

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
            listnumber.setText(newListNumber);
            ch_list_combobox.setValue(newListNumber);
        } catch (IOException | SQLException ex) {
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
        boolean trainingUnique = FormValidation.dateChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSE_START_DATE` BETWEEN ? AND ?) OR ( `COURSE_END_DATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean enfromstate = FormValidation.textFieldNotEmpty(ch_enfrom, "ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ch_ento, "ادخل الجهة المنتدب اليها");
        boolean caseChecking = FormValidation.balnceAndCaseCheck("cases", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `CASE_ENDING` = 'false'", "معامل بالمادة 13 من نظام خدمة الافراد", ch_mailitraynum.getText(), listnumber.getText());
        boolean balanceChecking = FormValidation.balnceAndCaseCheck("mandate_balance", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `BALANCE` > 90 ", "استنفذ رصيد الانتدابات للسنة الحالية", ch_mailitraynum.getText(), listnumber.getText());

        if (mandateUnique && trainingUnique && caseChecking && balanceChecking) {
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

        boolean mandateUnique = FormValidation.dateChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ?  AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean trainingUnique = FormValidation.dateChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSE_START_DATE` BETWEEN ? AND ?) OR ( `COURSE_END_DATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", ch_mailitraynum.getText(), listnumber.getText(), fromDate, toDate);
        boolean militaryidUnique = FormValidation.unique("nameslist", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean exuludedUnique = FormValidation.unique("excluded", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND  `LISTNUMBER` = '" + listnumber.getText() + "'", "تم ادراج الاسم في القائمة مسبقا");
        boolean enfromstate = FormValidation.textFieldNotEmpty(ch_enfrom, "ادخل الجهة المنتدب منها");
        boolean entostate = FormValidation.textFieldNotEmpty(ch_ento, "ادخل الجهة المنتدب اليها");
        boolean caseChecking = FormValidation.balnceAndCaseCheck("cases", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `CASE_ENDING` = 'false'", "معامل بالمادة 13 من نظام خدمة الافراد", ch_mailitraynum.getText(), listnumber.getText());
        boolean balanceChecking = FormValidation.balnceAndCaseCheck("mandate_balance", "`MILITARYID`", " `MILITARYID` = '" + ch_mailitraynum.getText() + "' AND `BALANCE` > 90 ", "استنفذ رصيد الانتدابات للسنة الحالية", ch_mailitraynum.getText(), listnumber.getText());

        if (mandateUnique && trainingUnique && caseChecking && balanceChecking) {
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

    private String calculateDays(String year, String month, String day, String additionalDays) {
        int theYear = Integer.parseInt(year);
        int theMonth = Integer.parseInt(month);
        int theDay = Integer.parseInt(day);
        int theAdditionalDays = Integer.parseInt(additionalDays);

        LocalDate date = LocalDate.of(theYear, theMonth, theDay).plusDays(theAdditionalDays);
        return date.toString();
    }

    @FXML
    private void updateDecState(ActionEvent event) {
        try {
            String decDate = setDate(mandate_ch_decday.getValue(), mandate_ch_decmonth.getValue(), mandate_ch_decyear.getValue());
            String decfromDate = setDate(mandate_ch_dec_fromday.getValue(), mandate_ch_dec_frommonth.getValue(), mandate_ch_dec_fromyear.getValue());
            String dectoDate = calculateDays(mandate_ch_dec_fromyear.getValue(), mandate_ch_dec_frommonth.getValue(), mandate_ch_dec_fromday.getValue(), mandate_ch_number_of_nights.getText());
            String[] data = {mandate_ch_decnumber.getText(), decDate, decfromDate, dectoDate, mandateDecListNumber, mandate_dec_militrayid.getText()};

            boolean militaryidNotEmpty = FormValidation.textFieldNotEmpty(mandate_dec_militrayid, "ادخل الرقم العسكري");
            boolean decNumberNotEmpty = FormValidation.textFieldNotEmpty(mandate_ch_decnumber, "ادخل رقم القرار");

            if (decNumberNotEmpty && militaryidNotEmpty && mandateDecListNumber != null) {
                DataMng.updat("nameslist", "`DICISIONNUMBER` = ? ,`DECISIONDATE` = ?,`ENDATEFROM`= ? ,`ENDATETO` = ? ,`DECISIONSTATUS` = 'true'", data, "`LISTNUMBER` =? AND `MILITARYID` = ?");
                refreshDecTables();
                increaseBalance(mandate_dec_militrayid.getText(), Integer.parseInt(mandate_ch_number_of_nights.getText()));
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
                increaseBalance(mandate_dec_militrayid.getText(), Integer.parseInt(mandate_ch_number_of_nights.getText()));
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

    public void getFormaitionDatabyMilitryid(String tableName, String militaryid) {
        try {
            String fieldName = "`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`EMPLOYMENTDATE`,`BIRTH_DATE`,`BIRTH_PLACE`,`SPECIALIZATION`,`UNIT_IN_FORCE`,`UNIT_BEFOR_FORCE`,`BANKNAME`,`IBANNUMBER`,`BLOODTYPE`,`DATE_OF_PROMOTION`,`DATE_OF_NEXT_PROMOTION`,`PASSPORTID`,`END_DATE_OFPASSPORT`,`MOBILENUMBER`,`MOBILENUMBER_OFCOUSIN`,`QUALIFICATION`,`MILITARYTYPE`,`TRANSPORTID`,`TRANSPORTDATE`,`WORKSTARTINGDATE`";
            ResultSet rs = DataMng.getDataWithCondition(tableName, fieldName, "`MILITARYID` = '" + militaryid + "'");
            if (rs.next()) {
                for_militaryid.setText(rs.getString("MILITARYID"));
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

    public void getDataByListNumber(String tableName, String listNumber) {
        try {
            String fieldName = "`ENFROM`,`ENDATEFROM`,`ENDATETO`,`ENTO`";
            ResultSet rs = DataMng.getDataWithCondition(tableName, fieldName, "`LISTNUMBER` = '" + listNumber + "'");
            if (rs.first()) {
                enfrom.setText(rs.getString("ENFROM"));
                ento.setText(rs.getString("ENTO"));

                fromDateday.setValue(getDay(rs.getString("ENDATEFROM")));
                fromDatemonth.setValue(getMonth(rs.getString("ENDATEFROM")));
                fromDateyear.setValue(getYear(rs.getString("ENDATEFROM")));

                toDateday.setValue(getDay(rs.getString("ENDATETO")));
                toDatemonth.setValue(getMonth(rs.getString("ENDATETO")));
                toDateyear.setValue(getYear(rs.getString("ENDATETO")));

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
                DataMng.insert("INSERT INTO `transport_and_termination`(`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`EMPLOYMENTDATE`,`BIRTH_DATE`,`BIRTH_PLACE`,`SPECIALIZATION`,`UNIT_IN_FORCE`,`UNIT_BEFOR_FORCE`,`BANKNAME`,`IBANNUMBER`,`BLOODTYPE`,"
                        + "`DATE_OF_PROMOTION`,`DATE_OF_NEXT_PROMOTION`,`PASSPORTID`,`END_DATE_OFPASSPORT`,`MOBILENUMBER`,`MOBILENUMBER_OFCOUSIN`,`QUALIFICATION`,`NOTES`,`MILITARYTYPE`,`TRANSPORTID`,`TRANSPORTDATE`,\n"
                        + "`WORKSTARTINGDATE`) SELECT * FROM hmsdatabase.formation where MILITARYID =?", for_outtra_militaryid.getText());
                boolean chexkDataInserting = FormValidation.checkInsrtingData("transport_and_termination", "`MILITARYID`", "`MILITARYID` = '" + for_outtra_militaryid.getText() + "'", "لم يتم نقل بياناته الي المنقولين والمكلفين");
                if (chexkDataInserting) {
                    DataMng.deleteEmployeeData("formation", "`MILITARYID` = '" + for_outtra_militaryid.getText() + "'");
                }
                refreshOutTransportTables();
                refreshTerminationTable();
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
        String condition = "`MILITARYID`='" + Militaryid + "' AND `TRANSPORTID`= '" + outTransPortId + "'";

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
            String condition = "`MILITARYID`='" + Militaryid + "' AND `TRANSPORTID`= '" + outTransPortId + "'";
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
        int passCount = 0;
        int x = 0;
        int y = 0;
        ObservableList<CheckAllDataModel> lodedData = FXCollections.observableArrayList();
        ObservableList<CheckAllDataModel> passData = FXCollections.observableArrayList();
        ObservableList<CheckAllDataModel> excludData = FXCollections.observableArrayList();

        try {
            ResultSet rs = DataMng.getAllQuiry("SELECT formation.MILITARYID,formation.RANK,formation.NAME, mandate_balance.BALANCE  FROM formation,mandate_balance "
                    + "WHERE formation.MILITARYID = mandate_balance.MILITARYID AND formation.MILITARYTYPE = '" + militaryType + "'");
            while (rs.next()) {
                lodedData.add(new CheckAllDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("BALANCE")
                ));
            }

            for (int i = 0; i < lodedData.size(); i++) {

                boolean mandateUnique = FormValidation.dateAllChaking("nameslist", "`MILITARYID`", " `MILITARYID` = ? AND ((`ENDATEFROM` BETWEEN ? AND ?) OR ( `ENDATETO` BETWEEN ? AND ? ))", "لديه انتداب خلال فترة الانتداب الحالية", lodedData.get(i).getMilitaryId(), listnumber.getText(), fromDate, toDate);
                boolean trainingUnique = FormValidation.dateAllChaking("training", "`MILITARYID`", " `MILITARYID` = ? AND ((`COURSE_START_DATE` BETWEEN ? AND ?) OR ( `COURSE_END_DATE` BETWEEN ? AND ? ))", "لديه دورة  خلال فترة الانتداب الحالية", lodedData.get(i).getMilitaryId(), listnumber.getText(), fromDate, toDate);
                boolean caseChecking = FormValidation.balnceAndCaseCheck("cases", "`MILITARYID`", " `MILITARYID` = '" + lodedData.get(i).getMilitaryId() + "' AND `CASE_ENDING` = 'false'", "معامل بالمادة 13 من نظام خدمة الافراد", lodedData.get(i).getMilitaryId(), listnumber.getText());
                boolean balanceChecking = FormValidation.balnceAndCaseCheck("mandate_balance", "`MILITARYID`", " `MILITARYID` = '" + lodedData.get(i).getMilitaryId() + "' AND `BALANCE` > 90 ", "استنفذ رصيد الانتدابات للسنة الحالية", lodedData.get(i).getMilitaryId(), listnumber.getText());

                if (trainingUnique && mandateUnique && caseChecking && balanceChecking) {
                    passCount++;
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
                            lodedData.get(i).getBalance(),
                            passCount
                    ));
                    DataMng.insertPassData(tableName, fieldName, valuenumbers, passData, x);
                    x++;
                } else {
                    excludData.add(new CheckAllDataModel(
                            listnumber.getText(),
                            lodedData.get(i).getMilitaryId()
                    ));
                    DataMng.insertExcludedData("excluded", "`LISTNUMBER`,`MILITARYID`", "?,?", excludData, y);
                    y++;
                }
            }

            for (int j = 0; j < passData.size(); j++) {
                ch_mailitraynum_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
                ch_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
                ch_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
                ch_en_from_col.setCellValueFactory(new PropertyValueFactory<>("enfrom"));
                ch_en_to_col.setCellValueFactory(new PropertyValueFactory<>("ento"));
                ch_en_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("enfromdate"));
                ch_en_todate_col.setCellValueFactory(new PropertyValueFactory<>("entodate"));
                ch_en_balance_col.setCellValueFactory(new PropertyValueFactory<>("balance"));
                en_ch_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));
                chacktable.setItems(chacktablelist);
            }

        } catch (IOException | SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshCasestable() {
        caseslist.clear();
        casesTableViewAll();
    }

    private void refreshCasestableByMilitaryid(String militaryid) {
        caseslist.clear();
        casesTableViewByMilitaryid(militaryid);
    }

    @FXML
    private void addCaseDecree(ActionEvent event) {
        String decreeDate = setDate(for_cases_decdate_day.getValue(), for_cases_decdate_month.getValue(), for_cases_decdate_year.getValue());
        String caseDecDateFrom = setDate(for_cases_decdatefrom_day.getValue(), for_cases_decdatefrom_month.getValue(), for_cases_decdatefrom_year.getValue());
        String caseStartWorkDate = setDate(for_cases_startwork_day.getValue(), for_cases_startwork_month.getValue(), for_cases_startwork_year.getValue());

        String tableName = "cases";
        String fieldName = "`MILITARYID`,`CASE_TYPE`,`CASE_DECREEID`,`CASE_DECREE_DATE`,`CASE_DECREE_FROM_DATE`,`DECREE_TYPE`,`CASE_STATE`,`START_WORK_DATE`,`CASE_DESCRIPTION`,`CASE_ENDING`";
        String caseEnding = "true";
        if ("null-null-null".equals(caseStartWorkDate)) {
            caseStartWorkDate = null;
            caseEnding = "false";
        }
        String valuenumbers = "?,?,?,?,?,?,?,?,?,?";
        String[] data = {for_cases_militaryid.getText(), for_cases_casetype.getValue(), for_cases_dec_id.getText(), decreeDate, caseDecDateFrom, for_cases_dectype.getValue(), for_cases_casestate.getText(), caseStartWorkDate, for_cases_casedescription.getText(), caseEnding};

        boolean militaryIdNoutEmpty = FormValidation.textFieldNotEmpty(for_cases_militaryid, "ادخل الرقم العسكري");
        boolean decreeidNoutEmpty = FormValidation.textFieldNotEmpty(for_cases_dec_id, "ادخل القرار");
        boolean casetypeNoutEmpty = FormValidation.comboBoxNotEmpty(for_cases_casetype, "اختر نوع القضية");
        boolean dectypeNoutEmpty = FormValidation.comboBoxNotEmpty(for_cases_dectype, "اختر نوع القرار");

        if (militaryIdNoutEmpty && decreeidNoutEmpty && casetypeNoutEmpty && dectypeNoutEmpty) {
            try {
                DataMng.insert(tableName, fieldName, valuenumbers, data);
                refreshCasestable();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void updateCaseDecree(ActionEvent event) {
        String decreeDate = setDate(for_cases_decdate_day.getValue(), for_cases_decdate_month.getValue(), for_cases_decdate_year.getValue());
        String caseDecDateFrom = setDate(for_cases_decdatefrom_day.getValue(), for_cases_decdatefrom_month.getValue(), for_cases_decdatefrom_year.getValue());
        String caseStartWorkDate = setDate(for_cases_startwork_day.getValue(), for_cases_startwork_month.getValue(), for_cases_startwork_year.getValue());

        String tableName = "cases";
        String fieldName = "`MILITARYID`=?,`CASE_TYPE`=?,`CASE_DECREEID`=?,`CASE_DECREE_DATE`=?,`CASE_DECREE_FROM_DATE`=?,`DECREE_TYPE`=?,`CASE_STATE`=?,`START_WORK_DATE`=?,`CASE_DESCRIPTION`=?,`CASE_ENDING`=?";
        String caseEnding = "true";
        if ("null-null-null".equals(caseStartWorkDate)) {
            caseStartWorkDate = null;
            caseEnding = "false";
        }
        String[] data = {for_cases_militaryid.getText(), for_cases_casetype.getValue(), for_cases_dec_id.getText(), decreeDate, caseDecDateFrom, for_cases_dectype.getValue(), for_cases_casestate.getText(), caseStartWorkDate, for_cases_casedescription.getText(), caseEnding};

        boolean militaryIdNoutEmpty = FormValidation.textFieldNotEmpty(for_cases_militaryid, "ادخل الرقم العسكري");
        boolean decreeidNoutEmpty = FormValidation.textFieldNotEmpty(for_cases_dec_id, "ادخل القرار");
        boolean casetypeNoutEmpty = FormValidation.comboBoxNotEmpty(for_cases_casetype, "اختر نوع القضية");

        if (militaryIdNoutEmpty && decreeidNoutEmpty && casetypeNoutEmpty) {
            try {
                DataMng.updat(tableName, fieldName, data, "`MILITARYID` = '" + Militaryid + "' AND `CASE_DECREEID` = '" + caseDecerrID + "'");
                refreshCasestable();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void deleteCaseDecree(ActionEvent event) {
        try {
            DataMng.delete("cases", "`MILITARYID` = '" + Militaryid + "' AND `CASE_DECREEID` = '" + caseDecerrID + "'");
            refreshCasestable();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addTriningCourse(ActionEvent event) {
        String corseDate = setDate(tra_coursedate_day.getValue(), tra_coursedate_month.getValue(), tra_coursedate_year.getValue());
        String corseStartDate = setDate(tra_coursestartdate_day.getValue(), tra_coursestartdate_month.getValue(), tra_coursestartdate_year.getValue());
        String corseEndDate = setDate(tra_courseenddate_day.getValue(), tra_courseenddate_month.getValue(), tra_courseenddate_year.getValue());
        String leavingDate = setDate(tra_leavingdate_day.getValue(), tra_leavingdate_month.getValue(), tra_leavingdate_year.getValue());
        String backDate = setDate(tra_backdate_day.getValue(), tra_backdate_month.getValue(), tra_backdate_year.getValue());

        String tableName = "training";
        String fieldName = "`MILITARYID`,`COURS_NAME`,`COURSEID`,`COURSE_DATE`,`COURSE_START_DATE`,`COURSE_END_DATE`,`LEAING_DATE`,`BACK_DATE`";
        if ("null-null-null".equals(leavingDate)) {
            leavingDate = null;
        }
        if ("null-null-null".equals(backDate)) {
            backDate = null;
        }
        String valuenumbers = "?,?,?,?,?,?,?,?";
        String[] data = {tra_militaryid.getText(), tra_coursename.getText(), tra_courseid.getText(), corseDate, corseStartDate, corseEndDate, leavingDate, backDate};

        boolean militaryIdNotEmpty = FormValidation.textFieldNotEmpty(tra_militaryid, "ادخل الرقم العسكري");
        boolean corseNameNotEmpty = FormValidation.textFieldNotEmpty(tra_coursename, "ادخل مسمى الدورة");
        boolean corseIdNotEmpty = FormValidation.textFieldNotEmpty(tra_courseid, "ادخل رقم امر الدورة");

        if (militaryIdNotEmpty && corseNameNotEmpty && corseIdNotEmpty) {
            try {
                DataMng.insert(tableName, fieldName, valuenumbers, data);
                refreshTrainingtable();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void updateTriningCourse(ActionEvent event) {
        String corseDate = setDate(tra_coursedate_day.getValue(), tra_coursedate_month.getValue(), tra_coursedate_year.getValue());
        String corseStartDate = setDate(tra_coursestartdate_day.getValue(), tra_coursestartdate_month.getValue(), tra_coursestartdate_year.getValue());
        String corseEndDate = setDate(tra_courseenddate_day.getValue(), tra_courseenddate_month.getValue(), tra_courseenddate_year.getValue());
        String leavingDate = setDate(tra_leavingdate_day.getValue(), tra_leavingdate_month.getValue(), tra_leavingdate_year.getValue());
        String backDate = setDate(tra_backdate_day.getValue(), tra_backdate_month.getValue(), tra_backdate_year.getValue());

        String tableName = "training";
        String fieldName = "`MILITARYID`=?,`COURS_NAME`=?,`COURSEID`=?,`COURSE_DATE`=?,`COURSE_START_DATE`=?,`COURSE_END_DATE`=?,`LEAING_DATE`=?,`BACK_DATE`=?";
        if ("null-null-null".equals(leavingDate)) {
            leavingDate = null;
        }
        if ("null-null-null".equals(backDate)) {
            backDate = null;
        }
        String[] data = {tra_militaryid.getText(), tra_coursename.getText(), tra_courseid.getText(), corseDate, corseStartDate, corseEndDate, leavingDate, backDate};

        boolean militaryIdNotEmpty = FormValidation.textFieldNotEmpty(tra_militaryid, "ادخل الرقم العسكري");
        boolean corseNameNotEmpty = FormValidation.textFieldNotEmpty(tra_coursename, "ادخل مسمى الدورة");
        boolean corseIdNotEmpty = FormValidation.textFieldNotEmpty(tra_courseid, "ادخل رقم امر الدورة");

        if (militaryIdNotEmpty && corseNameNotEmpty && corseIdNotEmpty) {
            try {
                DataMng.updat(tableName, fieldName, data, "`MILITARYID`= '" + Militaryid + "' AND `COURSEID`= '" + courseID + "'");
                refreshTrainingtable();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void deleteTriningCourse(ActionEvent event) {
        try {
            DataMng.delete("training", "`MILITARYID` = '" + Militaryid + "' AND `CASE_DECREEID` = '" + courseID + "'");
            refreshTrainingtable();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addVacation(ActionEvent event) {
        String vacationDate = setDate(vac_vacation_decdate_day.getValue(), vac_vacation_decdate_month.getValue(), vac_vacation_decdate_year.getValue());
        String vacationStartDate = setDate(vac_vacation_startdate_day.getValue(), vac_vacation_startdate_month.getValue(), vac_vacation_startdate_year.getValue());
        String vacationEndDate = setDate(vac_vacation_enddate_day.getValue(), vac_vacation_enddate_month.getValue(), vac_vacation_enddate_year.getValue());

        String tableName = "vacation";
        String fieldName = "`MILITARYID`,`VACATION_ID`,`VACATION_DATE`,`VACATION_TYPE`,`VACATION_DURATION`,`VACATION_PLACE`,`VACATION_START_DATE`,`VACATION_END_DATE`";
        if ("null-null-null".equals(vacationEndDate)) {
            vacationEndDate = null;
        }

        String valuenumbers = "?,?,?,?,?,?,?,?";
        String[] data = {vac_militaryid.getText(), vac_vacation_decid.getText(), vacationDate, vac_vacationtype.getValue(), vac_vacation_duration.getText(), vac_vacation_place.getText(), vacationStartDate, vacationEndDate};

        boolean militaryIdNotEmpty = FormValidation.textFieldNotEmpty(vac_militaryid, "ادخل الرقم العسكري");
        boolean vacationTypeNotEmpty = FormValidation.comboBoxNotEmpty(vac_vacationtype, "ادخل مسمى الدورة");
        boolean vacationidNotEmpty = FormValidation.textFieldNotEmpty(vac_vacation_decid, "ادخل رقم امر الدورة");
        boolean vacationDurationNotEmpty = FormValidation.textFieldNotEmpty(vac_vacation_duration, "ادخل رقم امر الدورة");
        boolean vacationPlaceNotEmpty = FormValidation.textFieldNotEmpty(vac_vacation_place, "ادخل رقم امر الدورة");

        if (militaryIdNotEmpty && vacationTypeNotEmpty && vacationidNotEmpty && vacationDurationNotEmpty && vacationPlaceNotEmpty) {
            try {
                DataMng.insert(tableName, fieldName, valuenumbers, data);
                refreshVacationtable();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void updateVacation(ActionEvent event) {
        String vacationDate = setDate(vac_vacation_decdate_day.getValue(), vac_vacation_decdate_month.getValue(), vac_vacation_decdate_year.getValue());
        String vacationStartDate = setDate(vac_vacation_startdate_day.getValue(), vac_vacation_startdate_month.getValue(), vac_vacation_startdate_year.getValue());
        String vacationEndDate = setDate(vac_vacation_enddate_day.getValue(), vac_vacation_enddate_month.getValue(), vac_vacation_enddate_year.getValue());

        String tableName = "vacation";
        String fieldName = "`MILITARYID`=?,`VACATION_ID`=?,`VACATION_DATE`=?,`VACATION_TYPE`=?,`VACATION_DURATION`=?,`VACATION_PLACE`=?,`VACATION_START_DATE`=?,`VACATION_END_DATE`=?";
        if ("null-null-null".equals(vacationEndDate)) {
            vacationEndDate = null;
        }
        
        String[] data = {vac_militaryid.getText(), vac_vacation_decid.getText(), vacationDate, vac_vacationtype.getValue(), vac_vacation_duration.getText(), vac_vacation_place.getText(), vacationStartDate, vacationEndDate};

        boolean militaryIdNotEmpty = FormValidation.textFieldNotEmpty(vac_militaryid, "ادخل الرقم العسكري");
        boolean vacationTypeNotEmpty = FormValidation.comboBoxNotEmpty(vac_vacationtype, "ادخل مسمى الدورة");
        boolean vacationidNotEmpty = FormValidation.textFieldNotEmpty(vac_vacation_decid, "ادخل رقم امر الدورة");
        boolean vacationDurationNotEmpty = FormValidation.textFieldNotEmpty(vac_vacation_duration, "ادخل رقم امر الدورة");
        boolean vacationPlaceNotEmpty = FormValidation.textFieldNotEmpty(vac_vacation_place, "ادخل رقم امر الدورة");

        if (militaryIdNotEmpty && vacationTypeNotEmpty && vacationidNotEmpty && vacationDurationNotEmpty && vacationPlaceNotEmpty) {
            try {
                DataMng.updat(tableName, fieldName, data,"`VACATION_ID`='"+data[1]+"'");
                refreshVacationtable();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void deleteVacation(ActionEvent event) {
    }

    private void casesTableViewAll() {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select cases.MILITARYID,cases.CASE_TYPE,cases.CASE_DECREEID,cases.CASE_DECREE_DATE,cases.CASE_DECREE_FROM_DATE,cases.DECREE_TYPE,cases.CASE_STATE,cases.START_WORK_DATE,cases.CASE_DESCRIPTION, formation.NAME, formation.RANK from cases ,formation  where  cases.MILITARYID = formation.MILITARYID ");

            while (rs.next()) {
                sq++;
                caseslist.add(new CasesDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("CASE_TYPE"),
                        rs.getString("CASE_DECREEID"),
                        rs.getString("CASE_DECREE_DATE"),
                        rs.getString("CASE_DECREE_FROM_DATE"),
                        rs.getString("DECREE_TYPE"),
                        rs.getString("CASE_STATE"),
                        rs.getString("START_WORK_DATE"),
                        rs.getString("CASE_DESCRIPTION"),
                        sq
                ));

            }
            rs.close();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        for_cases_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("militaryid"));
        for_cases_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        for_cases_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        for_cases_casetype_col.setCellValueFactory(new PropertyValueFactory<>("caseType"));
        for_cases_decid_col.setCellValueFactory(new PropertyValueFactory<>("decreeId"));
        for_cases_decdate_col.setCellValueFactory(new PropertyValueFactory<>("decreeDate"));
        for_cases_casefromdate_col.setCellValueFactory(new PropertyValueFactory<>("caseFromDate"));
        for_cases_dectype_col.setCellValueFactory(new PropertyValueFactory<>("decreeType"));
        for_cases_casestate_col.setCellValueFactory(new PropertyValueFactory<>("caseState"));
        for_cases_startworkdate_col.setCellValueFactory(new PropertyValueFactory<>("startWorkDate"));
        for_cases_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        casesTableView.setItems(caseslist);
    }

    private void casesTableViewByMilitaryid(String militaryid) {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select cases.MILITARYID,cases.CASE_TYPE,cases.CASE_DECREEID,cases.CASE_DECREE_DATE,cases.CASE_DECREE_FROM_DATE,cases.DECREE_TYPE,cases.CASE_STATE,cases.START_WORK_DATE,cases.CASE_DESCRIPTION, formation.NAME, formation.RANK from cases ,formation  where  cases.MILITARYID = formation.MILITARYID AND cases.MILITARYID = '" + militaryid + "' ");
            while (rs.next()) {
                sq++;
                caseslist.add(new CasesDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("CASE_TYPE"),
                        rs.getString("CASE_DECREEID"),
                        rs.getString("CASE_DECREE_DATE"),
                        rs.getString("CASE_DECREE_FROM_DATE"),
                        rs.getString("DECREE_TYPE"),
                        rs.getString("CASE_STATE"),
                        rs.getString("START_WORK_DATE"),
                        rs.getString("CASE_DESCRIPTION"),
                        sq
                ));
            }
            rs.close();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        for_cases_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("militaryid"));
        for_cases_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        for_cases_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        for_cases_casetype_col.setCellValueFactory(new PropertyValueFactory<>("caseType"));
        for_cases_decid_col.setCellValueFactory(new PropertyValueFactory<>("decreeId"));
        for_cases_decdate_col.setCellValueFactory(new PropertyValueFactory<>("decreeDate"));
        for_cases_casefromdate_col.setCellValueFactory(new PropertyValueFactory<>("caseFromDate"));
        for_cases_dectype_col.setCellValueFactory(new PropertyValueFactory<>("decreeType"));
        for_cases_casestate_col.setCellValueFactory(new PropertyValueFactory<>("caseState"));
        for_cases_startworkdate_col.setCellValueFactory(new PropertyValueFactory<>("startWorkDate"));
        for_cases_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        casesTableView.setItems(caseslist);
    }

    @FXML
    private void recoveryData(ActionEvent event) {
        try {
            boolean chexkDataInserting = FormValidation.checkInsrtingData("transport_and_termination", "`MILITARYID`", "`MILITARYID` = '" + for_recovery.getText() + "'", "لا توجد بيانات");
            if (chexkDataInserting) {
                DataMng.insert("INSERT INTO `formation`(`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`EMPLOYMENTDATE`,`BIRTH_DATE`,`BIRTH_PLACE`,`SPECIALIZATION`,`UNIT_IN_FORCE`,`UNIT_BEFOR_FORCE`,`BANKNAME`,`IBANNUMBER`,`BLOODTYPE`,"
                        + "`DATE_OF_PROMOTION`,`DATE_OF_NEXT_PROMOTION`,`PASSPORTID`,`END_DATE_OFPASSPORT`,`MOBILENUMBER`,`MOBILENUMBER_OFCOUSIN`,`QUALIFICATION`,`NOTES`,`MILITARYTYPE`,`TRANSPORTID`,`TRANSPORTDATE`,\n"
                        + "`WORKSTARTINGDATE`) SELECT * FROM transport_and_termination where MILITARYID =?", for_recovery.getText());
                FormValidation.showAlert("", "تم استعادة البيانات بنجاح", Alert.AlertType.INFORMATION);
            }
            boolean checkDataRecovering = FormValidation.checkInsrtingData("formation", "`MILITARYID`", "`MILITARYID` = '" + for_recovery.getText() + "'", "لا توجد بيانات");
            if (checkDataRecovering) {
                DataMng.deleteEmployeeData("transport_and_termination", "`MILITARYID` = '" + for_recovery.getText() + "'");
                refreshOutTransportTables();
                refreshTerminationTable();
            }
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addTermination(ActionEvent event) {
        String decreeDate = setDate(for_termination_decree_day.getValue(), for_termination_decree_month.getValue(), for_termination_decree_year.getValue());
        String terminationFromDate = setDate(for_termination_from_day.getValue(), for_termination_from_month.getValue(), for_termination_from_year.getValue());
        String leavingDate = setDate(for_termination_leaving_day.getValue(), for_termination_leaving_month.getValue(), for_termination_leaving_year.getValue());

        String tableName = "tremination";
        String fieldName = "`MILITARYID`,`TERMINATION_REASON`,`TERMINATION_DECREEID`,`TERMINATION_DECREE_DATE`,`TERMINTION_FROM_DATE`,`LEAVING_DATE`";
        if ("null-null-null".equals(leavingDate)) {
            leavingDate = null;
        }
        String valuenumbers = "?,?,?,?,?,?";
        String[] data = {for_termination_militaryid.getText(), for_termination_reason.getText(), for_termination_decreeid.getText(), decreeDate, terminationFromDate, leavingDate};

        boolean militaryIdNoutEmpty = FormValidation.textFieldNotEmpty(for_termination_militaryid, "ادخل الرقم العسكري");
        boolean reasonNoutEmpty = FormValidation.textFieldNotEmpty(for_termination_reason, "ادخل سبب انهاء الخدمة");
        boolean decreeidNoutEmpty = FormValidation.textFieldNotEmpty(for_termination_decreeid, "ادخل رقم القرار");

        if (militaryIdNoutEmpty && reasonNoutEmpty && decreeidNoutEmpty) {
            try {
                DataMng.insert(tableName, fieldName, valuenumbers, data);
                DataMng.insert("INSERT INTO `transport_and_termination`(`MILITARYID`,`NAME`,`RANK`,`IDNAMBER`,`EMPLOYMENTDATE`,`BIRTH_DATE`,`BIRTH_PLACE`,`SPECIALIZATION`,`UNIT_IN_FORCE`,`UNIT_BEFOR_FORCE`,`BANKNAME`,`IBANNUMBER`,`BLOODTYPE`,"
                        + "`DATE_OF_PROMOTION`,`DATE_OF_NEXT_PROMOTION`,`PASSPORTID`,`END_DATE_OFPASSPORT`,`MOBILENUMBER`,`MOBILENUMBER_OFCOUSIN`,`QUALIFICATION`,`NOTES`,`MILITARYTYPE`,`TRANSPORTID`,`TRANSPORTDATE`,\n"
                        + "`WORKSTARTINGDATE`) SELECT * FROM hmsdatabase.formation where MILITARYID =?", for_termination_militaryid.getText());
                boolean chexkDataInserting = FormValidation.checkInsrtingData("transport_and_termination", "`MILITARYID`", "`MILITARYID` = '" + for_termination_militaryid.getText() + "'", "لم يتم نقل بياناته الي المنقولين والمكلفين");
                if (chexkDataInserting) {
                    DataMng.deleteEmployeeData("formation", "`MILITARYID` = '" + for_termination_militaryid.getText() + "'");
                    refreshOutTransportTables();
                    refreshTerminationTable();
                }
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void updateTermination(ActionEvent event) {
        String decreeDate = setDate(for_termination_decree_day.getValue(), for_termination_decree_month.getValue(), for_termination_decree_year.getValue());
        String terminationFromDate = setDate(for_termination_from_day.getValue(), for_termination_from_month.getValue(), for_termination_from_year.getValue());
        String leavingDate = setDate(for_termination_leaving_day.getValue(), for_termination_leaving_month.getValue(), for_termination_leaving_year.getValue());

        String tableName = "tremination";
        String fieldName = "`MILITARYID`=?,`TERMINATION_REASON`=?,`TERMINATION_DECREEID`=?,`TERMINATION_DECREE_DATE`=?,`TERMINTION_FROM_DATE`=?,`LEAVING_DATE`=?";
        if ("null-null-null".equals(leavingDate)) {
            leavingDate = null;
        }

        String[] data = {for_termination_militaryid.getText(), for_termination_reason.getText(), for_termination_decreeid.getText(), decreeDate, terminationFromDate, leavingDate};

        boolean militaryIdNoutEmpty = FormValidation.textFieldNotEmpty(for_termination_militaryid, "ادخل الرقم العسكري");
        boolean reasonNoutEmpty = FormValidation.textFieldNotEmpty(for_termination_reason, "ادخل سبب انهاء الخدمة");
        boolean decreeidNoutEmpty = FormValidation.textFieldNotEmpty(for_termination_decreeid, "ادخل رقم القرار");

        if (militaryIdNoutEmpty && reasonNoutEmpty && decreeidNoutEmpty) {
            try {
                DataMng.updat(tableName, fieldName, data, "`MILITARYID` = '" + Militaryid + "' AND `TERMINATION_DECREEID` = '" + decreeid + "'");
                refreshTerminationTable();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void deleteTermination(ActionEvent event) {
    }

    private void refreshTerminationTable() {
        terminationlist.clear();
        terminationTableView();
    }

    private void refreshTerminationTableByMilitaryid(String militaryid) {
        terminationlist.clear();
        terminationTableViewBymilitaryid(militaryid);
    }

    private void terminationTableView() {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select tremination.MILITARYID,tremination.TERMINATION_REASON,tremination.TERMINATION_DECREEID,tremination.TERMINATION_DECREE_DATE,"
                    + "tremination.TERMINTION_FROM_DATE,tremination.LEAVING_DATE, transport_and_termination.NAME, transport_and_termination.RANK from tremination ,transport_and_termination "
                    + " where  transport_and_termination.MILITARYID = tremination.MILITARYID ");
            while (rs.next()) {
                sq++;
                terminationlist.add(new TerminationDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("TERMINATION_REASON"),
                        rs.getString("TERMINATION_DECREEID"),
                        rs.getString("TERMINATION_DECREE_DATE"),
                        rs.getString("TERMINTION_FROM_DATE"),
                        rs.getString("LEAVING_DATE"),
                        sq
                ));
            }
            rs.close();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for_termination_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("militaryid"));
        for_termination_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        for_termination_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        for_termination_reason_col.setCellValueFactory(new PropertyValueFactory<>("reason"));
        for_termination_decreeid_col.setCellValueFactory(new PropertyValueFactory<>("decreeid"));
        for_termination_decreedate_col.setCellValueFactory(new PropertyValueFactory<>("decreeDate"));
        for_termination_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        for_termination_leavingdate_col.setCellValueFactory(new PropertyValueFactory<>("leavingDate"));
        for_termination_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        terminationView.setItems(terminationlist);
    }

    private void terminationTableViewBymilitaryid(String militaryid) {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select tremination.MILITARYID,tremination.TERMINATION_REASON,tremination.TERMINATION_DECREEID,tremination.TERMINATION_DECREE_DATE,"
                    + "tremination.TERMINTION_FROM_DATE,tremination.LEAVING_DATE, transport_and_termination.NAME, transport_and_termination.RANK from tremination ,transport_and_termination "
                    + " where  transport_and_termination.MILITARYID = tremination.MILITARYID AND tremination.MILITARYID = '" + militaryid + "' ");
            while (rs.next()) {
                sq++;
                terminationlist.add(new TerminationDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("TERMINATION_REASON"),
                        rs.getString("TERMINATION_DECREEID"),
                        rs.getString("TERMINATION_DECREE_DATE"),
                        rs.getString("TERMINTION_FROM_DATE"),
                        rs.getString("LEAVING_DATE"),
                        sq
                ));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for_termination_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("militaryid"));
        for_termination_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        for_termination_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        for_termination_reason_col.setCellValueFactory(new PropertyValueFactory<>("reason"));
        for_termination_decreeid_col.setCellValueFactory(new PropertyValueFactory<>("decreeid"));
        for_termination_decreedate_col.setCellValueFactory(new PropertyValueFactory<>("decreeDate"));
        for_termination_fromdate_col.setCellValueFactory(new PropertyValueFactory<>("fromDate"));
        for_termination_leavingdate_col.setCellValueFactory(new PropertyValueFactory<>("leavingDate"));
        for_termination_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        terminationView.setItems(terminationlist);
    }

    private void refreshTrainingtable() {
        traininglist.clear();
        trainingTableView();
    }

    private void trainingTableView() {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select training.MILITARYID,training.COURS_NAME,training.COURSEID,training.COURSE_DATE,"
                    + "training.COURSE_START_DATE,training.COURSE_END_DATE,training.LEAING_DATE,training.BACK_DATE, "
                    + "formation.NAME, formation.RANK from training ,formation where  training.MILITARYID = formation.MILITARYID ");
            while (rs.next()) {
                sq++;
                traininglist.add(new TrainingDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("COURS_NAME"),
                        rs.getString("COURSEID"),
                        rs.getString("COURSE_DATE"),
                        rs.getString("COURSE_START_DATE"),
                        rs.getString("COURSE_END_DATE"),
                        rs.getString("LEAING_DATE"),
                        rs.getString("BACK_DATE"),
                        sq
                ));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tra_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("militaryid"));
        tra_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        tra_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        tra_coursename_col.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tra_courseid_col.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        tra_coursedate_col.setCellValueFactory(new PropertyValueFactory<>("corseDate"));
        tra_corsestartdate_col.setCellValueFactory(new PropertyValueFactory<>("corseSartDate"));
        tra_courseenddate_col.setCellValueFactory(new PropertyValueFactory<>("corseEndDate"));
        tra_leavingdate_col.setCellValueFactory(new PropertyValueFactory<>("leavingDate"));
        tra_backdate_col.setCellValueFactory(new PropertyValueFactory<>("backDate"));
        tra_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        trainingTableView.setItems(traininglist);
    }

    @FXML
    private void triningOpenAction(MouseEvent event) {
    }

    @FXML
    private void creataNewVacation(ActionEvent event) {
    }

    @FXML
    private void printDecree(ActionEvent event) {
    }

    @FXML
    private void printVacationDecument(ActionEvent event) {
    }

    private void refreshVacationtable() {
        vacationlist.clear();
        vacationTableView();
    }

    private void refreshVacationtable(String militaryId) {
        vacationlist.clear();
        vacationTableViewByMilitaryID(militaryId);
    }

    private void vacationTableView() {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select vacation.MILITARYID,vacation.VACATION_ID,vacation.VACATION_DATE,vacation.VACATION_TYPE,"
                    + "vacation.VACATION_DURATION,vacation.VACATION_PLACE,vacation.VACATION_START_DATE,vacation.VACATION_END_DATE,"
                    + "formation.NAME, formation.RANK from vacation ,formation where  vacation.MILITARYID = formation.MILITARYID ");
            while (rs.next()) {
                sq++;
                vacationlist.add(new VacationDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("VACATION_TYPE"),
                        rs.getString("VACATION_ID"),
                        rs.getString("VACATION_DATE"),
                        rs.getString("VACATION_DURATION"),
                        rs.getString("VACATION_PLACE"),
                        rs.getString("VACATION_START_DATE"),
                        rs.getString("VACATION_END_DATE"),
                        sq
                ));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        vac_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("militaryid"));
        vac_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        vac_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        vac_vacationtype_col.setCellValueFactory(new PropertyValueFactory<>("vacationType"));
        vac_decid_col.setCellValueFactory(new PropertyValueFactory<>("vacationId"));
        vac_decdate_col.setCellValueFactory(new PropertyValueFactory<>("vacationDate"));
        vac_vacation_duration_col.setCellValueFactory(new PropertyValueFactory<>("vacationDuration"));
        vac_vaction_place_col.setCellValueFactory(new PropertyValueFactory<>("vacationPlace"));
        vac_vacation_startdate_col.setCellValueFactory(new PropertyValueFactory<>("vacationStartDate"));
        vac_vacation_enddate_col.setCellValueFactory(new PropertyValueFactory<>("vacationEndDate"));
        vac_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        vacationTableView.setItems(vacationlist);
    }

    private void vacationTableViewByMilitaryID(String militaryid) {
        int sq = 0;
        try {
            ResultSet rs = DataMng.getDataJoinTable("select vacation.MILITARYID,vacation.VACATION_ID,vacation.VACATION_DATE,vacation.VACATION_TYPE,"
                    + "vacation.VACATION_DURATION,vacation.VACATION_PLACE,vacation.VACATION_START_DATE,vacation.VACATION_END_DATE,"
                    + "formation.NAME, formation.RANK from vacation ,formation where  vacation.MILITARYID = formation.MILITARYID AND MILITARYID = '" + militaryid + "' ");
            while (rs.next()) {
                sq++;
                vacationlist.add(new VacationDataModel(
                        rs.getString("MILITARYID"),
                        rs.getString("RANK"),
                        rs.getString("NAME"),
                        rs.getString("VACATION_TYPE"),
                        rs.getString("VACATION_ID"),
                        rs.getString("VACATION_DATE"),
                        rs.getString("VACATION_DURATION"),
                        rs.getString("VACATION_PLACE"),
                        rs.getString("VACATION_START_DATE"),
                        rs.getString("VACATION_END_DATE"),
                        sq
                ));
            }
            rs.close();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        vac_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("militaryid"));
        vac_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        vac_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        vac_vacationtype_col.setCellValueFactory(new PropertyValueFactory<>("vacationType"));
        vac_decid_col.setCellValueFactory(new PropertyValueFactory<>("vacationId"));
        vac_decdate_col.setCellValueFactory(new PropertyValueFactory<>("vacationDate"));
        vac_vacation_duration_col.setCellValueFactory(new PropertyValueFactory<>("vacationDuration"));
        vac_vaction_place_col.setCellValueFactory(new PropertyValueFactory<>("vacationPlace"));
        vac_vacation_startdate_col.setCellValueFactory(new PropertyValueFactory<>("vacationStartDate"));
        vac_vacation_enddate_col.setCellValueFactory(new PropertyValueFactory<>("vacationEndDate"));
        vac_sq_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        vacationTableView.setItems(vacationlist);
    }

    public class ChackAll extends Thread {

        String militaryType;

        public ChackAll(String militaryType) {
            this.militaryType = militaryType;
        }

        @Override
        public void run() {
            checkAllData(militaryType);
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
            DataMng.delete("DELETE `mandatelists`, `nameslist`,`excluded`,`exclusionmessage` FROM `mandatelists`, `nameslist`, excluded, exclusionmessage "
                    + "WHERE `exclusionmessage`.`LISTNUMBER` = `nameslist`.`LISTNUMBER` AND `excluded`.`LISTNUMBER` = `nameslist`.`LISTNUMBER` "
                    + "AND `mandatelists`.`LISTNUMBER` = `nameslist`.`LISTNUMBER` AND `mandatelists`.`LISTNUMBER` = '" + ch_list_combobox.getValue() + "'");
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
    }

    @FXML
    private void chClearFiled(ActionEvent event) {
        chacktablelist.clear();
        ch_enfrom.setText("");
        ch_ento.setText("");
        ch_en_fromdateday.setValue("");
        ch_en_fromdatemonth.setValue("");
        ch_en_fromdateyear.setValue("");
        ch_en_todateday.setValue("");
        ch_en_todatemonth.setValue("");
        ch_en_todateyear.setValue("");
        ch_list_combobox.setValue("");
    }

    private void chackTableViewData() {
        try {
            ResultSet rs = DataMng.getDataJoinTable("SELECT formation.RANK ,formation.NAME, nameslist.MILITARYID, nameslist.ENFROM , nameslist.ENTO ,nameslist.ENDATEFROM,nameslist.ENDATETO,"
                    + "mandate_balance.BALANCE FROM  formation,nameslist,mandate_balance WHERE formation.MILITARYID = nameslist.MILITARYID AND "
                    + "formation.MILITARYID = mandate_balance.MILITARYID AND formation.MILITARYID = '" + ch_mailitraynum.getText() + "' ");
            int sq = 0;
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
                        rs.getString("BALANCE"),
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
        ch_en_balance_col.setCellValueFactory(new PropertyValueFactory<>("balance"));
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
            ResultSet rs = DataMng.getDataJoinTable("SELECT formation.MILITARYID,formation.RANK,formation.NAME,nameslist.LISTNUMBER "
                    + "FROM mandate,nameslist,formation WHERE  mandate.ENNAMELISTNUMBER = nameslist.LISTNUMBER AND"
                    + " nameslist.MILITARYID = formation.MILITARYID AND mandate.ORDERID = '" + mandate_dec_orderid.getText() + "'AND nameslist.DECISIONSTATUS='false'");
            int sq = 0;
            while (rs.next()) {
                sq++;
                no_declist.add(new NamesDataModel(
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
        no_dec_militaryid_col.setCellValueFactory(new PropertyValueFactory<>("fo_militaryid"));
        no_dec_rank_col.setCellValueFactory(new PropertyValueFactory<>("rank"));
        no_dec_name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        no_dec_sequence_col.setCellValueFactory(new PropertyValueFactory<>("sq"));

        no_dec_table.setItems(no_declist);
    }

    private void namesWithDcTableViewData() {
        try {
            ResultSet rs = DataMng.getDataJoinTable("SELECT formation.MILITARYID,formation.RANK,formation.NAME,nameslist.LISTNUMBER "
                    + "FROM mandate,nameslist,formation WHERE  mandate.ENNAMELISTNUMBER = nameslist.LISTNUMBER AND "
                    + "nameslist.MILITARYID = formation.MILITARYID AND mandate.ORDERID = '" + mandate_dec_orderid.getText() + "'AND nameslist.DECISIONSTATUS='true'");
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
            ResultSet rs = DataMng.getDataJoinTable("select nameslist.MILITARYID,nameslist.ENDATEFROM,nameslist.ENDATETO,nameslist.ENFROM,nameslist.ENTO, "
                    + "formation.NAME, formation.RANK, mandate_balance.BALANCE from nameslist ,formation,mandate_balance "
                    + " where  nameslist.MILITARYID = formation.MILITARYID  AND mandate_balance.MILITARYID = formation.MILITARYID AND nameslist.LISTNUMBER ='" + listnumber.getText() + "'");
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
                        rs.getString("BALANCE"),
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
        ch_en_balance_col.setCellValueFactory(new PropertyValueFactory<>("balance"));
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
            ResultSet rs = DataMng.getDataJoinTable("select transport.MILITARYID ,transport.NEWUNIT,transport.TRANSPORTID,transport.TRANSPORTDATE,transport.TRANSPORTFROMDATE,transport.LEAVINGID,transport.LEAVINGDATE,transport.LEAVINGFROMDATE, transport_and_termination.NAME, transport_and_termination.RANK from transport ,transport_and_termination  where  transport.MILITARYID = transport_and_termination.MILITARYID  AND transport.TRANSPORTTYPE ='خارجي'");
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
            ResultSet rs = DataMng.getDataJoinTable("select nameslist.MILITARYID,nameslist.ENDATEFROM,nameslist.ENDATETO,nameslist.ENFROM,nameslist.ENTO, "
                    + "formation.NAME, formation.RANK, mandate_balance.BALANCE from nameslist ,formation,mandate_balance "
                    + " where  nameslist.MILITARYID = formation.MILITARYID  AND mandate_balance.MILITARYID = formation.MILITARYID AND nameslist.LISTNUMBER ='" + listnum + "'");
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
                            rs.getString("BALANCE"),
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
            ch_en_balance_col.setCellValueFactory(new PropertyValueFactory<>("balance"));
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

    private void dateOfCombobox(ComboBox com, ObservableList list) {
        com.setItems(list);
    }

    public static String plucDays(String year, String month, String day, int addedDays) {
        String returnDate = null;
        HijrahDate date = HijrahChronology.INSTANCE.date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        int monthLength = date.lengthOfMonth();
        String gdate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String[] parts = gdate.split("-");
        date.getEra();
        int intday = Integer.parseInt(parts[0]);
        int intmonth = Integer.parseInt(parts[1]);
        int intyear = Integer.parseInt(parts[2]);
        int diff = monthLength - intday;
        if (addedDays < 30) {
            if (diff < addedDays) {
                intday = addedDays - diff;
                intmonth++;
            } else {
                intday = intday + addedDays;
            }
        } else if (addedDays > 30 && addedDays < 360) {
            int themonth = addedDays / 30;
            int theday = themonth * 30;
            theday = addedDays - theday;
            intmonth = intmonth + themonth;
            intday = intday + theday;
        } else {
            int theyear = addedDays / 360;
            int themonth = theyear * 360;
            themonth = addedDays - themonth;
            addedDays = themonth;
            themonth = themonth / 30;
            int theday = themonth * 30;
            theday = addedDays - theday;
            intmonth = intmonth + themonth;
            intday = intday + theday;
            intyear = intyear + theyear;
        }
        returnDate = Integer.toString(intyear) + "-" + Integer.toString(intmonth) + "-" + Integer.toString(intday);
        return returnDate;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PlaceOfAssignment.setItems(list1);
        militarytayp.setItems(list2);
        entayp.setItems(list3);

        dateOfCombobox(orderdateday, fillDays(daylist), "day");
        dateOfCombobox(orderdatemonth, fillMonth(monthlist), "month");
        dateOfCombobox(orderdateyear, fillYare(yearlist), "year");

        dateOfCombobox(fromDateday, fillDays(daylist));
        dateOfCombobox(fromDatemonth, fillMonth(monthlist));
        dateOfCombobox(fromDateyear, fillYare(yearlist));

        dateOfCombobox(toDateday, fillDays(daylist));
        dateOfCombobox(toDatemonth, fillMonth(monthlist));
        dateOfCombobox(toDateyear, fillYare(yearlist));

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

        dateOfCombobox(mandate_ch_dec_today, fillDays(daylist));
        dateOfCombobox(mandate_ch_dec_tomonth, fillMonth(monthlist));
        dateOfCombobox(mandate_ch_dec_toyear, fillYare(yearlist));

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

        dateOfCombobox(for_cases_decdate_day, fillDays(daylist), "day");
        dateOfCombobox(for_cases_decdate_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_cases_decdate_year, fillYare(yearlist), "year");

        dateOfCombobox(for_cases_decdatefrom_day, fillDays(daylist), "day");
        dateOfCombobox(for_cases_decdatefrom_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_cases_decdatefrom_year, fillYare(yearlist), "year");

        dateOfCombobox(for_cases_startwork_day, fillDays(daylist));
        dateOfCombobox(for_cases_startwork_month, fillMonth(monthlist));
        dateOfCombobox(for_cases_startwork_year, fillYare(yearlist));

        dateOfCombobox(for_termination_decree_day, fillDays(daylist), "day");
        dateOfCombobox(for_termination_decree_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_termination_decree_year, fillYare(yearlist), "year");

        dateOfCombobox(for_termination_from_day, fillDays(daylist), "day");
        dateOfCombobox(for_termination_from_month, fillMonth(monthlist), "month");
        dateOfCombobox(for_termination_from_year, fillYare(yearlist), "year");

        dateOfCombobox(for_termination_leaving_day, fillDays(daylist));
        dateOfCombobox(for_termination_leaving_month, fillMonth(monthlist));
        dateOfCombobox(for_termination_leaving_year, fillYare(yearlist));

        dateOfCombobox(tra_coursedate_day, fillDays(daylist), "day");
        dateOfCombobox(tra_coursedate_month, fillMonth(monthlist), "month");
        dateOfCombobox(tra_coursedate_year, fillYare(yearlist), "year");

        dateOfCombobox(tra_leavingdate_day, fillDays(daylist));
        dateOfCombobox(tra_leavingdate_month, fillMonth(monthlist));
        dateOfCombobox(tra_leavingdate_year, fillYare(yearlist));

        dateOfCombobox(tra_backdate_day, fillDays(daylist));
        dateOfCombobox(tra_backdate_month, fillMonth(monthlist));
        dateOfCombobox(tra_backdate_year, fillYare(yearlist));

        dateOfCombobox(tra_coursestartdate_day, fillDays(daylist), "day");
        dateOfCombobox(tra_coursestartdate_month, fillMonth(monthlist), "month");
        dateOfCombobox(tra_coursestartdate_year, fillYare(yearlist), "year");

        dateOfCombobox(tra_courseenddate_day, fillDays(daylist), "day");
        dateOfCombobox(tra_courseenddate_month, fillMonth(monthlist), "month");
        dateOfCombobox(tra_courseenddate_year, fillYare(yearlist), "year");

        dateOfCombobox(vac_vacation_decdate_day, fillDays(daylist), "day");
        dateOfCombobox(vac_vacation_decdate_month, fillMonth(monthlist), "month");
        dateOfCombobox(vac_vacation_decdate_year, fillYare(yearlist), "year");

        dateOfCombobox(vac_vacation_startdate_day, fillDays(daylist), "day");
        dateOfCombobox(vac_vacation_startdate_month, fillMonth(monthlist), "month");
        dateOfCombobox(vac_vacation_startdate_year, fillYare(yearlist), "year");

        dateOfCombobox(vac_vacation_enddate_day, fillDays(daylist));
        dateOfCombobox(vac_vacation_enddate_month, fillMonth(monthlist));
        dateOfCombobox(vac_vacation_enddate_year, fillYare(yearlist));

        refreshListCombobox(fillListCombobox(ch_comboBoxlist));
        enTableViewData();
        mainePageOpenAction();
        refreshInTransportTables();
        refreshOutTransportTables();
        refreshCasestable();
        refreshTerminationTable();

        for_militarytayp.setItems(list2);
        for_qualification.setItems(qualificationlist);
        for_rank.setItems(ranklist);
        for_speclaization.setItems(setSpecializListCombobox(specialiazList));
        for_unitinforce.setItems(setUnitListCombobox(unitNameList));
        for_bloodtype.setItems(bloodTypeList);
        for_intra_newunit.setItems(setUnitListCombobox(unitNameList));
        for_cases_casetype.setItems(caseTypeList);
        for_cases_dectype.setItems(decreeTypeList);
        vac_vacationtype.setItems(vacationTypeList);

        addhint.setTooltip(new Tooltip("اضافة طلب انتداب"));
        chackingdata.setTooltip(new Tooltip("تدقيق البيانات"));
        en_update.setTooltip(new Tooltip("تحديث البيانات"));
        en_search.setTooltip(new Tooltip("البحث واستعراض البيانات"));

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
                try {
                    refreshEnChackTable();
                    ResultSet rs = DataMng.getDataWithCondition("nameslist", "`ENFROM`,`ENTO`,`ENDATEFROM`,`ENDATETO`", "`LISTNUMBER` = '" + ch_list_combobox.getValue() + "'");
                    if (rs.next()) {
                        ch_enfrom.setText(rs.getString("ENFROM"));
                        ch_ento.setText(rs.getString("ENTO"));

                        ch_en_fromdateday.setValue(getDay(rs.getString("ENDATEFROM")));
                        ch_en_fromdatemonth.setValue(getMonth(rs.getString("ENDATEFROM")));
                        ch_en_fromdateyear.setValue(getYear(rs.getString("ENDATEFROM")));

                        ch_en_todateday.setValue(getDay(rs.getString("ENDATETO")));
                        ch_en_todatemonth.setValue(getMonth(rs.getString("ENDATETO")));
                        ch_en_todateyear.setValue(getYear(rs.getString("ENDATETO")));
                    }
                    chackTableListView(ch_list_combobox.getValue());
                    listnumber.setText(ch_list_combobox.getValue());
                    ch_mailitraynum.setDisable(false);
                    ch_en_button.setDisable(false);
                    ch_en_allsoldiers.setDisable(false);
                    ch_en_allofficers.setDisable(false);
                } catch (IOException | SQLException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                getFormaitionDatabyMilitryid("formation", for_militaryid.getText());
            }
        });
        for_recovery.setOnKeyReleased(new EventHandler() {
            @Override
            public void handle(Event event) {
                getFormaitionDatabyMilitryid("transport_and_termination", for_recovery.getText());
            }
        });
        for_cases_militaryid.setOnKeyReleased(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (for_cases_militaryid.getText() == null || for_cases_militaryid.getText().equals("")) {
                    refreshCasestable();
                } else {
                    refreshCasestableByMilitaryid(for_cases_militaryid.getText());
                }
            }
        });
        for_termination_militaryid.setOnKeyReleased(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (for_termination_militaryid.getText() == null || for_termination_militaryid.getText().equals("")) {
                    refreshTerminationTable();
                } else {
                    refreshTerminationTableByMilitaryid(for_termination_militaryid.getText());
                }
            }
        });

        mandate_ch_number_of_nights.setOnKeyReleased(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (null == mandate_ch_number_of_nights.getText() || mandate_ch_number_of_nights.getText().equals("")) {
                } else {
                    mandate_ch_dec_today.setDisable(false);
                    mandate_ch_dec_tomonth.setDisable(false);
                    mandate_ch_dec_toyear.setDisable(false);
                    String dectoDate = plucDays(mandate_ch_dec_fromyear.getValue(), mandate_ch_dec_frommonth.getValue(), mandate_ch_dec_fromday.getValue(), Integer.parseInt(mandate_ch_number_of_nights.getText()));
                    mandate_ch_dec_today.setValue(getDay(dectoDate));
                    mandate_ch_dec_tomonth.setValue(getMonth(dectoDate));
                    mandate_ch_dec_toyear.setValue(getYear(dectoDate));
                }
            }
        });
        ennamelist.setOnKeyReleased(new EventHandler() {
            @Override
            public void handle(Event event) {
                getDataByListNumber("nameslist", ennamelist.getText());
            }
        });

        for_cases_casetype.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if ("قضية جنائية".equals(for_cases_casetype.getValue()) || "ثبوت اجابية".equals(for_cases_casetype.getValue())) {
                    for_cases_dectype.setDisable(false);
                } else {
                    for_cases_dectype.setDisable(true);
                }
            }
        });

        transportView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<TransportDataModel> list = FXCollections.observableArrayList();
                list = transportView.getSelectionModel().getSelectedItems();
                if (list.isEmpty()) {
                    FormValidation.showAlert("", "لاتوجد بيانات");
                } else {
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
            }
        });

        outTransportView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<TransportDataModel> outlist = FXCollections.observableArrayList();
                outlist = outTransportView.getSelectionModel().getSelectedItems();
                if (outlist.isEmpty()) {
                    FormValidation.showAlert("", "لاتوجد بيانات");
                } else {
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
                    Militaryid = outlist.get(0).getMilitaryid();
                    outTransPortId = outlist.get(0).getTransportid();
                }
            }
        });

        casesTableView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<CasesDataModel> outlist = FXCollections.observableArrayList();
                outlist = casesTableView.getSelectionModel().getSelectedItems();
                if (outlist.isEmpty()) {
                    FormValidation.showAlert("", "لاتوجد بيانات");
                } else {
                    for_cases_militaryid.setText(outlist.get(0).getMilitaryid());
                    for_cases_casetype.setValue(outlist.get(0).getCaseType());
                    for_cases_dec_id.setText(outlist.get(0).getDecreeId());
                    for_cases_decdate_day.setValue(getDay(outlist.get(0).getDecreeDate()));
                    for_cases_decdate_month.setValue(getMonth(outlist.get(0).getDecreeDate()));
                    for_cases_decdate_year.setValue(getYear(outlist.get(0).getDecreeDate()));
                    for_cases_decdatefrom_day.setValue(getDay(outlist.get(0).getCaseFromDate()));
                    for_cases_decdatefrom_month.setValue(getMonth(outlist.get(0).getCaseFromDate()));
                    for_cases_decdatefrom_year.setValue(getYear(outlist.get(0).getCaseFromDate()));
                    for_cases_startwork_day.setValue(getDay(outlist.get(0).getStartWorkDate()));
                    for_cases_startwork_month.setValue(getMonth(outlist.get(0).getStartWorkDate()));
                    for_cases_startwork_year.setValue(getYear(outlist.get(0).getStartWorkDate()));
                    for_cases_dectype.setValue(outlist.get(0).getDecreeType());
                    for_cases_casestate.setText(outlist.get(0).getCaseState());
                    for_cases_casedescription.setText(outlist.get(0).getCaseDescription());
                    Militaryid = outlist.get(0).getMilitaryid();
                    caseDecerrID = outlist.get(0).getDecreeId();
                }
            }
        });

        terminationView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<TerminationDataModel> outlist = FXCollections.observableArrayList();
                outlist = terminationView.getSelectionModel().getSelectedItems();
                if (outlist.isEmpty()) {
                    FormValidation.showAlert("", "لاتوجد بيانات");
                } else {
                    for_termination_militaryid.setText(outlist.get(0).getMilitaryid());
                    for_termination_reason.setText(outlist.get(0).getReason());
                    for_termination_decreeid.setText(outlist.get(0).getDecreeid());

                    for_termination_decree_day.setValue(getDay(outlist.get(0).getDecreeDate()));
                    for_termination_decree_month.setValue(getMonth(outlist.get(0).getDecreeDate()));
                    for_termination_decree_year.setValue(getYear(outlist.get(0).getDecreeDate()));

                    for_termination_from_day.setValue(getDay(outlist.get(0).getFromDate()));
                    for_termination_from_month.setValue(getMonth(outlist.get(0).getFromDate()));
                    for_termination_from_year.setValue(getYear(outlist.get(0).getFromDate()));

                    for_termination_leaving_day.setValue(getDay(outlist.get(0).getLeavingDate()));
                    for_termination_leaving_month.setValue(getMonth(outlist.get(0).getLeavingDate()));
                    for_termination_leaving_year.setValue(getYear(outlist.get(0).getLeavingDate()));

                    Militaryid = outlist.get(0).getMilitaryid();
                    decreeid = outlist.get(0).getDecreeid();
                }
            }
        });

        trainingTableView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<TrainingDataModel> outlist = FXCollections.observableArrayList();
                outlist = trainingTableView.getSelectionModel().getSelectedItems();
                if (outlist.isEmpty()) {
                    FormValidation.showAlert("", "لاتوجد بيانات");
                } else {
                    tra_militaryid.setText(outlist.get(0).getMilitaryid());
                    tra_coursename.setText(outlist.get(0).getCourseName());
                    tra_courseid.setText(outlist.get(0).getCourseId());

                    tra_coursedate_day.setValue(getDay(outlist.get(0).getCorseDate()));
                    tra_coursedate_month.setValue(getMonth(outlist.get(0).getBackDate()));
                    tra_coursedate_year.setValue(getYear(outlist.get(0).getBackDate()));

                    tra_coursestartdate_day.setValue(getDay(outlist.get(0).getCorseSartDate()));
                    tra_coursestartdate_month.setValue(getMonth(outlist.get(0).getCorseSartDate()));
                    tra_coursestartdate_year.setValue(getYear(outlist.get(0).getCorseSartDate()));

                    tra_courseenddate_day.setValue(getDay(outlist.get(0).getCorseEndDate()));
                    tra_courseenddate_month.setValue(getMonth(outlist.get(0).getCorseEndDate()));
                    tra_courseenddate_year.setValue(getYear(outlist.get(0).getCorseEndDate()));

                    tra_leavingdate_day.setValue(getDay(outlist.get(0).getLeavingDate()));
                    tra_leavingdate_month.setValue(getMonth(outlist.get(0).getLeavingDate()));
                    tra_leavingdate_year.setValue(getYear(outlist.get(0).getLeavingDate()));

                    tra_backdate_day.setValue(getDay(outlist.get(0).getBackDate()));
                    tra_backdate_month.setValue(getMonth(outlist.get(0).getBackDate()));
                    tra_backdate_year.setValue(getYear(outlist.get(0).getBackDate()));

                    Militaryid = outlist.get(0).getMilitaryid();
                    courseID = outlist.get(0).getCourseId();
                }
            }
        });

        vacationTableView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<VacationDataModel> outlist = FXCollections.observableArrayList();
                outlist = vacationTableView.getSelectionModel().getSelectedItems();
                if (outlist.isEmpty()) {
                    FormValidation.showAlert("", "لاتوجد بيانات");
                } else {
                    vac_militaryid.setText(outlist.get(0).getMilitaryid());
                    vac_vacationtype.setValue(outlist.get(0).getVacationType());
                    vac_vacation_decid.setText(outlist.get(0).getVacationId());

                    vac_vacation_decdate_day.setValue(getDay(outlist.get(0).getVacationDate()));
                    vac_vacation_decdate_month.setValue(getMonth(outlist.get(0).getVacationDate()));
                    vac_vacation_decdate_year.setValue(getYear(outlist.get(0).getVacationDate()));

                    vac_vacation_duration.setText(outlist.get(0).getVacationDuration());
                    vac_vacation_place.setText(outlist.get(0).getVacationPlace());

                    vac_vacation_startdate_day.setValue(getDay(outlist.get(0).getVacationStartDate()));
                    vac_vacation_startdate_month.setValue(getMonth(outlist.get(0).getVacationStartDate()));
                    vac_vacation_startdate_year.setValue(getYear(outlist.get(0).getVacationStartDate()));

                    vac_vacation_enddate_day.setValue(getDay(outlist.get(0).getVacationEndDate()));
                    vac_vacation_enddate_month.setValue(getMonth(outlist.get(0).getVacationEndDate()));
                    vac_vacation_enddate_year.setValue(getYear(outlist.get(0).getVacationEndDate()));

                    Militaryid = outlist.get(0).getMilitaryid();
                    vacationID = outlist.get(0).getVacationId();
                }
            }
        });

        en_table.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                ObservableList<EnDataModel> list = FXCollections.observableArrayList();
                list = en_table.getSelectionModel().getSelectedItems();
                if (list.isEmpty()) {
                    FormValidation.showAlert("", "لاتوجد بيانات");
                } else {
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
            }
        });
    }

}
