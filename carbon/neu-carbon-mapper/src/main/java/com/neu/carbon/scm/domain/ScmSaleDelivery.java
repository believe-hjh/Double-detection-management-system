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
 * 销售发货单对象 scm_sale_delivery
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@ApiModel("销售发货单")
public class ScmSaleDelivery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 发货编号 */
    @ApiModelProperty("发货编号")
    @Excel(name = "发货编号")
    private String deliveryNo;

    /** 合同id */
    @ApiModelProperty("合同id")
    @Excel(name = "合同id")
    private Long contractId;

    /** 合同编号 */
    @ApiModelProperty("合同编号")
    @Excel(name = "合同编号")
    private String contractNo;

    /** 客户id */
    @ApiModelProperty("客户id")
    @Excel(name = "客户id")
    private Long customerId;

    /** 送货方式 */
    @ApiModelProperty("送货方式")
    @Excel(name = "送货方式")
    private String deliveryType;

    /** 交货日期 */
    @ApiModelProperty(value="交货日期",example = "2021-09-10 10:20:40")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "交货日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date deliveryDate;

    /** 收货地址 */
    @ApiModelProperty("收货地址")
    @Excel(name = "收货地址")
    private String address;

    /** 联系人 */
    @ApiModelProperty("联系人")
    @Excel(name = "联系人")
    private String contact;

    /** 联系电话 */
    @ApiModelProperty("联系电话")
    @Excel(name = "联系电话")
    private String contactTel;

    /** 出库状态 */
    @ApiModelProperty("出库状态")
    @Excel(name = "出库状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeliveryNo(String deliveryNo) 
    {
        this.deliveryNo = deliveryNo;
    }

    public String getDeliveryNo() 
    {
        return deliveryNo;
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
    public void setCustomerId(Long customerId) 
    {
        this.customerId = customerId;
    }

    public Long getCustomerId() 
    {
        return customerId;
    }
    public void setDeliveryType(String deliveryType) 
    {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryType() 
    {
        return deliveryType;
    }
    public void setDeliveryDate(Date deliveryDate) 
    {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate() 
    {
        return deliveryDate;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setContactTel(String contactTel) 
    {
        this.contactTel = contactTel;
    }

    public String getContactTel() 
    {
        return contactTel;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deliveryNo", getDeliveryNo())
            .append("contractId", getContractId())
            .append("contractNo", getContractNo())
            .append("customerId", getCustomerId())
            .append("deliveryType", getDeliveryType())
            .append("deliveryDate", getDeliveryDate())
            .append("address", getAddress())
            .append("contact", getContact())
            .append("contactTel", getContactTel())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .toString();
    }
}
