package com.neu.carbon.scm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;
import com.neu.common.core.domain.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采购申请对象 scm_purchase_apply
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@ApiModel("采购申请")
public class ScmPurchaseApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 申请单号 */
    @ApiModelProperty("申请单号")
    @Excel(name = "申请单号")
    private String applyNo;

    /** 计划id */
    @ApiModelProperty("计划id")
    @Excel(name = "计划id")
    private Long planId;

    /** 计划no */
    @ApiModelProperty("计划no")
    @Excel(name = "计划no")
    private String planNo;

    /** 申请类型 */
    @ApiModelProperty("申请类型")
    @Excel(name = "申请类型")
    private String applyType;

    /** 补货id */
    @ApiModelProperty("补货id")
    @Excel(name = "补货id")
    private Long replenishId;

    /** 补货单号 */
    @ApiModelProperty("补货单号")
    @Excel(name = "补货单号")
    private String replenishNo;

    /** 申请人 */
    @ApiModelProperty("申请人")
    @Excel(name = "申请人")
    private String applyUser;

    /** 申请日期 */
    @ApiModelProperty(value="申请日期",example = "2021-09-10 10:20:40")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime;

    /** 申请状态 */
    @ApiModelProperty("申请状态")
    @Excel(name = "申请状态")
    private String applyStatus;

    /** 审核人 */
    @ApiModelProperty("审核人")
    @Excel(name = "审核人")
    private String auditUser;

    /** 审核时间 */
    @ApiModelProperty(value="审核时间",example = "2021-09-10 10:20:40")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date auditTime;

    /** 审核状态 */
    @ApiModelProperty("审核状态")
    @Excel(name = "审核状态")
    private String auditStatus;

    /** 审核意见 */
    @ApiModelProperty("审核意见")
    @Excel(name = "审核意见")
    private String auditComment;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setApplyNo(String applyNo) 
    {
        this.applyNo = applyNo;
    }

    public String getApplyNo() 
    {
        return applyNo;
    }
    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }
    public void setPlanNo(String planNo) 
    {
        this.planNo = planNo;
    }

    public String getPlanNo() 
    {
        return planNo;
    }
    public void setApplyType(String applyType) 
    {
        this.applyType = applyType;
    }

    public String getApplyType() 
    {
        return applyType;
    }
    public void setReplenishId(Long replenishId) 
    {
        this.replenishId = replenishId;
    }

    public Long getReplenishId() 
    {
        return replenishId;
    }
    public void setReplenishNo(String replenishNo) 
    {
        this.replenishNo = replenishNo;
    }

    public String getReplenishNo() 
    {
        return replenishNo;
    }
    public void setApplyUser(String applyUser) 
    {
        this.applyUser = applyUser;
    }

    public String getApplyUser() 
    {
        return applyUser;
    }
    public void setApplyTime(Date applyTime) 
    {
        this.applyTime = applyTime;
    }

    public Date getApplyTime() 
    {
        return applyTime;
    }
    public void setApplyStatus(String applyStatus) 
    {
        this.applyStatus = applyStatus;
    }

    public String getApplyStatus() 
    {
        return applyStatus;
    }
    public void setAuditUser(String auditUser) 
    {
        this.auditUser = auditUser;
    }

    public String getAuditUser() 
    {
        return auditUser;
    }
    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }
    public void setAuditStatus(String auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatus() 
    {
        return auditStatus;
    }
    public void setAuditComment(String auditComment) 
    {
        this.auditComment = auditComment;
    }

    public String getAuditComment() 
    {
        return auditComment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applyNo", getApplyNo())
            .append("planId", getPlanId())
            .append("planNo", getPlanNo())
            .append("applyType", getApplyType())
            .append("replenishId", getReplenishId())
            .append("replenishNo", getReplenishNo())
            .append("applyUser", getApplyUser())
            .append("applyTime", getApplyTime())
            .append("applyStatus", getApplyStatus())
            .append("auditUser", getAuditUser())
            .append("auditTime", getAuditTime())
            .append("auditStatus", getAuditStatus())
            .append("auditComment", getAuditComment())
            .append("remark", getRemark())
            .toString();
    }
}
