package cn.jinronga.springcloud.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVo {
    private Integer id;
    private String name;
    private String sex;
}