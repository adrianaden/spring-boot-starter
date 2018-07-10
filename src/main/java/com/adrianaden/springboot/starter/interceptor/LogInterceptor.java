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
        Long millis = System.currentTimeMillis();

        request.setAttribute("executionTime", millis);
        request.setAttribute("ID", millis);

        String sessionID = request.getAttribute("ID").toString();
        MDC.put("SessionID", sessionID);
        MDC.put("Method", request.getMethod());

        String format = "%-20s%s";
//        String body = getBody(request);
        log.info(String.format(format, "Session ID", ": " + sessionID));
        log.info(String.format(format, "Method", ": " + request.getMethod()));
        log.info(String.format(format, "Path", ": " + request.getRequestURI()));
        log.info(String.format(format, "Query", ": " + request.getQueryString()));
//        log.info(String.format(format, "Body", ": " + body));

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Long startTime = (Long) request.getAttribute("executionTime");
        String sessionID = request.getAttribute("ID").toString();

        log.info("Finish " + sessionID + " in " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
