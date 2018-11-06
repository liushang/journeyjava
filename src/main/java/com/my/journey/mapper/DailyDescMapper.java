package com.my.journey.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.my.journey.po.DailyDesc;

import java.util.List;

@Mapper
@Repository
public interface DailyDescMapper {

//    @Select("select * from daily_desc ")
//    List<DailyDesc> findAll();
    @Select("select id as id, user_name as userName, descs, create_time as createTime, user_id as userId from daily_desc  order by create_time desc")
    public List<DailyDesc> getAll();
    @Select("select id as id, user_name as userName, descs, create_time as createTime, user_id as userId from daily_desc  order by create_time desc limit ${(pageNo-1)*pageSize},${pageNo*pageSize}")
    public List<DailyDesc> getByPage(Int pageNo, int pageSize);
    @Insert(" insert into daily_desc ( user_name, descs, create_time) values (#{userName},#{descs},#{createTime}) ")
    public int save(DailyDesc dailyDesc);

    @Delete(" delete from daily_desc where id= #{id} ")
    public int deleteDailyDescById(int id);

    @Select("select * from daily_desc where id= #{id} ")
    public DailyDesc findDailyDescById(int id);

    @Update("update daily_desc set user_name=#{userName},descs=#{descs}, create_time=#{createTime} where id=#{id} ")
    public int update(DailyDesc dailyDesc);
}