package com.neu.carbon.scm.mapper;

import java.util.List;
import com.neu.carbon.scm.domain.ScmPurchaseArrive;

/**
 * 采购到货Mapper接口
 * 
 * @author neuedu
 * @date 2024-03-18
 */
public interface ScmPurchaseArriveMapper 
{
    /**
     * 查询采购到货
     * 
     * @param id 采购到货ID
     * @return 采购到货
     */
    public ScmPurchaseArrive selectScmPurchaseArriveById(Long id);

    /**
     * 查询采购到货列表
     * 
     * @param scmPurchaseArrive 采购到货
     * @return 采购到货集合
     */
    public List<ScmPurchaseArrive> selectScmPurchaseArriveList(ScmPurchaseArrive scmPurchaseArrive);

    /**
     * 新增采购到货
     * 
     * @param scmPurchaseArrive 采购到货
     * @return 结果
     */
    public int insertScmPurchaseArrive(ScmPurchaseArrive scmPurchaseArrive);

    /**
     * 修改采购到货
     * 
     * @param scmPurchaseArrive 采购到货
     * @return 结果
     */
    public int updateScmPurchaseArrive(ScmPurchaseArrive scmPurchaseArrive);

    /**
     * 删除采购到货
     * 
     * @param id 采购到货ID
     * @return 结果
     */
    public int deleteScmPurchaseArriveById(Long id);

    /**
     * 批量删除采购到货
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteScmPurchaseArriveByIds(Long[] ids);
}
