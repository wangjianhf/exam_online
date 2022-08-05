package com.exam.online.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * AOP 记录 请求处理日志
 */
@Aspect
@Component
public class WebLogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    /**
     * 请求的后台API
     */
    private static final String API_URL = "API_URL: ";

    /**
     * HTTP方法
     */
    private static final String HTTP_METHOD = "HTTP_METHOD: ";

    /**
     * IP地址
     */
    private static final String IP = "IP: ";

    /**
     * 调用的方法
     */
    private static final String CLASS_METHOD = "CLASS_METHOD: ";

    /**
     * 请求体
     */
    private static final String REQUEST_BODY = "REQUEST_BODY: ";

    /**
     * 返回值
     */
    private static final String RESPONSE_BODY = "RESPONSE_BODY: ";

    /**
     * 耗时
     */
    private static final String SPEND_TIME = "SPEND_TIME: ";

    /**
     * 错误信息
     */
    private static final String EXCEPTION_MESSAGE = "Exception_Class_Method: {}, Exception_Message: {}";

    /**
     * 分割线
     */
    private static final String REQUEST_AOP_BEGIN = "==================>>>>>>>>>>>>> REQUEST_AOP_BEGIN  >>>>>>>>>>>>>==================";
    private static final String REQUEST_AOP_OVER = "==================>>>>>>>>>>>>> REQUEST_AOP_OVER   >>>>>>>>>>>>>==================";
    private static final String RESPONSE_AOP_BEGIN = "==================<<<<<<<<<<<<< RESPONSE_AOP_BEGIN <<<<<<<<<<<<<==================";
    private static final String RESPONSE_AOP_OVER = "==================<<<<<<<<<<<<< RESPONSE_AOP_OVER  <<<<<<<<<<<<<==================";

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    // 切入点
    @Pointcut("execution(* com.exam.online.controller..*.*(..))")
    public void pc() {
    }

    // 前置通知
    @Before("pc()")
    public void doBefore(JoinPoint joinPoint) {

        // 记录请求开始时间
        startTime.set(System.currentTimeMillis());

        // 接收请求, 记录请求内容
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        // 记录请求内容
        LOGGER.info(REQUEST_AOP_BEGIN);
        LOGGER.info(API_URL + request.getRequestURL().toString());
        LOGGER.info(HTTP_METHOD + request.getMethod());
        LOGGER.info(IP + request.getRemoteAddr());
        LOGGER.info(CLASS_METHOD + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info(REQUEST_BODY + Arrays.toString(joinPoint.getArgs()));
        LOGGER.info(REQUEST_AOP_OVER);
    }

    // 返回通知
    @AfterReturning(returning = "result", pointcut = "pc()")
    public void doAfterReturning(Object result) {

        // 请求返回内容
        LOGGER.info(RESPONSE_AOP_BEGIN);
        LOGGER.info(RESPONSE_BODY + result);
        LOGGER.info(SPEND_TIME + (System.currentTimeMillis() - startTime.get()));
        LOGGER.info(RESPONSE_AOP_OVER);

        // 用完之后移除, 避免内存泄漏
        startTime.remove();
    }

    // 异常通知
    @AfterThrowing(value = "pc()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {

        // 获取类名加方法名
        String name = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

        // 记录异常信息
        LOGGER.info(EXCEPTION_MESSAGE, name, e.getMessage());
    }

}
