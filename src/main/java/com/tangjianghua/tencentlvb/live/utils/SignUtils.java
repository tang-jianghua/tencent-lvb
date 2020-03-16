/*
 * Copyright (c) 2020. 唐江华 版权所有
 */

package com.tangjianghua.tencentlvb.live.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author tangjianghua
 * date 2020/3/16
 * time 18:41
 */
public class SignUtils {

    private static Logger logger = LoggerFactory.getLogger(SignUtils.class);

    /**
     * 回调事件验签
     * @param map 回调参数
     * @param key 回调密钥
     * @return boolean
     * @author tangjianghua
     * date 2020/3/16
     */
    public static boolean verifyNotifyEvent(Map<String, Object> map,String key){
        if (map.get("t") == null) {
            logger.warn("过期时间丢失");
            return false;
        }
        Long t = Long.valueOf(map.get("t").toString());
        if (System.currentTimeMillis()/1000 > t) {
            logger.warn("请求过期");
            return false;
        }
        if (map.get("sign") == null) {
            logger.warn("签名丢失");
            return false;
        }
        return map.get("sign").equals(MD5Utils.md5(key+map.get("t").toString()));
    }
}
