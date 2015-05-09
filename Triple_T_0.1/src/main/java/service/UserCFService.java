package service;

import java.math.BigDecimal;
import java.util.ArrayList;

import service.DataCollection.AbstractUserInfo;
import service.DataCollection.Distance;
import service.DataCollection.SchoolInfo;
import service.DataCollection.UserInfoCollection;
import service.DataCollection.UserInfoWeight;

public class UserCFService {
	AbstractUserInfo user;
	UserInfoCollection userCollect;
	double fdis[];
	double fdis1[];  //graduate info
	double fdis2[];  //applicate time
	double fdis3[];  //grades
	double fdis4[];  //others
	int getknn[];
	double schooleval[];
	int schoolcount[];
	double f = 100.1234;
	int SIZE=100;
	public double[] getSchoolEval(){
		return schooleval;
	}
	
	public UserCFService(AbstractUserInfo newUser){
		user = new AbstractUserInfo( newUser);
		userCollect = new UserInfoCollection();
			
	}
	
	public void input( ArrayList<AbstractUserInfo> userlist){
		for(int i=0; i<userlist.size(); ++i){
			userCollect.insertUserInfo(userlist.get(i));
		}	
		
		init();
	}
	
	public void init(){
		fdis  = new double[UserInfoCollection.UserNum+1];
		fdis1 = new double[UserInfoCollection.UserNum];
		fdis2 = new double[UserInfoCollection.UserNum];
		fdis3 = new double[UserInfoCollection.UserNum];
		fdis4 = new double[UserInfoCollection.UserNum];
		for( int i=0; i<UserInfoCollection.UserNum; i++){
			fdis[i]  = 0.0;
			fdis1[i] = 0.0;
			fdis2[i] = 0.0;
			fdis3[i] = 0.0;
			fdis4[i] = 0.0;
		}
		fdis[UserInfoCollection.UserNum] = -1.0;
		
		getknn = new int[SIZE];
		for(int i=0; i<SIZE; ++i)
			getknn[i] = UserInfoCollection.UserNum;
		
		schoolcount = new int[SchoolInfo.schoolNum];
		schooleval = new double[SchoolInfo.schoolNum];
		for( int i=0; i<SchoolInfo.schoolNum; i++){
			schooleval[i] = 0.0;
			schoolcount[i] = 0;
		}
	}
	
	public void calcu(){
		calcuFriend();
		getKnn();

//		for(int i=0; i<getknn.length; i++){
//			System.out.println(getknn[i]);
//		}
		calcuSch();
	}

	public void clean(){
		UserInfoCollection.UserNum = 0;
		UserInfoCollection.userlist=new ArrayList<AbstractUserInfo>();
	}

	//�����û����ƶ�
	public void calcuFriend(){  	
		for(int i=0; i< UserInfoCollection.UserNum; i++){
			AbstractUserInfo userTemp = userCollect.userlist.get(i);
			
			calcuDis1(userTemp, i);
			calcuDis2(userTemp, i);
			calcuDis3(userTemp, i);
			calcuDis4(userTemp, i);
			//System.out.println(fdis1[i] +"\t"+fdis2[i]+"\t"+fdis3[i]+"\t"+fdis4[i]);
			//System.out.println(0.4*fdis1[i] + 0.4*fdis3[i] + 0.2*fdis4[i]);
			fdis[i] = getTwoDigit( 1/(0.4*fdis1[i] + 0.4*fdis3[i] + 0.2*fdis4[i]));
			//System.out.println( "user"+i+":"+fdis[i]);
		}
		System.out.println("\n");
	}
	
	public void calcuSch(){
		for( int i=0; i<SIZE; i++){
			int schindex = searchSchIndex( getknn[i]); //get school index for each userinfo
			//int schindex = userCollect.userlist.get(getknn[i]).school;
			//System.out.println( schindex);
			if(schindex != -1){
				schoolcount[schindex] += 1;
				schooleval[schindex] += fdis[getknn[i]];
			}
		}
		
		for(int j=0; j<SchoolInfo.schoolNum; j++){
			if( schoolcount[j] != 0);
			//System.out.println( SchoolInfo.school[j]+":"+String.format("%.6f", schooleval[j]) + "\tcount:" + schoolcount[j]);
		}
	}
	
