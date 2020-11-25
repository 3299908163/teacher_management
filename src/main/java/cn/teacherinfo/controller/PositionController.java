package cn.teacherinfo.controller;

import cn.teacherinfo.entity.Position;
import cn.teacherinfo.service.PositionService;
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
 * @Classname PositionController
 * @Description TODO
 * @Date 2020/11/19 15:44
 * @Created by 32999
 */
@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    /**
     * 专业技术职务分页
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @GetMapping("/positionList")
    public Object listPosition(@RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Integer limit){
        Page<Position> ipage = new Page<>(page,limit);
        IPage<Position> positionIPage = positionService.selectPagePosition(ipage);
        int count = positionService.count();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",positionIPage.getRecords());
        return map;
    }

    /**
     * 通过专业技术职务名查询专业技术职务信息是否重复
     * @param positionName
     * @return
     */
    @ResponseBody
    @RequestMapping("/isHavePositionName")
    public String isHavePositionName(String positionName){
        System.out.println("专业技术职务名:"+positionName);
        List<Position> positions = positionService.getPositionByPositionName(positionName);
        if(positions.size()!=0){
            return "true";
        }else {
            return "false";
        }
    }
    @ResponseBody
    @RequestMapping("/isHavePositionName2")
    public String isHavePositionName2(String positionName){
        System.out.println("专业技术职务名:"+positionName);
        List<Position> positions = positionService.getPositionByPositionName(positionName);
        if(positions.size()!=0){
            int id=positions.get(0).getPositionId();
            String Id=String.valueOf(id);
            return Id;
        }else {
            return "false";
        }
    }

    /**
     * 添加专业技术职务
     * @param positionName
     * @return
     */
    @ResponseBody
    @RequestMapping("/addPosition")
    public String addPosition(String positionName){
        if(positionService.insert(positionName)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 修改专业技术职务
     * @param position
     * @return
     */
    @ResponseBody
    @RequestMapping("/updatePosition")
    public String updatePosition(Position position) {
        if(positionService.updateById(position)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 删除专业技术职务
     * @param positionId
     * @return
     */
    @ResponseBody
    @GetMapping("/delPosition")
    public String delPosition(int positionId){
        int result = positionService.deleteById(positionId);
        System.out.println("删除成功！");
        if(result>0){
            return "true";
        }
        else {
            return "false";
        }
    }

    @ResponseBody
    @GetMapping("/getPositionListByCreate")
    /**
     *添加教师信息需要的专业技术职务集合
     * @return
     */
    public Map<String,Object> getPositionListByCreate(){
        try{
            List<Position> positionList = positionService.getPositionList();   //获取学科集合
            return ReturnResult.returnSuccess(null,positionList);
        }catch (Exception e){
            return ReturnResult.returnFail(null,null,500);
        }
    }
}
