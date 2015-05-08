package Dao.model;

public class SchoolChinese {
    private Integer schoolid;

    private String schoolname;

    private Integer schooltype;

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

    public Integer getSchooltype() {
        return schooltype;
    }

    public void setSchooltype(Integer schooltype) {
        this.schooltype = schooltype;
    }

}