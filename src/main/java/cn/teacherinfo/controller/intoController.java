package cn.teacherinfo.controller;

import cn.teacherinfo.dao.DegreeMapper;
import cn.teacherinfo.dao.QualificationMapper;
import cn.teacherinfo.dao.SubjectMapper;
import cn.teacherinfo.dao.TitleMapper;
import cn.teacherinfo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Classname intoController
 * @Description TODO
 * @Date 2020/11/3 10:21
 * @Created by 32999
 */
@Controller
public class intoController {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private TitleMapper titleMapper;

    @Autowired
    private QualificationMapper qualificationMapper;

    @Autowired
    private DegreeMapper degreeMapper;

    /**
     * 进入登陆
     * @return
     */
    @RequestMapping("/intoLogin")
    public String intoLogin(){
        return "login";
    }

    /**
     * 进入首页
     * @return
     */
    @RequestMapping("/intoindex")
    public String intoIndex(){return "teacher/index";}

    /**
     * 进入教师信息页面
     * @return
     */
    @RequestMapping("/intoTeacherInfo")
    public String intoTeacherInfo(Model model){
        List<Subject> subjectList = subjectMapper.getSubjectsList();
        List<Title> titleList = titleMapper.getTitleList();
        List<Qualification> qualificationList = qualificationMapper.getQualificationList();
        List<Degree> degreeList = degreeMapper.getDegreeList();
        model.addAttribute("subjectList",subjectList);
        model.addAttribute("qualificationList",qualificationList);
        model.addAttribute("titleList",titleList);
        model.addAttribute("degreeList",degreeList);
        return "teacher/TeacherInfo";
    }

    /**
     * 进入添加教师页面
     * @return
     */
    @RequestMapping("/intoTeacherAdd")
    public String intoTeacherAdd(){
        return "teacher/TeacherRegister";
    }

    /**
     * 进入学科信息页面
     * @return
     */
    @RequestMapping("/intoSubjectInfo")
    public String intoSubjectInfo(){
        return "subject/SubjectInfo";
    }

    /**
     * 进入职称资格信息页面
     * @return
     */
    @RequestMapping("/intoTitleInfo")
    public String intoTitleInfo(){
        return "title/TitleInfo";
    }

    /**
     * 进入教师资格种类信息页面
     * @return
     */
    @RequestMapping("/intoQualificationInfo")
    public String intoQualificationInfo(){
        return "qualification/QualificationInfo";
    }

    /**
     * 进入专业技术职务信息页面
     * @return
     */
    @RequestMapping("/intoPositionInfo")
    public String intoPositionInfo(){
        return "position/PositionInfo";
    }

    /**
     * 进入学位信息页面
     * @return
     */
    @RequestMapping("/intoDegreeInfo")
    public String intoDegreeInfo(){
        return "degree/DegreeInfo";
    }

    /**
     * 进入合同信息页面
     * @return
     */
    @RequestMapping("/intoContractInfo")
    public String intoContractInfo(){
        return "contract/ContractInfo";
    }
}
