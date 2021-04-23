package com.springboot.nettysimple.netty.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author: zenan
 * @date: 2021/4/23
 */
public class WSServerInitialzer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        pipeline.addLast(new HttpServerCodec()) // http 编解码器
                .addLast(new ChunkedWriteHandler()) // 大数据流的支持
                .addLast(new HttpObjectAggregator(1024*64)) // http message 聚合
                .addLast(new WebSocketServerProtocolHandler("/ws")) // websocket
                .addLast(new ChatHandler()); // 自定义handler
    }
}
