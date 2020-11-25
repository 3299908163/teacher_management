package cn.teacherinfo.controller;

import cn.teacherinfo.entity.Teacher;
import cn.teacherinfo.service.TeacherService;
import cn.teacherinfo.utils.Constant;
import cn.teacherinfo.utils.ReturnResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname TeacherInfoController
 * @Description TODO
 * @Date 2020/10/27 10:58
 * @Created by 32999
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 教师信息分页
     * @param page
     * @param limit
     * @param titleId
     * @param qualificationId
     * @param degreeId
     * @param userName
     * @param isAdmin
     * @param subjectId
     * @return
     */
    @ResponseBody
    @GetMapping("/teacherList")
    public Object listTeacher(@RequestParam(required = false) Integer page,
                              @RequestParam(required = false) Integer limit,
                              @RequestParam(required = false) int titleId,
                              @RequestParam(required = false) int qualificationId,
                              @RequestParam(required = false) int degreeId,
                              @RequestParam(required = false) String userName,
                              @RequestParam(required = false) String isAdmin,
                              @RequestParam(required = false) Integer subjectId){
        Page<Teacher> ipage = new Page<>(page,limit);
        IPage<Teacher> pageTeacher = teacherService.getPageTeacher(ipage,titleId,qualificationId,degreeId,subjectId,isAdmin,userName);
        int count = teacherService.count(titleId,qualificationId,degreeId,subjectId,isAdmin,userName);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",pageTeacher.getRecords());
        return map;
    }

    /**
     * 修改教师
     * @param userName
     * @param userIdentity
     * @param userAddress
     * @param userPhone
     * @param userId
     * @param userSex
     * @param userBirthday
     * @param userWorkhours
     * @param userJoinparty
     * @param userEmail
     * @param titleId
     * @param titleTime
     * @param positionId
     * @param qualificationId
     * @param subjectId
     * @param contractId
     * @param contractStarttime
     * @param contractEndtime
     * @param educationFirstName
     * @param educationFirstSchool
     * @param educationFirstProfessionalName
     * @param educationFirstGraduationtime
     * @param degreeId
     * @param educationHighestName
     * @param educationHighestSchool
     * @param educationHighestProfessionalName
     * @param educationHighestGraduationtime
     * @param remarks
     * @param isAdmin
     * @return
     * @throws ParseException
     */
    @ResponseBody
    @RequestMapping("/updateTeacher")
    public String updateTeacher(String userName,String userIdentity,String userAddress,String userPhone,
                                String userId,String userSex,String userBirthday, String userWorkhours,
                                String userJoinparty,String userEmail,String titleId, String titleTime,
                                String positionId,String qualificationId,String subjectId,String contractId,
                                String contractStarttime,String contractEndtime,String educationFirstName,
                                String educationFirstSchool,String educationFirstProfessionalName,
                                String educationFirstGraduationtime,String degreeId,String educationHighestName,
                                String educationHighestSchool,String educationHighestProfessionalName,
                                String educationHighestGraduationtime,String remarks, String isAdmin) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date userbirthday = simpleDateFormat.parse(userBirthday);
        Date userworkhours = simpleDateFormat.parse(userWorkhours);
        Date userjoinparty = simpleDateFormat.parse(userJoinparty);
        Date titletime = simpleDateFormat.parse(titleTime);
        Date contractstarttime = simpleDateFormat.parse(contractStarttime);
        Date contractendtime = simpleDateFormat.parse(contractEndtime);
        Date educationfirstgraduationtime = simpleDateFormat.parse(educationFirstGraduationtime);
        Date educationhighestgraduationtime = simpleDateFormat.parse(educationHighestGraduationtime);
        Integer userid = Integer.valueOf(userId);
        Integer subjectid = Integer.valueOf(subjectId);
        Integer titleid = Integer.valueOf(titleId);
        Integer positionid = Integer.valueOf(positionId);
        Integer qualificationid = Integer.valueOf(qualificationId);
        Integer contractid = Integer.valueOf(contractId);
        Integer degreeid = Integer.valueOf(degreeId);

        Teacher teacher = new Teacher();
        teacher.setUserName(userName);
        teacher.setUserIdentity(userIdentity);
        teacher.setUserAddress(userAddress);
        teacher.setUserPhone(userPhone);
        teacher.setUserId(userid);
        teacher.setUserSex(userSex);
        teacher.setUserBirthday(userbirthday);
        teacher.setUserWorkhours(userworkhours);
        teacher.setUserJoinparty(userjoinparty);
        teacher.setUserEmail(userEmail);
        teacher.setTitleId(titleid);
        teacher.setTitleTime(titletime);
        teacher.setPositionId(positionid);
        teacher.setQualificationId(qualificationid);
        teacher.setSubjectId(subjectid);
        teacher.setContractId(contractid);
        teacher.setContractStarttime(contractstarttime);
        teacher.setContractEndtime(contractendtime);
        teacher.setEducationFirstName(educationFirstName);
        teacher.setEducationFirstSchool(educationFirstSchool);
        teacher.setEducationFirstProfessionalName(educationFirstProfessionalName);
        teacher.setEducationFirstGraduationtime(educationfirstgraduationtime);
        teacher.setDegreeId(degreeid);
        teacher.setEducationHighestName(educationHighestName);
        teacher.setEducationHighestSchool(educationHighestSchool);
        teacher.setEducationHighestProfessionalName(educationHighestProfessionalName);
        teacher.setEducationHighestGraduationtime(educationhighestgraduationtime);
        teacher.setRemarks(remarks);
        teacher.setIsAdmin(isAdmin);

        if(teacherService.updateTeacher(teacher)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 注册教师
     * @param userName
     * @param userIdentity
     * @param userAddress
     * @param userPhone
     * @param subjectId
     * @param userSex
     * @param userBirthday
     * @param userWorkhours
     * @param userEmail
     * @param isAdmin
     * @param session
     * @return
     * @throws ParseException
     */
    @RequestMapping("/addTeacher")
    @ResponseBody
    public Object addTeacher(String userName,String userIdentity,String userAddress,String userPhone,
                             String userSex,String userBirthday, String userWorkhours,
                             String userJoinparty,String userEmail,String titleId, String titleTime,
                             String positionId,String qualificationId,String subjectId,String contractId,
                             String contractStarttime,String contractEndtime,String educationFirstName,
                             String educationFirstSchool,String educationFirstProfessionalName,
                             String educationFirstGraduationtime,String degreeId,String educationHighestName,
                             String educationHighestSchool,String educationHighestProfessionalName,
                             String educationHighestGraduationtime,String remarks, String isAdmin,HttpSession session) throws ParseException {
        Teacher teacher1 = teacherService.findTeacherByidentity(userIdentity);
        if(teacher1!=null){     //不为空表示已经有此用户
            return ReturnResult.returnFail("用户已存在",null,"600");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date userbirthday = simpleDateFormat.parse(userBirthday);
        Date userworkhours = simpleDateFormat.parse(userWorkhours);
        Date userjoinparty = simpleDateFormat.parse(userJoinparty);
        Date titletime = simpleDateFormat.parse(titleTime);
        Date contractstarttime = simpleDateFormat.parse(contractStarttime);
        Date contractendtime = simpleDateFormat.parse(contractEndtime);
        Date educationfirstgraduationtime = simpleDateFormat.parse(educationFirstGraduationtime);
        Date educationhighestgraduationtime = simpleDateFormat.parse(educationHighestGraduationtime);
        Integer subjectid = Integer.valueOf(subjectId);
        Integer titleid = Integer.valueOf(titleId);
        Integer positionid = Integer.valueOf(positionId);
        Integer qualificationid = Integer.valueOf(qualificationId);
        Integer contractid = Integer.valueOf(contractId);
        Integer degreeid = Integer.valueOf(degreeId);

        Teacher teacher = new Teacher();
        teacher.setUserName(userName);
        teacher.setUserIdentity(userIdentity);
        teacher.setUserAddress(userAddress);
        teacher.setUserPhone(userPhone);
        teacher.setUserSex(userSex);
        teacher.setUserBirthday(userbirthday);
        teacher.setUserWorkhours(userworkhours);
        teacher.setUserJoinparty(userjoinparty);
        teacher.setUserEmail(userEmail);
        teacher.setTitleId(titleid);
        teacher.setTitleTime(titletime);
        teacher.setPositionId(positionid);
        teacher.setQualificationId(qualificationid);
        teacher.setSubjectId(subjectid);
        teacher.setContractId(contractid);
        teacher.setContractStarttime(contractstarttime);
        teacher.setContractEndtime(contractendtime);
        teacher.setEducationFirstName(educationFirstName);
        teacher.setEducationFirstSchool(educationFirstSchool);
        teacher.setEducationFirstProfessionalName(educationFirstProfessionalName);
        teacher.setEducationFirstGraduationtime(educationfirstgraduationtime);
        teacher.setDegreeId(degreeid);
        teacher.setEducationHighestName(educationHighestName);
        teacher.setEducationHighestSchool(educationHighestSchool);
        teacher.setEducationHighestProfessionalName(educationHighestProfessionalName);
        teacher.setEducationHighestGraduationtime(educationhighestgraduationtime);
        teacher.setRemarks(remarks);
        teacher.setIsAdmin(isAdmin);
        int i = teacherService.addTeacher(teacher);
        if(i>0){
            session.setAttribute(Constant.CURRENT_USER, teacher);
            return ReturnResult.returnSuccess("注册成功",teacher.getUserName());
        }else {
            return ReturnResult.returnFail("注册失败",null,"500");
        }

    }

    /**
     * 删除教师
     * @param list
     * @return
     */
    @ResponseBody
    @GetMapping("/delTeacher")
    public String delTeacher(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int a = teacherService.delTeacher(list[i]);
            System.out.println("删除成功！");
            if (a == 0) {
                return "false";
            }
        }
        return "true";
    }

}
