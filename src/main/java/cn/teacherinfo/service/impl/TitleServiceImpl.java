package cn.teacherinfo.service.impl;

import cn.teacherinfo.dao.TitleMapper;
import cn.teacherinfo.entity.Title;
import cn.teacherinfo.service.TitleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname TitleServiceImpl
 * @Description TODO
 * @Date 2020/11/19 16:53
 * @Created by 32999
 */
@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleMapper titleMapper;

    @Override
    public List<Title> getTitleList() {
        return titleMapper.getTitleList();
    }

    @Override
    public IPage<Title> selectPageTitle(Page page) {
        return titleMapper.selectPageTitle(page);
    }

    @Override
    public List<Title> getTitleByTitleName(String titleName) {
        return titleMapper.getTitleByTitleName(titleName);
    }

    @Override
    public int count() {
        return titleMapper.count();
    }

    @Override
    public int insert(String titleName) {
        return titleMapper.insert(titleName);
    }

    @Override
    public int deleteById(int titleId) {
        return titleMapper.deleteById(titleId);
    }

    @Override
    public int updateById(Title title) {
        return titleMapper.updateById(title);
    }
}
