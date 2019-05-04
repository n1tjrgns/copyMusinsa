package com.fakesinsa.project.controller;


import com.fakesinsa.project.dto.UserDto;
import com.fakesinsa.project.service.ProductDaoImpl;
import com.fakesinsa.project.service.UserDaoImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Autowired
    private ProductDaoImpl productDaoImpl;

    //
    //회원가입 컨트롤러
    @RequestMapping(value = "/view/signUp.do")
    public ModelAndView signUp(HttpServletRequest req, UserDto userDto) {

        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String userName = req.getParameter("userName");
        String userEmail = req.getParameter("userEmail");
        String userPassword = req.getParameter("userPassword");
        System.out.println("userName : " + userName);
        System.out.println("userEmail : " + userEmail);


        //bcrypt로 비밀번호 암호화
        userPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt());
        userDto.setUserPassword(userPassword);
        System.out.println("userPassword : " + userPassword);

        int signUpResult = userDaoImpl.setUserInfo(userName, userEmail, userPassword);
        System.out.println("signUpResult : " + signUpResult);
        ModelAndView mv = new ModelAndView();

        if (signUpResult == 1) {
            mv.setViewName("redirect:../view/login.jsp");
        } else {
            mv.setViewName("redirect:../view/signup.jsp");
        }
        return mv;
    }


    //로그인 컨트롤러
    @RequestMapping(value = "/view/login.do")
    public ModelAndView login(HttpServletRequest req, UserDto userDto) {


        String userEmail = req.getParameter("userEmail");
        System.out.println("userEmail : " + userEmail);

        //회원정보 확인
        String selectAccount = userDaoImpl.getUserInfo(userEmail);
        System.out.println(selectAccount);



        ModelAndView mv = new ModelAndView();
        HttpSession session = req.getSession();

        if (selectAccount != null) {
            //로그인 시 상품 정보를 select해서 같이 넘겨준다.
            List<Map<Object,Object>> selectProduct = productDaoImpl.getProductInfo();
            System.out.println(selectProduct);

            //redirect를 하면 정보가 사라져서 session을 사용해
            session.setAttribute("selectProduct",selectProduct);

            if (BCrypt.checkpw(userDto.getUserPassword(), selectAccount)) {
                mv.setViewName("redirect:../view/main.jsp");
            }
        } else {
            mv.setViewName("redirect:../view/login.jsp");
        }
        return mv;
    }

    /*//인코딩 맞춰주기
    private void convertEncoding(HttpServletRequest req) {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }*/
}
