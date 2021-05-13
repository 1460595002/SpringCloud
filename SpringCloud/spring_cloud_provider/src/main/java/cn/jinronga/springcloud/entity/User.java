package cn.jinronga.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName User
 * @Author 郭金荣
 * @Date 2021/5/12 19:19
 * @Description User
 * @Version 1.0
 */

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String sex;
}
