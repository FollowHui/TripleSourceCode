package service.DataCollection;

public class AbstractUserInfo {
	public int userid;
	public boolean gradsch;
	public double GPA;
	public int Toefl;
	public int GRE;
	public int paper;
	public int recomand;
	public int time;
	public String school;
	public AbstractUserInfo(){

	}
	
	public AbstractUserInfo(int userid, boolean gradsch, double gpa, int toefl, int gre, int paper, int recomand, int time, String school){
		this.userid = userid;
		this.gradsch = gradsch;
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
