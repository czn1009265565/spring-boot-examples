package com.springboot.logging.service;

import com.github.pagehelper.PageHelper;
import com.springboot.logging.dao.OperationMapper;
import com.springboot.logging.dto.OperationDetail;
import com.springboot.logging.dto.OperationParam;
import com.springboot.logging.entity.Operation;
import com.springboot.logging.entity.OperationExample;
import com.springboot.logging.enums.LogTypeEnum;
import com.springboot.logging.utils.LogUtils;
import com.springboot.logging.vo.PageResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: zenan
 * @date: 2021/3/30
 */
@Service
public class OperationServiceImpl implements OperationService{

    @Resource
    private OperationMapper operationMapper;

    @Override
    public int create(ProceedingJoinPoint joinPoint) {
        Operation Operation = new Operation();
        HttpServletRequest request = LogUtils.obtainServlet();

        Operation.setUsername(LogUtils.obtainUsername());
        Operation.setDescription(LogUtils.obtainDescription(joinPoint));
        Operation.setMethod(LogUtils.obtainMethodName(joinPoint));
        Operation.setParams(LogUtils.obtainRequestParam(joinPoint));
        Operation.setLogType(LogTypeEnum.INFO.getDesc());
        Operation.setRequestIp(LogUtils.obtainIp(request));
        Operation.setBrowser(LogUtils.obtainBrowser(request));
        return operationMapper.insertSelective(Operation);
    }

    @Override
    public int create(ProceedingJoinPoint joinPoint, Throwable e) {
        Operation Operation = new Operation();
        HttpServletRequest request = LogUtils.obtainServlet();

        Operation.setUsername(LogUtils.obtainUsername());
        Operation.setDescription(e.getMessage());
        Operation.setMethod(LogUtils.obtainMethodName(joinPoint));
        Operation.setParams(LogUtils.obtainRequestParam(joinPoint));
        Operation.setLogType(LogTypeEnum.ERROR.getDesc());
        Operation.setRequestIp(LogUtils.obtainIp(request));
        Operation.setBrowser(LogUtils.obtainBrowser(request));
        return operationMapper.insertSelective(Operation);
    }

    @Override
    public List<Operation> list(OperationParam operationParam) {
        OperationExample example = new OperationExample();
        OperationExample.Criteria criteria = example.createCriteria();

        String username = operationParam.getUsername();
        if (StringUtils.hasLength(username)) {
            criteria.andUsernameEqualTo(username);
        }
        String description = operationParam.getDescription();
        if (StringUtils.hasLength(description)) {
            criteria.andDescriptionEqualTo(description);
        }
        String requestIp = operationParam.getRequestIp();
        if (StringUtils.hasLength(requestIp)) {
            criteria.andRequestIpEqualTo(requestIp);
        }

        PageHelper.startPage(operationParam.getPageNum(), operationParam.getPageSize());
        return operationMapper.selectByExample(example);
    }
}
