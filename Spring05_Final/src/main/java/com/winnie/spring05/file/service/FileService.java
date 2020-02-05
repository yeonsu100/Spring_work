package com.winnie.spring05.file.service;

import javax.servlet.http.HttpServletRequest;

import com.winnie.spring05.file.dto.FileDto;

public interface FileService {
	public void list(HttpServletRequest request);
	public void saveFile(HttpServletRequest request, FileDto dto);
}
