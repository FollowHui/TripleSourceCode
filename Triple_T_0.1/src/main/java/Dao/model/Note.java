package Dao.model;

import java.util.Date;

public class Note {
    private Integer noteid;

    private Date pushdate;

    private Integer collectedtimes;

    private Integer userid;

    private String pushcontent;

    private String title;
    private String notePublisher;

    private String commenter;

    private Integer commentCount;
    public Integer getCommentCount(){
        return commentCount;
    }
    public void setCommentCount(int commentCount){
        this.commentCount=commentCount;
    }
    public String getNotePublisher(){
        return notePublisher;
    }
    public void setNotePublisher(String notePublisher) {
        this.notePublisher = notePublisher;
    }
    public String getCommenter(){
        return commenter;
    }
    public void setCommenter(String commenter){
        this.commenter=commenter;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}