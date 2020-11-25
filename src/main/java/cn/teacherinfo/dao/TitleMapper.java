package cn.teacherinfo.dao;

import cn.teacherinfo.entity.Title;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TitleMapper extends BaseMapper<Title> {
    /**
     * 查询职称资格信息
     * @return
     */
    List<Title> getTitleList();

    /**
     * 分页职称资格
     */
    IPage<Title> selectPageTitle(Page page);

    /**
     * 根据职称资格姓名查询职称资格信息
     * @param titleName
     * @return
     */
    List<Title> getTitleByTitleName(String titleName);

    /**
     * 查询职称资格总数
     * @return
     */
    int count();

    /**
     * 添加职称资格
     * @param titleName
     * @return
     */
    int insert(String titleName);

    /**
     * 删除职称资格
     * @param titleId
     * @return
     */
    int deleteById(int titleId);

    /**
     * 修改职称资格
     * @param title
     * @return
     */
    int updateById(Title title);
}