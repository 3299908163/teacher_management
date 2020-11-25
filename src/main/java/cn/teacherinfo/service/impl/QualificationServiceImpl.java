package cn.teacherinfo.service.impl;

import cn.teacherinfo.dao.QualificationMapper;
import cn.teacherinfo.entity.Qualification;
import cn.teacherinfo.service.QualificationService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname QualificationServiceImpl
 * @Description TODO
 * @Date 2020/11/19 15:31
 * @Created by 32999
 */
@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationMapper qualificationMapper;

    @Override
    public List<Qualification> getQualificationList() {
        return qualificationMapper.getQualificationList();
    }

    @Override
    public IPage<Qualification> selectPageQualification(Page page) {
        return qualificationMapper.selectPageQualification(page);
    }

    @Override
    public List<Qualification> getQualificationByqualificationName(String qualificationName) {
        return qualificationMapper.getQualificationByqualificationName(qualificationName);
    }

    @Override
    public int count() {
        return qualificationMapper.count();
    }

    @Override
    public int insert(String qualificationName) {
        return qualificationMapper.insert(qualificationName);
    }

    @Override
    public int deleteById(int qualificationId) {
        return qualificationMapper.deleteById(qualificationId);
    }

    @Override
    public int updateById(Qualification qualification) {
        return qualificationMapper.updateById(qualification);
    }
}
