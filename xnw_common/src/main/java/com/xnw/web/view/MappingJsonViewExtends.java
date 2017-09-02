package com.xnw.web.view;

//import net.sf.json.JSONObject;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BaoCai on 17/7/26.
 * Description:自定义jsonView
 */
public class MappingJsonViewExtends extends AbstractView{

    private static Logger logger = LoggerFactory.getLogger(MappingJsonViewExtends.class);

    private String contentType = "text/json;charset=UTF-8";

    /**
     * 实现自定义渲染视图方法
     * @param map
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        logger.info("there have no view be found;default parse model to json");

        httpServletResponse.setContentType(contentType);
        Object filtedModel = filterModel(map);
        String str = JSON.toJSONString(filtedModel);
        httpServletResponse.getWriter().print(str);
    }

    /**
     * 过滤未定义的参数
     *   map中会存在一些框架自带参数
     * @param map
     * @return
     */
    protected Object filterModel(Map<String, Object> map){
        Map<String,Object> result = new HashMap();
        for(Map.Entry<String, Object> entry: map.entrySet()){
            if(!(entry.getValue() instanceof BindingResult)){
                result.put(entry.getKey(),entry.getValue());
            }
        }
        return result;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
