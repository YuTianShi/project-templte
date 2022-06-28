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

    private static String lockParam = "{\"deptId\":\"28\",\"doctorId\":\"1-839\",\"scheduleId\":\"\",\"scheduleDate\":\"2022-07-12\"," +
            "\"visitPeriod\":\"morning\",\"visitBeginTime\":\"\",\"visitEndTime\":\"\",\"patientId\":\"1995058\",\"smsId\":\"%s\"," +
            "\"mobileCode\":\"%d\",\"visitQueue\":\"871700\",\"mblNo\":\"18772772693\",\"subHisId\":\"18701\",\"districtId\":\"1001\"," +
            "\"branchId\":\"00\",\"intervalCode\":\"8\"}";


    public static void main(String[] args) {
        String format = String.format(lockParam, "b042bbd28ccb46e59f7d011ef81efe27", 435373);
        HttpResponse execute = HttpUtil.createPost(host + lockUrl)
                .body(format)
                .header("token", "c4df69bc21a446ea943b33d2170b3c13")
                .header("Cookie", "COOKIE_JSESSIONID_187_1=1634831982590-C140EF9D8B724758C600B9").execute();
        String body = execute.body();
        log.info(body);
    }
}
