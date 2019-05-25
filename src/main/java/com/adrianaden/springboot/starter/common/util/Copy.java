package com.adrianaden.springboot.starter.common.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.Arrays;

public class Copy {

    public Copy() {
        throw new IllegalArgumentException("Don't create instance Utility class!");
    }


    public static void copyProperties(Object s, Object t) {
        BeanUtils.copyProperties(s, t);
    }

    public static void copyNonNullProperties(Object s, Object t) {
        BeanUtils.copyProperties(s, t, getNullPropertyNames(s));
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);

        return Arrays.stream(src.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(name -> src.getPropertyValue(name) == null)
                .toArray(String[]::new);
    }
}
