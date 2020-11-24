package com.green.biz.schedule;

import java.util.List;

public interface ScheduleService {

	void insertSelected(SelectedVO vo);

	void insertRandom(RandomVO vo);
	
	public List<SelectedVO> selectSelected(String user_id);
	
	public void deleteSelected(SelectedVO vo);
	
	public void saveTrip(TempTripVO vo);
	
	public List<TempTripVO> getTempTrip(String user_id);
	
	public void deleteTempTrip(String user_id);
	
	public void insertSchedule(ScheduleVO vo);
	
	public int latestSseq();
	
	public List<ScheduleVO> getAllSchedule(String user_id);
	
	public List<RandomVO> getRandomByUserid(String user_id);
	
	public void deleteRandom(int sseq);
	
	public void deleteSchedule(int sseq);
	

}