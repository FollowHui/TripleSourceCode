package Dao.model;

import java.util.Date;

public class Note {
    private Integer noteid;

    private Date pushdate;

    private Integer collectedtimes;

    private Integer userid;

    private String pushcontent;

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public Date getPushdate() {
        return pushdate;
    }

    public void setPushdate(Date pushdate) {
        this.pushdate = pushdate;
    }

    public Integer getCollectedtimes() {
        return collectedtimes;
    }

    public void setCollectedtimes(Integer collectedtimes) {
        this.collectedtimes = collectedtimes;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPushcontent() {
        return pushcontent;
    }

    public void setPushcontent(String pushcontent) {
        this.pushcontent = pushcontent == null ? null : pushcontent.trim();
    }
}