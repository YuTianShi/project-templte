package com.log.demo.util;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Test.
 *
 * @author shitianyu 2021-10-20 15:14
 */
@Slf4j
public class Test {

    private static String host = "https://api.asclepius.whxh.com.cn";

    //保存 post
    private static String lockUrl = "/outpatient/register/order/lock";

    private static String lockParam = "{\"deptId\":\"28\",\"doctorId\":\"1-2063\",\"scheduleId\":\"\",\"scheduleDate\":\"2021-10-27\"," +
            "\"visitPeriod\":\"afternoon\",\"visitBeginTime\":\"\",\"visitEndTime\":\"\",\"patientId\":\"1986696\",\"smsId\":\"%s\"," +
            "\"mobileCode\":\"%d\",\"visitQueue\":\"870559\",\"mblNo\":\"18772772693\",\"subHisId\":\"18701\",\"districtId\":\"1001\"," +
            "\"branchId\":\"00\",\"intervalCode\":\"9\"}";


    public static void main(String[] args) {
        String format = String.format(lockParam, "b3485b76712d43c7a60a4c206d247ef9", 515797);
        HttpResponse execute = HttpUtil.createPost(host + lockUrl)
                .body(format)
                .header("token", "c22e5ac6362342a4b8f880bd9d840b55")
                .header("Cookie", "COOKIE_JSESSIONID_187_1=1634745705316-FC442CBC21A842E8A6E4F2").execute();
        String body = execute.body();
        log.info(body);
    }
}
