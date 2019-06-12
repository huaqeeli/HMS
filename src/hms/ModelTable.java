package hms;

public class ModelTable {

    String orderid,orderdate, enfrom, ento, endatefrom, endateto, enplase, militarytype, entype;

    public ModelTable(String orderid, String orderdate, String enfrom, String ento, String endatefrom, String endateto, String enplase, String militarytype, String entype) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.enfrom = enfrom;
        this.ento = ento;
        this.endatefrom = endatefrom;
        this.endateto = endateto;
        this.enplase = enplase;
        this.militarytype = militarytype;
        this.entype = entype;
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

    public void setEnfrom(String enfrom) {
        this.enfrom = enfrom;
    }

    public String getEnto() {
        return ento;
    }

    public void setEnto(String ento) {
        this.ento = ento;
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

}
