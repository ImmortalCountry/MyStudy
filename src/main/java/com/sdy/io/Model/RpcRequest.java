package com.sdy.io.Model;

import lombok.*;

/**
 * @author: sundy
 * @date: 2021/1/26 15:41
 * @description: 客户端请求实体类
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@ToString
public class RpcRequest {
    private String interfaceName;
    private String methodName;
}
