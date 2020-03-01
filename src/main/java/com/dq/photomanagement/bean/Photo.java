package com.dq.photomanagement.bean;

import javax.validation.constraints.NotNull;

public class Photo {
    private String photoid;
    
    @NotNull
    private String photoname;

    private String gname;

    private String realpath;

    private String path;

    private Integer size;

    
    public Photo() {
		super();
	}

	public Photo(String photoid, String photoname, String gname, String realpath, String path, Integer size) {
		super();
		this.photoid = photoid;
		this.photoname = photoname;
		this.gname = gname;
		this.realpath = realpath;
		this.path = path;
		this.size = size;
	}

	public String getPhotoid() {
        return photoid;
    }

    public void setPhotoid(String photoid) {
        this.photoid = photoid == null ? null : photoid.trim();
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname == null ? null : photoname.trim();
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getRealpath() {
        return realpath;
    }

    public void setRealpath(String realpath) {
        this.realpath = realpath == null ? null : realpath.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}