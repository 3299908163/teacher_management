package cn.teacherinfo.controller;

import cn.teacherinfo.entity.Degree;
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
 * @Classname DegreeController
 * @Description TODO
 * @Date 2020/11/19 15:44
 * @Created by 32999
 */
@Controller
@RequestMapping("/degree")
public class DegreeController {
    @Autowired
    private DegreeService degreeService;

    /**
     * 学位分页
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @GetMapping("/degreeList")
    public Object listDegree(@RequestParam(required = false) Integer page,
                             @RequestParam(required = false) Integer limit){
        Page<Degree> ipage = new Page<>(page,limit);
        IPage<Degree> degreeIPage = degreeService.selectPageDegree(ipage);
        int count = degreeService.count();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",degreeIPage.getRecords());
        return map;
    }

    /**
     * 通过学位名查询学位信息是否重复
     * @param degreeName
     * @return
     */
    @ResponseBody
    @RequestMapping("/isHaveDegreeName")
    public String isHaveDegreeName(String degreeName){
        System.out.println("学位名:"+degreeName);
        List<Degree> degrees = degreeService.getDegreeByDegreeName(degreeName);
        if(degrees.size()!=0){
            return "true";
        }else {
            return "false";
        }
    }
    @ResponseBody
    @RequestMapping("/isHaveDegreeName2")
    public String isHaveDegreeName2(String degreeName){
        System.out.println("学位名:"+degreeName);
        List<Degree> degrees = degreeService.getDegreeByDegreeName(degreeName);
        if(degrees.size()!=0){
            int id=degrees.get(0).getDegreeId();
            String Id=String.valueOf(id);
            return Id;
        }else {
            return "false";
        }
    }

    /**
     * 添加学位
     * @param degreeName
     * @return
     */
    @ResponseBody
    @RequestMapping("/addDegree")
    public String addDegree(String degreeName){
        if(degreeService.insert(degreeName)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 修改学位
     * @param degree
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateDegree")
    public String updateDegree(Degree degree) {
        if(degreeService.updateById(degree)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 删除学位
     * @param degreeId
     * @return
     */
    @ResponseBody
    @GetMapping("/delDegree")
    public String delDegree(int degreeId){
        int result = degreeService.deleteById(degreeId);
        System.out.println("删除成功！");
        if(result>0){
            return "true";
        }
        else {
            return "false";
        }
    }

    @ResponseBody
    @GetMapping("/getDegreeListByCreate")
    /**
     *添加教师信息需要的学位集合
     * @return
     */
    public Map<String,Object> getDegreeListByCreate(){
        try{
            List<Degree> degreeList = degreeService.getDegreeList();   //获取学科集合
            return ReturnResult.returnSuccess(null,degreeList);
        }catch (Exception e){
            return ReturnResult.returnFail(null,null,500);
        }
    }
}
