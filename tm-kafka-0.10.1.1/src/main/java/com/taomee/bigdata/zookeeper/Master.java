package com.taomee.bigdata.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;


/**
 * Created by looper on 2017/6/9.
 */
public class Master implements Watcher{
    static ZooKeeper zk;
    String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK()
    {
        try {
            zk = new ZooKeeper(hostPort,15000,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    public static void main(String[] args) {
        Master master = new Master("10.1.1.228:2181,10.1.1.225:2181,10.1.1.223:2181");
        master.startZK();
        try {
            zk.setData("/tms/server-detector","1".getBytes(),-1);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //Thread.sleep(60000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
