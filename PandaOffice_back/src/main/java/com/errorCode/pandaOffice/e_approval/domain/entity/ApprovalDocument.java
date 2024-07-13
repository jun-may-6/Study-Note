package com.errorCode.pandaOffice.e_approval.domain.entity;

import com.errorCode.pandaOffice.e_approval.domain.type.ApprovalStatus;
import com.errorCode.pandaOffice.e_approval.domain.type.converter.ApprovalStatusConverter;
import com.errorCode.pandaOffice.e_approval.dto.approvalDocument.request.CreateApprovalDocumentRequest;
import com.errorCode.pandaOffice.employee.domain.entity.Department;
import com.errorCode.pandaOffice.employee.domain.entity.Employee;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "approval_document")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
/* 전자결재 */
public class ApprovalDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /* 결재서 제목 */
    private String title;
    @ManyToOne
    @JoinColumn(nullable = false, name = "document_template_id")
    private DocumentTemplate documentTemplate;
    @ManyToOne
    @JoinColumn(nullable = false, name="draft_employee_id")
    /* 기안자 */
    private Employee draftEmployee;
    @Column(nullable = false)
    /* 기안일 */
    private LocalDate draftDate;
    /* 최근 결재일 */
    private LocalDate lastApprovalDate;
    /* 기안 당시 부서 */
    @ManyToOne
    @JoinColumn(nullable = false, name = "department_id")
    private Department department;
    /* 문서 파일 */
    @Column(name = "document", columnDefinition = "LONGTEXT")
    private String document;
    /* 결재 상태 */
    @Convert(converter = ApprovalStatusConverter.class)
    private ApprovalStatus status = ApprovalStatus.APPROVE;
    /* 문서 첨부파일 리스트 */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private List<DocumentAttachedFile> attachments;
    /* 결재선 */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private List<ApprovalLine> approvalLineList;

    public static ApprovalDocument of(CreateApprovalDocumentRequest documentRequest, DocumentTemplate documentTemplate, Employee draftEmployee, List<ApprovalLine> approvalLine, List<DocumentAttachedFile> documentAttachedFileList) {
        ApprovalDocument approvalDocument = new ApprovalDocument();
        approvalDocument.title = documentRequest.getTitle();
        approvalDocument.documentTemplate = documentTemplate;
        approvalDocument.draftEmployee = draftEmployee;
        approvalDocument.draftDate = LocalDate.now();
        approvalDocument.department = draftEmployee.getDepartment();
        approvalDocument.document = documentRequest.getDocument();
        approvalDocument.attachments = documentAttachedFileList;
        approvalDocument.approvalLineList = approvalLine;
        return approvalDocument;
    }

    public void stateHandler(ApprovalStatus approvalStatus) {
        this.status = approvalStatus;
    }
}
