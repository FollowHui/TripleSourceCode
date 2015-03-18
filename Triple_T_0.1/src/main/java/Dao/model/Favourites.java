package Dao.model;

public class Favourites {
    private Integer collectid;

    private Boolean collecttype;

    private Integer schoolid;

    private Integer userid;

    public Integer getCollectid() {
        return collectid;
    }

    public void setCollectid(Integer collectid) {
        this.collectid = collectid;
    }

    public Boolean getCollecttype() {
        return collecttype;
    }

    public void setCollecttype(Boolean collecttype) {
        this.collecttype = collecttype;
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}