package com.neu.carbon.scm.service.impl;

import java.util.List;
import com.neu.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmPurchaseReturnMapper;
import com.neu.carbon.scm.domain.ScmPurchaseReturn;
import com.neu.carbon.scm.service.IScmPurchaseReturnService;

/**
 * 采购退货Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmPurchaseReturnServiceImpl implements IScmPurchaseReturnService 
{
    @Autowired
    private ScmPurchaseReturnMapper scmPurchaseReturnMapper;

    /**
     * 查询采购退货
     * 
     * @param id 采购退货ID
     * @return 采购退货
     */
    @Override
    public ScmPurchaseReturn selectScmPurchaseReturnById(Long id)
    {
        return scmPurchaseReturnMapper.selectScmPurchaseReturnById(id);
    }

    /**
     * 查询采购退货列表
     * 
     * @param scmPurchaseReturn 采购退货
     * @return 采购退货
     */
    @Override
    public List<ScmPurchaseReturn> selectScmPurchaseReturnList(ScmPurchaseReturn scmPurchaseReturn)
    {
        return scmPurchaseReturnMapper.selectScmPurchaseReturnList(scmPurchaseReturn);
    }

    /**
     * 新增采购退货
     * 
     * @param scmPurchaseReturn 采购退货
     * @return 结果
     */
    @Override
    public int insertScmPurchaseReturn(ScmPurchaseReturn scmPurchaseReturn)
    {
        scmPurchaseReturn.setCreateTime(DateUtils.getNowDate());
        return scmPurchaseReturnMapper.insertScmPurchaseReturn(scmPurchaseReturn);
    }

    /**
     * 修改采购退货
     * 
     * @param scmPurchaseReturn 采购退货
     * @return 结果
     */
    @Override
    public int updateScmPurchaseReturn(ScmPurchaseReturn scmPurchaseReturn)
    {
        return scmPurchaseReturnMapper.updateScmPurchaseReturn(scmPurchaseReturn);
    }

    /**
     * 批量删除采购退货
     * 
     * @param ids 需要删除的采购退货ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchaseReturnByIds(Long[] ids)
    {
        return scmPurchaseReturnMapper.deleteScmPurchaseReturnByIds(ids);
    }

    /**
     * 删除采购退货信息
     * 
     * @param id 采购退货ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchaseReturnById(Long id)
    {
        return scmPurchaseReturnMapper.deleteScmPurchaseReturnById(id);
    }
}
