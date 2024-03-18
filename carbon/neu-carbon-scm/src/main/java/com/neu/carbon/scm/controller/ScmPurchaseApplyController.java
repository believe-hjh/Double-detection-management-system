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
import com.neu.carbon.scm.domain.ScmPurchaseApply;
import com.neu.carbon.scm.service.IScmPurchaseApplyService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 采购申请Controller
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Api(tags = {"采购申请"})
@RestController
@RequestMapping("/scm/apply")
public class ScmPurchaseApplyController extends BaseController
{
    @Autowired
    private IScmPurchaseApplyService scmPurchaseApplyService;

    /**
     * 查询采购申请列表
     */
    @GetMapping("/list")
    @ApiOperation("查询采购申请列表")
    @DynamicResponseParameters(properties = {
	        @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = ScmPurchaseApply.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo list(ScmPurchaseApply scmPurchaseApply)
    {
        startPage();
        List<ScmPurchaseApply> list = scmPurchaseApplyService.selectScmPurchaseApplyList(scmPurchaseApply);
        return getDataTable(list);
    }

    /**
     * 导出采购申请列表
     */
    @ApiOperation("导出采购申请列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "文件名")
    })
    @PreAuthorize("@ss.hasPermi('scm:apply:export')")
    @Log(title = "采购申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ScmPurchaseApply scmPurchaseApply)
    {
        List<ScmPurchaseApply> list = scmPurchaseApplyService.selectScmPurchaseApplyList(scmPurchaseApply);
        ExcelUtil<ScmPurchaseApply> util = new ExcelUtil<ScmPurchaseApply>(ScmPurchaseApply.class);
        return util.exportExcel(list, "apply");
    }

    /**
     * 获取采购申请详细信息
     */
    @ApiOperation("获取采购申请详细信息")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "data", value = "返回业务数据", dataTypeClass = ScmPurchaseApply.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(scmPurchaseApplyService.selectScmPurchaseApplyById(id));
    }

    /**
     * 新增采购申请
     */
    @ApiOperation("新增采购申请")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:apply:add')")
    @Log(title = "采购申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScmPurchaseApply scmPurchaseApply)
    {
        return toAjax(scmPurchaseApplyService.insertScmPurchaseApply(scmPurchaseApply));
    }

    /**
     * 修改采购申请
     */
    @ApiOperation("修改采购申请")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:apply:edit')")
    @Log(title = "采购申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScmPurchaseApply scmPurchaseApply)
    {
        return toAjax(scmPurchaseApplyService.updateScmPurchaseApply(scmPurchaseApply));
    }

    /**
     * 删除采购申请
     */
    @ApiOperation("删除采购申请")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:apply:remove')")
    @Log(title = "采购申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scmPurchaseApplyService.deleteScmPurchaseApplyByIds(ids));
    }
}
