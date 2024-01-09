package com.belajar.spring.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private int rowPerPage;
    private int totalPage;
    private int currentPage;
    private T data;
}

