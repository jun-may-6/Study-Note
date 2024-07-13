package com.errorCode.pandaOffice.e_approval.dto.approvalDocument.response;

import com.errorCode.pandaOffice.e_approval.domain.entity.ApprovalDocument;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class ApprovalDocumentListResponse {
    private final int id;
    private final String title;
    private final String templateName;
    private final String draftEmployeeName;
    private final LocalDate draftDate;
    private final LocalDate lastApprovalDate;
    private final String departmentName;
    private final String documentStatus;
    private final String approvalStatus;

    public static ApprovalDocumentListResponse from(final ApprovalDocument approvalDocument, int employeeId){
        return ApprovalDocumentListResponse.builder()
                .id(approvalDocument.getId())
                .title(approvalDocument.getTitle())
                .templateName(approvalDocument.getDocumentTemplate().getName())
                .draftEmployeeName(approvalDocument.getDraftEmployee().getName())
                .draftDate(approvalDocument.getDraftDate())
                .lastApprovalDate(approvalDocument.getLastApprovalDate())
                .departmentName(approvalDocument.getDepartment().getName())
                .approvalStatus(approvalDocument
                        .getApprovalLineList()
                        .stream()
                        .filter(line->line.getEmployee().getEmployeeId() == employeeId)
                        .findFirst()
                        .map(line -> line.getStatus().getDescription())
                        .orElse(null))
                .documentStatus(approvalDocument.getStatus().getDescription())
                .build();
    }
}
