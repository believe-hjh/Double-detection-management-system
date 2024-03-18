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
import com.neu.carbon.scm.domain.ScmSaleReturn;
import com.neu.carbon.scm.service.IScmSaleReturnService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 销售退货Controller
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Api(tags = {"销售退货"})
@RestController
@RequestMapping("/scm/return")
public class ScmSaleReturnController extends BaseController
{
    @Autowired
    private IScmSaleReturnService scmSaleReturnService;

    /**
     * 查询销售退货列表
     */
    @GetMapping("/list")
    @ApiOperation("查询销售退货列表")
    @DynamicResponseParameters(properties = {
	        @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = ScmSaleReturn.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo list(ScmSaleReturn scmSaleReturn)
    {
        startPage();
        List<ScmSaleReturn> list = scmSaleReturnService.selectScmSaleReturnList(scmSaleReturn);
        return getDataTable(list);
    }

    /**
     * 导出销售退货列表
     */
    @ApiOperation("导出销售退货列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "文件名")
    })
    @PreAuthorize("@ss.hasPermi('scm:return:export')")
    @Log(title = "销售退货", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ScmSaleReturn scmSaleReturn)
    {
        List<ScmSaleReturn> list = scmSaleReturnService.selectScmSaleReturnList(scmSaleReturn);
        ExcelUtil<ScmSaleReturn> util = new ExcelUtil<ScmSaleReturn>(ScmSaleReturn.class);
        return util.exportExcel(list, "return");
    }

    /**
     * 获取销售退货详细信息
     */
    @ApiOperation("获取销售退货详细信息")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "data", value = "返回业务数据", dataTypeClass = ScmSaleReturn.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(scmSaleReturnService.selectScmSaleReturnById(id));
    }

    /**
     * 新增销售退货
     */
    @ApiOperation("新增销售退货")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:return:add')")
    @Log(title = "销售退货", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScmSaleReturn scmSaleReturn)
    {
        return toAjax(scmSaleReturnService.insertScmSaleReturn(scmSaleReturn));
    }

    /**
     * 修改销售退货
     */
    @ApiOperation("修改销售退货")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:return:edit')")
    @Log(title = "销售退货", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScmSaleReturn scmSaleReturn)
    {
        return toAjax(scmSaleReturnService.updateScmSaleReturn(scmSaleReturn));
    }

    /**
     * 删除销售退货
     */
    @ApiOperation("删除销售退货")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:return:remove')")
    @Log(title = "销售退货", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scmSaleReturnService.deleteScmSaleReturnByIds(ids));
    }
}
