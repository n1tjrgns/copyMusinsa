package com.fakesinsa.project.dao;

public interface UserDao {

    //회원정보 받는 메소드
    int setUserInfo(String userName, String userEmail, String userPassword);

    //로그인 메소드//
    String getUserInfo(String userEmail);
}
