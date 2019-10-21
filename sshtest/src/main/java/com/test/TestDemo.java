package com.test;


import net.sshtest.common.GenerateId;
import org.junit.Test;

public class TestDemo {
    @Test
    public void testGenerateId(){
        String s = new GenerateId().genEquipmentId("20190606",1);
        System.out.println(s);
    }

}
