package Dao.model;

public class Favourites {
    private Integer collectid;

    private Boolean collecttype;

    private Integer schoolornoteid;

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

    public Integer getSchoolornoteid() {
        return schoolornoteid;
    }

    public void setSchoolornoteid(Integer schoolornoteid) {
        this.schoolornoteid= schoolornoteid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}