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

    private static final String REQUEST_PREFIX = "==================>>>>>>>>>>>>>  ";
    private static final String REQUEST_SUFFIX = " >>>>>>>>>>>>>==================";
    private static final String RESPONSE_PREFIX = "==================<<<<<<<<<<<<< ";
    private static final String RESPONSE_SUFFIX = " <<<<<<<<<<<<<==================";

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
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 记录请求内容
        LOGGER.info(REQUEST_PREFIX + "REQUEST AOP START" + REQUEST_SUFFIX);
        LOGGER.info("API_URL: " + request.getRequestURL().toString());
        LOGGER.info("HTTP_METHOD: " + request.getMethod());
        LOGGER.info("IP: " + request.getRemoteAddr());
        LOGGER.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOGGER.info("REQUEST BODY: " + Arrays.toString(joinPoint.getArgs()));
        LOGGER.info(REQUEST_PREFIX + "REQUEST AOP OVER " + REQUEST_SUFFIX);
    }

    // 返回通知
    @AfterReturning(returning = "result", pointcut = "pc()")
    public void doAfterReturning(Object result) {

        // 请求返回内容
        LOGGER.info(RESPONSE_PREFIX + "RESPONSE AOP START" + RESPONSE_SUFFIX);
        LOGGER.info("RESPONSE BODY: " + result);
        LOGGER.info("SPEND TIME: " + (System.currentTimeMillis() - startTime.get()));
        LOGGER.info(RESPONSE_PREFIX + "RESPONSE AOP OVER " + RESPONSE_SUFFIX);

        // 用完之后移除, 避免内存泄漏
        startTime.remove();
    }

    // 异常通知
    @AfterThrowing(value = "pc()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        // 获取类名加方法名
        String name = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        // 记录异常信息
        LOGGER.info("Exception_Class_Method: {}, Exception_Message: {}", name, e.getMessage());
    }
}
