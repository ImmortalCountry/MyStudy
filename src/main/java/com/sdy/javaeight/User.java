package com.sdy.javaeight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: sundy
 * @date: 2020/10/19 11:03
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private String age;
    private String page;
    List<User> children;

    public User(String name, String age, String page) {
     this.name = name;
     this.page = page;
     this.age = age;
    }
}
