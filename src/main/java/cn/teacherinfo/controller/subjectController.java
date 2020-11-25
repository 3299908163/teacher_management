package cn.teacherinfo.controller;

import cn.teacherinfo.entity.Subject;
import cn.teacherinfo.entity.Teacher;
import cn.teacherinfo.service.SubjectService;
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
 * @Classname subjectController
 * @Description TODO
 * @Date 2020/11/16 11:24
 * @Created by 32999
 */
@Controller
@RequestMapping("/subject")
public class subjectController {
    @Autowired
    private SubjectService subjectService;

    /**
     * 学科信息分页
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @GetMapping("/subjectList")
    public Object listSubject(@RequestParam(required = false) Integer page,
                              @RequestParam(required = false) Integer limit){
        Page<Subject> ipage = new Page<>(page,limit);
        IPage<Subject> pageSubject = subjectService.selectPageSubject(ipage);
        int count = subjectService.count();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",pageSubject.getRecords());
        return map;
    }

    /**
     * 通过学科名查询学科信息是否重复
     * @param subjectName
     * @return
     */
    @ResponseBody
    @RequestMapping("/isHaveSubjectName")
    public String isHaveSubjectName(String subjectName){
        System.out.println("学科名:"+subjectName);
        List<Subject> subjects = subjectService.getSubjectBySubjectName(subjectName);
        if(subjects.size()!=0){
            return "true";
        }else {
            return "false";
        }
    }

    @ResponseBody
    @RequestMapping("/isHaveSubjectName2")
    public String isHaveSubjectName2(String subjectName){
        System.out.println("学科名:"+subjectName);
        List<Subject> subjects = subjectService.getSubjectBySubjectName(subjectName);
        if(subjects.size()!=0){
            int id=subjects.get(0).getSubjectId();
            String Id=String.valueOf(id);
            return Id;
        }else {
            return "false";
        }
    }

    /**
     * 添加学科
     * @param subjectName
     * @return
     */
    @ResponseBody
    @RequestMapping("/addSubject")
    public String addSubject(String subjectName){
        if(subjectService.insert(subjectName)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     *
     * @param subject
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateSubject")
    public String addSubject(Subject subject) {
        if(subjectService.updateById(subject)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 删除学科
     * @param subjectId
     * @return
     */
    @ResponseBody
    @GetMapping("/delSubject")
    public String delSubject(int subjectId){
        int result = subjectService.delSubject(subjectId);
        System.out.println("删除成功！");
        if(result>0){
            return "true";
        }
        else {
            return "false";
        }
    }

    @ResponseBody
    @GetMapping("/getSubjectListByCreate")
    /**
     *添加教师信息需要的任教学科集合
     * @return
     */
    public Map<String,Object> getSubjectListByCreate(){
        try{
            List<Subject> subjectList = subjectService.getSubjectsList();   //获取学科集合
            return ReturnResult.returnSuccess(null,subjectList);
        }catch (Exception e){
            return ReturnResult.returnFail(null,null,500);
        }
    }
}
