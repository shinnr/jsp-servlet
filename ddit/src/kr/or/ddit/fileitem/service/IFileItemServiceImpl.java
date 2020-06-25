package kr.or.ddit.fileitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.fileitem.dao.IFileItemDAO;
import kr.or.ddit.fileitem.dao.IFileItemDAOImpl;
import kr.or.ddit.vo.FileItemVO;

public class IFileItemServiceImpl implements IFileItemService {
	private static IFileItemService service = new IFileItemServiceImpl();
	private IFileItemDAO dao;
	
	private IFileItemServiceImpl(){
		dao = IFileItemDAOImpl.getInstance();
	}
	
	public static IFileItemService getInstance(){
		return (service == null) ? new IFileItemServiceImpl() : service;
	}
	
	@Override
	public void insertFileItem(List<FileItemVO> fileitemList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FileItemVO fileitemInfo(Map<String, String> params) {
		FileItemVO fileItemInfo = null;
		
		try {
			fileItemInfo = dao.fileitemInfo(params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileItemInfo;
	}

}
