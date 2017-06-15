package com.taomee.bigdata.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by looper on 2017/4/28.
 */
@Repository(value = "jdbcGPZSRepository")
public class JdbcGPZSRepository implements GPZSRepository{

    private JdbcOperations jdbcOperations; //JdbcTemplate实现的接口

    @Autowired
    public JdbcGPZSRepository(JdbcOperations jdbcOperations)
    {
        this.jdbcOperations = jdbcOperations;
    }

    public void addGPZS(GPZSInfo info) {
        jdbcOperations.
                update("insert info " +
                        "t_gpzs_info(game_id,platform_id,zone_id,server_id,gpzs_name,status,add_time) " +
                        "values(?,?,?,?,?,?,?)",
                        info.getGame_id(),
                        info.getPlatform_id(),
                        info.getZone_id(),
                        info.getServer_id(),
                        info.getGpzs_name(),
                        info.getStatus(),
                        info.getAdd_time());
    }

    public GPZSInfo findOne(Integer id) {

        return jdbcOperations.queryForObject("select * from t_gpzs_info where gpzs_id = ?",new GPZSInfoRowMapper(),id);
    }

    /**
     * private Integer gpzs_id;
     private Integer game_id;
     private Integer platform_id;
     private Integer zone_id;
     private Integer server_id;
     private String gpzs_name;
     private Integer status;
     private Date add_time;
     */
    private static final class GPZSInfoRowMapper implements RowMapper<GPZSInfo>
    {
        public GPZSInfo mapRow(ResultSet rs, int i) throws SQLException {
            return new GPZSInfo(rs.getInt("gpzs_id"),rs.getInt("game_id"),
                    rs.getInt("platform_id"),rs.getInt("zone_id"),rs.getInt("server_id"),
                    rs.getString("gpzs_name"),rs.getInt("status"),rs.getDate("add_time"));

        }
    }
}
