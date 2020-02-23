/*
 * Copyright (c) 2020. 唐江华 版权所有
 */

package com.tangjianghua.tencentlvb.live.enums;

/**
 * 域名类型，
 * 0：推流域名，
 * 1：播放域名。
 * @author tangjianghua
 * @date 2020/2/21
 * @time 14:49
 */
public enum DomainTypeEnum {
    //推流域名
    PUSH(0),
    //播放域名
    RECEIVE(1);


    private Integer code;

    public Integer getCode() {
        return code;
    }

    DomainTypeEnum(Integer code) {
        this.code = code;
    }
}
