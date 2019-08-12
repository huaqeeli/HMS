package hms.models;

import static hms.FXMLDocumentController.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


public class EnDataModel {

    String orderid, orderdate, enfrom, ento, endatefrom, endateto, enplase, militarytype, entype;
    int sq ;
//    Button updateBut;
//    Button deletBut;
//
//    ImageView update = new ImageView("images/editeicon.png");
//    ImageView delete = new ImageView("images/deleteicon.png");

    public EnDataModel(String orderid, String orderdate, String enfrom, String ento, String endatefrom, String endateto, String enplase, String militarytype, String entype,int sq) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.enfrom = enfrom;
        this.ento = ento;
        this.endatefrom = endatefrom;
        this.endateto = endateto;
        this.enplase = enplase;
        this.militarytype = militarytype;
        this.entype = entype;
        this.sq = sq;
//        this.updateBut = new Button();
//        this.deletBut = new Button();
//
//        updateBut.setOnAction(e -> {
//           
////            en_editPage.setVisible(true);
//        });
//
//        updateBut.setGraphic(update);
//        updateBut.setStyle("-fx-background-color: #5B6B71;");
//
//        deletBut.setOnAction(e -> {
//            System.out.print("delete");
//
//        });
//
//        deletBut.setGraphic(delete);
//        deletBut.setStyle("-fx-background-color: #5B6B71;");
    }

    public int getSq() {
        return sq;
    }

    public void setSq(int sq) {
        this.sq = sq;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getEnfrom() {
        return enfrom;
    }

    public String getEnto() {
        return ento;
    }

    public void setEnto(String ento) {
        this.ento = ento;
    }

    public void setEnfrom(String enfrom) {
        this.enfrom = enfrom;
    }

    public String getEndatefrom() {
        return endatefrom;
    }

    public void setEndatefrom(String endatefrom) {
        this.endatefrom = endatefrom;
    }

    public String getEndateto() {
        return endateto;
    }

    public void setEndateto(String endateto) {
        this.endateto = endateto;
    }

    public String getEnplase() {
        return enplase;
    }

    public void setEnplase(String enplase) {
        this.enplase = enplase;
    }

    public String getMilitarytype() {
        return militarytype;
    }

    public void setMilitarytype(String militarytype) {
        this.militarytype = militarytype;
    }

    public String getEntype() {
        return entype;
    }

    public void setEntype(String entype) {
        this.entype = entype;
    }

//    public Button getUpdateBut() {
//        return updateBut;
//    }
//
//    public void setUpdateBut(Button updateBut) {
//        this.updateBut = updateBut;
//    }
//
//    public Button getDeletBut() {
//        return deletBut;
//    }
//
//    public void setDeletBut(Button deletBut) {
//        this.deletBut = deletBut;
//    }

}
