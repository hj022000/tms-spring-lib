package com.taomee.spring.web.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by looper on 2017/4/27.
 */
@Controller //申明为一个控制器
public class HomeController {

    //处理对"/"的GET请求
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String home()
    {
        //返回视图名为home
        return "home";
    }

}
