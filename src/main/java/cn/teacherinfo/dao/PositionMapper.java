package cn.teacherinfo.dao;

import cn.teacherinfo.entity.Position;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionMapper {
    /**
     * 查询专业技术职务信息
     * @return
     */
    List<Position> getPositionList();

    /**
     * 分页专业技术职务
     */
    IPage<Position> selectPagePosition(Page page);

    /**
     * 根据专业技术职务姓名查询专业技术职务信息
     * @param positionName
     * @return
     */
    List<Position> getPositionByPositionName(String positionName);

    /**
     * 查询专业技术职务总数
     * @return
     */
    int count();

    /**
     * 添加专业技术职务
     * @param positionName
     * @return
     */
    int insert(String positionName);

    /**
     * 删除专业
     * @param positionId
     * @return
     */
    int deleteById(int positionId);

    /**
     * 修改专业技术职务
     * @param position
     * @return
     */
    int updateById(Position position);
}