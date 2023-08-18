package com.akr.business.url.shortner.creator.util;

import org.junit.jupiter.api.Test;

public class UtilsTest {


    @Test
    public  void getShortKey(){
        String key= Utils.getShortKey();
        System.out.println(key);
    }
}
