package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by sifu on 2017/8/14
 *
 * @author sifu
 * @version 1.0.0
 */
@Slf4j
@Aspect
@Component
public class HttpAspect {

    @Pointcut(value = "execution(public * com.example.demo.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        log.info("url={}", request.getRequestURL());
        // port
        log.info("port={}", request.getRemotePort());
        // method
        log.info("method={}", request.getMethod());
        // ip
        log.info("ip={}", request.getRemoteAddr());
        // class_method
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // 参数
        log.info("args={}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("response={}", object);
    }

}