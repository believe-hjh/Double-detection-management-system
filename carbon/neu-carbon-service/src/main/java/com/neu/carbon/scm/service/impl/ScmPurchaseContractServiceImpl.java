package com.neu.carbon.scm.service.impl;

import java.util.List;
import com.neu.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmPurchaseContractMapper;
import com.neu.carbon.scm.domain.ScmPurchaseContract;
import com.neu.carbon.scm.service.IScmPurchaseContractService;

/**
 * 采购合同Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmPurchaseContractServiceImpl implements IScmPurchaseContractService 
{
    @Autowired
    private ScmPurchaseContractMapper scmPurchaseContractMapper;

    /**
     * 查询采购合同
     * 
     * @param id 采购合同ID
     * @return 采购合同
     */
    @Override
    public ScmPurchaseContract selectScmPurchaseContractById(Long id)
    {
        return scmPurchaseContractMapper.selectScmPurchaseContractById(id);
    }

    /**
     * 查询采购合同列表
     * 
     * @param scmPurchaseContract 采购合同
     * @return 采购合同
     */
    @Override
    public List<ScmPurchaseContract> selectScmPurchaseContractList(ScmPurchaseContract scmPurchaseContract)
    {
        return scmPurchaseContractMapper.selectScmPurchaseContractList(scmPurchaseContract);
    }

    /**
     * 新增采购合同
     * 
     * @param scmPurchaseContract 采购合同
     * @return 结果
     */
    @Override
    public int insertScmPurchaseContract(ScmPurchaseContract scmPurchaseContract)
    {
        scmPurchaseContract.setCreateTime(DateUtils.getNowDate());
        return scmPurchaseContractMapper.insertScmPurchaseContract(scmPurchaseContract);
    }

    /**
     * 修改采购合同
     * 
     * @param scmPurchaseContract 采购合同
     * @return 结果
     */
    @Override
    public int updateScmPurchaseContract(ScmPurchaseContract scmPurchaseContract)
    {
        return scmPurchaseContractMapper.updateScmPurchaseContract(scmPurchaseContract);
    }

    /**
     * 批量删除采购合同
     * 
     * @param ids 需要删除的采购合同ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchaseContractByIds(Long[] ids)
    {
        return scmPurchaseContractMapper.deleteScmPurchaseContractByIds(ids);
    }

    /**
     * 删除采购合同信息
     * 
     * @param id 采购合同ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchaseContractById(Long id)
    {
        return scmPurchaseContractMapper.deleteScmPurchaseContractById(id);
    }
}
