import com.redis.RedisApplication;
import com.redis.dto.TbItem;
import com.redis.mapper.TbItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes= RedisApplication.class)
@RunWith(SpringRunner.class)
public class TbItemTest {


    @Autowired
    TbItemMapper tbItemMapper;

    @Test
    void selectTbItem(){
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        List<TbItem> users = tbItemMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
