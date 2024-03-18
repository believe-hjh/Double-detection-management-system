package com.neu.carbon.scm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmPurchasePlanMapper;
import com.neu.carbon.scm.domain.ScmPurchasePlan;
import com.neu.carbon.scm.service.IScmPurchasePlanService;

/**
 * 采购计划Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmPurchasePlanServiceImpl implements IScmPurchasePlanService 
{
    @Autowired
    private ScmPurchasePlanMapper scmPurchasePlanMapper;

    /**
     * 查询采购计划
     * 
     * @param id 采购计划ID
     * @return 采购计划
     */
    @Override
    public ScmPurchasePlan selectScmPurchasePlanById(Long id)
    {
        return scmPurchasePlanMapper.selectScmPurchasePlanById(id);
    }

    /**
     * 查询采购计划列表
     * 
     * @param scmPurchasePlan 采购计划
     * @return 采购计划
     */
    @Override
    public List<ScmPurchasePlan> selectScmPurchasePlanList(ScmPurchasePlan scmPurchasePlan)
    {
        return scmPurchasePlanMapper.selectScmPurchasePlanList(scmPurchasePlan);
    }

    /**
     * 新增采购计划
     * 
     * @param scmPurchasePlan 采购计划
     * @return 结果
     */
    @Override
    public int insertScmPurchasePlan(ScmPurchasePlan scmPurchasePlan)
    {
        return scmPurchasePlanMapper.insertScmPurchasePlan(scmPurchasePlan);
    }

    /**
     * 修改采购计划
     * 
     * @param scmPurchasePlan 采购计划
     * @return 结果
     */
    @Override
    public int updateScmPurchasePlan(ScmPurchasePlan scmPurchasePlan)
    {
        return scmPurchasePlanMapper.updateScmPurchasePlan(scmPurchasePlan);
    }

    /**
     * 批量删除采购计划
     * 
     * @param ids 需要删除的采购计划ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchasePlanByIds(Long[] ids)
    {
        return scmPurchasePlanMapper.deleteScmPurchasePlanByIds(ids);
    }

    /**
     * 删除采购计划信息
     * 
     * @param id 采购计划ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchasePlanById(Long id)
    {
        return scmPurchasePlanMapper.deleteScmPurchasePlanById(id);
    }
}
