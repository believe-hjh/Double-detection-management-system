package com.neu.carbon.scm.mapper;

import java.util.List;
import com.neu.carbon.scm.domain.ScmPurchaseReturn;

/**
 * 采购退货Mapper接口
 * 
 * @author neuedu
 * @date 2024-03-18
 */
public interface ScmPurchaseReturnMapper 
{
    /**
     * 查询采购退货
     * 
     * @param id 采购退货ID
     * @return 采购退货
     */
    public ScmPurchaseReturn selectScmPurchaseReturnById(Long id);

    /**
     * 查询采购退货列表
     * 
     * @param scmPurchaseReturn 采购退货
     * @return 采购退货集合
     */
    public List<ScmPurchaseReturn> selectScmPurchaseReturnList(ScmPurchaseReturn scmPurchaseReturn);

    /**
     * 新增采购退货
     * 
     * @param scmPurchaseReturn 采购退货
     * @return 结果
     */
    public int insertScmPurchaseReturn(ScmPurchaseReturn scmPurchaseReturn);

    /**
     * 修改采购退货
     * 
     * @param scmPurchaseReturn 采购退货
     * @return 结果
     */
    public int updateScmPurchaseReturn(ScmPurchaseReturn scmPurchaseReturn);

    /**
     * 删除采购退货
     * 
     * @param id 采购退货ID
     * @return 结果
     */
    public int deleteScmPurchaseReturnById(Long id);

    /**
     * 批量删除采购退货
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteScmPurchaseReturnByIds(Long[] ids);
}
