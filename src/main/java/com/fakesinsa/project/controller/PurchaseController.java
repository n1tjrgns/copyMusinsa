package com.fakesinsa.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PurchaseController {

    //해당 상품이 클릭되었을 때 정보를 받아오는 메소드
    @RequestMapping(value = "/view/purchase.do")
    public ModelAndView movePurchasePage(HttpServletRequest req, String productName, String productCategory, int productPrice, String productDetail) {

        System.out.println(productName);
        ModelAndView mv = new ModelAndView();
        HttpSession session = req.getSession();

        session.setAttribute("productName", productName);
        session.setAttribute("productDetail", productDetail);
        session.setAttribute("productPrice", productPrice);
        session.setAttribute("productCategory", productCategory);
        mv.setViewName("forward:/view/purchase.jsp");
        return mv;
    }
}
