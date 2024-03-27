package javaLow.实验五.youdao;


import javaLow.实验五.youdao.utils.AuthV3Util;
import javaLow.实验五.youdao.utils.HttpUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 网易有道智云翻译服务api调用demo
 * api接口: https://openapi.youdao.com/api
 */
public class YouDaoTranslates {

    private static final String APP_KEY = "58fb4126634d993e";     // 您的应用ID
    private static final String APP_SECRET = "rA0xxIxFywcbPcjisq9mxuywaeQodJlK";  // 您的应用密钥

    public String translate(String q) {
//        String q = "你好88";

        // 添加请求参数
        Map<String, String[]> params = createRequestParams(q);
        // 添加鉴权相关参数
        try {
            AuthV3Util.addAuthParams(APP_KEY, APP_SECRET, params);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        // 请求api服务
        byte[] result = HttpUtil.doPost("https://openapi.youdao.com/api", null, params, "application/json");

        String translateResult = extractTranslation(new String(result, StandardCharsets.UTF_8));
        // 打印返回结果
//        if (result != null) {
//            System.out.println(translateResult);
//        }
        return translateResult;
//        System.exit(1);
    }

    private static Map<String, String[]> createRequestParams(String q) {
        /*
         * note: 将下列变量替换为需要请求的参数
         * 取值参考文档: https://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/API%E6%96%87%E6%A1%A3/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-API%E6%96%87%E6%A1%A3.html
         */
//        String q = "待翻译文本";
        String from = "auto";
        String to = "auto";
//        String vocabId = "您的用户词表ID";

        return new HashMap<String, String[]>() {{
            put("q", new String[]{q});
            put("from", new String[]{from});
            put("to", new String[]{to});
//            put("vocabId", new String[]{vocabId});
        }};
    }

    public static String extractTranslation(String jsonString) {
        try {
            // 将字符串解析为 JSON 对象
            JSONObject jsonObject = new JSONObject(jsonString);

            // 从 JSON 对象中获取 translation 数组
            JSONArray translationArray = jsonObject.getJSONArray("translation");

            // 获取数组中的第一个翻译结果
            String translationResult = translationArray.optString(0, "");

            return translationResult;
        } catch (Exception e) {
            // 如果解析过程中出现异常，返回空字符串或者其他默认值
            e.printStackTrace();
            return "";
        }
    }

}
