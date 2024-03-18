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
import com.neu.carbon.scm.domain.ScmPurchaseSupplier;
import com.neu.carbon.scm.service.IScmPurchaseSupplierService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 供应商Controller
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Api(tags = {"供应商"})
@RestController
@RequestMapping("/scm/supplier")
public class ScmPurchaseSupplierController extends BaseController
{
    @Autowired
    private IScmPurchaseSupplierService scmPurchaseSupplierService;

    /**
     * 查询供应商列表
     */
    @GetMapping("/list")
    @ApiOperation("查询供应商列表")
    @DynamicResponseParameters(properties = {
	        @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = ScmPurchaseSupplier.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo list(ScmPurchaseSupplier scmPurchaseSupplier)
    {
        startPage();
        List<ScmPurchaseSupplier> list = scmPurchaseSupplierService.selectScmPurchaseSupplierList(scmPurchaseSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @ApiOperation("导出供应商列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "文件名")
    })
    @PreAuthorize("@ss.hasPermi('scm:supplier:export')")
    @Log(title = "供应商", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ScmPurchaseSupplier scmPurchaseSupplier)
    {
        List<ScmPurchaseSupplier> list = scmPurchaseSupplierService.selectScmPurchaseSupplierList(scmPurchaseSupplier);
        ExcelUtil<ScmPurchaseSupplier> util = new ExcelUtil<ScmPurchaseSupplier>(ScmPurchaseSupplier.class);
        return util.exportExcel(list, "supplier");
    }

    /**
     * 获取供应商详细信息
     */
    @ApiOperation("获取供应商详细信息")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "data", value = "返回业务数据", dataTypeClass = ScmPurchaseSupplier.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(scmPurchaseSupplierService.selectScmPurchaseSupplierById(id));
    }

    /**
     * 新增供应商
     */
    @ApiOperation("新增供应商")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:supplier:add')")
    @Log(title = "供应商", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScmPurchaseSupplier scmPurchaseSupplier)
    {
        return toAjax(scmPurchaseSupplierService.insertScmPurchaseSupplier(scmPurchaseSupplier));
    }

    /**
     * 修改供应商
     */
    @ApiOperation("修改供应商")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:supplier:edit')")
    @Log(title = "供应商", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScmPurchaseSupplier scmPurchaseSupplier)
    {
        return toAjax(scmPurchaseSupplierService.updateScmPurchaseSupplier(scmPurchaseSupplier));
    }

    /**
     * 删除供应商
     */
    @ApiOperation("删除供应商")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:supplier:remove')")
    @Log(title = "供应商", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scmPurchaseSupplierService.deleteScmPurchaseSupplierByIds(ids));
    }
}
