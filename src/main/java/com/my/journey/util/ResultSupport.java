package com.my.journey.util;
import java.io.Serializable;

public class ResultSupport implements Serializable {
    private static final long serialVersionUID = -2235152751651905167L;

    public boolean isSuccess() {
        return code == ResultCode.SuccessCode;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private String message;
    private int code;
}
//
//
//    @RequestMapping(method = RequestMethod.GET, value = "/success")
//    public PageResult<List<User>> findPageResultSuccess(HttpServletRequest req) {
//        List<User> users = new ArrayList<User>();
//        for (int i = 0; i < 20; i++) {
//
//            User tom = new User();
//            tom.setUsername("tom" + i);
//            users.add(tom);
//        }
//        PageResult<List<User>> result = PageResult.newSuccessResult(1, 2, users.size(), users);
//        return result;
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/fail")
//    public PageResult<List<User>> findPageResultFail(HttpServletRequest req) {
//        List<User> users = new ArrayList<User>();
//        PageResult<List<User>> result = PageResult.newFailResult(1, "分页查询失败");
//        return result;
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/success")
//    public APIResult<User> findAPIResultSuccess(HttpServletRequest req) {
//        User user = new User();
//        APIResult<User> result = APIResult.newSuccessResult(user);
//        return result;
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/fail")
//    public APIResult<User> findAPIResultFail(HttpServletRequest req) {
//        APIResult<User> result = APIResult.newFailResult(1, "没有找到用户");
//        return result;
//    }
//
//作者：碳头tantou
//        链接：https://www.jianshu.com/p/d8f2939d6a36
//        來源：简书
//        简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。