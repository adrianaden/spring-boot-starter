package com.adrianaden.springboot.starter.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String requestId = request.getHeader("requestId");
        MDC.put("requestId", requestId);
        MDC.put("Method", request.getMethod());

        String format = "%-20s%s";
        log.info(String.format(format, "Request ID", ": " + requestId));
        log.info(String.format(format, "Method", ": " + request.getMethod()));
        log.info(String.format(format, "Path", ": " + request.getRequestURI()));
        log.info(String.format(format, "Query", ": " + request.getQueryString()));

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("Finish process with returning status : " + response.getStatus());
    }
}
