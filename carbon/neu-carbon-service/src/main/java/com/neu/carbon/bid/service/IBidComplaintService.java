package com.neu.carbon.bid.service;

import java.util.List;
import com.neu.carbon.bid.domain.BidComplaint;

/**
 * 违规投诉Service接口
 * 
 * @author neuedu
 * @date 2023-04-21
 */
public interface IBidComplaintService 
{
    /**
     * 查询违规投诉
     * 
     * @param id 违规投诉ID
     * @return 违规投诉
     */
    public BidComplaint selectBidComplaintById(Long id);

    /**
     * 查询违规投诉列表
     * 
     * @param bidComplaint 违规投诉
     * @return 违规投诉集合
     */
    public List<BidComplaint> selectBidComplaintList(BidComplaint bidComplaint);

    /**
     * 新增违规投诉
     * 
     * @param bidComplaint 违规投诉
     * @return 结果
     */
    public int insertBidComplaint(BidComplaint bidComplaint);

    /**
     * 修改违规投诉
     * 
     * @param bidComplaint 违规投诉
     * @return 结果
     */
    public int updateBidComplaint(BidComplaint bidComplaint);

    /**
     * 批量删除违规投诉
     * 
     * @param ids 需要删除的违规投诉ID
     * @return 结果
     */
    public int deleteBidComplaintByIds(Long[] ids);

    /**
     * 删除违规投诉信息
     * 
     * @param id 违规投诉ID
     * @return 结果
     */
    public int deleteBidComplaintById(Long id);
}
