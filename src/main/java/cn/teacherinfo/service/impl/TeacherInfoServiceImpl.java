package cn.teacherinfo.service.impl;

import cn.teacherinfo.dao.TeacherMapper;
import cn.teacherinfo.entity.Teacher;
import cn.teacherinfo.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname TeacherInfoServiceImpl
 * @Description TODO
 * @Date 2020/10/27 10:42
 * @Created by 32999
 */
@Service
public class TeacherInfoServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 登陆方法
     * @param userIdentity
     * @param username
     * @return
     */
    @Override
    public Teacher login(String userIdentity, String username) {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("user_identity",userIdentity).eq("user_name",username);
        return teacherMapper.selectOne(wrapper);
    }

    /**
     * 查询所有教师信息
     * @return
     */
    @Override
    public List<Teacher> teacherList() {
        return null;
    }

    /**
     * 分页查询教师信息
     * @param page
     * @param titleId
     * @param qualificationId
     * @param degreeId
     * @param subjectId
     * @param isAdmin
     * @param userName
     * @return
     */
    @Override
    public IPage<Teacher> getPageTeacher(Page page,int titleId,int qualificationId,int degreeId,int subjectId,String isAdmin, String userName) {
        IPage<Teacher> pageUser = teacherMapper.selectPageTeacher(page,titleId,qualificationId,degreeId,subjectId,isAdmin,userName);
        for (Teacher pageInfo:pageUser.getRecords()){   //遍历分页
            if("0".equals(pageInfo.getUserSex())){      //如果性别为0，就是男
                pageInfo.setUserSex("男");
            }
            else {
                pageInfo.setUserSex("女");
            }
            if("0".equals(pageInfo.getIsAdmin())){
                pageInfo.setIsAdmin("普通员工");
            }else if("1".equals(pageInfo.getIsAdmin())){
                pageInfo.setIsAdmin("管理员");
            }
        }
        return pageUser;
    }

    /**
     * 查询教师数量
     * @param titleId
     * @param qualificationId
     * @param degreeId
     * @param subjectId
     * @param isAdmin
     * @param userName
     * @return
     */
    @Override
    public int count(int titleId,int qualificationId,int degreeId,int subjectId,String isAdmin, String userName) {
        return teacherMapper.count(titleId,qualificationId,degreeId,subjectId,isAdmin,userName);
    }


    /**
     * 查询身份证是否存在
     * @param userIdentity
     * @return
     */
    @Override
    public Teacher findTeacherByidentity(String userIdentity) {
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.eq("user_identity",userIdentity);
        return teacherMapper.selectOne(wrapper);
    }

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.insertSelective(teacher);
    }

    /**
     * 修改教师信息
     * @param teacher
     * @return
     */
    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateByIdSelective(teacher);
    }

    /**
     * 修改session
     * @param teacher
     * @return
     */
    @Override
    public Integer updateSession(Teacher teacher) {
        return teacherMapper.updateById(teacher);
    }

    /**
     * 删除教师信息
     * @param userId
     * @return
     */
    @Override
    public int delTeacher(int userId) {
        return teacherMapper.deleteById(userId);
    }
}
