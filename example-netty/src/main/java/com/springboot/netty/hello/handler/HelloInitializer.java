package com.springboot.netty.hello.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author: zenan
 * @date: 2021/4/14
 */
public class HelloInitializer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel ch) throws Exception {
        // 通过SocketChannel去获得对应的管道
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("HttpServerCodec", new HttpServerCodec());

        // 添加自定义的助手类
        pipeline.addLast("customHandler", new CustomHandler());
    }
}
