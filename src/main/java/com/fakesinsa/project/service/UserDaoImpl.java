package com.fakesinsa.project.service;

import com.fakesinsa.project.dao.UserDao;
import com.fakesinsa.project.dto.UserDto;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("UserDao")
public class UserDaoImpl implements UserDao {


    private String namespace = "mybatis.userMapper.";

    @Resource(name = "sessionTemplateForUser")
    private SqlSessionTemplate sqlSession;


    //회원가입 시 유저 정보를 insert
    @Override
    public int setUserInfo(String userName, String userEmail, String userPassword) {
        UserDto userDto = new UserDto();

        userDto.setUserEmail(userEmail);
        userDto.setUserName(userName);
        userDto.setUserPassword(userPassword);

        return sqlSession.insert(namespace + "setUserInfo", userDto);
    }

    //로그인 시 회원정보를 가져올 메소드//
    public String getUserInfo(String userEmail) {
        UserDto userDto = new UserDto();

        userDto.setUserEmail(userEmail);
        //userDto.setUserPassword(userPassword);

        return sqlSession.selectOne(namespace + "getUserInfo", userDto);
    }
}
