package com.neu.carbon.scm.service.impl;

import java.util.List;
import com.neu.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neu.carbon.scm.mapper.ScmSaleReturnMapper;
import com.neu.carbon.scm.domain.ScmSaleReturn;
import com.neu.carbon.scm.service.IScmSaleReturnService;

/**
 * 销售退货Service业务层处理
 * 
 * @author neuedu
 * @date 2024-03-18
 */
@Service
public class ScmSaleReturnServiceImpl implements IScmSaleReturnService 
{
    @Autowired
    private ScmSaleReturnMapper scmSaleReturnMapper;

    /**
     * 查询销售退货
     * 
     * @param id 销售退货ID
     * @return 销售退货
     */
    @Override
    public ScmSaleReturn selectScmSaleReturnById(Long id)
    {
        return scmSaleReturnMapper.selectScmSaleReturnById(id);
    }

    /**
     * 查询销售退货列表
     * 
     * @param scmSaleReturn 销售退货
     * @return 销售退货
     */
    @Override
    public List<ScmSaleReturn> selectScmSaleReturnList(ScmSaleReturn scmSaleReturn)
    {
        return scmSaleReturnMapper.selectScmSaleReturnList(scmSaleReturn);
    }

    /**
     * 新增销售退货
     * 
     * @param scmSaleReturn 销售退货
     * @return 结果
     */
    @Override
    public int insertScmSaleReturn(ScmSaleReturn scmSaleReturn)
    {
        scmSaleReturn.setCreateTime(DateUtils.getNowDate());
        return scmSaleReturnMapper.insertScmSaleReturn(scmSaleReturn);
    }

    /**
     * 修改销售退货
     * 
     * @param scmSaleReturn 销售退货
     * @return 结果
     */
    @Override
    public int updateScmSaleReturn(ScmSaleReturn scmSaleReturn)
    {
        return scmSaleReturnMapper.updateScmSaleReturn(scmSaleReturn);
    }

    /**
     * 批量删除销售退货
     * 
     * @param ids 需要删除的销售退货ID
     * @return 结果
     */
    @Override
    public int deleteScmSaleReturnByIds(Long[] ids)
    {
        return scmSaleReturnMapper.deleteScmSaleReturnByIds(ids);
    }

    /**
     * 删除销售退货信息
     * 
     * @param id 销售退货ID
     * @return 结果
     */
    @Override
    public int deleteScmSaleReturnById(Long id)
    {
        return scmSaleReturnMapper.deleteScmSaleReturnById(id);
    }
}
