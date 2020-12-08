package com.sdy.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: sundy
 * @date: 2020/11/4 15:29
 * @description:
 */
@Data
@Builder
public class CategoryVo {
    private String name;
    private List<CategoryVo> children;
}
