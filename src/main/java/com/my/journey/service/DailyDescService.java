package com.my.journey.service;

import com.my.journey.po.DailyDesc;
import com.my.journey.mapper.DailyDescMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DailyDescService{
    public int save(DailyDesc dailyDesc);
    public void update(DailyDesc dailyDesc);
    public DailyDesc findDailyDescById(int id);
    public List<DailyDesc> getAll();
    public void deleteDailyDescById(int id);
    public List<DailyDesc> getDailyDescByPage(int pageNo, int pageSize);
}
