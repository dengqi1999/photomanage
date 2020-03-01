package com.dq.photomanagement.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dq.photomanagement.bean.Msg;
import com.dq.photomanagement.bean.Photo;
import com.dq.photomanagement.service.PhotoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理图片的查询
 * @author dq
 *
 */
@Controller
public class PhotoController {
	
	@Autowired
	PhotoService photoservice;
	
	/**
	 * 支持前后端分离的写法
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/photo")//负责获取所有列表数据
	@ResponseBody
	public Msg getPhoto(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		PageHelper.startPage(pn,21);
		List<Photo> photolist=photoservice.getAll();
		PageInfo<Photo> pageInfo=new PageInfo<Photo>(photolist,21);
		return Msg.success().add("pageInfo", pageInfo);
	}
	/**
	 * 获取指定的photo数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/photo/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Msg getPhotoByID(@PathVariable(value="id")String id) {
		return Msg.success().add("photo", photoservice.selectPhotoByID(id));
	}
	/**
	 * 保存相关图片信息
	 * @param request
	 * @param upload
	 * @param gname
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/photo", method = RequestMethod.POST)
	@ResponseBody
	public Msg upload( HttpServletRequest request, MultipartFile upload,@RequestParam(value="gname",defaultValue="全部")String gname,@RequestParam(value="name",defaultValue="")String name) throws Exception {
		if(upload.isEmpty())return Msg.fail().setMsg("上传失败，文件为空");;
		photoservice.savePhoto(request, upload, gname,name);
	    return Msg.success();
	}
	/**
	 * 删除照片数据
	 * @param photoid
	 * @return
	 */
	@RequestMapping(value = "/photo/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg delete(@PathVariable(value="ids")String ids) {
		boolean flag;
		if(ids.contains("-")){
			String[] ids_str=ids.split("-");
			List<String> list=Arrays.asList(ids_str);
			flag=photoservice.deletePhotoBatch(list);
		}else {
			flag=photoservice.deletePhoto(ids);
		}
		if(flag) {
			return Msg.success();
		}else {
			return Msg.fail();
		}
	}
	
	@RequestMapping(value="/photo/{photoid}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updatePhoto(Photo photo) {
		photoservice.savePhotoChange(photo);
		return Msg.success();
	}
}
