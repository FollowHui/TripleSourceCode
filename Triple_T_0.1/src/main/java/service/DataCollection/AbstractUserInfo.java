package service.DataCollection;

public class AbstractUserInfo {
	public int userid;
	public int gradsch;
	public String subject;
	public int time;
	public double GPA;
	public int Toefl;
	public int GRE;
	public int paper;
	public int recomand;
	
	public Integer school;
	
	public AbstractUserInfo(int userid, int gradsch,String subject, int time, double gpa, int toefl, int gre, int paper, int recomand, Integer school){
		this.userid = userid;
		this.gradsch = gradsch;
		this.subject = subject;
		this.GPA = gpa;
		this.Toefl = toefl;
		this.GRE = gre;
		this.paper = paper;
		this.recomand = recomand;
		this.time = time;
		this.school = school;
	}
	
	public AbstractUserInfo(AbstractUserInfo newUser){
		this.userid = newUser.userid;
		this.gradsch = newUser.gradsch;
		this.GPA = newUser.GPA;
		this.Toefl = newUser.Toefl;
		this.GRE = newUser.GRE;
		this.paper = newUser.paper;
		this.recomand = newUser.recomand;
		this.time = newUser.time;
		this.school = newUser.school;
	}
}
