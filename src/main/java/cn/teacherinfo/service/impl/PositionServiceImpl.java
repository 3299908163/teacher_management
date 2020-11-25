package cn.teacherinfo.service.impl;

import cn.teacherinfo.dao.PositionMapper;
import cn.teacherinfo.entity.Position;
import cn.teacherinfo.service.PositionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname PostServiceImpl
 * @Description TODO
 * @Date 2020/11/19 15:31
 * @Created by 32999
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<Position> getPositionList() {
        return positionMapper.getPositionList();
    }

    @Override
    public IPage<Position> selectPagePosition(Page page) {
        return positionMapper.selectPagePosition(page);
    }

    @Override
    public List<Position> getPositionByPositionName(String positionName) {
        return positionMapper.getPositionByPositionName(positionName);
    }

    @Override
    public int count() {
        return positionMapper.count();
    }

    @Override
    public int insert(String positionName) {
        return positionMapper.insert(positionName);
    }

    @Override
    public int deleteById(int positionId) {
        return positionMapper.deleteById(positionId);
    }

    @Override
    public int updateById(Position position) {
        return positionMapper.updateById(position);
    }
}
