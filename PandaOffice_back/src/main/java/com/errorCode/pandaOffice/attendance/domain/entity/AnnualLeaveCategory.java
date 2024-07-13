package com.errorCode.pandaOffice.attendance.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
/* 연차 분류 */
public class AnnualLeaveCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* 연차 분류 코드 */
    private int id;

    /* 연차 분류 이름 */
    private String name;

    // 이거 안씀
    /* 연차 분류의 타입 */
    /* 부여 or 소진 */
    private String type;

}
