package com.ruoyi.system.service;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.BProject;

/**
 * 项目信息Service接口
 * 
 * @author ruoyi
 * @date 2024-03-05
 */
public interface IBProjectService 
{
    /**
     * 查询项目信息
     * 
     * @param id 项目信息主键
     * @return 项目信息
     */
    public BProject selectBProjectById(Long id);

    /**
     * 查询项目信息列表
     * 
     * @param bProject 项目信息
     * @return 项目信息集合
     */
    public List<BProject> selectBProjectList(BProject bProject);

    /**
     * 新增项目信息
     * 
     * @param bProject 项目信息
     * @return 结果
     */
    public int insertBProject(BProject bProject);

    /**
     * 修改项目信息
     * 
     * @param bProject 项目信息
     * @return 结果
     */
    public int updateBProject(BProject bProject);

    /**
     * 批量删除项目信息
     * 
     * @param ids 需要删除的项目信息主键集合
     * @return 结果
     */
    public int deleteBProjectByIds(Long[] ids);

    /**
     * 删除项目信息信息
     * 
     * @param id 项目信息主键
     * @return 结果
     */
    public int deleteBProjectById(Long id);

    public  List<BProject> getBProjectByDept(List<Long> deptId);

    public List<Map<String, Object>> selectBProjectListJoinPrevent(Long id);

    public ByteArrayInputStream setExcelValue(Map<String, Object> map);

    public ByteArrayInputStream setExcelValue3(Map<String, Object> map);

    ByteArrayInputStream setExcelValueFive(Map projecMaps);

    ByteArrayInputStream setExcelValueSix(List<Map<String, Object>> mapList);

    ByteArrayInputStream setExcelValueSeven(List listResult);

    ByteArrayInputStream setExcelValueEight(List<Map> listResult);
}
