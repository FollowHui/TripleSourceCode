package Dao.model;

import java.util.Date;

public class Favourites {
    private Integer collectid;

    private Boolean collecttype;

    private Integer schoolornoteid;

    private Integer userid;

    private Date pushDate;

    private String noteTitle;
    private Integer noteId;
    private Integer schoolId;
    private String schoolLogo;
    private String schoolName;
    public String getSchoolName(){
        return schoolName;
    }
    public void setSchoolName(String schoolName){
        this.schoolName=schoolName;
    }
    public String getSchoolLogo(){
        return schoolLogo;
    }
    public void setSchoolLogo(String schoolLogo){
        this.schoolLogo=schoolLogo;
    }
    public Integer getSchoolId(){
        return schoolId;
    }
    public void setSchoolId(Integer schoolId){
        this.schoolId=schoolId;
    }
    public Integer getNoteId(){
        return noteId;
    }
    public void setNoteId(Integer noteId){
        this.noteId=noteId;
    }
    public Date getPushDate(){
        return pushDate;
    }
    public void setPushDate(Date pushDate){
        this.pushDate=pushDate;
    }
    public String getNoteTitle(){
        return noteTitle;
    }
    public void setNoteTitle(String noteTitle){
        this.noteTitle=noteTitle;
    }

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