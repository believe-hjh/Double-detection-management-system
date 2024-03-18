package com.neu.carbon.scm.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.neu.common.annotation.Log;
import com.neu.common.core.controller.BaseController;
import com.neu.common.core.domain.AjaxResult;
import com.neu.common.enums.BusinessType;
import com.neu.carbon.scm.domain.ScmSaleDelivery;
import com.neu.carbon.scm.service.IScmSaleDeliveryService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 销售发货单Controller
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Api(tags = {"销售发货单"})
@RestController
@RequestMapping("/scm/delivery")
public class ScmSaleDeliveryController extends BaseController
{
    @Autowired
    private IScmSaleDeliveryService scmSaleDeliveryService;

    /**
     * 查询销售发货单列表
     */
    @GetMapping("/list")
    @ApiOperation("查询销售发货单列表")
    @DynamicResponseParameters(properties = {
	        @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = ScmSaleDelivery.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo list(ScmSaleDelivery scmSaleDelivery)
    {
        startPage();
        List<ScmSaleDelivery> list = scmSaleDeliveryService.selectScmSaleDeliveryList(scmSaleDelivery);
        return getDataTable(list);
    }

    /**
     * 导出销售发货单列表
     */
    @ApiOperation("导出销售发货单列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "文件名")
    })
    @PreAuthorize("@ss.hasPermi('scm:delivery:export')")
    @Log(title = "销售发货单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ScmSaleDelivery scmSaleDelivery)
    {
        List<ScmSaleDelivery> list = scmSaleDeliveryService.selectScmSaleDeliveryList(scmSaleDelivery);
        ExcelUtil<ScmSaleDelivery> util = new ExcelUtil<ScmSaleDelivery>(ScmSaleDelivery.class);
        return util.exportExcel(list, "delivery");
    }

    /**
     * 获取销售发货单详细信息
     */
    @ApiOperation("获取销售发货单详细信息")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "data", value = "返回业务数据", dataTypeClass = ScmSaleDelivery.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(scmSaleDeliveryService.selectScmSaleDeliveryById(id));
    }

    /**
     * 新增销售发货单
     */
    @ApiOperation("新增销售发货单")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:delivery:add')")
    @Log(title = "销售发货单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScmSaleDelivery scmSaleDelivery)
    {
        return toAjax(scmSaleDeliveryService.insertScmSaleDelivery(scmSaleDelivery));
    }

    /**
     * 修改销售发货单
     */
    @ApiOperation("修改销售发货单")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:delivery:edit')")
    @Log(title = "销售发货单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScmSaleDelivery scmSaleDelivery)
    {
        return toAjax(scmSaleDeliveryService.updateScmSaleDelivery(scmSaleDelivery));
    }

    /**
     * 删除销售发货单
     */
    @ApiOperation("删除销售发货单")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:delivery:remove')")
    @Log(title = "销售发货单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scmSaleDeliveryService.deleteScmSaleDeliveryByIds(ids));
    }
}
