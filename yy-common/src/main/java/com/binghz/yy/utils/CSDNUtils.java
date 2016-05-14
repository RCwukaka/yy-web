package com.binghz.yy.utils;

import java.io.File;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class CSDNUtils {
	private static UploadManager uploadManager = new UploadManager();

	private static String ACCESS_KEY = "nsCXn1nN2tBle9SZor1xHP2y77Im1pFH_InLu-rO";
	private static String SECRET_KEY = "IEgTi-3FSoLSzo1U8VWDmBSMT7H3gkh-LrAMi3SZ";

	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

	private volatile static CSDNUtils ftpQiNiu;

	private CSDNUtils() {
	}

	public static CSDNUtils getFtpQiNiu() {
		if (ftpQiNiu == null) {
			synchronized (CSDNUtils.class) {
				if (ftpQiNiu == null) {
					ftpQiNiu = new CSDNUtils();
				}
			}
		}
		return ftpQiNiu;
	}

	private String getUpToken1(String fileSrc) {
		return auth.uploadToken("static",fileSrc);
	}

	public Response upFile(File file, String fileSrc) throws QiniuException {
		String token = getUpToken1(fileSrc);
		return uploadManager.put(file, fileSrc, token);
	}
}
