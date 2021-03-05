package com.sdy.io.Model;

import lombok.*;

/**
 * @author: sundy
 * @date: 2021/1/26 15:42
 * @description: 服务端响应实体类
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@ToString
public class RpcResponse {
    private String message;
}
