package com.adrianaden.springboot.starter.common.http;

import com.adrianaden.springboot.starter.common.bind.DTO;
import org.dozer.DozerBeanMapper;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

public class ResponseDTO<T> extends HttpEntity<T> {

    private static final DozerBeanMapper modelMapper = new DozerBeanMapper();

    private HttpStatus status;

    ResponseDTO(T body, HttpStatus status) {
        super(body);
        this.status = status;
    }


    public static ResponseDTO.Builder accepted() {
        return status(HttpStatus.ACCEPTED);
    }

    public static Builder badRequest() {
        return status(HttpStatus.BAD_REQUEST);
    }

    public static Builder status(HttpStatus status) {
        return new BodyBuilder(status);
    }

    public interface Builder {
        <T> ResponseDTO<T> convertTo(Object entity, Class<T> aClass);
    }

    private static class BodyBuilder  implements Builder{
        private HttpStatus status;

        public BodyBuilder(HttpStatus status) {
            this.status = status;
        }

        public <T> ResponseDTO<T> convertTo(Object entity, Class<T> aClass) {
            Assert.notNull(AnnotationUtils.getAnnotation(aClass, DTO.class),
                    "Type should contain DTO annotation");

            return new ResponseDTO<>(modelMapper.map(entity, aClass), this.status);
        }
    }
}
