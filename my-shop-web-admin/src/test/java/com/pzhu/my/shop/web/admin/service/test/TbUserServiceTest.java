/**
 * @ProjectName: my-shop
 * @Package: com.pzhu.my.shop.web.admin.service.test
 * @ClassName: TbUserServiceTest
 * @Author: Guo Huaijian
 * @Date: 2019/9/23 19:09
 * @Version:
 * @Description:
 */
package com.pzhu.my.shop.web.admin.service.test;

import com.pzhu.my.shop.domain.TbUser;
import com.pzhu.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: Guo Huaijian
 * @Date: 2019/9/23 19:09
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll(){
        List<TbUser> tbUsers = tbUserService.selectAll();
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }
}
