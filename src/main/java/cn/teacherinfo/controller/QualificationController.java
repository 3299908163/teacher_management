package cn.teacherinfo.controller;

import cn.teacherinfo.entity.Qualification;
import cn.teacherinfo.entity.Teacher;
import cn.teacherinfo.entity.Title;
import cn.teacherinfo.service.QualificationService;
import cn.teacherinfo.service.TitleService;
import cn.teacherinfo.utils.ReturnResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname QualificationController
 * @Description TODO
 * @Date 2020/11/19 15:44
 * @Created by 32999
 */
@Controller
@RequestMapping("/qualification")
public class QualificationController {
    @Autowired
    private QualificationService qualificationService;

    /**
     * 教师资格种类信息分页
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @GetMapping("/qualificationList")
    public Object listQualification(@RequestParam(required = false) Integer page,
                                    @RequestParam(required = false) Integer limit){
        Page<Qualification> ipage = new Page<>(page,limit);
        IPage<Qualification> qualificationIPage = qualificationService.selectPageQualification(ipage);
        int count = qualificationService.count();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",qualificationIPage.getRecords());
        return map;
    }

    /**
     * 通过教师资格种类名查询教师资格种类信息是否重复
     * @param qualificationName
     * @return
     */
    @ResponseBody
    @RequestMapping("/isHaveQualificationName")
    public String isHaveQualificationName(String qualificationName){
        System.out.println("教师资格种类名:"+qualificationName);
        List<Qualification> qualifications = qualificationService.getQualificationByqualificationName(qualificationName);
        if(qualifications.size()!=0){
            return "true";
        }else {
            return "false";
        }
    }
    @ResponseBody
    @RequestMapping("/isHaveQualificationName2")
    public String isHaveQualificationName2(String qualificationName){
        System.out.println("教师资格种类名:"+qualificationName);
        List<Qualification> qualifications = qualificationService.getQualificationByqualificationName(qualificationName);
        if(qualifications.size()!=0){
            int id=qualifications.get(0).getQualificationId();
            String Id=String.valueOf(id);
            return Id;
        }else {
            return "false";
        }
    }

    /**
     * 添加教师资格种类
     * @param qualificationName
     * @return
     */
    @ResponseBody
    @RequestMapping("/addQualification")
    public String addQualification(String qualificationName){
        if(qualificationService.insert(qualificationName)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 修改教师资格种类
     * @param qualification
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateQualification")
    public String updateQualification(Qualification qualification) {
        if(qualificationService.updateById(qualification)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 删除教师资格种类
     * @param qualificationId
     * @return
     */
    @ResponseBody
    @GetMapping("/delQualification")
    public String delQualification(int qualificationId){
        int result = qualificationService.deleteById(qualificationId);
        System.out.println("删除成功！");
        if(result>0){
            return "true";
        }
        else {
            return "false";
        }
    }

    @ResponseBody
    @GetMapping("/getQualificationListByCreate")
    /**
     *添加教师信息需要的教师资格种类集合
     * @return
     */
    public Map<String,Object> getQualificationListByCreate(){
        try{
            List<Qualification> qualificationList = qualificationService.getQualificationList();   //获取学科集合
            return ReturnResult.returnSuccess(null,qualificationList);
        }catch (Exception e){
            return ReturnResult.returnFail(null,null,500);
        }
    }
}
