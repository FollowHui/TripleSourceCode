package Dao.model;

public class DataSet {
    private Integer dataid;

    private String student;

    private String school;

    private String major;

    private String undergraduate;

    private Double gpa;

    private Double tofel;

    private Double gre;

    private Integer paper;

    private Integer promotion;

    private Integer time;

    private String country;

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student == null ? null : student.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getUndergraduate() {
        return undergraduate;
    }

    public void setUndergraduate(String undergraduate) {
        this.undergraduate = undergraduate == null ? null : undergraduate.trim();
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Double getTofel() {
        return tofel;
    }

    public void setTofel(Double tofel) {
        this.tofel = tofel;
    }

    public Double getGre() {
        return gre;
    }

    public void setGre(Double gre) {
        this.gre = gre;
    }

    public Integer getPaper() {
        return paper;
    }

    public void setPaper(Integer paper) {
        this.paper = paper;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time ;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }
}