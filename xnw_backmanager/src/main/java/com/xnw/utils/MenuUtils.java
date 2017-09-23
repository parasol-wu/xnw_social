package com.xnw.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xnw.dto.system.SysFunctionDto;
import com.xnw.persistence.model.system.SysFunction;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by BaoCai on 17/9/23.
 * Description:
 */
public class MenuUtils {

    public static void calculateMenu(List<SysFunction> allFunctionList, HttpServletRequest httpServletRequest) {
        //topMenu
        List<SysFunction> topMenu = allFunctionList.parallelStream().filter(sysFunction -> sysFunction.getFunctionParentId()==null)
                .collect(Collectors.toList());
        httpServletRequest.setAttribute("topMenu",topMenu);
        allFunctionList.removeAll(topMenu);
        //leftMenu
        Map<Integer,List<SysFunction>> allFunctionMap = functionListToMap(allFunctionList);
        Map<Integer,List<SysFunctionDto>> leftMenuMap = buildLeftMenu(allFunctionMap,topMenu);
        httpServletRequest.setAttribute("leftMenuMap",leftMenuMap);
    }

    private static Map<Integer,List<SysFunctionDto>> buildLeftMenu(Map<Integer, List<SysFunction>> allFunctionMap, List<SysFunction> topMenu) {
        Map<Integer,List<SysFunctionDto>> leftMenuMap = new HashMap<>();
        topMenu.forEach(top -> {
            List<SysFunctionDto> sysFunctionDto = buildFunctionDto(top.getId(),allFunctionMap);
            leftMenuMap.put(top.getId(),sysFunctionDto);
        });
        return leftMenuMap;
    }

    private static List<SysFunctionDto> buildFunctionDto(Integer id,Map<Integer, List<SysFunction>> allFunctionMap) {
        List<SysFunction> functionList = allFunctionMap.get(id);
        if(CollectionUtils.isEmpty(functionList)){
            return null;
        }
        List<SysFunctionDto> sysFunctionDtos = new ArrayList<>();
        functionList.forEach(function -> {
            SysFunctionDto functionDto = new SysFunctionDto();
            functionDto.setFunctionName(function.getFunctionName());
            functionDto.setParentId(String.valueOf(function.getFunctionParentId()));
            functionDto.setFunctionUrl(function.getFunctionUrl());
            //递归
            functionDto.setChildenFunctions(buildFunctionDto(function.getId(),allFunctionMap));
            functionDto.setParentFunction(StringUtil.isEmpty(function.getFunctionUrl()));
            sysFunctionDtos.add(functionDto);
        });
        return sysFunctionDtos;
    }

    private static Map<Integer,List<SysFunction>> functionListToMap(List<SysFunction> allFunctionList) {
        Map<Integer,List<SysFunction>> map = new HashMap();
        allFunctionList.forEach(sysFunction -> {
            if(!map.containsKey(sysFunction.getFunctionParentId())){
                map.put(sysFunction.getFunctionParentId(),new ArrayList());
            }
            map.get(sysFunction.getFunctionParentId()).add(sysFunction);
        });
        return map;
    }

    public static void main(String[] args){
        List<SysFunction> top = new ArrayList();
        //一级菜单
        for(int i = 1 ; i < 4 ; i++){
            SysFunction sysFunction = new SysFunction();
            sysFunction.setFunctionUrl(null);
            sysFunction.setId(i);
            sysFunction.setFunctionName("top----" + i);
            top.add(sysFunction);
        }

        Random random = new Random();
        //second
        List<SysFunction> second = new ArrayList();
        top.forEach(sysFunction -> {
            for(int i = 0 ; i < 3 ; i++){
                SysFunction secondFunction = new SysFunction();
                secondFunction.setFunctionUrl(null);
                secondFunction.setId(random.nextInt(1000));
                secondFunction.setFunctionParentId(sysFunction.getId());
                secondFunction.setFunctionName("second----" + i);
                second.add(secondFunction);
            }
        });

        List<SysFunction> third = new ArrayList();
        second.stream()
                .filter(sysFunction -> sysFunction.getId()%2==1)
                .forEach(sysFunction -> {
            for(int i = 0 ; i < 3 ; i++){
                SysFunction thirdFunction = new SysFunction();
                thirdFunction.setFunctionUrl(null);
                thirdFunction.setId(random.nextInt(1000));
                thirdFunction.setFunctionParentId(sysFunction.getId());
                thirdFunction.setFunctionName("thirdFunction----" + i);
                third.add(thirdFunction);
            }
        });

        List<SysFunction> all = new ArrayList();
        all.addAll(second);
        all.addAll(third);
        Map<Integer,List<SysFunction>> allFunctionMap = functionListToMap(all);

        Map<Integer,List<SysFunctionDto>> buildLeftMenu = buildLeftMenu(allFunctionMap,top);

        String str = JSON.toJSONString(buildLeftMenu);

        System.out.println(str);
    }
}
