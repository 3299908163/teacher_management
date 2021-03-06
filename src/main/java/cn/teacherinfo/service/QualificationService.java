package cn.teacherinfo.service;

import cn.teacherinfo.entity.Qualification;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname QualificationInfoService
 * @Description TODO
 * @Date 2020/10/27 9:27
 * @Created by 32999
 */
public interface QualificationService {
    /**
     * 查询教师资格种类信息
     * @return
     */
    List<Qualification> getQualificationList();

    /**
     * 分页教师资格种类
     */
    IPage<Qualification> selectPageQualification(Page page);

    /**
     * 根据教师资格种类姓名查询教师资格种类信息
     * @param qualificationName
     * @return
     */
    List<Qualification> getQualificationByqualificationName(String qualificationName);

    /**
     * 查询教师资格种类总数
     * @return
     */
    int count();

    /**
     * 添加教师资格种类
     * @param qualificationName
     * @return
     */
    int insert(String qualificationName);

    /**
     * 删除教师资格种类
     * @param qualificationId
     * @return
     */
    int deleteById(int qualificationId);

    /**
     * 修改教师资格种类
     * @param qualification
     * @return
     */
    int updateById(Qualification qualification);
}
