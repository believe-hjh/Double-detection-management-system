package com.neu.carbon.scm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmSaleOrderMapper;
import com.neu.carbon.scm.domain.ScmSaleOrder;
import com.neu.carbon.scm.service.IScmSaleOrderService;

/**
 * 销售订单Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmSaleOrderServiceImpl implements IScmSaleOrderService 
{
    @Autowired
    private ScmSaleOrderMapper scmSaleOrderMapper;

    /**
     * 查询销售订单
     * 
     * @param id 销售订单ID
     * @return 销售订单
     */
    @Override
    public ScmSaleOrder selectScmSaleOrderById(Long id)
    {
        return scmSaleOrderMapper.selectScmSaleOrderById(id);
    }

    /**
     * 查询销售订单列表
     * 
     * @param scmSaleOrder 销售订单
     * @return 销售订单
     */
    @Override
    public List<ScmSaleOrder> selectScmSaleOrderList(ScmSaleOrder scmSaleOrder)
    {
        return scmSaleOrderMapper.selectScmSaleOrderList(scmSaleOrder);
    }

    /**
     * 新增销售订单
     * 
     * @param scmSaleOrder 销售订单
     * @return 结果
     */
    @Override
    public int insertScmSaleOrder(ScmSaleOrder scmSaleOrder)
    {
        return scmSaleOrderMapper.insertScmSaleOrder(scmSaleOrder);
    }

    /**
     * 修改销售订单
     * 
     * @param scmSaleOrder 销售订单
     * @return 结果
     */
    @Override
    public int updateScmSaleOrder(ScmSaleOrder scmSaleOrder)
    {
        return scmSaleOrderMapper.updateScmSaleOrder(scmSaleOrder);
    }

    /**
     * 批量删除销售订单
     * 
     * @param ids 需要删除的销售订单ID
     * @return 结果
     */
    @Override
    public int deleteScmSaleOrderByIds(Long[] ids)
    {
        return scmSaleOrderMapper.deleteScmSaleOrderByIds(ids);
    }

    /**
     * 删除销售订单信息
     * 
     * @param id 销售订单ID
     * @return 结果
     */
    @Override
    public int deleteScmSaleOrderById(Long id)
    {
        return scmSaleOrderMapper.deleteScmSaleOrderById(id);
    }
}
