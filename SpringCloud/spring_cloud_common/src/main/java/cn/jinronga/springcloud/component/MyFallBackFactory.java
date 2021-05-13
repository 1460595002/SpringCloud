package cn.jinronga.springcloud.component;

import cn.jinronga.springcloud.api.UserRemoteService;
import cn.jinronga.springcloud.entity.vo.UserVo;
import cn.jinronga.springcloud.util.R;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyFallBackFactory
 * @Author 郭金荣
 * @Date 2021/5/12 20:08
 * @Description MyFallBackFactory
 * @Version 1.0
 * 1.实现Consumer端服务降级的功能
 * 2.实现FallbackFactory接口时要传入@FeignClient接口类型
 * 3.在create()方法中返回一个@FeignClient注解标注的接口类型的对象，当Provider调用失败后，会执行这个对象的对应方法
 */
@Component
public class MyFallBackFactory implements FallbackFactory<UserRemoteService> {

    @Override
    public UserRemoteService create(Throwable throwable) {
        return new UserRemoteService() {
            @Override
            public R getQQ() {
                return R.failed("consumer端降级！！");
            }

            @Override
            public R<UserVo> getUserById(String keyword) {
                return R.failed("consumer端降级！！");
            }
        };
    }
}
