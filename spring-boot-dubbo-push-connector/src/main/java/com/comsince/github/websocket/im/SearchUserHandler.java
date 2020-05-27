package com.comsince.github.websocket.im;

import cn.wildfirechat.proto.WFCMessage;
import com.comsince.github.PushPacket;
import com.comsince.github.Signal;
import com.comsince.github.SubSignal;
import com.comsince.github.handler.im.Handler;
import com.comsince.github.handler.im.IMTopic;
import com.comsince.github.websocket.model.WsUserSearchRequest;

/**
 * @author comsicne
 * Copyright (c) [2019]
 * @Time 20-5-27 下午2:18
 **/
@Handler(IMTopic.UserSearchTopic)
public class SearchUserHandler extends WsImHandler<WsUserSearchRequest,WFCMessage.SearchUserResult>{

    @Override
    public byte[] request(Signal signal, SubSignal subSignal, WsUserSearchRequest wsUserSearchRequest) {
        log.info("user search {}",wsUserSearchRequest);
        WFCMessage.SearchUserRequest request = WFCMessage.SearchUserRequest.newBuilder()
                .setKeyword(wsUserSearchRequest.getKeyword())
                .setFuzzy(wsUserSearchRequest.getFuzzy())
                .setPage(wsUserSearchRequest.getPage())
                .build();
        return request.toByteArray();
    }

    @Override
    public String result(Signal signal, SubSignal subSignal, WFCMessage.SearchUserResult result) {
        return null;
    }
}