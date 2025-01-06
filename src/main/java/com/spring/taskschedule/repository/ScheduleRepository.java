package com.spring.taskschedule.repository;

import com.spring.taskschedule.entity.ScheduleEntity;
import com.spring.taskschedule.exception.IdNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

    default ScheduleEntity findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(()->new IdNotFoundException("아이디를 확인해주세요"));
    }


}
