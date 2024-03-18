package com.neu.carbon.scm.service.impl;

import java.util.List;
import com.neu.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmSalePlanMapper;
import com.neu.carbon.scm.domain.ScmSalePlan;
import com.neu.carbon.scm.service.IScmSalePlanService;

/**
 * 销售计划Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmSalePlanServiceImpl implements IScmSalePlanService 
{
    @Autowired
    private ScmSalePlanMapper scmSalePlanMapper;

    /**
     * 查询销售计划
     * 
     * @param id 销售计划ID
     * @return 销售计划
     */
    @Override
    public ScmSalePlan selectScmSalePlanById(Long id)
    {
        return scmSalePlanMapper.selectScmSalePlanById(id);
    }

    /**
     * 查询销售计划列表
     * 
     * @param scmSalePlan 销售计划
     * @return 销售计划
     */
    @Override
    public List<ScmSalePlan> selectScmSalePlanList(ScmSalePlan scmSalePlan)
    {
        return scmSalePlanMapper.selectScmSalePlanList(scmSalePlan);
    }

    /**
     * 新增销售计划
     * 
     * @param scmSalePlan 销售计划
     * @return 结果
     */
    @Override
    public int insertScmSalePlan(ScmSalePlan scmSalePlan)
    {
        scmSalePlan.setCreateTime(DateUtils.getNowDate());
        return scmSalePlanMapper.insertScmSalePlan(scmSalePlan);
    }

    /**
     * 修改销售计划
     * 
     * @param scmSalePlan 销售计划
     * @return 结果
     */
    @Override
    public int updateScmSalePlan(ScmSalePlan scmSalePlan)
    {
        return scmSalePlanMapper.updateScmSalePlan(scmSalePlan);
    }

    /**
     * 批量删除销售计划
     * 
     * @param ids 需要删除的销售计划ID
     * @return 结果
     */
    @Override
    public int deleteScmSalePlanByIds(Long[] ids)
    {
        return scmSalePlanMapper.deleteScmSalePlanByIds(ids);
    }

    /**
     * 删除销售计划信息
     * 
     * @param id 销售计划ID
     * @return 结果
     */
    @Override
    public int deleteScmSalePlanById(Long id)
    {
        return scmSalePlanMapper.deleteScmSalePlanById(id);
    }
}
