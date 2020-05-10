package com.bjsxt.spark.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bjsxt.spark.dao.ICarTrackDAO;
import com.bjsxt.spark.domain.CarTrack;
import com.bjsxt.spark.jdbc.JDBCHelper;

public class CarTrackDAOImpl implements ICarTrackDAO {
	@Override
	public void insertBatchCarTrack(List<CarTrack> carTracks) {
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		 String sql = "INSERT INTO car_track VALUES(?,?,?,?)";
		 List<Object[]> params = new ArrayList<>();
		 for(CarTrack c : carTracks){
			 /**
			  * 添加到车辆轨迹表中
			  */
			 params.add(new Object[]{c.getTaskId(),c.getDate(),c.getCar(),c.getTrack()});
			 
		 }
		 jdbcHelper.executeBatch(sql, params);
	}

}
