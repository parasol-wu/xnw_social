package com.xnw.dto.system;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * Created by BaoCai on 17/9/9.
 * Description:
 */
@Data
public class SysFunctionDto {

    private String parentId;

    private String functionName;

    private String functionUrl;

    private Boolean parentFunction;

    private List<SysFunctionDto> childenFunctions = new ArrayList();

}
