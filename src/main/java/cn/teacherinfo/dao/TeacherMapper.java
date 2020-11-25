package cn.teacherinfo.dao;

import cn.teacherinfo.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * Mapper注释的作用
 1:为了把mapper这个DAO交給Spring管理
 2:为了不再写mapper映射文件
 3:为了给mapper接口 自动根据一个添加@Mapper注解的接口生成一个实现类
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    List<Teacher> selectAll();

    IPage<Teacher> selectPageTeacher(Page page, @Param("titleId") int titleId,@Param("qualificationId") int qualificationId,@Param("degreeId") int degreeId,@Param("subjectId") int subjectId,@Param("isAdmin")String isAdmin,@Param("userName") String userName);

    Teacher selectInfoByIdentity(String userIdentity,String userName);

    Teacher findTeacherByidentity(String userIdentity);

    int count(@Param("titleId") int titleId,@Param("qualificationId") int qualificationId,@Param("degreeId")int degreeId,@Param("subjectId") int subjectId,@Param("isAdmin")String isAdmin,@Param("userName") String userName);

    int insert(Teacher record);

    int deleteById(int userId);

    int insertSelective(Teacher teacher);

    Teacher selectByPrimaryKey(Integer userId);

    int updateByIdSelective(Teacher teacher);
}