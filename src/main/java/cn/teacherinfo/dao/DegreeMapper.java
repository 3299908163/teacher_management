package cn.teacherinfo.dao;

import cn.teacherinfo.entity.Degree;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DegreeMapper {
    /**
     * 查询学位信息
     * @return
     */
    List<Degree> getDegreeList();

    /**
     * 分页学位
     */
    IPage<Degree> selectPageDegree(Page page);

    /**
     * 根据学位姓名查询学位信息
     * @param degreeName
     * @return
     */
    List<Degree> getDegreeByDegreeName(String degreeName);

    /**
     * 查询学位总数
     * @return
     */
    int count();

    /**
     * 添加学位
     * @param degreeName
     * @return
     */
    int insert(String degreeName);

    /**
     * 删除学位
     * @param degreeId
     * @return
     */
    int deleteById(int degreeId);

    /**
     * 修改学位
     * @param degree
     * @return
     */
    int updateById(Degree degree);
}