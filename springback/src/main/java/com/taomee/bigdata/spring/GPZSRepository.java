package com.taomee.bigdata.spring;

/**
 * Created by looper on 2017/4/28.
 */
public interface GPZSRepository {

    public void addGPZS(GPZSInfo info);

    public GPZSInfo findOne(Integer id);
}
