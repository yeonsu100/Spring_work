package com.winnie.spring05.file.dao;

import java.util.List;

import com.winnie.spring05.file.dto.FileDto;

public interface FileDao {
	public int getCount();
	public List<FileDto> getList(FileDto dto);
}