	private void calcuDis1(AbstractUserInfo v, int i){
		int sdis = findsub(user.subject, v.subject);
		fdis1[i] = getTwoDigit( Math.sqrt( Math.pow(user.gradsch - v.gradsch, 2.0) + Math.pow(sdis, 2.0))) ;
	}
	
	private void calcuDis2(AbstractUserInfo v, int i){  
		fdis2[i] = user.time - v.time;
	}
	
	private void calcuDis3(AbstractUserInfo v, int i){
		//o distance
		double uu1[] = {user.GPA/UserInfoWeight.wGPA*20, user.Toefl/UserInfoWeight.wToefl*20, user.GRE/UserInfoWeight.wGRE*20};
		double vv1[] = {v.GPA/UserInfoWeight.wGPA*20, v.Toefl/UserInfoWeight.wToefl*20, v.GRE/UserInfoWeight.wGRE*20};

//		double uu1[] = {user.GPA, user.Toefl, user.GRE};
//		double vv1[] = {v.GPA, v.Toefl, v.GRE};
		
		double odis = getTwoDigit( Math.sqrt( Math.pow( uu1[0]-vv1[0], 2.0) + Math.pow( uu1[1]-vv1[1], 2.0) + Math.pow( uu1[2]-vv1[2], 2.0)));
		fdis3[i] = odis;
	}
	
	private void calcuDis4(AbstractUserInfo v, int i){
		fdis4[i] = getTwoDigit( Math.sqrt(Math.abs(user.paper - v.paper) + Math.abs(user.recomand - v.recomand)));
	}
	
	private double calcuCos( AbstractUserInfo u, AbstractUserInfo v){
//		double timeDis =  u.time - v.time;  
//		double schDis = u.gradsch - v.gradsch;
//		double subDis = Distance.SubjectDis[u.subject][v.subject];
//		
//		System.out.println( timeDis/10+"\t"+schDis+"\t" +subDis);
//		
//		double gpaDegree= Math.round( (Math.abs(u.GPA-v.GPA)) / UserInfoWeight.wGPA );
//		int tofelDegree = Math.round((Math.abs(u.Toefl - v.Toefl)) / UserInfoWeight.wToefl);
//		int greDegree = Math.round((Math.abs(u.GRE - v.GRE)) / UserInfoWeight.wGRE);
//		int paperDegree = Math.abs(u.paper - v.paper);
//		int recDegree = Math.abs(u.recomand - v.recomand);
		
//		System.out.println( gpaDegree+"\t"+tofelDegree+"\t"+greDegree+"\t"+paperDegree+"\t"+recDegree);
		
//cos distance
//		double uu1[] = {u.GPA/UserInfoWeight.wGPA, u.Toefl/UserInfoWeight.wToefl, u.GRE/UserInfoWeight.wGRE};
//		double vv1[] = {v.GPA/UserInfoWeight.wGPA, v.Toefl/UserInfoWeight.wToefl, v.GRE/UserInfoWeight.wGRE};
//		double uu1[] = {u.GPA, u.Toefl, u.GRE};
//		double vv1[] = {v.GPA, v.Toefl, v.GRE};
//		double puu = (uu1[0]+uu1[1]+uu1[2])/3;
//		double pvv = (vv1[0]+vv1[1]+vv1[2])/3;
//		
//		double uu[] = {getTwoDigit(u.GPA-puu), getTwoDigit(u.Toefl-puu), getTwoDigit(u.GRE-puu)};
//		double vv[] = {getTwoDigit(v.GPA-pvv), getTwoDigit(v.Toefl-pvv), getTwoDigit(v.GRE-pvv)};
//
//		double up = getTwoDigit(uu[0]*vv[0] + uu[1]*vv[1] + uu[2]*vv[2]);
//		double downu = getTwoDigit(Math.sqrt( Math.pow( uu[0], 2.0) + Math.pow( uu[1], 2.0) + Math.pow( uu[2], 2.0)));
//		double downv = getTwoDigit(Math.sqrt( Math.pow( vv[0], 2.0) + Math.pow( vv[1], 2.0) + Math.pow( vv[2], 2.0)));
//		System.out.println(up + "\t" + downu + "\t" + downv +"\t" + up/(downu*downv));
//		return up/(downu*downv);
		
//o distance
//		double uu1[] = {u.GPA/UserInfoWeight.wGPA, u.Toefl/UserInfoWeight.wToefl, u.GRE/UserInfoWeight.wGRE};
//		double vv1[] = {v.GPA/UserInfoWeight.wGPA, v.Toefl/UserInfoWeight.wToefl, v.GRE/UserInfoWeight.wGRE};

		double uu1[] = {u.GPA, u.Toefl, u.GRE};
		double vv1[] = {v.GPA, v.Toefl, v.GRE};
		
		double odis = getTwoDigit( Math.sqrt( Math.pow( uu1[0]-vv1[0], 2.0) + Math.pow( uu1[1]-vv1[1], 2.0) + Math.pow( uu1[2]-vv1[2], 2.0)));
		return odis;
		
//m distance
		
	}
	
