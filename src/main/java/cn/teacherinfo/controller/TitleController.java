package cn.teacherinfo.controller;

import cn.teacherinfo.entity.Subject;
import cn.teacherinfo.entity.Teacher;
import cn.teacherinfo.entity.Title;
import cn.teacherinfo.service.SubjectService;
import cn.teacherinfo.service.TitleService;
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
 * @Classname TitleController
 * @Description TODO
 * @Date 2020/11/19 15:43
 * @Created by 32999
 */
@Controller
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;

    /**
     * 职称资格信息分页
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @GetMapping("/titleList")
    public Object listTitle(@RequestParam(required = false) Integer page,
                            @RequestParam(required = false) Integer limit){
        Page<Title> ipage = new Page<>(page,limit);
        IPage<Title> pageTitle = titleService.selectPageTitle(ipage);
        int count = titleService.count();
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",pageTitle.getRecords());
        return map;
    }

    /**
     * 通过职称资格名查询职称资格信息是否重复
     * @param titleName
     * @return
     */
    @ResponseBody
    @RequestMapping("/isHaveTitleName")
    public String isHaveTitleName(String titleName){
        System.out.println("职称资格名:"+titleName);
        List<Title> titles = titleService.getTitleByTitleName(titleName);
        if(titles.size()!=0){
            return "true";
        }else {
            return "false";
        }
    }
    @ResponseBody
    @RequestMapping("/isHaveTitleName2")
    public String isHaveTitleName2(String titleName){
        System.out.println("职称资格名:"+titleName);
        List<Title> titles = titleService.getTitleByTitleName(titleName);
        if(titles.size()!=0){
            int id=titles.get(0).getTitleId();
            String Id=String.valueOf(id);
            return Id;
        }else {
            return "false";
        }
    }

    /**
     * 添加职称资格
     * @param titleName
     * @return
     */
    @ResponseBody
    @RequestMapping("/addTitle")
    public String addTitle(String titleName){
        if(titleService.insert(titleName)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 修改职称资格
     * @param title
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateTitle")
    public String addTitle(Title title) {
        if(titleService.updateById(title)>0){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 删除职称资格
     * @param titleId
     * @return
     */
    @ResponseBody
    @GetMapping("/delTitle")
    public String delTitle(int titleId){
        int result = titleService.deleteById(titleId);
        System.out.println("删除成功！");
        if(result>0){
            return "true";
        }
        else {
            return "false";
        }
    }

    @ResponseBody
    @GetMapping("/getTitleListByCreate")
    /**
     *添加教师信息需要的职称资格集合
     * @return
     */
    public Map<String,Object> getTitleListByCreate(){
        try{
            List<Title> titleList = titleService.getTitleList();   //获取学科集合
            return ReturnResult.returnSuccess(null,titleList);
        }catch (Exception e){
            return ReturnResult.returnFail(null,null,500);
        }
    }
}
