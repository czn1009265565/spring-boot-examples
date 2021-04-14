package com.springboot.netty.hello;

import com.springboot.netty.hello.handler.HelloInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author: zenan
 * @date: 2021/4/14
 */
public class HelloServer {

    public static void main(String[] args) throws InterruptedException {
        // 接收服务端的请求，但是不做任何处理
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // 真正处理业务逻辑
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)         // 主从线程组
                    .channel(NioServerSocketChannel.class)  // nio双向通道
                    .childHandler(new HelloInitializer())   // 子处理器
            ;
            // 启动server 绑定端口号 以同步方式启动
            ChannelFuture channelFuture = bootstrap.bind(8080).sync();
            // 监听关闭的channel,设置为同步方式
            channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
