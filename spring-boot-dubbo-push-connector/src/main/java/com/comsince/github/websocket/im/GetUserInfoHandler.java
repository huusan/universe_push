package com.comsince.github.websocket.im;

import cn.wildfirechat.proto.WFCMessage;
import com.comsince.github.PushPacket;
import com.comsince.github.Signal;
import com.comsince.github.SubSignal;
import com.comsince.github.handler.im.Handler;
import com.comsince.github.handler.im.IMTopic;

import java.util.ArrayList;

/**
 * @author comsicne
 * Copyright (c) [2019]
 * @Time 20-5-27 上午11:15
 **/
@Handler(IMTopic.GetUserInfoTopic)
public class GetUserInfoHandler extends WsImHandler<ArrayList<String>,WFCMessage.PullUserResult>{

    @Override
    public byte[] request(Signal signal, SubSignal subSignal, ArrayList<String> userIds) {
        log.info("get user info userIds {}",userIds);
        WFCMessage.PullUserRequest.Builder userRequestBuilder = WFCMessage.PullUserRequest.newBuilder();
        for(String user : userIds){
            WFCMessage.UserRequest userRequest = WFCMessage.UserRequest.newBuilder().setUid(user).build();
            userRequestBuilder.addRequest(userRequest);
        }
        return userRequestBuilder.build().toByteArray();
    }

    @Override
    public String result(Signal signal, SubSignal subSignal, WFCMessage.PullUserResult result) {
        return null;
    }
}