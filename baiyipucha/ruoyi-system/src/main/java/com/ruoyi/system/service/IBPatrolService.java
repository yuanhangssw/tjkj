package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BPatrol;

/**
 * 巡查Service接口
 * 
 * @author ruoyi
 * @date 2024-03-05
 */
public interface IBPatrolService 
{
    /**
     * 查询巡查
     * 
     * @param id 巡查主键
     * @return 巡查
     */
    public BPatrol selectBPatrolById(Long id);

    /**
     * 查询巡查列表
     * 
     * @param bPatrol 巡查
     * @return 巡查集合
     */
    public List<BPatrol> selectBPatrolList(BPatrol bPatrol);

    /**
     * 新增巡查
     * 
     * @param bPatrol 巡查
     * @return 结果
     */
    public int insertBPatrol(BPatrol bPatrol);

    /**
     * 修改巡查
     * 
     * @param bPatrol 巡查
     * @return 结果
     */
    public int updateBPatrol(BPatrol bPatrol);

    /**
     * 批量删除巡查
     * 
     * @param ids 需要删除的巡查主键集合
     * @return 结果
     */
    public int deleteBPatrolByIds(Long[] ids);

    /**
     * 删除巡查信息
     * 
     * @param id 巡查主键
     * @return 结果
     */
    public int deleteBPatrolById(Long id);
}
