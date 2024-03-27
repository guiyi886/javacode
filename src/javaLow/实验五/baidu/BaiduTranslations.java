package javaLow.实验五.baidu;

public class BaiduTranslations {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20230313001598470";
    private static final String SECURITY_KEY = "unsWFzBRFEt9_2XpWpm3";
    String translationResult;

    public String translation(String query) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

//        String query = "高度600米";
        String jsonData = api.getTransResult(query, "auto", "en");
        // 查找 "dst" 字符串的位置
        int dstIndex = jsonData.indexOf("\"dst\"");

        if (dstIndex != -1) {
            // 从 "dst" 字符串的位置开始查找":"的位置
            int colonIndex = jsonData.indexOf(":", dstIndex);

            // 从 ":" 的位置开始查找 "\"" 的位置
            int quoteStartIndex = jsonData.indexOf("\"", colonIndex + 1);

            // 从 "\"" 的位置开始查找下一个 "\"" 的位置
            int quoteEndIndex = jsonData.indexOf("\"", quoteStartIndex + 1);

            if (quoteStartIndex != -1 && quoteEndIndex != -1) {
                // 提取 "dst" 后面的值
                translationResult = jsonData.substring(quoteStartIndex + 1, quoteEndIndex);
//                System.out.println("翻译结果：" + translationResult);
            }
        }
        return translationResult + ".";
    }

}
