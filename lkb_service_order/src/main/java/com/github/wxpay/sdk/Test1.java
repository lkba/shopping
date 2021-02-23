package com.github.wxpay.sdk;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Config config = new Config();
        //1.封装请求参数
        Map<String,String> map =new HashMap<String, String>();
        map.put("appid",config.getAppID());//公众账号ID
        map.put("mch_id",config.getMchID());//商户号
        map.put("nonce_str",WXPayUtil.generateNonceStr());//随机字符串
        map.put("body","手机");//商品描述
        map.put("out_trade_no","1198803549270708224");//订单号
        map.put("total_fee","1");//金额
        map.put("spbill_create_ip","127.0.0.1");//终端IP
        map.put("notify_url","http://www.baidu.com");//回调地址
        map.put("trade_type","NATIVE");//交易类型

        String xmlParam=WXPayUtil.generateSignedXml(map,config.getKey());//MAP转换为XML字符串（自动添加签名）

        //xml格式的参数
        System.out.println("参数："+xmlParam);

        //2.发送请求
        WXPayRequest wxPayRequest=new WXPayRequest(config);
        String xmlResult=wxPayRequest.requestWithCert("/pay/unifiedorder",null,xmlParam,false);
        System.out.println("结果："+xmlResult);

        //3.解析返回结果
        Map<String,String> mapResult=WXPayUtil.xmlToMap(xmlResult);//将XML字符串转换为MAP
        String code_url=mapResult.get("code_url");
        System.out.println(code_url);

    }
}
