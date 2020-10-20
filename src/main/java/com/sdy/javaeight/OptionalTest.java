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
        Optional<User> optionalUser = Optional.empty();
//
        User user = User.builder().name("小明").age("18").build();
        User userNull = User.builder().name("小红").age("28").build();;
        System.out.println(Optional.ofNullable(userNull).orElse(user).getName());

    }
}

