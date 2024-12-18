package com.spring.taskschedule.lv2_3.service;


import com.spring.taskschedule.lv2_3.dto.ScheduleResponseDto;
import com.spring.taskschedule.lv2_3.entity.ScheduleEntity;
import com.spring.taskschedule.lv2_3.entity.User;
import com.spring.taskschedule.lv2_3.repository.ScheduleRepository2;
import com.spring.taskschedule.lv2_3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService2 {

    private final UserRepository userRepository;
    private final ScheduleRepository2 scheduleRepository2;

    public ScheduleResponseDto save(Long userId, String title, String todo){

        User findUser = userRepository.findByIdOrElseThrow(userId);

        ScheduleEntity scheduleEntity = new ScheduleEntity(title, todo);

        scheduleEntity.setUser(findUser);

        scheduleRepository2.save(scheduleEntity);

        return ScheduleResponseDto.toDto(scheduleEntity);


    }

    public List<ScheduleResponseDto> findAllSchedule(){
        return scheduleRepository2.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto updateSchedule(Long id, String title, String todo){

        ScheduleEntity findSchedule = scheduleRepository2.findByIdOrElseThrow(id);

        findSchedule.setTitle(title);
        findSchedule.setTodo(todo);

        ScheduleEntity updateSchedule = scheduleRepository2.save(findSchedule);

        return ScheduleResponseDto.toDto(updateSchedule);

    }

    public void deleteSchedule(Long id){

        ScheduleEntity findSchedule = scheduleRepository2.findByIdOrElseThrow(id);

        scheduleRepository2.delete(findSchedule);
    }

}
