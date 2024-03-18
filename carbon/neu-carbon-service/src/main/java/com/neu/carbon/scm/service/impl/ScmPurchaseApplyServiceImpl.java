package com.neu.carbon.scm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmPurchaseApplyMapper;
import com.neu.carbon.scm.domain.ScmPurchaseApply;
import com.neu.carbon.scm.service.IScmPurchaseApplyService;

/**
 * 采购申请Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmPurchaseApplyServiceImpl implements IScmPurchaseApplyService 
{
    @Autowired
    private ScmPurchaseApplyMapper scmPurchaseApplyMapper;

    /**
     * 查询采购申请
     * 
     * @param id 采购申请ID
     * @return 采购申请
     */
    @Override
    public ScmPurchaseApply selectScmPurchaseApplyById(Long id)
    {
        return scmPurchaseApplyMapper.selectScmPurchaseApplyById(id);
    }

    /**
     * 查询采购申请列表
     * 
     * @param scmPurchaseApply 采购申请
     * @return 采购申请
     */
    @Override
    public List<ScmPurchaseApply> selectScmPurchaseApplyList(ScmPurchaseApply scmPurchaseApply)
    {
        return scmPurchaseApplyMapper.selectScmPurchaseApplyList(scmPurchaseApply);
    }

    /**
     * 新增采购申请
     * 
     * @param scmPurchaseApply 采购申请
     * @return 结果
     */
    @Override
    public int insertScmPurchaseApply(ScmPurchaseApply scmPurchaseApply)
    {
        return scmPurchaseApplyMapper.insertScmPurchaseApply(scmPurchaseApply);
    }

    /**
     * 修改采购申请
     * 
     * @param scmPurchaseApply 采购申请
     * @return 结果
     */
    @Override
    public int updateScmPurchaseApply(ScmPurchaseApply scmPurchaseApply)
    {
        return scmPurchaseApplyMapper.updateScmPurchaseApply(scmPurchaseApply);
    }

    /**
     * 批量删除采购申请
     * 
     * @param ids 需要删除的采购申请ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchaseApplyByIds(Long[] ids)
    {
        return scmPurchaseApplyMapper.deleteScmPurchaseApplyByIds(ids);
    }

    /**
     * 删除采购申请信息
     * 
     * @param id 采购申请ID
     * @return 结果
     */
    @Override
    public int deleteScmPurchaseApplyById(Long id)
    {
        return scmPurchaseApplyMapper.deleteScmPurchaseApplyById(id);
    }
}
