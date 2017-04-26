package com.taomee.bigdata.spring.day1;

import org.springframework.stereotype.Component;

/**
 * Created by looper on 2017/4/19. Component申明为组件类
 */
@Component
public class SgtPeppers implements CampactDisc{
    private String title = "title";
    private String artist = "The Beatles";
    public void play() {
        System.out.println("Playing " + title +" by "+artist);
    }
}
