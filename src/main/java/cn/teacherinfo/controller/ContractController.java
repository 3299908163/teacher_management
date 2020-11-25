package cn.teacherinfo.controller;

import cn.teacherinfo.entity.Contract;
import cn.teacherinfo.entity.Degree;
import cn.teacherinfo.entity.Teacher;
import cn.teacherinfo.service.ContractService;
import cn.teacherinfo.service.DegreeService;
import cn.teacherinfo.utils.ReturnResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname ContractController
 * @Description TODO
 * @Date 2020/11/19 15:44
 * @Created by 32999
 */
@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    /**
     * 合同分页
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @GetMapping("/contractList")
    public Object listContract(@RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Integer limit){
        Page<Contract> ipage = new Page<>(page,limit);
        IPage<Contract> contractIPage = contractService.selectPageContract(ipage);
        int count = contractService.count();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",contractIPage.getRecords());
        return map;
    }

    /**
     * 通过合同名查询合同信息是否重复
     * @param contractName
     * @return
     */
    @ResponseBody
    @RequestMapping("/isHaveContractName")
    public String isHaveContractName(String contractName){
        System.out.println("合同名:"+contractName);
        List<Contract> contracts = contractService.getContractByContractName(contractName);
        if(contracts.size()!=0){
            return "true";
        }else {
            return "false";
        }
    }

    @ResponseBody
    @RequestMapping("/isHaveContractName2")
    public String isHaveContractName2(String contractName){
        System.out.println("合同名:"+contractName);
        List<Contract> contracts = contractService.getContractByContractName(contractName);
        if(contracts.size()!=0){
            int id=contracts.get(0).getContractId();
            String Id=String.valueOf(id);
            return Id;
        }else {
            return "false";
        }
    }

    /**
     * 添加合同
     * @param contractName
     * @return
     */
    @ResponseBody
    @RequestMapping("/addContract")
    public String addContract(String contractName){
        if(contractService.insert(contractName)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 修改合同
     * @param contract
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateContract")
    public String updateContract(Contract contract) {
        if(contractService.updateById(contract)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 删除合同
     * @param contractId
     * @return
     */
    @ResponseBody
    @GetMapping("/delContract")
    public String delContract(int contractId){
        int result = contractService.deleteById(contractId);
        System.out.println("删除成功！");
        if(result>0){
            return "true";
        }
        else {
            return "false";
        }
    }

    @ResponseBody
    @GetMapping("/getContractListByCreate")
    /**
     *添加教师信息需要的合同集合
     * @return
     */
    public Map<String,Object> getContractListByCreate(){
        try{
            List<Contract> contractList = contractService.getContractList();   //获取合同集合
            return ReturnResult.returnSuccess(null,contractList);
        }catch (Exception e){
            return ReturnResult.returnFail(null,null,500);
        }
    }
}
