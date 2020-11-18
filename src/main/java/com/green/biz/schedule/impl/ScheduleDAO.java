package com.green.biz.schedule.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.schedule.RandomVO;
import com.green.biz.schedule.SelectedVO;




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
}
