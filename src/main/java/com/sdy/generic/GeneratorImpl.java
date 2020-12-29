package com.sdy.generic;

import com.sdy.generic.Generator;

/**
 * @author: SunDeYu
 * @date: 2020/8/12 15:59
 * @description:
 */
public class GeneratorImpl implements Generator<String> {
    @Override
    public String method() {
        return "hello";
    }
}
