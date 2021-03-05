package com.sdy.io.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: sundy
 * @date: 2021/1/26 11:53
 * @description:
 */
@Data
@AllArgsConstructor
public class Message implements Serializable {
    private static final long serialVersionUID = -5910150528560492190L;
    private String content;
}
