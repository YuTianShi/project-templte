package com.validate.demo.domain;

import com.validate.demo.valid.IntegerEnum;
import lombok.Data;

/**
 * Event.
 *
 * @author shitianyu 2021-09-30 14:43
 */
@Data
public class Event {

    private Long id;

    @IntegerEnum(values = {1, 2, 3}, message = "类型错误")
    private Integer type;

}
