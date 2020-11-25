package cn.teacherinfo.service;

import cn.teacherinfo.entity.Subject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SubjectinfoService
 * @Description TODO
 * @Date 2020/10/27 9:27
 * @Created by 32999
 */
@Service
public interface SubjectService {

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

    int updateById(Subject subject);

    int delSubject(int subjectId);
}
