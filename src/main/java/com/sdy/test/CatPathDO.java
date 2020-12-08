package com.sdy.test;

import lombok.Data;

import java.util.List;

/**
 * @author: sundy
 * @date: 2020/11/4 14:32
 * @description:
 */
@Data
public class CatPathDO {
    private String name;
    private List<CatPathDO> children;
}
