package com.ites.poswebservice.services;

import com.ites.poswebservice.dao.TableDao;
import com.ites.poswebservice.model.hotelpos.TableConfig;
import com.ites.poswebservice.model.random.OpenTableDetail;
import com.ites.poswebservice.model.random.TableLoad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TableServiceImpl implements TableService {
	@Autowired
	TableDao tableDao;

	/* 
	 * Get all the available tables from DAO
	 * 
	 * @return List<TableConfig>
	 */
        @Override
	public List<TableLoad> getAllTables(int id,int userId) {
		List<TableLoad> allTables = tableDao.getAllTables(id,userId);
		return allTables;
	}
	
	/* 
	 * Get a particular TableConfig from DAO.
	 * 
	 * @param int id
	 * 
	 * @return TableConfig
	 */
        @Override
	public TableConfig getTable(int id) {
		TableConfig table = tableDao.getTable(id);
		return table;
	}
	
        @Override
	public List<OpenTableDetail> getOpenTableDetail(int tableId){
		List<OpenTableDetail> openTableDetail = tableDao.getOpenTableDetail(tableId);
		return openTableDetail;
	}
        
        @Override
        public void updateOpenTableState(Integer kotNo){
        tableDao.updateOpenTableState(kotNo);
        }
        
}