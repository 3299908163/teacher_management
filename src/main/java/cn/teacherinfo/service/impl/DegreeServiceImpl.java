package cn.teacherinfo.service.impl;

import cn.teacherinfo.dao.DegreeMapper;
import cn.teacherinfo.entity.Degree;
import cn.teacherinfo.service.DegreeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname DegreeServiceImpl
 * @Description TODO
 * @Date 2020/11/19 15:31
 * @Created by 32999
 */
@Service
public class DegreeServiceImpl implements DegreeService {

    @Autowired
    private DegreeMapper degreeMapper;

    @Override
    public List<Degree> getDegreeList() {
        return degreeMapper.getDegreeList();
    }

    @Override
    public IPage<Degree> selectPageDegree(Page page) {
        return degreeMapper.selectPageDegree(page);
    }

    @Override
    public List<Degree> getDegreeByDegreeName(String degreeName) {
        return degreeMapper.getDegreeByDegreeName(degreeName);
    }

    @Override
    public int count() {
        return degreeMapper.count();
    }

    @Override
    public int insert(String degreeName) {
        return degreeMapper.insert(degreeName);
    }

    @Override
    public int deleteById(int degreeId) {
        return degreeMapper.deleteById(degreeId);
    }

    @Override
    public int updateById(Degree degree) {
        return degreeMapper.updateById(degree);
    }
}
