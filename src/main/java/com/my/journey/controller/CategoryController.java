package com.my.journey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.my.journey.mapper.CategoryMapper;
import com.my.journey.dao.CategoryDAO;
import com.my.journey.entity.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
//public class CategoryController {
//    @Autowired CategoryDAO categoryDAO;
//
//    @RequestMapping("/listCategory")
//    public String listCategory(Model m) throws Exception {
//        List<Category> cs=categoryDAO.findAll();
//
//        m.addAttribute("cs", cs);
//
//        return "listCategory";
//    }
//
//}
// 传统表单
//@Controller
//public class CategoryController {
//    @Autowired CategoryMapper categoryMapper;
//
//    @RequestMapping("/listCategory")
//    public String listCategory(Model m) throws Exception {
//        List<Category> cs=categoryMapper.findAll();
//
//        m.addAttribute("cs", cs);
//
//        return "listCategory";
//    }
//    @RequestMapping("/addCategory")
//    public String listCategory(Category c) throws Exception {
//        categoryMapper.save(c);
//        return "redirect:listCategory";
//    }
//    @RequestMapping("/deleteCategory")
//    public String deleteCategory(Category c) throws Exception {
//        categoryMapper.delete(c.getId());
//        return "redirect:listCategory";
//    }
//    @RequestMapping("/updateCategory")
//    public String updateCategory(Category c) throws Exception {
//        categoryMapper.update(c);
//        return "redirect:listCategory";
//    }
//    @RequestMapping("/editCategory")
//    public String listCategory(int id,Model m) throws Exception {
//        Category c= categoryMapper.get(id);
//        m.addAttribute("c", c);
//        return "editCategory";
//    }
//
//}
// 接口 buggy形式
@Controller
public class CategoryController {
    @Autowired CategoryDAO categoryDAO;

    @GetMapping("/categories")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Category> page =categoryDAO.findAll(pageable);
        m.addAttribute("page", page);
        return "listCategory";
    }

    @PostMapping("/categories")
    public String addCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:/categories";
    }
    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c) throws Exception {
        categoryDAO.delete(c);
        return "redirect:/categories";
    }
    @PutMapping("/categories/{id}")
    public String updateCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:/categories";
    }
    @GetMapping("/categories/{id}")
    public String getCategory(@PathVariable("id") int id,Model m) throws Exception {
        Category c= categoryDAO.getOne(id);
        m.addAttribute("c", c);
        return "editCategory";
    }
}
//import org.springboot.entity.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.List;
//@Controller
//@RequestMapping("/hello")
//public class HelloController {
//
//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//    public String index(ModelMap modelMap) {
//        modelMap.put("msg", "SpringBoot Ajax 示例");
//
//        return "index";
//    }
//
//    @RequestMapping(value = "/home", method = RequestMethod.GET)
//    @ResponseBody
//    public String home() {
//
//        return "home";
//    }
//
//    @RequestMapping(value = "/data", method = RequestMethod.POST)
//    @ResponseBody
//    public List<User> data() {
//        List<User> list = new ArrayList<User>();
//
//        for (int i = 0; i < 10; i++) {
//            User user = new User();
//            user.setId(i + 1);
//            user.setName("springboot" + i);
//            user.setSex("male");
//            user.setAge(i + 1);
//            user.setRole("developer");
//
//            list.add(user);
//        }
//
//        return list;
//    }
//}
