/*
 * Copyright (c) 2020. 唐江华 版权所有
 */

package com.tangjianghua.tencentlvb.live.enums;

/**
 * 拉流域名类型：
 * 1：国内，
 * 2：全球，
 * 3：境外。
 * 默认值：1。
 * @author tangjianghua
 * date 2020/2/21
 * time 14:53
 */
public enum PlayTypeEnum {
    //国内
    DOMESTIC(1),
    //全球
    GLOBAL(2),
    //境外
    ABROAD(3);

    private Integer code;

    public Integer getCode() {
        return code;
    }

    PlayTypeEnum(Integer code) {
        this.code = code;
    }
}
