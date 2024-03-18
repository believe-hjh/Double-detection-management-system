package com.neu.carbon.scm.mapper;

import java.util.List;
import com.neu.carbon.scm.domain.ScmPurchaseContract;

/**
 * 采购合同Mapper接口
 * 
 * @author neuedu
 * @date 2024-03-18
 */
public interface ScmPurchaseContractMapper 
{
    /**
     * 查询采购合同
     * 
     * @param id 采购合同ID
     * @return 采购合同
     */
    public ScmPurchaseContract selectScmPurchaseContractById(Long id);

    /**
     * 查询采购合同列表
     * 
     * @param scmPurchaseContract 采购合同
     * @return 采购合同集合
     */
    public List<ScmPurchaseContract> selectScmPurchaseContractList(ScmPurchaseContract scmPurchaseContract);

    /**
     * 新增采购合同
     * 
     * @param scmPurchaseContract 采购合同
     * @return 结果
     */
    public int insertScmPurchaseContract(ScmPurchaseContract scmPurchaseContract);

    /**
     * 修改采购合同
     * 
     * @param scmPurchaseContract 采购合同
     * @return 结果
     */
    public int updateScmPurchaseContract(ScmPurchaseContract scmPurchaseContract);

    /**
     * 删除采购合同
     * 
     * @param id 采购合同ID
     * @return 结果
     */
    public int deleteScmPurchaseContractById(Long id);

    /**
     * 批量删除采购合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteScmPurchaseContractByIds(Long[] ids);
}
