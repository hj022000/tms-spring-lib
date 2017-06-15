package com.taomee.storm.trident.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by looper on 2017/6/14.
 */
public class TestP {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\w+)\\(([A-Za-z0-9_,]*)\\)");
        Matcher matcher = pattern.matcher("material(_hip_,_ts_,_acid_,_plid_,_vip_,_lv_)");
        System.out.println(matcher.find());
        System.out.println(matcher.group(2));
    }
}
