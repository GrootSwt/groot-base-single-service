package com.blog;

import com.groot.base.web.util.EncryptionUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SingleBlogApplicationTests {

    @Test
    void contextLoads() {
        String result = EncryptionUtil.getMD5("123456");
        System.out.println(result);
    }

}
