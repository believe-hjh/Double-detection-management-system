package com.neu.carbon.scm.mapper;

import java.util.List;
import com.neu.carbon.scm.domain.ScmSalePlan;

/**
 * 销售计划Mapper接口
 * 
 * @author neuedu
 * @date 2024-03-18
 */
public interface ScmSalePlanMapper 
{
    /**
     * 查询销售计划
     * 
     * @param id 销售计划ID
     * @return 销售计划
     */
    public ScmSalePlan selectScmSalePlanById(Long id);

    /**
     * 查询销售计划列表
     * 
     * @param scmSalePlan 销售计划
     * @return 销售计划集合
     */
    public List<ScmSalePlan> selectScmSalePlanList(ScmSalePlan scmSalePlan);

    /**
     * 新增销售计划
     * 
     * @param scmSalePlan 销售计划
     * @return 结果
     */
    public int insertScmSalePlan(ScmSalePlan scmSalePlan);

    /**
     * 修改销售计划
     * 
     * @param scmSalePlan 销售计划
     * @return 结果
     */
    public int updateScmSalePlan(ScmSalePlan scmSalePlan);

    /**
     * 删除销售计划
     * 
     * @param id 销售计划ID
     * @return 结果
     */
    public int deleteScmSalePlanById(Long id);

    /**
     * 批量删除销售计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteScmSalePlanByIds(Long[] ids);
}
