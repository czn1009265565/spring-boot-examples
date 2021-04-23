package com.springboot.nettysimple.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;

/**
 * @author: zenan
 * @date: 2021/4/23
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    /**
     * 用于记录和管理所有客户端的 channel
     */
    private static ChannelGroup clients =
            new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // 获取客户端传输过来的消息
        String content = msg.text();
        System.out.println("接收到的消息:".concat(content));

        for (Channel channle : clients) {
            channle.writeAndFlush(new TextWebSocketFrame(String.format("%s:%s", LocalDateTime.now(), content)));
        }
    }

    /**
     * 当客户端连接服务端之后
     * 获取客户端的channel,并放入ChannelGroup中进行管理
     *
     * @param ctx 上下文
     * @throws Exception exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 当触发 handlerRemoved channelGroup 会自动移除对应客户端channel
        // clients.remove(ctx.channel());
        System.out.println("客户端断开 channel对应长id:".concat(ctx.channel().id().asLongText()));
        System.out.println("客户端断开 channel对应短id:".concat(ctx.channel().id().asShortText()));
    }
}
