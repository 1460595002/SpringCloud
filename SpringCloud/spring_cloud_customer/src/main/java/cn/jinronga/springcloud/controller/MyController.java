package cn.jinronga.springcloud.controller;

import cn.jinronga.springcloud.entity.vo.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName MyController
 * @Author 郭金荣
 * @Date 2021/5/11 20:16
 * @Description MyController
 * @Version 1.0
 */
@RestController
public class MyController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/get/emp")
    public Employee employee() {
        //1.远程调用得主机
//        String host = "http://localhost:1000";
        String host = "http://provider";
        // 2.远程调用方法的具体URL地址
        String url = "/provider/get/employee";
        Employee forObject = restTemplate.getForObject(host + url, Employee.class);
        return forObject;
    }

    @RequestMapping("/consumer/get/qq")
    public String getQQPort() {
        //1.远程调用得主机
        String  host="http://provider";
        // 2.远程调用方法的具体URL地址
        String url = "/provider/get/QQId";
        String forObject = restTemplate.getForObject(host + url, String.class);
        return forObject;
    }

}
