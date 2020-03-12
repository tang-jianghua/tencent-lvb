/*
 * Copyright (c) 2020. 唐江华 版权所有
 */

package com.tangjianghua.tencentlvb.live.enums;

/**
 * 腾讯云直播回调事件枚举
 * @author tangjianghua
 * @date 2020/2/23
 * @time 20:13
 */
public enum EventTypeEnum {

    PUSH(1,"推流事件"),
    STOP(0,"断流事件"),
    RECORD(100,"录制事件"),
    SCREENSHOT(200,"截屏事件");

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    EventTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
