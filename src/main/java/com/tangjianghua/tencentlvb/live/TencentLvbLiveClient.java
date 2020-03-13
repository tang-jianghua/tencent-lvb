package com.tangjianghua.tencentlvb.live;

import com.tangjianghua.tencentlvb.live.enums.DomainTypeEnum;
import com.tangjianghua.tencentlvb.live.enums.IsDelayLiveEnum;
import com.tangjianghua.tencentlvb.live.enums.PlayTypeEnum;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.live.v20180801.LiveClient;
import com.tencentcloudapi.live.v20180801.models.AddLiveDomainRequest;
import com.tencentcloudapi.live.v20180801.models.AddLiveDomainResponse;
import com.tencentcloudapi.live.v20180801.models.DescribeLiveStreamStateRequest;
import com.tencentcloudapi.live.v20180801.models.DescribeLiveStreamStateResponse;

/**
 * @author tangjianghua
 * date 2020/2/21
 * time 14:29
 */
public class TencentLvbLiveClient {

    private String secretId;

    private String secretKey;

    private LiveClient client;

    public String getSecretId() {
        return secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public TencentLvbLiveClient(String secretId, String secretKey) {
        this.secretId = secretId;
        this.secretKey = secretKey;
        Credential credential = new Credential(secretId, secretKey);
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setSignMethod(ClientProfile.SIGN_TC3_256);
        this.client = new LiveClient(credential, null, clientProfile);
    }

    /**
     * 添加域名
     * @param domainName 域名 必填
     * @param domainTypeEnum 域名类型 必填
     * @param playTypeEnum 拉流域名类型 默认国内
     * @param isDelayLiveEnum 是否是慢直播 默认否
     * @return AddLiveDomainResponse
     * @author tangjianghua
     * date 2020/2/21
     */
    public AddLiveDomainResponse addRealmName(String domainName, DomainTypeEnum domainTypeEnum, PlayTypeEnum playTypeEnum, IsDelayLiveEnum isDelayLiveEnum) {
        try {
            AddLiveDomainRequest request = new AddLiveDomainRequest();
            request.setDomainType(Long.valueOf(domainTypeEnum.ordinal()));
            request.setDomainName(domainName);
            if (playTypeEnum != null) {
                request.setPlayType(Long.valueOf(playTypeEnum.getCode()));
            }
            if (isDelayLiveEnum != null) {
                request.setIsDelayLive(Long.valueOf(isDelayLiveEnum.getCode()));
            }
            return client.AddLiveDomain(request);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加普通(非慢直播)直播域名
     * @param domainName 域名 必填
     * @param domainTypeEnum 域名类型 必填
     * @param playTypeEnum 拉流域名类型 默认国内
     * @return AddLiveDomainResponse
     * @author tangjianghua
     * date 2020/2/21
     */
    public AddLiveDomainResponse addRealmName(String domainName, DomainTypeEnum domainTypeEnum, PlayTypeEnum playTypeEnum) {
        try {
            AddLiveDomainRequest request = new AddLiveDomainRequest();
            request.setDomainType(Long.valueOf(domainTypeEnum.ordinal()));
            request.setDomainName(domainName);
            if (playTypeEnum != null) {
                request.setPlayType(Long.valueOf(playTypeEnum.getCode()));
            }
            return client.AddLiveDomain(request);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加国内普通(非慢直播)直播域名
     * @param domainName 域名 必填
     * @param domainTypeEnum 域名类型 必填
     * @return AddLiveDomainResponse
     * @author tangjianghua
     * date 2020/2/21
     */
    public AddLiveDomainResponse addRealmName(String domainName, DomainTypeEnum domainTypeEnum) {
        try {
            AddLiveDomainRequest request = new AddLiveDomainRequest();
            request.setDomainType(Long.valueOf(domainTypeEnum.ordinal()));
            request.setDomainName(domainName);
            return client.AddLiveDomain(request);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 查询流状态
     * @param domain 域名
     * @param appName 应用名称
     * @param streamName 流名称
     * @return DescribeLiveStreamStateResponse
     * @author tangjianghua
     * date 2020/2/23
     */
    public DescribeLiveStreamStateResponse describeLiveStreamState(String domain, String appName, String streamName){
        try {
        DescribeLiveStreamStateRequest request = new DescribeLiveStreamStateRequest();
        request.setDomainName(domain);
        request.setAppName(appName);
        request.setStreamName(streamName);
        return client.DescribeLiveStreamState(request);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
            return null;
        }
    }


}
