package com.neu.carbon.scm.service.impl;

import java.util.List;
import com.neu.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmSaleDeliveryMapper;
import com.neu.carbon.scm.domain.ScmSaleDelivery;
import com.neu.carbon.scm.service.IScmSaleDeliveryService;

/**
 * 销售发货单Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmSaleDeliveryServiceImpl implements IScmSaleDeliveryService 
{
    @Autowired
    private ScmSaleDeliveryMapper scmSaleDeliveryMapper;

    /**
     * 查询销售发货单
     * 
     * @param id 销售发货单ID
     * @return 销售发货单
     */
    @Override
    public ScmSaleDelivery selectScmSaleDeliveryById(Long id)
    {
        return scmSaleDeliveryMapper.selectScmSaleDeliveryById(id);
    }

    /**
     * 查询销售发货单列表
     * 
     * @param scmSaleDelivery 销售发货单
     * @return 销售发货单
     */
    @Override
    public List<ScmSaleDelivery> selectScmSaleDeliveryList(ScmSaleDelivery scmSaleDelivery)
    {
        return scmSaleDeliveryMapper.selectScmSaleDeliveryList(scmSaleDelivery);
    }

    /**
     * 新增销售发货单
     * 
     * @param scmSaleDelivery 销售发货单
     * @return 结果
     */
    @Override
    public int insertScmSaleDelivery(ScmSaleDelivery scmSaleDelivery)
    {
        scmSaleDelivery.setCreateTime(DateUtils.getNowDate());
        return scmSaleDeliveryMapper.insertScmSaleDelivery(scmSaleDelivery);
    }

    /**
     * 修改销售发货单
     * 
     * @param scmSaleDelivery 销售发货单
     * @return 结果
     */
    @Override
    public int updateScmSaleDelivery(ScmSaleDelivery scmSaleDelivery)
    {
        return scmSaleDeliveryMapper.updateScmSaleDelivery(scmSaleDelivery);
    }

    /**
     * 批量删除销售发货单
     * 
     * @param ids 需要删除的销售发货单ID
     * @return 结果
     */
    @Override
    public int deleteScmSaleDeliveryByIds(Long[] ids)
    {
        return scmSaleDeliveryMapper.deleteScmSaleDeliveryByIds(ids);
    }

    /**
     * 删除销售发货单信息
     * 
     * @param id 销售发货单ID
     * @return 结果
     */
    @Override
    public int deleteScmSaleDeliveryById(Long id)
    {
        return scmSaleDeliveryMapper.deleteScmSaleDeliveryById(id);
    }
}
