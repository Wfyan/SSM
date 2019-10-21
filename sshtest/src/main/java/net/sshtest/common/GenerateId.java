package net.sshtest.common;

public class GenerateId {

    /**
     * 生成器材的ID 日期（8位）+序号（4位）
     */
    public String genEquipmentId(String data,int count){
        for(int i=0;i<4-(Integer.valueOf(count).toString().length());i++){
            data+='0';
        }
        data+=Integer.valueOf(count).toString();
        return data;
    }



}
