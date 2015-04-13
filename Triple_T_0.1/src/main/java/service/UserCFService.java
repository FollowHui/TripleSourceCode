package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import service.DataCollection.AbstractUserInfo;
import service.DataCollection.SchoolInfo;
import service.DataCollection.UserInfoWeight;
public class UserCFService {
	AbstractUserInfo user;
	double frienddegree[];
	double schooldegree[];
	int schoolcount[];
	
	public UserCFService(AbstractUserInfo newUser){
		user = new AbstractUserInfo( newUser);
		
		frienddegree = new double[UserInfoCollectionService.UserNum];
		for( int i=0; i<UserInfoCollectionService.UserNum; i++)
			frienddegree[i] = 0.0;
		
		schooldegree = new double[SchoolInfo.schoolNum];
		schoolcount = new int[SchoolInfo.schoolNum];
		for( int i=0; i<SchoolInfo.schoolNum; i++){
			schooldegree[i] = 0.0;
			schoolcount[i] = 0;
		}
			
	}
	
	public void calcuFriend(){
		UserInfoCollectionService userInfo=new UserInfoCollectionService();

		ArrayList<AbstractUserInfo> userlist=userInfo.userlist;		
		for(int i=0; i< UserInfoCollectionService.UserNum; i++){
			AbstractUserInfo userTemp = userInfo.userlist.get(i);
			frienddegree[i] = 0.0;
			
			double gradDegree = (user.gradsch == userTemp.gradsch) ? 0.0 :  0.5;
			double gpaDegree= Math.round( (Math.abs(user.GPA-userTemp.GPA)) / UserInfoWeight.wGPA );
			int tofelDegree = Math.round((Math.abs(user.Toefl - userTemp.Toefl)) / UserInfoWeight.wToefl);
			int greDegree = Math.round((Math.abs(user.GRE - userTemp.GRE)) / UserInfoWeight.wGRE);
			int paperDegree = Math.abs(user.paper - userTemp.paper);
			int recDegree = Math.abs(user.recomand - userTemp.recomand);
			
			frienddegree[i] = gradDegree + gpaDegree + tofelDegree + greDegree + paperDegree + recDegree;
			System.out.println("user"+i + ":" + frienddegree[i] );
		}
	}
	
	public void calcuSch(){
		for( int i=0; i<UserInfoCollectionService.UserNum; i++){
			int schindex = searchSchIndex(i); //get school index for each userinfo 
			System.out.println( schindex);
			if(schindex != -1){
				schoolcount[schindex] += 1;
				schooldegree[schindex] += frienddegree[i];
			}
		}
		
		for(int j=0; j<SchoolInfo.schoolNum; j++){
			schooldegree[j] = schooldegree[j] / schoolcount[j];
			System.out.println( UserInfoCollectionService.userlist.get(j).school+":"+schooldegree[j]);
		}
	}
	
	private int searchSchIndex(int userindex){
		for(int i=0; i<SchoolInfo.schoolNum; i++){
			if(SchoolInfo.schoolList.get(i).equals((UserInfoCollectionService.userlist.get(userindex).school)))
				return i;
		}
		return -1;
	}
	
//	public static void main(String[] args){
//		AbstractUserInfo newUser = new AbstractUserInfo(1000, true, 3.96, 104, 326, 0, 0, 2015, " " );
//		UserCF newcf = new UserCF(newUser);
//		newcf.calcuFriend();
//		newcf.calcuSch();
//	}
	
}
