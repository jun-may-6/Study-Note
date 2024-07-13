package com.errorCode.pandaOffice.recruitment.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
@ToString
public class InterviewScheduleCreateRequest {


    /* 일정명 */
    @NotNull
    private final String name;

    /* 메모 */
    @NotNull
    private final String memo;

    /* 일정 시작일 */
    @NotNull
    private final LocalDate startDate;

    /* 일정 종료일 */
    @NotNull
    private final LocalDate endDate;

    /* 일정 시작 일시 */
    @NotNull
    private final LocalTime startTime;

    /* 면접 장소 */
    @NotNull
    private final Integer place;
    /* 면접관들 */
    @NotNull
    private final Integer employee;

    /* 면접자들 */
    @NotNull
    private final List<Integer> applicantList;
}
