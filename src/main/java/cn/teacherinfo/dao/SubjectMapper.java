package cn.teacherinfo.dao;

import cn.teacherinfo.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

    /**
     * 查询学科信息
     * @return
     */
    List<Subject> getSubjectsList();

    /**
     * 分页学科
     */
    IPage<Subject> selectPageSubject(Page page);

    /**
     * 根据学科姓名查询学科信息
     * @param subjectName
     * @return
     */
    List<Subject> getSubjectBySubjectName(String subjectName);

    /**
     * 查询学科总数
     * @return
     */
    int count();

    /**
     * 添加学科
     * @param subjectName
     * @return
     */
    int insert(String subjectName);

    /**
     * 删除学科
     * @param subjectId
     * @return
     */
    int deleteById(int subjectId);

    /**
     * 修改学科
     * @param subject
     * @return
     */
    int updateById(Subject subject);
}