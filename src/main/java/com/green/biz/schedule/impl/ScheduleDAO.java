package com.green.biz.schedule.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.schedule.RandomVO;
import com.green.biz.schedule.ScheduleVO;
import com.green.biz.schedule.SelectedVO;
import com.green.biz.schedule.TempTripVO;




@Repository
public class ScheduleDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertSelected(SelectedVO vo) {
		mybatis.insert("ScheduleDAO.insertSelected", vo);
		
	}
	
	public void insertRandom(RandomVO vo) {
		mybatis.insert("ScheduleDAO.insertRandom", vo);
		
	}
	
	public List<SelectedVO> selectSelected(String user_id) {
		return mybatis.selectList("ScheduleDAO.selectSelected", user_id);
	}
	
	public void deleteSelected(SelectedVO vo) {
		mybatis.delete("ScheduleDAO.delete_selected", vo);
		
	}
	
	public void saveTrip(TempTripVO vo) {
		mybatis.insert("ScheduleDAO.saveTrip", vo );
	}
	
	public List<TempTripVO> getTempTrip(String user_id){
		return mybatis.selectList("ScheduleDAO.getTempTrip", user_id);
	}
	
	public void deleteTempTrip(String user_id) {
		mybatis.delete("ScheduleDAO.deleteTempTrip", user_id);
	}
	
	public void insertSchedule(ScheduleVO vo) {
		mybatis.insert("ScheduleDAO.insertSchedule", vo);
	}
	
	public int latestSseq() {
		return mybatis.selectOne("ScheduleDAO.latestSseq");
	}
	
	public List<ScheduleVO> getAllSchedule(String user_id){
		return mybatis.selectList("ScheduleDAO.getAllSchedule", user_id);
	}
	
	public List<RandomVO> getRandomByUserid(String user_id){
		return mybatis.selectList("ScheduleDAO.getRandomByUserid", user_id);
	}
} 
