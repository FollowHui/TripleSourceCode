package Dao.model;

import java.util.List;

public class SchoolInformation {
    private Integer schoolid;

    private String schoolname;

    private String address;

    private Integer continent;

    private String offercondition;

    private String hotclass;

    private String settime;

    private String website;

    private String classset;

    private String tuition;

    private Double score;

    private Integer ranking;

    private String phonenumber;

    private String emailaddress;

    private String schoollogo;

    private String description;

    private List<DataSet> dataSets;
    public void setDataSets(List<DataSet> dataSets){
        this.dataSets=dataSets;
    }
    public List<DataSet> getDataSets(){
        return dataSets;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getContinent() {
        return continent;
    }

    public void setContinent(Integer continent) {
        this.continent = continent;
    }

    public String getOffercondition() {
        return offercondition;
    }

    public void setOffercondition(String offercondition) {
        this.offercondition = offercondition == null ? null : offercondition.trim();
    }

    public String getHotclass() {
        return hotclass;
    }

    public void setHotclass(String hotclass) {
        this.hotclass = hotclass == null ? null : hotclass.trim();
    }

    public String getSettime() {
        return settime;
    }

    public void setSettime(String settime) {
        this.settime = settime == null ? null : settime.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getClassset() {
        return classset;
    }

    public void setClassset(String classset) {
        this.classset = classset == null ? null : classset.trim();
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition == null ? null : tuition.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress == null ? null : emailaddress.trim();
    }

    public String getSchoollogo() {
        return schoollogo;
    }

    public void setSchoollogo(String schoollogo) {
        this.schoollogo = schoollogo == null ? null : schoollogo.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}