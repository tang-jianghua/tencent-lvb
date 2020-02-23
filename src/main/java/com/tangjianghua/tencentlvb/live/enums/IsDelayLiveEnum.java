/*
 * Copyright (c) 2020. 唐江华 版权所有
 */

package com.tangjianghua.tencentlvb.live.enums;

/**
 * 是否是慢直播：
 * 0： 普通直播，
 * 1 ：慢直播 。
 * 默认值： 0。
 * @author tangjianghua
 * @date 2020/2/21
 * @time 14:58
 */
public enum IsDelayLiveEnum {

    //推流域名
    YES(0),
    //播放域名
    NO(1);


    private Integer code;

    public Integer getCode() {
        return code;
    }

    IsDelayLiveEnum(Integer code) {
        this.code = code;
    }
}
