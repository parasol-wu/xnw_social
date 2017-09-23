package com.xnw.web.interceptor;

import com.xnw.dto.system.SysFunctionDto;
import com.xnw.persistence.model.system.SysFunction;
import com.xnw.service.system.SysFunctionService;
import com.xnw.utils.MenuUtils;
import com.xnw.utils.StringUtil;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by BaoCai on 17/9/9.
 * Description: Menu load
 */
public class UserFunctionInterceptor implements HandlerInterceptor {

    @Autowired
    private SysFunctionService sysFunctionService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        List<SysFunction> functionList = sysFunctionService.findAllFunction();
        MenuUtils.calculateMenu(functionList,httpServletRequest);
        return Boolean.TRUE;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
