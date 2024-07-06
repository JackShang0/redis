import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.redis.RedisApplication;
import com.redis.mapper.TbItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
public class CaffeineTest {


    @Resource
    TbItemMapper itemMapper;

    @Test
    public void testCaffeine(){
        //构建cache对象
        Cache<String, String> cache = Caffeine.newBuilder().build();

        //存入cache数据
        cache.put("gf","dlrb");

        //取数据
        String gf = cache.getIfPresent("gf");
        System.out.println("gf = " + gf);


        //取数据，如果缓存未命中，则查询数据库,并将数据存入缓存中
        String gfIfNullInCache = cache.get("gfIfNullInCache", s -> itemMapper.selectById("1001").getName());
        System.out.println("gfIfNullInCache = " + gfIfNullInCache);


        String gfIfNull = cache.getIfPresent("gfIfNullInCache");
        System.out.println("gfIfNull = " + gfIfNull);

    }


    @Test
    public void testCaffeineExpire(){
        //构建cache对象
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(1)//设置最大缓存的数量
                .expireAfterWrite(10, TimeUnit.SECONDS)  //设置缓存的有效时间
                .build();

        //存入cache数据
        cache.put("gf","dlrb");

        //取数据
        String gf = cache.getIfPresent("gf");
        System.out.println("gf = " + gf);


        //取数据，如果缓存未命中，则查询数据库,并将数据存入缓存中
        String gfIfNullInCache = cache.get("gfIfNullInCache", s -> itemMapper.selectById("1001").getName());
        System.out.println("gfIfNullInCache = " + gfIfNullInCache);


        String gfIfNull = cache.getIfPresent("gfIfNullInCache");
        System.out.println("gfIfNull = " + gfIfNull);

    }
}