	private int searchSchIndex(int userindex){
		int i = userCollect.userlist.get(userindex).school-1;
		if( i < SchoolInfo.schoolNum)
			return i;
		return -1;
	}
	
	private int findsub(String subu, String subv){
		if( subu == subu)
			return 1;
		
		int uflag=0,vflag=0;
		for(int i=0; i<Distance.SubjectDis.length; ++i){
			for(int j=0; i<Distance.SubjectDis[i].length; ++j){
				if( subu.equals(Distance.SubjectDis[i][j]))
					uflag=i;
				if( subv.equals(Distance.SubjectDis[i][j]))
					vflag=i;
			}
		}
		
		if( uflag == vflag)
			return 2;
		else
			return 3;
	}
	
	private double getTwoDigit(double d){
		//double   f   =   111231.5585;  
		BigDecimal b = new BigDecimal(d);  
		double f1 = b.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
	
	private void getKnn(){
		for( int i=0; i<UserInfoCollection.UserNum; ++i){
			for(int j=0; j<SIZE; ++j){
				if( fdis[i] > fdis[getknn[j]]){
					for(int k=4; k>j; )
						getknn[k] = getknn[--k];
					getknn[j] = i;
					break;
				}
				
			}
		}
	}
	
//	public static void main(String[] args){
//		AbstractUserInfo newUser = new AbstractUserInfo(1000, 0, "�����", 2015, 3.36, 109, 330, 0, 0, " " );
//		UserCF newcf = new UserCF(newUser);
//
//		ArrayList<AbstractUserInfo> userlist = new ArrayList<AbstractUserInfo>();
//		userlist.add(new AbstractUserInfo(1000, 0, "�����", 2015, 3.36, 109, 330, 0, 0, "CMU" ));
//		userlist.add(new AbstractUserInfo(1000, 0, "�����", 2015, 3.36, 109, 330, 0, 0, "CMU" ));
//		userlist.add(new AbstractUserInfo(1000, 0, "�����", 2015, 3.36, 109, 330, 0, 0, "CMU" ));
//		userlist.add(new AbstractUserInfo(1000, 0, "�����", 2015, 3.36, 109, 330, 0, 0, "CMU" ));
//		userlist.add(new AbstractUserInfo(1000, 0, "�����", 2015, 3.36, 109, 330, 0, 0, "CMU" ));
//		userlist.add(new AbstractUserInfo(1000, 0, "�����", 2015, 3.36, 109, 330, 0, 0, "CMU" ));
//		userlist.add(new AbstractUserInfo(1000, 0, "�����", 2015, 3.36, 109, 330, 0, 0, "CMU" ));
//
//		newcf.input(userlist);
//		newcf.calcu();
//	}
	
}
