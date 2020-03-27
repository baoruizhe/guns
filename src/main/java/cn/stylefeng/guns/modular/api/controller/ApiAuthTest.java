package cn.stylefeng.guns.modular.api.controller;

import cn.stylefeng.guns.core.util.RedisUtil;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Copyright 成都可迅捷科技有限公司
 * @ClassName ApiAuthTest
 * @Description
 * @Author baoruizhe
 * @Date 2020/3/17 20:07
 * @Version 1.0
 **/
@RequestMapping("/api/auth")
@RestController
public class ApiAuthTest extends BaseController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public Object test() {
        for (int i = 0; i < 10; i++) {
            redisUtil.set(i+"",i+"");
        }
        System.out.println("开发中......");
        System.out.println("新功能开发完毕");

        for (int i = 0; i < 10; i++) {
            System.out.println("修复bug");
            System.out.println("修复bug2");
            System.out.println(redisUtil.get(i+""));
        }
        return SUCCESS_TIP;
    }



}
