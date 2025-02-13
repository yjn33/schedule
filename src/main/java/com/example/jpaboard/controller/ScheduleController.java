package com.example.jpaboard.controller;

import com.example.jpaboard.dto.CreateScheduleRequestDto;
import com.example.jpaboard.dto.ScheduleResponseDto;
import com.example.jpaboard.service.ScheduleService;

import lombok.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController
{
    private final ScheduleService scheduleService;


    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll()
    {
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();
        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
