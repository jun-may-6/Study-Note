package com.errorCode.pandaOffice.payroll.domain.entity;

import com.errorCode.pandaOffice.employee.domain.entity.Employee;
import com.errorCode.pandaOffice.payroll.dto.request.PayrollRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/* 급여 기록 Entity */
@Entity
@Table(name = "payroll_record")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class PayrollRecord {

    /*
     * 들어오는 JSON
     * {
     *   {사번: 123142,
     *   지급: [{지급 항목:1, 금액:인풋값}, {지급 항목:2, 금액:인풋값]
     *   공제: [{공제 항목:1, 금액:인풋값}, {공제 항목:2, 금액:인풋값]
     * }
     *
     * {
     *   empId: 123142
     *   List<지급기록>: [{지급 항목:1, 금액:인풋값}, {지급 항목:2, 금액:인풋값]
     *   List<공제기록>: [{공제 항목:1, 금액:인풋값}, {공제 항목:2, 금액:인풋값]
     * }
     * */

    /* 급여코드 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /* 사번 */
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    /* 급여일 */
    @Column(name = "payroll_date")
    private LocalDate payrollDate;

    /* 생성일 */
    @CreatedDate
    @Column(name = "created_date")
    private LocalDate createdDate;

    /* 급여명세서 경로 */
    @Column(name = "pay_stub_path")
    private String payStubPath;

    /* 지급 코드 */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "payroll_id")
    private List<EarningRecord> earningRecordList = new ArrayList<>();;

    /* 공제 코드 */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "payroll_id")
    private List<DeductionRecord> deductionRecordList = new ArrayList<>();;

    public PayrollRecord(Employee employee, LocalDate payrollDate, String payStubPath,
                         List<EarningRecord> earningRecords, List<DeductionRecord> deductionRecords) {
        this.employee = employee;
        this.payrollDate = payrollDate;
        this.payStubPath = payStubPath;
        this.earningRecordList = earningRecords;
        this.deductionRecordList = deductionRecords;
    }

    public static PayrollRecord of(PayrollRequest payrollRequest, Employee employeeEntity, List<EarningRecord> earningRecordEntityList, List<DeductionRecord> deductionRecordEntityList) {
        PayrollRecord newRecord = new PayrollRecord();
        newRecord.employee = employeeEntity;
        newRecord.payrollDate = payrollRequest.getPayrollDate();
        newRecord.payStubPath = payrollRequest.getPayStubPath();
        newRecord.earningRecordList = earningRecordEntityList;
        newRecord.deductionRecordList = deductionRecordEntityList;
        return newRecord;
    }
}
