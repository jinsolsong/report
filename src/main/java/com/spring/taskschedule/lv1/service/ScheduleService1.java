package com.spring.taskschedule.lv1.service;

import com.spring.taskschedule.lv1.dto.ResponseDto;
import com.spring.taskschedule.lv1.dto.UpdateResponseDto;
import com.spring.taskschedule.lv1.entity.Schedule;
import com.spring.taskschedule.lv1.repository.ScheduleRepository1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService1 {

    private final ScheduleRepository1 scheduleRepository;

    public ResponseDto createSchedule(String userName, String title, String todo){

        Schedule schedule = new Schedule(userName, title, todo);

        Schedule saveSchedule = scheduleRepository.save(schedule);

        return ResponseDto.toDto(saveSchedule);
    }

    public List<ResponseDto> findAll(){
        return scheduleRepository.findAll()
                .stream()
                .map(ResponseDto::toDto)
                .toList();
    }

    @Transactional
    public UpdateResponseDto updateSchedule(Long id, String userName, String title, String todo){

        Schedule findSchedule = scheduleRepository.findById(id).orElse(null);

        if (findSchedule == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id " + id);
        }

        findSchedule.setUserName(userName);
        findSchedule.setTitle(title);
        findSchedule.setTodo(todo);

        Schedule updateSchedule = scheduleRepository.save(findSchedule);

        return UpdateResponseDto.updateSchedule(updateSchedule);
    }
    @Transactional
    public void delete(Long id){

        Schedule findSchedule = scheduleRepository.findById(id).orElse(null);

        if (findSchedule == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id " + id);
        }

        scheduleRepository.delete(findSchedule);
    }



}
