package com.errorCode.pandaOffice.payroll.domain.repository;

import com.errorCode.pandaOffice.payroll.domain.entity.EarningRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EarningRecordRepository extends JpaRepository<EarningRecord, Integer> {

}
