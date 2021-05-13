package cn.jinronga.springcloud.api;

import cn.jinronga.springcloud.component.MyFallBackFactory;
import cn.jinronga.springcloud.entity.vo.UserVo;
import cn.jinronga.springcloud.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserRemoteService
 * @Author 郭金荣
 * @Date 2021/5/12 14:43
 * @Description UserRemoteService
 * @FeignClient 注解表示当前接口和一个provider对应，注解中value属性指定要调用的provider的微服务名称
 */
@FeignClient(value = "provider",fallbackFactory = MyFallBackFactory.class)
public interface UserRemoteService {
    /**
     * 远程调用的接口方法：
     * 1.要求@RequestMapping注解映射的地址一致
     * 2.要求方法声明一致
     * 3.用来获取请求参数
     * ： @RequestParam  @PathVariable @RequestBody @RequestParam  不能省略，两边一致
     *
     * @return
     */
    @RequestMapping("/provider/get/QQId")
    R getQQ();

    @GetMapping("/provider/search/user/by/name")
    R<UserVo> getUserById(@RequestParam("keyword") String keyword);

}
