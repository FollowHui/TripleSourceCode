package Dao.model;



public class schoolNews {
    private Integer schoolnewsid;

    private String newsdate;

    private String newscontent;

    private String url;

    private Integer schoolid;

    public Integer getSchoolnewsid() {
        return schoolnewsid;
    }

    public void setSchoolnewsid(Integer schoolnewsid) {
        this.schoolnewsid = schoolnewsid;
    }

    public String getNewsdate() {
        return newsdate;
    }

    public void setNewsdate(String newsdate) {
        this.newsdate = newsdate;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }

}