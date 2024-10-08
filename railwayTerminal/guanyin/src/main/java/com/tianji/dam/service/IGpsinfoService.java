package com.tianji.dam.service;

import com.tianji.dam.domain.Gpsinfo;

import java.util.List;

/**
 * 人员定位信息Service接口
 * 
 * @author ruoyi
 * @date 2023-10-19
 */
public interface IGpsinfoService 
{
    /**
     * 查询人员定位信息
     * 
     * @param id 人员定位信息主键
     * @return 人员定位信息
     */
    public Gpsinfo selectGpsinfoById(Long id);

    /**
     * 查询人员定位信息列表
     * 
     * @param gpsinfo 人员定位信息
     * @return 人员定位信息集合
     */
    public List<Gpsinfo> selectGpsinfoList(Gpsinfo gpsinfo);

    /**
     * 新增人员定位信息
     * 
     * @param gpsinfo 人员定位信息
     * @return 结果
     */
    public int insertGpsinfo(Gpsinfo gpsinfo);

    /**
     * 修改人员定位信息
     * 
     * @param gpsinfo 人员定位信息
     * @return 结果
     */
    public int updateGpsinfo(Gpsinfo gpsinfo);

    /**
     * 批量删除人员定位信息
     * 
     * @param ids 需要删除的人员定位信息主键集合
     * @return 结果
     */
    public int deleteGpsinfoByIds(Long[] ids);

    /**
     * 删除人员定位信息信息
     * 
     * @param id 人员定位信息主键
     * @return 结果
     */
    public int deleteGpsinfoById(Long id);
}
