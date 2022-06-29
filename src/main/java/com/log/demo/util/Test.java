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

    private static String lockParam = "{\"deptId\":\"28\",\"doctorId\":\"1-839\",\"scheduleId\":\"\",\"scheduleDate\":\"2022-07-12\",\n" +
            "        \"visitPeriod\":\"afternoon\",\"visitBeginTime\":\"\",\"visitEndTime\":\"\",\"patientId\":\"1995058\",\"smsId\":\"%s\",\n" +
            "        \"mobileCode\":\"%d\",\"visitQueue\":\"1070978\",\"mblNo\":\"18772772693\",\n" +
            "        \"subHisId\":\"18701\",\"districtId\":\"1001\",\"branchId\":\"00\",\"intervalCode\":\"5\",\"parentDeptId\":\"\",\"rid\":\"232\"}";


    public static void main(String[] args) {
        String format = String.format(lockParam, "1c49baf8677c400a8642d4c5d2d9d424", 738084);
        HttpResponse execute = HttpUtil.createPost(host + lockUrl)
                .body(format)
                .header("token", "c4df69bc21a446ea943b33d2170b3c13")
                .header("Cookie", "COOKIE_JSESSIONID_187_1=1634831982590-C140EF9D8B724758C600B9").execute();
        String body = execute.body();
        log.info(body);
    }
}
