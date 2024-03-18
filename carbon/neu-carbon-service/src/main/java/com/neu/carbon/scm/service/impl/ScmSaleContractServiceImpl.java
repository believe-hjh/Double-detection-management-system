package com.neu.carbon.scm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmSaleContractMapper;
import com.neu.carbon.scm.domain.ScmSaleContract;
import com.neu.carbon.scm.service.IScmSaleContractService;

/**
 * 销售合同Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmSaleContractServiceImpl implements IScmSaleContractService 
{
    @Autowired
    private ScmSaleContractMapper scmSaleContractMapper;

    /**
     * 查询销售合同
     * 
     * @param id 销售合同ID
     * @return 销售合同
     */
    @Override
    public ScmSaleContract selectScmSaleContractById(Long id)
    {
        return scmSaleContractMapper.selectScmSaleContractById(id);
    }

    /**
     * 查询销售合同列表
     * 
     * @param scmSaleContract 销售合同
     * @return 销售合同
     */
    @Override
    public List<ScmSaleContract> selectScmSaleContractList(ScmSaleContract scmSaleContract)
    {
        return scmSaleContractMapper.selectScmSaleContractList(scmSaleContract);
    }

    /**
     * 新增销售合同
     * 
     * @param scmSaleContract 销售合同
     * @return 结果
     */
    @Override
    public int insertScmSaleContract(ScmSaleContract scmSaleContract)
    {
        return scmSaleContractMapper.insertScmSaleContract(scmSaleContract);
    }

    /**
     * 修改销售合同
     * 
     * @param scmSaleContract 销售合同
     * @return 结果
     */
    @Override
    public int updateScmSaleContract(ScmSaleContract scmSaleContract)
    {
        return scmSaleContractMapper.updateScmSaleContract(scmSaleContract);
    }

    /**
     * 批量删除销售合同
     * 
     * @param ids 需要删除的销售合同ID
     * @return 结果
     */
    @Override
    public int deleteScmSaleContractByIds(Long[] ids)
    {
        return scmSaleContractMapper.deleteScmSaleContractByIds(ids);
    }

    /**
     * 删除销售合同信息
     * 
     * @param id 销售合同ID
     * @return 结果
     */
    @Override
    public int deleteScmSaleContractById(Long id)
    {
        return scmSaleContractMapper.deleteScmSaleContractById(id);
    }
}
