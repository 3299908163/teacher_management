package cn.teacherinfo.service.impl;

import cn.teacherinfo.dao.ContractMapper;
import cn.teacherinfo.entity.Contract;
import cn.teacherinfo.service.ContractService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ContractServiceImpl
 * @Description TODO
 * @Date 2020/11/19 15:30
 * @Created by 32999
 */
@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public List<Contract> getContractList() {
        return contractMapper.getContractList();
    }

    @Override
    public IPage<Contract> selectPageContract(Page page) {
        return contractMapper.selectPageContract(page);
    }

    @Override
    public List<Contract> getContractByContractName(String contractName) {
        return contractMapper.getContractByContractName(contractName);
    }

    @Override
    public int count() {
        return contractMapper.count();
    }

    @Override
    public int insert(String contractName) {
        return contractMapper.insert(contractName);
    }

    @Override
    public int deleteById(int contractId) {
        return contractMapper.deleteById(contractId);
    }

    @Override
    public int updateById(Contract contract) {
        return contractMapper.updateById(contract);
    }
}
