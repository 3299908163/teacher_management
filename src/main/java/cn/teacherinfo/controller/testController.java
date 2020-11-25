package cn.teacherinfo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname testController
 * @Description TODO
 * @Date 2020/10/23 17:25
 * @Created by 32999
 */
@RestController

public class testController {
    @RequestMapping("test")
    public String test(){
        return "hello springboot";
    }

}
