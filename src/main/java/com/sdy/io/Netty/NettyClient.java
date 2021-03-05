// package com.sdy.io.Netty;
//
// import com.sdy.io.Model.RpcRequest;
// import com.sdy.io.Model.RpcResponse;
// import io.netty.bootstrap.Bootstrap;
// import io.netty.channel.ChannelInitializer;
// import io.netty.channel.ChannelOption;
// import io.netty.channel.nio.NioEventLoopGroup;
// import io.netty.channel.socket.SocketChannel;
// import io.netty.channel.socket.nio.NioSocketChannel;
// import io.netty.handler.logging.LogLevel;
// import io.netty.handler.logging.LoggingHandler;
// import lombok.extern.slf4j.Slf4j;
//
// /**
//  * @author: sundy
//  * @date: 2021/1/26 15:44
//  * @description:
//  */
// @Slf4j
// public class NettyClient {
//     private final String host;
//     private int port;
//     private static final Bootstrap b;
//
//     // 初始化相关资源比如 EventLoopGroup, Bootstrap
//
//     static {
//         NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
//         b = new Bootstrap();
//         KryoSerializer kryoSerializer = new KryoSerializer();
//         b.group(eventLoopGroup)
//                 .channel(NioSocketChannel.class)
//                 .handler(new LoggingHandler(LogLevel.INFO))
//                 // 连接的超时时间，超过这个时间还是建立不上的话则代表连接失败
//                 // 如果 15 秒之内没有发送数据给服务端的话，就发送一次心跳请求
//                 .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
//                 .handler(new ChannelInitializer<SocketChannel>() {
//                     @Override
//                     protected void initChannel(SocketChannel ch) throws Exception {
//                         /*
//                          自定义序列化编解码器
//                          */
//                         // RpcResponse -> ByteBuf
//                         ch.pipeline().addLast(new NettyKryoDecoder(kryoSerializer, RpcResponse.class));
//                         // ByteBuf -> RpcRequest
//                         ch.pipeline().addLast(new NettyKryoEncoder(kryoSerializer, RpcRequest.class));
//                         ch.pipeline().addLast(new NettyClientHandler());
//                     }
//                 });
//     }
//
//     public NettyClient(String host, int port) {
//         this.host = host;
//         this.port = port;
//     }
// }
