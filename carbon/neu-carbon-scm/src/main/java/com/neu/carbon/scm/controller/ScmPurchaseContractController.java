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
import com.neu.carbon.scm.domain.ScmPurchaseContract;
import com.neu.carbon.scm.service.IScmPurchaseContractService;
import com.neu.common.utils.poi.ExcelUtil;
import com.neu.common.core.page.TableDataInfo;

/**
 * 采购合同Controller
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Api(tags = {"采购合同"})
@RestController
@RequestMapping("/scm/contract")
public class ScmPurchaseContractController extends BaseController
{
    @Autowired
    private IScmPurchaseContractService scmPurchaseContractService;

    /**
     * 查询采购合同列表
     */
    @GetMapping("/list")
    @ApiOperation("查询采购合同列表")
    @DynamicResponseParameters(properties = {
	        @DynamicParameter(name = "total", value = "总记录数"),
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "rows", value = "返回业务数据（数组类型）", dataTypeClass = ScmPurchaseContract.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    public TableDataInfo list(ScmPurchaseContract scmPurchaseContract)
    {
        startPage();
        List<ScmPurchaseContract> list = scmPurchaseContractService.selectScmPurchaseContractList(scmPurchaseContract);
        return getDataTable(list);
    }

    /**
     * 导出采购合同列表
     */
    @ApiOperation("导出采购合同列表")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "文件名")
    })
    @PreAuthorize("@ss.hasPermi('scm:contract:export')")
    @Log(title = "采购合同", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ScmPurchaseContract scmPurchaseContract)
    {
        List<ScmPurchaseContract> list = scmPurchaseContractService.selectScmPurchaseContractList(scmPurchaseContract);
        ExcelUtil<ScmPurchaseContract> util = new ExcelUtil<ScmPurchaseContract>(ScmPurchaseContract.class);
        return util.exportExcel(list, "contract");
    }

    /**
     * 获取采购合同详细信息
     */
    @ApiOperation("获取采购合同详细信息")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "data", value = "返回业务数据", dataTypeClass = ScmPurchaseContract.class),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(scmPurchaseContractService.selectScmPurchaseContractById(id));
    }

    /**
     * 新增采购合同
     */
    @ApiOperation("新增采购合同")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:contract:add')")
    @Log(title = "采购合同", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScmPurchaseContract scmPurchaseContract)
    {
        return toAjax(scmPurchaseContractService.insertScmPurchaseContract(scmPurchaseContract));
    }

    /**
     * 修改采购合同
     */
    @ApiOperation("修改采购合同")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:contract:edit')")
    @Log(title = "采购合同", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ScmPurchaseContract scmPurchaseContract)
    {
        return toAjax(scmPurchaseContractService.updateScmPurchaseContract(scmPurchaseContract));
    }

    /**
     * 删除采购合同
     */
    @ApiOperation("删除采购合同")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "code", value = "状态码，200正确，其他错误"),
            @DynamicParameter(name = "msg", value = "返回消息内容")
    })
    @PreAuthorize("@ss.hasPermi('scm:contract:remove')")
    @Log(title = "采购合同", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(scmPurchaseContractService.deleteScmPurchaseContractByIds(ids));
    }
}
