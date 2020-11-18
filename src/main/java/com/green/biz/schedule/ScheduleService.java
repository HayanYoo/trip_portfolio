package com.green.biz.schedule;

import java.util.List;

public interface ScheduleService {

	void insertSelected(SelectedVO vo);

	void insertRandom(RandomVO vo);
	
	public List<SelectedVO> selectSelected(String user_id);

}