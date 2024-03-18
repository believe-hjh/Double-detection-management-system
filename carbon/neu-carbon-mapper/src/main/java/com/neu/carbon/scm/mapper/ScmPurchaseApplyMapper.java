package com.neu.carbon.scm.mapper;

import java.util.List;
import com.neu.carbon.scm.domain.ScmPurchaseApply;

/**
 * 采购申请Mapper接口
 * 
 * @author neuedu
 * @date 2024-03-18
 */
public interface ScmPurchaseApplyMapper 
{
    /**
     * 查询采购申请
     * 
     * @param id 采购申请ID
     * @return 采购申请
     */
    public ScmPurchaseApply selectScmPurchaseApplyById(Long id);

    /**
     * 查询采购申请列表
     * 
     * @param scmPurchaseApply 采购申请
     * @return 采购申请集合
     */
    public List<ScmPurchaseApply> selectScmPurchaseApplyList(ScmPurchaseApply scmPurchaseApply);

    /**
     * 新增采购申请
     * 
     * @param scmPurchaseApply 采购申请
     * @return 结果
     */
    public int insertScmPurchaseApply(ScmPurchaseApply scmPurchaseApply);

    /**
     * 修改采购申请
     * 
     * @param scmPurchaseApply 采购申请
     * @return 结果
     */
    public int updateScmPurchaseApply(ScmPurchaseApply scmPurchaseApply);

    /**
     * 删除采购申请
     * 
     * @param id 采购申请ID
     * @return 结果
     */
    public int deleteScmPurchaseApplyById(Long id);

    /**
     * 批量删除采购申请
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteScmPurchaseApplyByIds(Long[] ids);
}
