import com.hua.pojo.User;
import com.hua.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017-07-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class test_Pro {
    @Resource
    private UserServiceImpl userService;
    /**
     * 通过id获取用户信息
     */
    @Test
    public void selectUserById(){
        User user = userService.getUser(2);
        System.out.println(user);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("fid",2);
        map.put("type","2");
        userService.queryUser(map);
        System.out.println(map.get("name"));
    }
    /**
     *  CREATE OR REPLACE Procedure getUsers(cur_arg out Sys_Refcursor)
		As
		begin
		    open cur_arg for Select * From pro_user;
		End;
		
		Declare
		  testCursor SYS_REFCURSOR;
		  testRec pro_user%ROWTYPE;
		Begin
		   getUsers(testCursor);
		   loop
		      fetch testCursor into testRec;
		      exit when testCursor%NOTFOUND;
		      DBMS_OUTPUT.put_line(testRec.name);
		   end loop;
		End;
		/
     * 获取用户的集合（游标）
     */
    @Test
    public void selectUsers(){
    	Map<String,Object> map =new HashMap<String,Object>();
    	userService.queryUsers(map);
    	Set<Map.Entry<String, Object>> set = map.entrySet();
		for (Iterator<Map.Entry<String, Object>> it = set.iterator(); it
				.hasNext();) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it
					.next();
			// System.out.println(entry.getKey() + "--->" +
			// (Teacher)entry.getValue());
			@SuppressWarnings("unchecked")
			List<User> t = (List<User>) entry.getValue();
			Iterator<User> itera = t.iterator();
			while (itera.hasNext()) {
				User user = itera.next();
				System.out.println(user.getName() + "," + user.getId());
			}
		}
    }
}
