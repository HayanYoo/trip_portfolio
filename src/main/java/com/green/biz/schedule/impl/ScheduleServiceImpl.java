package com.green.biz.schedule.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.schedule.RandomVO;
import com.green.biz.schedule.ScheduleService;
import com.green.biz.schedule.SelectedVO;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleDAO schedule;
	
	@Override
	public void insertSelected(SelectedVO vo) {
		
		schedule.insertSelected(vo);
	}

	@Override
	public void insertRandom(RandomVO vo) {
		
		schedule.insertRandom(vo);
		
	}

	@Override
	public List<SelectedVO> selectSelected(String user_id) {
		return schedule.selectSelected(user_id);
	}

	@Override
	public void delete_selected(SelectedVO vo) {
		schedule.delete_selected(vo);
		
	}

}
