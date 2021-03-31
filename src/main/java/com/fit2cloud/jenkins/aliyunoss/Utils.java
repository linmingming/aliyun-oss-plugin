package com.fit2cloud.jenkins.aliyunoss;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import hudson.Util;
import hudson.model.BuildListener;
import hudson.model.AbstractBuild;


public class Utils {
	public static final String FWD_SLASH = "/";

	public static boolean isNullOrEmpty(final String name) {
		boolean isValid = false;
		if (name == null || name.matches("\\s*")) {
			isValid = true;
		}
		return isValid;
	}

	public static String replaceTokens(AbstractBuild<?, ?> build,
			BuildListener listener, String text) throws IOException,
			InterruptedException {
		String newText = null;
		if (!isNullOrEmpty(text)) {
			Map<String, String> envVars = build.getEnvironment(listener);
			newText = Util.replaceMacro(text, envVars);
		}
		return newText;
	}


	// dist/**
	// C:\Users\Administrator\.jenkins\workspace\test-oss\dist\static\js\chunk-e5454fc0.d69fb8f6.js
	public static String getFilePathPrefix(String artifactConfig, String filePath) {
		String pathPrefix = "";
		if (artifactConfig.indexOf("**") != -1 ) {
			// 去掉**
			String match = artifactConfig.replaceAll("\\*\\*", "");
			// 反斜杠替换成正斜杠
			filePath = filePath.replaceAll("\\\\", "/");
			// 进行匹配截取路径后面部分
			pathPrefix = filePath.substring(filePath.lastIndexOf(match) + match.length());

			System.out.println(pathPrefix);
			// 去除最后的文件名拿到路径前缀部分
			if (pathPrefix.lastIndexOf("/") == -1) {
				pathPrefix = "";
			} else {
				pathPrefix = pathPrefix.substring(0, pathPrefix.lastIndexOf("/") + 1);
			}
		}
		return pathPrefix;
	}
}

