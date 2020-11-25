package cn.teacherinfo.service;

import cn.teacherinfo.entity.Teacher;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname TeacherInfoService
 * @Description TODO
 * @Date 2020/10/27 9:26
 * @Created by 32999
 */
@Service
public interface TeacherService {
    /**
     * 登陆方法
     * @param userIdentity
     * @param username
     * @return
     */
    Teacher login(String userIdentity, String username);

    /**
     *查询所有教师信息
     * @return
     */
    List<Teacher> teacherList();

    IPage<Teacher> getPageTeacher(Page page,@Param("titleId") int titleId,@Param("qualificationId") int qualificationId,@Param("degreeId") int degreeId,@Param("subjectId") int subjectId,@Param("isAdmin")String isAdmin,@Param("userName") String userName);

    int count(@Param("titleId") int titleId,@Param("qualificationId") int qualificationId,@Param("degreeId") int degreeId,@Param("subjectId") int subjectId,@Param("isAdmin")String isAdmin,@Param("userName") String userName);

    Teacher findTeacherByidentity(String userIdentity);

    /**
     * 添加教师信息
     * @param teacher
     * @return
     */
    int addTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 修改sessionid
     * @return
     */
    Integer updateSession(Teacher teacher);

    /**
     * 删除教师信息
     * @param userId
     * @return
     */
    int delTeacher(int userId);
}
