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
import com.neu.carbon.scm.domain.ScmPurchaseReturn;
import com.neu.carbon.scm.service.IScmPurchaseReturnService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 采购退货Controller
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Api(tags = {"采购退货"})
@RestController
@RequestMapping("/scm/return")
public class ScmPurchaseReturnController extends BaseController
{
    @Autowired
    private IScmPurchaseReturnService scmPurchaseReturnService;

    /**
     * 查询采购退货列表
     */
    @GetMapping("/list")
    @ApiOperation("查询采购退货列表")
    @DynamicResponseParameters(properties = {
	        @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = ScmPurchaseReturn.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo list(ScmPurchaseReturn scmPurchaseReturn)
    {
        startPage();
        List<ScmPurchaseReturn> list = scmPurchaseReturnService.selectScmPurchaseReturnList(scmPurchaseReturn);
        return getDataTable(list);
    }

    /**
     * 导出采购退货列表
     */
    @ApiOperation("导出采购退货列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "文件名")
    })
    @PreAuthorize("@ss.hasPermi('scm:return:export')")
    @Log(title = "采购退货", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ScmPurchaseReturn scmPurchaseReturn)
    {
        List<ScmPurchaseReturn> list = scmPurchaseReturnService.selectScmPurchaseReturnList(scmPurchaseReturn);
        ExcelUtil<ScmPurchaseReturn> util = new ExcelUtil<ScmPurchaseReturn>(ScmPurchaseReturn.class);
        return util.exportExcel(list, "return");
    }

    /**
     * 获取采购退货详细信息
     */
    @ApiOperation("获取采购退货详细信息")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "data", value = "返回业务数据", dataTypeClass = ScmPurchaseReturn.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(scmPurchaseReturnService.selectScmPurchaseReturnById(id));
    }

    /**
     * 新增采购退货
     */
    @ApiOperation("新增采购退货")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:return:add')")
    @Log(title = "采购退货", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScmPurchaseReturn scmPurchaseReturn)
    {
        return toAjax(scmPurchaseReturnService.insertScmPurchaseReturn(scmPurchaseReturn));
    }

    /**
     * 修改采购退货
     */
    @ApiOperation("修改采购退货")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:return:edit')")
    @Log(title = "采购退货", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScmPurchaseReturn scmPurchaseReturn)
    {
        return toAjax(scmPurchaseReturnService.updateScmPurchaseReturn(scmPurchaseReturn));
    }

    /**
     * 删除采购退货
     */
    @ApiOperation("删除采购退货")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:return:remove')")
    @Log(title = "采购退货", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scmPurchaseReturnService.deleteScmPurchaseReturnByIds(ids));
    }
}
