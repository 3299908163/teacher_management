package cn.teacherinfo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname json返回值封装
 * @Description TODO
 * @Date 2020/10/27 11:40
 * @Created by 32999
 */
public class ReturnResult {
    /**
     * 成功返回
     * @return
     */
    public static Map<String,Object> returnSuccess(Object msg, Object data){
        Map<String,Object> map = new HashMap<>();
        map.put("Msg",msg);
        map.put("Code",200);
        map.put("Data",data);
        return map;
    }

    /**
     * 失败
     * @param msg
     * @param data
     * @param code
     * @return
     */
    public static Map<String,Object> returnFail(Object msg,Object data,Object code){
        Map<String,Object> map = new HashMap<>();
        map.put("Msg",msg);
        map.put("Code",code);
        map.put("Data",data);
        return map;
    }
}
