package Dao.model;

public class DataSet {
    private Integer dataid;

    private Integer datatype;

    private Integer apptime;

    private Integer graschool;

    private String grapro;

    private Double gpa;

    private Double grereal;

    private Double tofelreal;

    private Integer appschool;

    private String apppro;

    private Integer iscom;

    private Integer ispaper;

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }

    public Integer getApptime() {
        return apptime;
    }

    public void setApptime(Integer apptime) {
        this.apptime = apptime;
    }

    public Integer getGraschool() {
        return graschool;
    }

    public void setGraschool(Integer graschool) {
        this.graschool = graschool;
    }

    public String getGrapro() {
        return grapro;
    }

    public void setGrapro(String grapro) {
        this.grapro = grapro == null ? null : grapro.trim();
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Double getGrereal() {
        return grereal;
    }

    public void setGrereal(Double grereal) {
        this.grereal = grereal;
    }

    public Double getTofelreal() {
        return tofelreal;
    }

    public void setTofelreal(Double tofelreal) {
        this.tofelreal = tofelreal;
    }

    public Integer getAppschool() {
        return appschool;
    }

    public void setAppschool(Integer appschool) {
        this.appschool = appschool;
    }

    public String getApppro() {
        return apppro;
    }

    public void setApppro(String apppro) {
        this.apppro = apppro == null ? null : apppro.trim();
    }

    public Integer getIscom() {
        return iscom;
    }

    public void setIscom(Integer iscom) {
        this.iscom = iscom;
    }

    public Integer getIspaper() {
        return ispaper;
    }

    public void setIspaper(Integer ispaper) {
        this.ispaper = ispaper;
    }
}