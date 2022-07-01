package com.log.demo.util;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * LogRecordContext.
 *
 * @author shitianyu 2021-10-08 15:58
 */
@Slf4j
public class LogRecordContext {

    private static String host = "https://api.asclepius.whxh.com.cn";

    private static String url1 = "/outpatient/register/depts?branchId=00&districtId=1001&subHisId=18701";

    private static String url2 = "/outpatient/register/dept/doctors?deptId=28&subHisId=18701&districtId=1001&branchId=00";

    //具体日期的医生列表
    private static String url3 = "/outpatient/register/dept/sources?scheduleDate=2022-07-12&deptId=28&subHisId=18701&districtId=1001&branchId=00";

    //疫情检查 post
    private static String url4 = "/outpatient/NucleiAcidForm";

    //短信
    private static String smsUrl = "/outpatient/register/verify/before/sms?deptId=28&doctorId=1-839&patientId=1995058&scheduleDate=2022-07-07";
    private static String smsUrl1 = "/houseKeeperAuth/authentication/smsCode/18772772693?mobile=18772772693&subHisId=18701";

    /*private static String smsUrl2 = "/outpatient/register/verify/before/sms?deptId=28&doctorId=1-2063&patientId=1995058&scheduleDate=2022-07-13";
    private static String smsUrl3 = "/houseKeeperAuth/authentication/smsCode/18772772693?mobile=18772772693&subHisId=18701";*/
    private static String param1 = "{\"patientName\":\"任娇\",\"patientIdNo\":\"140602199505130028\",\"type\":\"register\",\"isFever\":\"1\",\"isDangerous\":\"1\",\"isNegative\":\"0\"}";
    private static String param2 = "{\"patientName\":\"施天宇\",\"patientIdNo\":\"421083199510012812\",\"type\":\"register\",\"isFever\":\"1\",\"isDangerous\":\"1\",\"isNegative\":\"0\"}";


    //json
    /**
     *
     {
     "deptId": "28",
     "doctorId": "1-229",
     "scheduleId": "",
     "scheduleDate": "2021-10-25",
     "visitPeriod": "afternoon",
     "visitBeginTime": "",
     "visitEndTime": "",
     "patientId": "1995058",
     "smsId": "b6dde6757c6843e5a985af71e218dcda",
     "mobileCode": "435577",
     "visitQueue": "867299",
     "mblNo": "18772772693",
     "subHisId": "18701",
     "districtId": "1001",
     "branchId": "00",
     "intervalCode": "9"
     }token: 4b7531564fa64af18bdc5b45f660c6e5
     **/
    public static void main(String[] args) {
        //String smsId = sms();
        for (;;) {
            String smsId = sms();
            if (smsId != null) {
                break;
            }
        }

        //第一步 疫情的校验
        /*boolean nucleiFlag = nucleiAcidForm();
        if (nucleiFlag) {
            String smsId = sms();
            log.info(smsId);
        }*/
        //test();
    }

    private static void test() {
        HttpResponse execute = HttpUtil
                .createGet(host + url3)
                .header("token", "0ac8c5215bb84e34815233a8c16d7ad3")
                .header("Cookie", "COOKIE_JSESSIONID_187_1=1634831982590-C140EF9D8B724758C600B9").execute();
        String body = execute.body();
        JSONObject parse = JSONUtil.parseObj(body);
        log.info(body);
    }

    private static String sms() {
        HttpResponse execute = HttpUtil
                .createGet(host + smsUrl)
                .header("token", "0ac8c5215bb84e34815233a8c16d7ad3")
                .header("Cookie", "COOKIE_JSESSIONID_187_1=1634831982590-C140EF9D8B724758C600B9").execute();
        String body = execute.body();
        JSONObject parse = JSONUtil.parseObj(body);
        log.info(body);

        if (parse.getInt("code") == 200) {
            HttpResponse execute1 = HttpUtil
                    .createGet(host + smsUrl1)
                    .header("token", "0ac8c5215bb84e34815233a8c16d7ad3")
                    .header("Cookie", "COOKIE_JSESSIONID_187_1=1634831982590-C140EF9D8B724758C600B9").execute();
            String body1 = execute1.body();
            log.info(body1);
            JSONObject parse1 = JSONUtil.parseObj(body1);
            return parse1.getStr("data");
        } else {
            return null;
        }
    }

    private static boolean nucleiAcidForm() {
        HttpResponse execute = HttpUtil.createPost(host + url4)
                .body(param1)
                .header("token", "0ac8c5215bb84e34815233a8c16d7ad3")
                .header("Cookie", "COOKIE_JSESSIONID_187_1=1634831982590-C140EF9D8B724758C600B9").execute();
        String body = execute.body();
        log.info(body);
        JSONObject parse = JSONUtil.parseObj(body);
        return parse.getInt("code") == 200;
    }
}
