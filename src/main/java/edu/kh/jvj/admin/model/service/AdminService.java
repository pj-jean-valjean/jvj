package edu.kh.jvj.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.jvj.admin.model.vo.Admin;
import edu.kh.jvj.admin.model.vo.ProductWrite;
import edu.kh.jvj.admin.model.vo.SearchedMember;

public interface AdminService {

	/** Product Insert 
	 * @param images
	 * @param product
	 * @param webPath
	 * @param serverPath
	 * @return result
	 * ProductWrite- writecate 상품대분류
	 */
	int insertProduct(List<MultipartFile> images, ProductWrite product, String webPath,
			String serverPath);

	/** Notice Insert
	 * @param title
	 * @param noticecate
	 * @param editordata
	 * @return result
	 */
	int insertNotice(String title, String noticecate, String editordata, int loginMember);

	/** findMatchedAdminIdPw
	 * @param admin
	 * @return count(*)
	 */
	Admin findMatchAdmin(Admin admin);

	List<SearchedMember> searchMember(Map<String, String> dataMap);

	int insertOptionP(Map<String, String> map);

	
}
