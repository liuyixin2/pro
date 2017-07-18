import com.hua.pojo.User;
import com.hua.service.IUserService;
import com.hua.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017-07-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class test_Pro {
    @Resource
    private UserServiceImpl userService;
    @Test
    public void selectUserById(){
        User user = userService.getUser(2);
        System.out.println(user);
        Map map =new HashMap();
        map.put("fid",2);
        map.put("type","2");
        userService.queryUser(map);
        System.out.println(map.get("name"));

    }
}
