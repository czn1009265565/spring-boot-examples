package com.springboot.netty.websocket.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author: zenan
 * @date: 2021/4/17
 */
public class WSServerInitialzer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        // http 编解码器
        pipeline.addLast(new HttpServerCodec());
        // 大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        // http message 聚合
        pipeline.addLast(new HttpObjectAggregator(1024*64));


        // websocket 服务器处理的协议 指定客户端访问路由 /ws
        // 本handler处理繁重复杂任务
        // 会帮你处理握手动作
        // 对于websocket来讲，都是以frames传输的，不同的数据类型对应的frames也不同
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 自定义handler
        pipeline.addLast(new ChatHandler());
    }
}
