package cn.jinronga.springcloud.controller;

import cn.jinronga.springcloud.entity.vo.UserVo;
import cn.jinronga.springcloud.api.UserRemoteService;
import cn.jinronga.springcloud.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserFeignController
 * @Author 郭金荣
 * @Date 2021/5/12 14:58
 * @Description UserFeignController
 * @Version 1.0
 */
@RestController
public class UserFeignController {
    /**
     * 注入要远程调用得接口
     */
    @Resource
    private UserRemoteService userRemoteService;

    @RequestMapping("/remote/user/qq")
    public R getQQProvider() {
        return userRemoteService.getQQ();
    }

    @RequestMapping("/remote/getUser/key")
    public R<UserVo> getUserByIdInfo(@RequestParam("keyWord") String keyWord) {
        R<UserVo> userInfo = userRemoteService.getUserById(keyWord);
        return userInfo;
    }
}
