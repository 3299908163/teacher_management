package cn.teacherinfo.service.impl;

import cn.teacherinfo.dao.SubjectMapper;
import cn.teacherinfo.entity.Subject;
import cn.teacherinfo.service.SubjectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname SubjectServiceImpl
 * @Description TODO
 * @Date 2020/11/11 16:09
 * @Created by 32999
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> getSubjectsList() {
        return subjectMapper.getSubjectsList();
    }

    @Override
    public IPage<Subject> selectPageSubject(Page page) {
        return subjectMapper.selectPageSubject(page);
    }

    @Override
    public List<Subject> getSubjectBySubjectName(String subjectName) {
        return subjectMapper.getSubjectBySubjectName(subjectName);
    }

    @Override
    public int count() {
        return subjectMapper.count();
    }

    @Override
    public int insert(String subjectName) {
        return subjectMapper.insert(subjectName);
    }

    @Override
    public int updateById(Subject subject) {
        return subjectMapper.updateById(subject);
    }

    @Override
    public int delSubject(int subjectId) {
        return subjectMapper.deleteById(subjectId);
    }
}
