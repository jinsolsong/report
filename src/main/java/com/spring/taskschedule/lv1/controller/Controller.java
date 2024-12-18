package com.spring.taskschedule.lv1.controller;

import com.spring.taskschedule.lv1.dto.RequestDto;
import com.spring.taskschedule.lv1.dto.ResponseDto;
import com.spring.taskschedule.lv1.dto.UpdateResponseDto;
import com.spring.taskschedule.lv1.service.ScheduleService1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class Controller {

    private final ScheduleService1 scheduleService;

    @PostMapping
    public ResponseEntity<ResponseDto> createSchedule(@RequestBody RequestDto dto){

        ResponseDto responseDto =
                scheduleService.createSchedule(
                        dto.getUserName(),
                        dto.getTitle(),
                        dto.getTodo()
                );
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponseDto>> findAll(){
        List<ResponseDto> responseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")

    public ResponseEntity<UpdateResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody RequestDto dto
    ){

        UpdateResponseDto updateSchedule = scheduleService.updateSchedule(id, dto.getUserName(), dto.getTitle(), dto.getTodo());

        return new ResponseEntity<>(updateSchedule, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void> delete(@PathVariable Long id){

        scheduleService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
