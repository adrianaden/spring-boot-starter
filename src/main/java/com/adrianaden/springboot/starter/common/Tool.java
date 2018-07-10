package com.adrianaden.springboot.starter.common;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

public class Tool {

    public Tool() {
        throw new IllegalArgumentException("Don't create instance Utility class!");
    }

    /**
     * Copy non null value attribute from source to target
     * attribute with null value will ignored and keep using attribute value in target
     *
     * see:
     */
    public static void copyNonNullProperties(Object s, Object t) {
        BeanUtils.copyProperties(s, t, getNullPropertyNames(s));
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}