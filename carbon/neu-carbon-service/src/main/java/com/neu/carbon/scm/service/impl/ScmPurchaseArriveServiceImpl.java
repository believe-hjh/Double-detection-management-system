package com.neu.carbon.scm.service.impl;

import java.util.List;
import com.neu.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmPurchaseArriveMapper;
import com.neu.carbon.scm.domain.ScmPurchaseArrive;
import com.neu.carbon.scm.service.IScmPurchaseArriveService;

/**
 * 采购到货Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmPurchaseArriveServiceImpl implements IScmPurchaseArriveService 
{
    @Autowired
    private ScmPurchaseArriveMapper scmPurchaseArriveMapper;

    /**
     * 查询采购到货
     * 
     * @param id 采购到货ID
     * @return 采购到货
     */
    @Override
    public ScmPurchaseArrive selectScmPurchaseArriveById(Long id)
    {
        return scmPurchaseArriveMapper.selectScmPurchaseArriveById(id);
    }

    /**
     * 查询采购到货列表
     * 
     * @param scmPurchaseArrive 采购到货
     * @return 采购到货
     */
    @Override
    public List<ScmPurchaseArrive> selectScmPurchaseArriveList(ScmPurchaseArrive scmPurchaseArrive)
    {
        return scmPurchaseArriveMapper.selectScmPurchaseArriveList(scmPurchaseArrive);
    }

    /**
     * 新增采购到货
     * 
     * @param scmPurchaseArrive 采购到货
     * @return 结果
     */
    @Override
    public int insertScmPurchaseArrive(ScmPurchaseArrive scmPurchaseArrive)
    {
        scmPurchaseArrive.setCreateTime(DateUtils.getNowDate());
        return scmPurchaseArriveMapper.insertScmPurchaseArrive(scmPurchaseArrive);
    }

    /**
     * 修改采购到货
     * 
     * @param scmPurchaseArrive 采购到货
     * @return 结果
     */
    @Override
    public int updateScmPurchaseArrive(ScmPurchaseArrive scmPurchaseArrive)
    {
        return scmPurchaseArriveMapper.updateScmPurchaseArrive(scmPurchaseArrive);
    }

    /**
     * 批量删除采购到货
     * 
     * @param ids 需要删除的采购到货ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchaseArriveByIds(Long[] ids)
    {
        return scmPurchaseArriveMapper.deleteScmPurchaseArriveByIds(ids);
    }

    /**
     * 删除采购到货信息
     * 
     * @param id 采购到货ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchaseArriveById(Long id)
    {
        return scmPurchaseArriveMapper.deleteScmPurchaseArriveById(id);
    }
}
