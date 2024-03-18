package com.neu.carbon.scm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.neu.common.annotation.Excel;
import com.neu.common.core.domain.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采购退货对象 scm_purchase_return
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@ApiModel("采购退货")
public class ScmPurchaseReturn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 退货单号 */
    @ApiModelProperty("退货单号")
    @Excel(name = "退货单号")
    private String returnNo;

    /** 到货id */
    @ApiModelProperty("到货id")
    @Excel(name = "到货id")
    private Long arriveId;

    /** 到货编号 */
    @ApiModelProperty("到货编号")
    @Excel(name = "到货编号")
    private String arriveNo;

    /** 合同id */
    @ApiModelProperty("合同id")
    @Excel(name = "合同id")
    private Long contractId;

    /** 合同编号 */
    @ApiModelProperty("合同编号")
    @Excel(name = "合同编号")
    private String contractNo;

    /** 供应商id */
    @ApiModelProperty("供应商id")
    @Excel(name = "供应商id")
    private Long supplierId;

    /** 退货日期 */
    @ApiModelProperty(value="退货日期",example = "2021-09-10")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date returnDate;

    /** 退货金额 */
    @ApiModelProperty("退货金额")
    @Excel(name = "退货金额")
    private BigDecimal returnAmount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setReturnNo(String returnNo) 
    {
        this.returnNo = returnNo;
    }

    public String getReturnNo() 
    {
        return returnNo;
    }
    public void setArriveId(Long arriveId) 
    {
        this.arriveId = arriveId;
    }

    public Long getArriveId() 
    {
        return arriveId;
    }
    public void setArriveNo(String arriveNo) 
    {
        this.arriveNo = arriveNo;
    }

    public String getArriveNo() 
    {
        return arriveNo;
    }
    public void setContractId(Long contractId) 
    {
        this.contractId = contractId;
    }

    public Long getContractId() 
    {
        return contractId;
    }
    public void setContractNo(String contractNo) 
    {
        this.contractNo = contractNo;
    }

    public String getContractNo() 
    {
        return contractNo;
    }
    public void setSupplierId(Long supplierId) 
    {
        this.supplierId = supplierId;
    }

    public Long getSupplierId() 
    {
        return supplierId;
    }
    public void setReturnDate(Date returnDate) 
    {
        this.returnDate = returnDate;
    }

    public Date getReturnDate() 
    {
        return returnDate;
    }
    public void setReturnAmount(BigDecimal returnAmount) 
    {
        this.returnAmount = returnAmount;
    }

    public BigDecimal getReturnAmount() 
    {
        return returnAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("returnNo", getReturnNo())
            .append("arriveId", getArriveId())
            .append("arriveNo", getArriveNo())
            .append("contractId", getContractId())
            .append("contractNo", getContractNo())
            .append("supplierId", getSupplierId())
            .append("returnDate", getReturnDate())
            .append("returnAmount", getReturnAmount())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("remark", getRemark())
            .toString();
    }
}
