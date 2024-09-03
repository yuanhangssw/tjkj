package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BPatrolUnit;

/**
 * 巡查单元Service接口
 * 
 * @author ruoyi
 * @date 2024-03-05
 */
public interface IBPatrolUnitService 
{
    /**
     * 查询巡查单元
     * 
     * @param id 巡查单元主键
     * @return 巡查单元
     */
    public BPatrolUnit selectBPatrolUnitById(Long id);

    /**
     * 查询巡查单元列表
     * 
     * @param bPatrolUnit 巡查单元
     * @return 巡查单元集合
     */
    public List<BPatrolUnit> selectBPatrolUnitList(BPatrolUnit bPatrolUnit);

    /**
     * 新增巡查单元
     * 
     * @param bPatrolUnit 巡查单元
     * @return 结果
     */
    public int insertBPatrolUnit(BPatrolUnit bPatrolUnit);

    /**
     * 修改巡查单元
     * 
     * @param bPatrolUnit 巡查单元
     * @return 结果
     */
    public int updateBPatrolUnit(BPatrolUnit bPatrolUnit);

    /**
     * 批量删除巡查单元
     * 
     * @param ids 需要删除的巡查单元主键集合
     * @return 结果
     */
    public int deleteBPatrolUnitByIds(Long[] ids);

    /**
     * 删除巡查单元信息
     * 
     * @param id 巡查单元主键
     * @return 结果
     */
    public int deleteBPatrolUnitById(Long id);

    public void deleteBPatrolUnitByProject(Long projectId);

}
