package com.my.journey.controller;

import java.util.List;

import com.my.journey.service.DailyDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.my.journey.mapper.DailyDescMapper;
import com.my.journey.dao.DailyDescDAO;
import com.my.journey.po.DailyDesc;
import org.springframework.ui.ModelMap;
import com.my.journey.util.Page;
import com.my.journey.util.PageResult;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController   // 和Controller有什么区别
public class DailyDescController {
    @Autowired
    DailyDescService dailyDescService;
    @RequestMapping(value = "/api/DailyDesc", method = RequestMethod.POST)
    public void createDailyDesc(@RequestBody DailyDesc dailyDesc) {
        dailyDescService.save(dailyDesc);
    }
    @RequestMapping(value = "/api/DailyDesc/update", method = RequestMethod.POST)
    public void updateDailyDesc(@RequestBody DailyDesc dailyDesc) {
        dailyDescService.update(dailyDesc);
    }
    @RequestMapping(value = "/api/DailyDesc", method = RequestMethod.GET)
    public PageResult<List<DailyDesc>> getDailyDesc(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        System.out.print(22222222);
        System.out.print(pageNo);
        System.out.print(pageSize);
        List<DailyDesc> datas = dailyDescService.getDailyDescByPage(pageNo, pageSize);
        System.out.print(datas);
        PageResult<List<DailyDesc>> page = PageResult.newSuccessResult(pageNo, pageSize, datas.size(), datas);
        return page;
    }
    @RequestMapping(value = "/api/DailyDesc/{id}", method = RequestMethod.GET)
    public DailyDesc findDailyDesc(@PathVariable("id") int id) {
        System.out.print(1232123123);
        return dailyDescService.findDailyDescById(id);
    }
    @RequestMapping(value = "/api/DailyDesc/delete/{id}", method = RequestMethod.GET)
    public void deleteDailyDesc(@PathVariable("id") int id) {
        System.out.print(23);
        dailyDescService.deleteDailyDescById(id);
    }
}
