package com.taomee.spring.web.config;

/**
 * Created by looper on 2017/4/27.
 */
public class HomeControllerTest {

    public void testHomePage()
    {
        HomeController controller  = new HomeController();
        System.out.println(controller.home());
    }

    public static void main(String[] args) {
        new HomeControllerTest().testHomePage();
    }
}
