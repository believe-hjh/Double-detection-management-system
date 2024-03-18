package com.neu.carbon.scm.mapper;

import java.util.List;
import com.neu.carbon.scm.domain.ScmSaleContract;

/**
 * 销售合同Mapper接口
 * 
 * @author neuedu
 * @date 2024-03-18
 */
public interface ScmSaleContractMapper 
{
    /**
     * 查询销售合同
     * 
     * @param id 销售合同ID
     * @return 销售合同
     */
    public ScmSaleContract selectScmSaleContractById(Long id);

    /**
     * 查询销售合同列表
     * 
     * @param scmSaleContract 销售合同
     * @return 销售合同集合
     */
    public List<ScmSaleContract> selectScmSaleContractList(ScmSaleContract scmSaleContract);

    /**
     * 新增销售合同
     * 
     * @param scmSaleContract 销售合同
     * @return 结果
     */
    public int insertScmSaleContract(ScmSaleContract scmSaleContract);

    /**
     * 修改销售合同
     * 
     * @param scmSaleContract 销售合同
     * @return 结果
     */
    public int updateScmSaleContract(ScmSaleContract scmSaleContract);

    /**
     * 删除销售合同
     * 
     * @param id 销售合同ID
     * @return 结果
     */
    public int deleteScmSaleContractById(Long id);

    /**
     * 批量删除销售合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteScmSaleContractByIds(Long[] ids);
}
