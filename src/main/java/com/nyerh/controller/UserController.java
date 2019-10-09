package com.nyerh.controller;

import com.nyerh.entity.Demand;
import com.nyerh.entity.User;
import com.nyerh.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/User")
@Slf4j
public class UserController {

    public static boolean isIDNumber(String IDNumber) {
        if (IDNumber == null || "".equals(IDNumber)) {
            return false;
        }
        // 定义判别用户身份证号的正则表达式（15位或者18位，最后一位可以为字母）
        String regularExpression = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        boolean matches = IDNumber.matches(regularExpression);

        //判断第18位校验值
        if (matches) {
            if (IDNumber.length() == 18) {
                try {
                    char[] charArray = IDNumber.toCharArray();
                    //前十七位加权因子
                    int[] idCardWi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                    //这是除以11后，可能产生的11位余数对应的验证码
                    String[] idCardY = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
                    int sum = 0;
                    for (int i = 0; i < idCardWi.length; i++) {
                        int current = Integer.parseInt(String.valueOf(charArray[i]));
                        int count = current * idCardWi[i];
                        sum += count;
                    }
                    char idCardLast = charArray[17];
                    int idCardMod = sum % 11;
                    if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                        return true;
                    } else {
                        System.out.println("身份证最后一位:" + String.valueOf(idCardLast).toUpperCase() +
                                "错误,正确的应该是:" + idCardY[idCardMod].toUpperCase());
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("异常:" + IDNumber);
                    return false;
                }
            }
        }
        return matches;
    }

    @Resource
    private UserService userService;

    //修改用户信息
    @RequestMapping(value = "/getUserById", method = {RequestMethod.GET, RequestMethod.POST})
    public List<User> getUserById(Integer id, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        List<User> list = userService.getUserById(uid);
        return list;
    }

    //保存用户修改信息，更新信息
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public Integer updateUser(User user, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        String idCard = user.getIdCard();
        boolean idNumber = isIDNumber(idCard);
        if (idNumber){
            user.setUId(uid);
            Integer count = userService.updateUser(user);
            return count;
        }
        return 0;
    }

    //获取正在进行的订单及已发布的订单
    @RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
    public List<Demand> getAllOrder(Integer id, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        List<Demand> list = userService.getAllOrder(uid);
        return list;
    }

    //用户确认收货
    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public Integer confirm(Integer gId) {
        Integer count = userService.confirm(gId);
        return count;
    }
}
