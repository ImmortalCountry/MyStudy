package com.sdy.javaeight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

/**
 * @author: SunDeYu
 * @date: 2020/9/1 16:01
 * @description:
 */
public class OptionalTest {
    public static void main(String[] args) {
        User user = new User("张三", "20");
        Optional<User> userOptional = Optional.ofNullable(user);
        userOptional.ifPresent(System.out::println);
        User user1 = new User("李四", "20");
        System.out.println(Optional.ofNullable(null).orElse(user1));
    }


    @Data
    @AllArgsConstructor
    @Builder
    static class User {
        private String name;
        private String age;
    }
}

