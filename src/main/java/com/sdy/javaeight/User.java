package com.sdy.javaeight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author: sundy
 * @date: 2020/10/19 11:03
 * @description:
 */
@Data
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private String age;
}
