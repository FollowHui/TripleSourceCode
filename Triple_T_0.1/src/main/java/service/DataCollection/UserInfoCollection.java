package service.DataCollection;

import java.util.ArrayList;

public class UserInfoCollection {
	public static ArrayList<AbstractUserInfo> userlist=new ArrayList<AbstractUserInfo>();
	public static int UserNum = -1;
	
	public UserInfoCollection()
	{
//		AbstractUserInfo user0 = new AbstractUserInfo( 0, 0, "鐢典俊", 	   2014,   3.5, 110,  326, 0, 0, "CMU");
//		AbstractUserInfo user1 = new AbstractUserInfo( 1, 1, "璁＄畻鏈�,   2014,  3.64, 105,  325, 0, 0, "IIT");
//		AbstractUserInfo user2 = new AbstractUserInfo( 2, 0, "璁＄畻鏈�,   2014,   3.3, 103,  319, 0, 0, "SIT");
//		AbstractUserInfo user3 = new AbstractUserInfo( 3, 0, "鐢垫皵", 	   2014,  3.75, 102,  320, 0, 0, "CMU");
//		AbstractUserInfo user4 = new AbstractUserInfo( 4, 2, "璁＄畻鏈�,   2014,   3.9, 105,  329, 0, 0, "CMU");
//		AbstractUserInfo user5 = new AbstractUserInfo( 5, 2, "璇█瀛�,   2014,  3.15,  93,  300, 1, 0, "CMU");
//		AbstractUserInfo user6 = new AbstractUserInfo( 6, 2, "鍏朵粬",    2014,   3.1, 109,  329, 0, 0, "CMU");
//		AbstractUserInfo user7 = new AbstractUserInfo( 7, 2, "绀句細绉戝", 2014,  3.22, 100,  300, 0, 0, "CMU");
//		AbstractUserInfo user8 = new AbstractUserInfo( 8, 2, "鏁板",   2014,  3.65,  116,  328, 0, 0, "CMU");
//		AbstractUserInfo user9 = new AbstractUserInfo( 9, 2, "璁＄畻鏈�,  2014,   3.6, 104,  323, 0, 0, "CMU");
//		
//		userlist.add(user0);
//		userlist.add(user1);
//		userlist.add(user2);
//		userlist.add(user3);
//		userlist.add(user4);
//		userlist.add(user5);
//		userlist.add(user6);
//		userlist.add(user7);
//		userlist.add(user8);
//		userlist.add(user9);
	}
	
	public void insertUserInfo(AbstractUserInfo u){
		AbstractUserInfo userNew = new AbstractUserInfo( ++UserNum, u.gradsch, u.subject,  u.time,   u.GPA, u.Toefl,  u.GRE, u.paper, u.recomand, u.school);
		userlist.add(userNew);
	}

}
