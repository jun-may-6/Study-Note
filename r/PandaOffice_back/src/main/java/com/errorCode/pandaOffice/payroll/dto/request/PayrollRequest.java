package com.errorCode.pandaOffice.payroll.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class PayrollRequest {

    private final int employeeId;
    private final LocalDate payrollDate;
    private final String payStubPath;
    private final List<EarningRequest> earningRecordList;
    private final List<DeductionRequest> deductionRecordList;

    @RequiredArgsConstructor
    @Getter
    @ToString
    public static class EarningRequest {
        private final int earningCategoryId;
        private final int amount;
    }

    @RequiredArgsConstructor
    @Getter
    @ToString
    public static class DeductionRequest {
        private final int deductionCategoryId;
        private final int amount;
    }
}
