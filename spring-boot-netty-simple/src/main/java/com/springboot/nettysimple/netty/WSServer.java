package com.springboot.nettysimple.netty;

import com.springboot.nettysimple.netty.handler.WSServerInitialzer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: zenan
 * @date: 2021/4/23
 */
@Slf4j
@Component
public class WSServer {

    private NioEventLoopGroup mainGroup;
    private NioEventLoopGroup subGroup;
    private ServerBootstrap bootstrap;
    private ChannelFuture channelFuture;

    public WSServer() {
        this.mainGroup = new NioEventLoopGroup();
        this.subGroup = new NioEventLoopGroup();
        this.bootstrap = new ServerBootstrap();
        bootstrap.group(mainGroup, subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new WSServerInitialzer());
    }

    public void start() {
        this.channelFuture = this.bootstrap.bind(8088);
        log.info("WSServer 启动成功");
    }
}
