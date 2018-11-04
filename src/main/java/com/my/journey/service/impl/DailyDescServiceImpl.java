package com.my.journey.service.impl;

import com.my.journey.po.DailyDesc;
import com.my.journey.mapper.DailyDescMapper;
import com.my.journey.service.DailyDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
@Service
public class DailyDescServiceImpl implements DailyDescService{
    @Autowired DailyDescMapper dailyDescMapper;
    @Override
    public int save(DailyDesc dailyDesc) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));
        dailyDesc.setCreateTime(new Date());
        return dailyDescMapper.save(dailyDesc);
    }
    public void update(DailyDesc dailyDesc) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));
        dailyDesc.setCreateTime(new Date());
        dailyDescMapper.update(dailyDesc);
    }
    @Override
    public DailyDesc findDailyDescById(int id) {
        System.out.print(3333);
        DailyDesc dailyDesc = dailyDescMapper.findDailyDescById(id);
        System.out.print(dailyDesc);
        return dailyDesc;
    }
    @Override
    public void deleteDailyDescById(int id) {
        System.out.print(3333);
        dailyDescMapper.deleteDailyDescById(id);;
    }
    @Override
    public List<DailyDesc> getAll() {
        List<DailyDesc> datas = (List<DailyDesc>)dailyDescMapper.getAll();
        System.out.print(datas);
        return datas;
    }
    @Override
    public List<DailyDesc> getDailyDescByPage(int pageNo, int pageSize) {
        System.out.print(pageNo);
        System.out.print(121222222);
        List<DailyDesc> datas = (List<DailyDesc>)dailyDescMapper.getByPage(pageNo, pageSize);
        System.out.print(datas);
        return datas;
    }
}
