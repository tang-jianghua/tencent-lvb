/*
 * Copyright (c) 2020. 唐江华 版权所有
 */

package com.tangjianghua.tencentlvb.live;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: tangjianghua
 * @date: 2020/2/22
 * @time: 16:07
 */
public class TencentLvbLiveUrlGenerator {


    private static final char[] DIGITS_LOWER =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String getSafeUrl(String key, String streamName, long txTime) {
        String input = new StringBuilder().
                append(key).
                append(streamName).
                append(Long.toHexString(txTime).toUpperCase()).toString();

        String txSecret = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            txSecret = byteArrayToHexString(
                    messageDigest.digest(input.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return txSecret == null ? "" :
                new StringBuilder().
                        append("txSecret=").
                        append(txSecret).
                        append("&").
                        append("txTime=").
                        append(Long.toHexString(txTime).toUpperCase()).
                        toString();
    }

    private static String byteArrayToHexString(byte[] data) {
        char[] out = new char[data.length << 1];

        for (int i = 0, j = 0; i < data.length; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return new String(out);
    }

    /**
     * 生成rtmp推流地址
     * @param: domain 推流域名
     * @param: key 鉴权key
     * @param: appName
     * @param: streamName 流名称
     * @param: txTime 过期时间戳
     * @return: String
     * @author: tangjianghua
     * @date: 2020/2/22
     */
    public static String generaterPushRTMPUrl(String domain, String key, String appName, String streamName, long txTime) {
        StringBuilder url = new StringBuilder("rtmp://");
        url.append(domain)
                .append("/")
                .append(appName)
                .append("/")
                .append(streamName)
                .append("?")
                .append(getSafeUrl(key, streamName, txTime));
        return url.toString();
    }
    /**
     * 生成flv推流地址
     * @param: domain 推流域名
     * @param: key 鉴权key
     * @param: appName
     * @param: streamName 流名称
     * @param: txTime 过期时间戳
     * @return: String
     * @author: tangjianghua
     * @date: 2020/2/22
     */
    public static String generaterPushFLVUrl(String domain, String key, String appName, String streamName, long txTime) {
        StringBuilder url = new StringBuilder("http://");
        url.append(domain)
                .append("/")
                .append(appName)
                .append("/")
                .append(streamName)
                .append(".flv?")
                .append(getSafeUrl(key, streamName, txTime));
        return url.toString();
    }
    /**
     * 生成m3u8推流地址
     * @param: domain 推流域名
     * @param: key 鉴权key
     * @param: appName
     * @param: streamName 流名称
     * @param: txTime 过期时间戳
     * @return: String
     * @author: tangjianghua
     * @date: 2020/2/22
     */
    public static String generaterPushM3U8Url(String domain, String key, String appName, String streamName, long txTime) {
        StringBuilder url = new StringBuilder("http://");
        url.append(domain)
                .append("/")
                .append(appName)
                .append("/")
                .append(streamName)
                .append(".m3u8?")
                .append(getSafeUrl(key, streamName, txTime));
        return url.toString();
    }

    /**
     * 生成rtmp播放地址
     * @param: domain 播放域名
     * @param: key 鉴权key
     * @param: appName
     * @param: streamName 流名称
     * @param: txTime 过期时间戳
     * @return: String
     * @author: tangjianghua
     * @date: 2020/2/22
     */
    public static String generaterPlayRTMPUrl(String domain, String key, String appName, String streamName, long txTime) {
        StringBuilder url = new StringBuilder("rtmp://");
        url.append(domain)
                .append("/")
                .append(appName)
                .append("/")
                .append(streamName)
                .append("?")
                .append(getSafeUrl(key, streamName, txTime));
        return url.toString();
    }

    /**
     * 生成flv播放地址
     * @param: domain 播放域名
     * @param: key 鉴权key
     * @param: appName
     * @param: streamName 流名称
     * @param: txTime 过期时间戳
     * @return: String
     * @author: tangjianghua
     * @date: 2020/2/22
     */
    public static String generaterPlayFLVUrl(String domain, String key, String appName, String streamName, long txTime) {
        StringBuilder url = new StringBuilder("http://");
        url.append(domain)
                .append("/")
                .append(appName)
                .append("/")
                .append(streamName)
                .append(".flv?")
                .append(getSafeUrl(key, streamName, txTime));
        return url.toString();
    }

    /**
     * 生成m3u8播放地址
     * @param: domain 播放域名
     * @param: key 鉴权key
     * @param: appName
     * @param: streamName 流名称
     * @param: txTime 过期时间戳
     * @return: String
     * @author: tangjianghua
     * @date: 2020/2/22
     */
    public static String generaterPlayM3U8Url(String domain, String key, String appName, String streamName, long txTime) {
        StringBuilder url = new StringBuilder("http://");
        url.append(domain)
                .append("/")
                .append(appName)
                .append("/")
                .append(streamName)
                .append(".m3u8?")
                .append(getSafeUrl(key, streamName, txTime));
        return url.toString();
    }

}
