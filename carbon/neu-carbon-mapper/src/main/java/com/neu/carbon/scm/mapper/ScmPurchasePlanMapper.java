package com.neu.carbon.scm.mapper;

import java.util.List;
import com.neu.carbon.scm.domain.ScmPurchasePlan;

/**
 * 采购计划Mapper接口
 * 
 * @author neuedu
 * @date 2024-03-18
 */
public interface ScmPurchasePlanMapper 
{
    /**
     * 查询采购计划
     * 
     * @param id 采购计划ID
     * @return 采购计划
     */
    public ScmPurchasePlan selectScmPurchasePlanById(Long id);

    /**
     * 查询采购计划列表
     * 
     * @param scmPurchasePlan 采购计划
     * @return 采购计划集合
     */
    public List<ScmPurchasePlan> selectScmPurchasePlanList(ScmPurchasePlan scmPurchasePlan);

    /**
     * 新增采购计划
     * 
     * @param scmPurchasePlan 采购计划
     * @return 结果
     */
    public int insertScmPurchasePlan(ScmPurchasePlan scmPurchasePlan);

    /**
     * 修改采购计划
     * 
     * @param scmPurchasePlan 采购计划
     * @return 结果
     */
    public int updateScmPurchasePlan(ScmPurchasePlan scmPurchasePlan);

    /**
     * 删除采购计划
     * 
     * @param id 采购计划ID
     * @return 结果
     */
    public int deleteScmPurchasePlanById(Long id);

    /**
     * 批量删除采购计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteScmPurchasePlanByIds(Long[] ids);
}
