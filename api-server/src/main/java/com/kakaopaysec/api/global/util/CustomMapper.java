package com.kakaopaysec.api.global.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CustomMapper {

    public static <T, E> List<T> listMapper(List<E> replaceList, Function<E, T> replaceFunc) {
        List<T> mappingList = new ArrayList<>();
        for (E data : replaceList) {
            mappingList.add(replaceFunc.apply(data));
        }
        return mappingList;
    }
}
