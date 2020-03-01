package com.dq.photomanagement.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dq.photomanagement.bean.Photo;
import com.dq.photomanagement.bean.PhotoExample;
import com.dq.photomanagement.bean.PhotoExample.Criteria;
import com.dq.photomanagement.dao.PhotoMapper;
import com.dq.photomanagement.utils.PhotoFileUtils;
@Service
public class PhotoService {

	@Autowired
	PhotoMapper photomapper;
	
	PhotoFileUtils fileUtils=new PhotoFileUtils();
	
	public List<Photo> getAll() {
		return photomapper.selectByExample(null);
	}
	
	public boolean savePhoto(HttpServletRequest request, MultipartFile upload,String gname, String name) throws IllegalStateException, IOException {
		// 使用fileupload组件完成文件上传
	    // 1. 指定文件上传保存的位置
	    String path = request.getSession().getServletContext().getRealPath("/WEB-INF/photo/"+gname);
	    // 判断该路径是否存在
	    File file = new File(path);
	    if (!file.exists() || !file.isDirectory()){
	         file.mkdirs();
	    }
	    // 打印一下文件保存的路径
	    System.out.println("path:"+path);

	    // 把文件的id设置唯一值，uuid
	    String uuid = UUID.randomUUID().toString().replace("-", "");
	    uuid = uuid+"_"+name;
	    System.out.println("图片名字："+name);
	    System.out.println("分组名字："+gname);
	    // 3.上传文件
	    upload.transferTo(new File(path,uuid));
	    photomapper.insert(new Photo(uuid, name, gname, path+"/"+uuid, gname+"/"+uuid, Integer.valueOf((int)file.length())));
	    return true;
	}

	/**
	 * 删除单个照片
	 * @param ids
	 */
	public boolean deletePhoto(String ids) {
		Photo photo=selectPhotoByID(ids);
		System.out.println(ids);
		if(fileUtils.deleteFile(photo.getRealpath())) {
			photomapper.deleteByPrimaryKey(ids);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 批量删除照片
	 * @param ids_str
	 * @return 
	 */
	public boolean deletePhotoBatch(List<String> ids_str) {
		boolean flag=false;
		for(String id:ids_str) {
			Photo photo=selectPhotoByID(id);
			if(fileUtils.deleteFile(photo.getRealpath())) {
				flag= true;
			}
			else {
				flag= false;
			}
		}
		if(!flag)return false;
		PhotoExample example=new PhotoExample();
		Criteria cri=example.createCriteria();
		cri.andPhotoidIn(ids_str);
		photomapper.deleteByExample(example);
		return true;
	}
	/**
	 * 根据指定的id查找对应的photo对象
	 * @param id
	 * @return
	 */
	public Photo selectPhotoByID(String id) {
		return photomapper.selectByPrimaryKey(id);
	}

	public void savePhotoChange(Photo photo) {
		photomapper.updateByPrimaryKeySelective(photo);
	}
}
