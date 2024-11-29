package kr.co.mbc.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {
	
	public static String uploadPath = Paths.get("src/main/resources/static/upload").toAbsolutePath().toString();
	
	public static void deleteFiles(List<String> list) {
		
		for(String file : list) {
			File f = new File(uploadPath, file);
			f.delete();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static String isImage(String filename) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("png", "png");
		map.put("gif", "gif");
		map.put("jpg", "jpg");
		map.put("jpeg", "jpeg");
		
		int idx = filename.lastIndexOf(".") + 1;
		String extname = filename.substring(idx).toLowerCase();
		
		String result = map.get(extname); 
		
		return result;
	}
	
	   public static String uploadFile(String orgname, byte[] arr) {

		      String fullFilename = null;

		      String path = UploadFileUtils.makeFolder();

		      String uploadPath = Paths.get("src/main/resources/static").toAbsolutePath().toString() + "/" + "upload";

		      String newFilename = UploadFileUtils.makeFilename(orgname);

		      File target = new File(uploadPath + path, newFilename);

		      try {
		         FileCopyUtils.copy(arr, target);

		         fullFilename = path + File.separator + newFilename;
		         fullFilename = fullFilename.replace(File.separatorChar, '/');
		      } catch (IOException e) {
		         e.printStackTrace();
		      }

		      return fullFilename;
		   }

	public static String uploadFile(MultipartFile file) {

		String orgname = file.getOriginalFilename();

		String fullFilename = null;

		String path = UploadFileUtils.makeFolder();

		String uploadPath = Paths.get("src/main/resources/static").toAbsolutePath().toString() + "/" + "upload";

		String newFilename = UploadFileUtils.makeFilename(orgname);

		File target = new File(uploadPath + path, newFilename);

		try {
			FileCopyUtils.copy(file.getBytes(), target);

			fullFilename = path + File.separator + newFilename;
			fullFilename = fullFilename.replace(File.separatorChar, '/');
		} catch (IOException e) {
			e.printStackTrace();
		}

		return fullFilename;
	}

	public static String getOrgname(String filename) {

		String orgname = null;

		String cut = "___mbc___";
		int idx = filename.indexOf(cut) + cut.length();
		orgname = filename.substring(idx);

		return orgname;
	}

	public static String makeFilename(String orgname) {

		String filename = null;

		String uid = UUID.randomUUID().toString();
		filename = uid + "___mbc___" + orgname;

		return filename;
	}

	public static String makeFolder() {

		String uploadPath = Paths.get("src/main/resources/static").toAbsolutePath().toString() + "/" + "upload";
		File uploadPathFile = new File(uploadPath);

		if (!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}

		String path = UploadFileUtils.dateInfo();

		File f = new File(uploadPath, path);

		if (!f.exists()) {
			f.mkdirs();
		}

		return path;
	}

	public static String dateInfo() {
		Date d = new Date();

		String pattern = String.format("%syyyy%sMM%sdd", File.separator, File.separator, File.separator);

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String naljja = sdf.format(d);

		return naljja;
	}

}
