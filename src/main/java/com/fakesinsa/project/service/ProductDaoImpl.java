package com.fakesinsa.project.service;

import com.fakesinsa.project.dao.ProductDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("ProductDao")
public class ProductDaoImpl implements ProductDao {

    private String namespace = "mybatis.productMapper.";

    @Resource(name = "sessionTemplateForUser")
    private SqlSessionTemplate sqlSession;
    public List<Map<Object, Object>> getProductInfo() {
        return sqlSession.selectList(namespace+"getProductInfo");
    }
}
