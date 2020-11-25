package cn.teacherinfo.service;

import cn.teacherinfo.entity.Contract;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ContractInfoService
 * @Description TODO
 * @Date 2020/10/27 9:28
 * @Created by 32999
 */
public interface ContractService {
    /**
     * 查询合同信息
     * @return
     */
    List<Contract> getContractList();

    /**
     * 分页学科
     */
    IPage<Contract> selectPageContract(Page page);

    /**
     * 根据合同姓名查询合同信息
     * @param contractName
     * @return
     */
    List<Contract> getContractByContractName(String contractName);

    /**
     * 查询合同总数
     * @return
     */
    int count();

    /**
     * 添加合同
     * @param contractName
     * @return
     */
    int insert(String contractName);

    /**
     * 删除合同
     * @param contractId
     * @return
     */
    int deleteById(int contractId);

    /**
     * 修改合同
     * @param contract
     * @return
     */
    int updateById(Contract contract);
}
