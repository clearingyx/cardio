package com.common.controller;

import com.common.model.biz.UserResp;
import com.common.other.annotation.ApiRequest;
import com.common.dao.auto.UserMapper;
import com.common.dao.biz.UserBizMapper;
import com.common.model.auto.User;
import com.common.model.auto.UserExample;
import com.common.service.UserService;
import com.common.model.biz.UserReq;
import com.util.PageUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User相关控制类
 * BaseController定义了success和error的常量
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController
{
    Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private UserBizMapper userBizMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    /**
     * 通过ID查找用户
     * @param id
     * @return User对象
     */
    @ApiRequest
    @RequestMapping("/selectById")
    @ResponseBody
    public Object selectById(Integer id)
    {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 得到对象进行insert操作，事务测试
      * @param user
     * @return success or error
     */
    @ApiRequest
    @RequestMapping("insert")
    @ResponseBody
    public Object insert(UserReq user)
    {
        return userService.insertUser(user) == 1 ? SUCCESS : ERROR;
    }

    /**
     * 条件查询/模糊查询，排序测试
     * @param userReq
     * @return UserResp
     */
    @ApiRequest
    @ResponseBody
    @RequestMapping("/selectByCriteria")
    public Object selectByCriteria(UserReq userReq)
    {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(userReq.getUserName() != null && !"".equals(userReq.getUserName()))
        {
            criteria.andUserNameLike("%" + userReq.getUserName() + "%");
        }
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

    /**
     * 分页测试
     * pageNum和pageSize是UserSet继承的AbstractPageParam内的参数
     * pageNum当前第几页，PageSize每页显示数量
     * @param userReq，pageNum，pageSize
     * @return UserResp
     */
    @ApiRequest
    @ResponseBody
    @RequestMapping("/selectByPage")
    public Object selectByPage(UserReq userReq)
    {
        UserExample example = new UserExample();
        //各种条件，排序分页等，这里省略

        // 分页参数
        RowBounds rowBounds = PageUtil.initRowBounds(userReq);

        // 读取数据条数
        int rowCount = userMapper.countByExample(example);
        int pageCount = PageUtil.calculatePageCount(rowCount, userReq.getPageSize());
        //分页查询
        List<User> list = userMapper.selectByExampleWithRowbounds(example,rowBounds);

        // 返回结果，如果不需要resp，直接注释掉，返回list即可
        UserResp resp = new UserResp();
        resp.setPageCount(pageCount);
        resp.setRowCount(rowCount);
        resp.setUserList(list);
        return resp;
        //return list;
    }

}
