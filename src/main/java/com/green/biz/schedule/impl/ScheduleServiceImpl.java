package com.green.biz.schedule.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.schedule.RandomVO;
import com.green.biz.schedule.ScheduleService;
import com.green.biz.schedule.ScheduleVO;
import com.green.biz.schedule.SelectedVO;
import com.green.biz.schedule.TempTripVO;

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
	public void deleteSelected(SelectedVO vo) {
		schedule.deleteSelected(vo);
		
	}

	@Override
	public void saveTrip(TempTripVO vo) {
		schedule.saveTrip(vo);
		
	}

	@Override
	public List<TempTripVO> getTempTrip(String user_id) {
		return schedule.getTempTrip(user_id);
	}

	@Override
	public void deleteTempTrip(String user_id) {
		schedule.deleteTempTrip(user_id);
		
	}

	@Override
	public void insertSchedule(ScheduleVO vo) {
		schedule.insertSchedule(vo);
		
	}

	@Override
	public int latestSseq() {
		return schedule.latestSseq();
	}

	@Override
	public List<ScheduleVO> getAllSchedule(String user_id) {
		return schedule.getAllSchedule(user_id);
	}

	@Override
	public List<RandomVO> getRandomByUserid(String user_id) {
		return schedule.getRandomByUserid(user_id);
	}

}
