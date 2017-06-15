package com.taomee.bigdata.spring;

/**
 * Created by looper on 2017/4/28.
 */


import java.util.Date;

/**
 * `gpzs_id` bigint(20) NOT NULL auto_increment,
   `game_id` int(11) NOT NULL default '0',
   `platform_id` int(11) NOT NULL default '0',
   `zone_id` int(11) NOT NULL default '0',
   `server_id` int(11) NOT NULL default '0',
   `gpzs_name` char(64) NOT NULL default '' COMMENT '平台区服名字',
   `status` tinyint(4) NOT NULL default '0' COMMENT '0:正常 1：下架',
   `add_time` timestamp NOT NULL default CURRENT_TIMESTAMP,
 */
public class GPZSInfo {

    private Integer gpzs_id;
    private Integer game_id;
    private Integer platform_id;
    private Integer zone_id;
    private Integer server_id;
    private String gpzs_name;
    private Integer status;
    private Date add_time;

    //默认构造函数
    public GPZSInfo() {
    }

    public GPZSInfo(Integer gpzs_id, Integer game_id, Integer platform_id, Integer zone_id, Integer server_id, String gpzs_name, Integer status, Date add_time) {
        this.gpzs_id = gpzs_id;
        this.game_id = game_id;
        this.platform_id = platform_id;
        this.zone_id = zone_id;
        this.server_id = server_id;
        this.gpzs_name = gpzs_name;
        this.status = status;
        this.add_time = add_time;
    }

    public Integer getGpzs_id() {

        return gpzs_id;
    }

    public void setGpzs_id(Integer gpzs_id) {
        this.gpzs_id = gpzs_id;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public Integer getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(Integer platform_id) {
        this.platform_id = platform_id;
    }

    public Integer getZone_id() {
        return zone_id;
    }

    public void setZone_id(Integer zone_id) {
        this.zone_id = zone_id;
    }

    public Integer getServer_id() {
        return server_id;
    }

    public void setServer_id(Integer server_id) {
        this.server_id = server_id;
    }

    public String getGpzs_name() {
        return gpzs_name;
    }

    public void setGpzs_name(String gpzs_name) {
        this.gpzs_name = gpzs_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    @Override
    public String toString() {
        return "GPZSInfo{" +
                "gpzs_id=" + gpzs_id +
                ", game_id=" + game_id +
                ", platform_id=" + platform_id +
                ", zone_id=" + zone_id +
                ", server_id=" + server_id +
                ", gpzs_name='" + gpzs_name + '\'' +
                ", status=" + status +
                ", add_time=" + add_time +
                '}';
    }
}
