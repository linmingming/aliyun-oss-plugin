package test;

import com.fit2cloud.jenkins.aliyunoss.Utils;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void testGetPathPrefix() {
        // dist/**
        //
        String prefix = "dist/**";
        String filePath = "C:\\Users\\Administrator\\.jenkins\\workspace\\test-oss\\dist\\static\\js\\chunk-e5454fc0.d69fb8f6.js";
        System.out.println(filePath);
        System.out.println(Utils.getFilePathPrefix(prefix, filePath));

        filePath = "C:\\Users\\Administrator\\.jenkins\\workspace\\test-oss\\dist\\NIM_Web_SDK_v8.2.0.js.gz";
        System.out.println(filePath);
        System.out.println(Utils.getFilePathPrefix(prefix, filePath));

        filePath = "C:\\Users\\Administrator\\.jenkins\\workspace\\test-oss\\dist\\index.html";
        System.out.println(filePath);
        System.out.println(Utils.getFilePathPrefix(prefix, filePath));

        filePath = "C:\\Users\\Administrator\\.jenkins\\workspace\\test-oss\\dist\\static\\img\\404.a57b6f31.png";
        System.out.println(filePath);
        System.out.println(Utils.getFilePathPrefix(prefix, filePath));
    }
}
