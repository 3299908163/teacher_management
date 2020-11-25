package cn.teacherinfo.controller;



import cn.teacherinfo.entity.Teacher;
import cn.teacherinfo.service.TeacherService;
import cn.teacherinfo.utils.Constant;
import cn.teacherinfo.utils.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 教师信息分页
 * @Description TODO
 * @Date 2020/11/9 10:00
 * @Created by 32999
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 登陆方法
     * @param userIdentity
     * @param userName
     * @param session
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping("/login")
    public Map<String,Object> login(@RequestParam String userIdentity, @RequestParam String userName,
                                    HttpSession session, HttpServletRequest request){
        Teacher teacherInfo = teacherService.login(userIdentity,userName);
        Map<String,Object> map=null;
        if(null==teacherInfo){
            //判断身份证是否存在
            if(null==teacherService.findTeacherByidentity(userIdentity)){
                //为空返回5002，身份证不存在
                map = ReturnResult.returnFail(null,null,5002);
            }else{
                //返回5003，身份证存在，用户名不匹配
                map = ReturnResult.returnFail(null,null,5003);
            }
        }else {
            //保存用户到session中
            session.setAttribute(Constant.CURRENT_USER, teacherInfo);
            String id = request.getSession(true).getId();
            teacherInfo.setSessionId(id);
            teacherService.updateTeacher(teacherInfo );
            //登陆成功
            map=ReturnResult.returnSuccess(null,teacherInfo.getIsAdmin());
        }
        return map;
    }

    /**
     * 注销方法
     * @param session
     * @return
     */
    @ResponseBody
    @GetMapping("/sessionCancellation")
    public boolean sessionCancellation(HttpSession session){
        session.removeAttribute(Constant.CURRENT_USER);
        return true;
    }

    /**
     * 重复登陆 跳转页面
     * @return
     */
    @GetMapping("/toErrorLogin")
    public String toErrorLogin(){
        return "errorLogin";
    }


}
