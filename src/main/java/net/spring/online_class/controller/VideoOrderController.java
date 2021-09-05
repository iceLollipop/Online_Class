package net.spring.online_class.controller;

import net.spring.online_class.model.request.VideoOrderRequest;
import net.spring.online_class.service.VideoOrderService;
import net.spring.online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {
    @Autowired
    private VideoOrderService videoOrderService;

    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest request, HttpServletRequest httpServletRequest){
        Integer userId = (Integer) httpServletRequest.getAttribute("user_id");
        int rows = videoOrderService.saveOrder(userId,request.getVideoId());

        return rows==0 ? JsonData.buildError("下单失败"):JsonData.buildSuccess();
    }
}
