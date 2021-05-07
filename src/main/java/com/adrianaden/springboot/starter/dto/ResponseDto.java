package com.adrianaden.springboot.starter.dto;

import org.dozer.DozerBeanMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

public class ResponseDto<T> extends HttpEntity<T> {

    private static final DozerBeanMapper modelMapper = new DozerBeanMapper();

    private HttpStatus status;

    ResponseDto(T body, HttpStatus status) {
        super(body);
        this.status = status;
    }

    public static ResponseDto.Builder accepted() {
        return status(HttpStatus.ACCEPTED);
    }

    public static Builder badRequest() {
        return status(HttpStatus.BAD_REQUEST);
    }

    public static Builder status(HttpStatus status) {
        return new BodyBuilder(status);
    }

    public interface Builder {
        <T> ResponseDto<T> convertTo(Object entity, Class<T> aClass);
    }

    private static class BodyBuilder  implements Builder{
        private HttpStatus status;

        public BodyBuilder(HttpStatus status) {
            this.status = status;
        }

        public <T> ResponseDto<T> convertTo(Object entity, Class<T> aClass) {

            return new ResponseDto<>(modelMapper.map(entity, aClass), this.status);
        }
    }
}
