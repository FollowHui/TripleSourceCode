package Dao.model;

import java.util.Date;

public class schoolNews {
    private Integer schoolnewsid;

    private Date newsdate;

    private String newscontent;

    private Integer schoolid;

    public Integer getSchoolnewsid() {
        return schoolnewsid;
    }

    public void setSchoolnewsid(Integer schoolnewsid) {
        this.schoolnewsid = schoolnewsid;
    }

    public Date getNewsdate() {
        return newsdate;
    }

    public void setNewsdate(Date newsdate) {
        this.newsdate = newsdate;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent.trim();
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }
}