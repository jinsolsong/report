package com.spring.taskschedule.controller;

import com.spring.taskschedule.dto.CreateScheduleRequestDto;
import com.spring.taskschedule.dto.ScheduleResponseDto;
import com.spring.taskschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules2")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService2;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto dto){

        ScheduleResponseDto scheduleResponseDto =
                scheduleService2.save(
                        dto.getUserId(),
                        dto.getTitle(),
                        dto.getTodo()
                );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);


    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(){

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService2.findAllSchedule();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleResponseDto dto
    ){
        ScheduleResponseDto updateSchedule = scheduleService2.updateSchedule(id, dto.getTitle(), dto.getTodo());

        return new ResponseEntity<>(updateSchedule, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){

        scheduleService2.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
