package cn.jinronga.springcloud.controller;

import cn.jinronga.springcloud.entity.User;
import cn.jinronga.springcloud.entity.vo.Employee;
import cn.jinronga.springcloud.util.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @ClassName ProviderController
 * @Author 郭金荣
 * @Date 2021/5/11 19:43
 * @Description ProviderController
 * @Version 1.0
 */
@RestController
public class ProviderController {
    private static final Logger log = LoggerFactory.getLogger(ProviderController.class);

    @RequestMapping("provider/get/employee")
    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("jinronga");
        employee.setSex("男");
        log.info("信息：", employee);
        return employee;
    }

    @RequestMapping("/provider/get/QQId")
    public String getQQ(HttpServletRequest request) {
        //获取端口号
        int serverPort = request.getServerPort();
        System.out.println("访问服务为:" + serverPort);
        return "1460595002--->端口；" + serverPort;
    }

    @GetMapping("/provider/search/user/by/name")
    public  R<User>  getUserByName(@RequestParam("keyword") String keyword) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "AA", "男"));
        users.add(new User(2, "BB", "女"));
        users.add(new User(3, "CC", "男"));
        users.add(new User(4, "DD", "男"));
        users.add(new User(5, "EE", "男"));
        int i = Integer.parseInt(keyword);

        return R.successWithData(users.get(i));
    }


    @HystrixCommand(fallbackMethod = "getUserBackUp")
    @RequestMapping("/provider/get/user")
    public R<User> getUser(@RequestParam("name") String name) {

        return R.successWithData(new User(1, name, "男"));
    }

    /**
     * 备用方案
     *
     * @param name
     * @return
     */
    public R<User> getUserBackUp(@RequestParam("name") String name) {
        return R.failed("熔断机制触发！");
    }

}
