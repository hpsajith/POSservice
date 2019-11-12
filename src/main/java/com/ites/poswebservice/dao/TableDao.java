package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.TableConfig;
import com.ites.poswebservice.model.random.OpenTableDetail;
import com.ites.poswebservice.model.random.TableLoad;
import java.util.List;

public interface TableDao {
	List<TableLoad> getAllTables(int id,int userId);
	TableConfig getTable(int id);
	List<OpenTableDetail> getOpenTableDetail(int tableId);

    public void updateOpenTableState(Integer kotNo);
}