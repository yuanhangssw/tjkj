package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BPatrolUnitPlace;

/**
 * 普查处管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public interface BPatrolUnitPlaceMapper 
{
    /**
     * 查询普查处管理
     * 
     * @param id 普查处管理主键
     * @return 普查处管理
     */
    public BPatrolUnitPlace selectBPatrolUnitPlaceById(Long id);

    /**
     * 查询普查处管理列表
     * 
     * @param bPatrolUnitPlace 普查处管理
     * @return 普查处管理集合
     */
    public List<BPatrolUnitPlace> selectBPatrolUnitPlaceList(BPatrolUnitPlace bPatrolUnitPlace);

    /**
     * 新增普查处管理
     * 
     * @param bPatrolUnitPlace 普查处管理
     * @return 结果
     */
    public int insertBPatrolUnitPlace(BPatrolUnitPlace bPatrolUnitPlace);

    /**
     * 修改普查处管理
     * 
     * @param bPatrolUnitPlace 普查处管理
     * @return 结果
     */
    public int updateBPatrolUnitPlace(BPatrolUnitPlace bPatrolUnitPlace);

    /**
     * 删除普查处管理
     * 
     * @param id 普查处管理主键
     * @return 结果
     */
    public int deleteBPatrolUnitPlaceById(Long id);

    /**
     * 批量删除普查处管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBPatrolUnitPlaceByIds(Long[] ids);
}
