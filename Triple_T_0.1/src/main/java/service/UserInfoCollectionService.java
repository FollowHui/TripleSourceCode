package service;

import Dao.dao.DataSetMapper;
import Dao.model.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DataCollection.AbstractUserInfo;
import service.DataCollection.SchoolInfo;

import java.util.ArrayList;
import java.util.List;

public class UserInfoCollectionService {
	public static ArrayList<AbstractUserInfo> userlist=new ArrayList<AbstractUserInfo>();
	public static int UserNum = 0;
	
	public UserInfoCollectionService()
	{
//		AbstractUserInfo user0 = new AbstractUserInfo( 0, true, 3.48, 100, 322, 0, 0, 2014, "CMU");
//		AbstractUserInfo user1 = new AbstractUserInfo( 1, true, 3.3,  94,  320, 0, 0, 2014, "IIT");
//		AbstractUserInfo user2 = new AbstractUserInfo( 2, true, 3.3,  94,  327, 0, 0, 2014, "SIT");
//		AbstractUserInfo user3 = new AbstractUserInfo( 3, true, 3,    96,  320, 1, 0, 2014, "CMU");
//		AbstractUserInfo user4 = new AbstractUserInfo( 4, true, 3.4, 101,  317, 0, 0, 2014, "CMU");
//
//		userlist.add(user0);
//		userlist.add(user1);
//		userlist.add(user2);
//		userlist.add(user3);
//		userlist.add(user4);

	}

}
