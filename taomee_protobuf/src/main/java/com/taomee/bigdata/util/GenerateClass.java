package com.taomee.bigdata.util;

import java.io.IOException;

/**
 * Created by looper on 2017/6/2.
 */
public class GenerateClass {
    public static void main(String[] args) {
        String protoFile = "person-entity.proto";//
       // String path = "E:\\idea_workspace_java\\platform\\refactor\\tms\\hadoop\\storm-starter\\tms-spring-lib\\taomee_protobuf\\src\\main\\java\\com\\taomee\\bigdata\\spring";
        //String project_comm = "E:/idea_workspace_java/platform/refactor/tms/hadoop/storm-starter/tms-spring-lib/taomee_protobuf";
       // String project_comm ="E:\\idea_workspace_java\\platform\\refactor\\tms\\hadoop\\storm-starter\\tms-spring-lib\\taomee_protobuf";
        String strCmd = "E:/idea_workspace_java/platform/refactor/tms/hadoop/storm-starter/tms-spring-lib/taomee_protobuf/protoc.exe --java_out=./src/main/java ./src/main/proto/" + protoFile;
        System.out.println(strCmd);
        //String strCmd = "E:/protobuf/protobuf-2.5.0/protobuf-2.5.0/protoc-2.5.0-win32/protoc.exe -I=./proto/person-entity.proto";
        try {
          Runtime.getRuntime().exec(strCmd);
        } catch (Exception e) {
            e.printStackTrace();
        }//通过执行cmd命令调用protoc.exe程序
    }


}
