package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 巡查对象 b_patrol
 * 
 * @author ruoyi
 * @date 2024-03-05
 */
public class BPatrol extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 巡查类型 */
    @Excel(name = "巡查类型")
    private Long patrolType;

    /** 巡查单元 */
    @Excel(name = "巡查单元")
    private String patrolUnit;
    private String unitName;

    /** 巡查用户 */
    @Excel(name = "巡查用户")
    private Long inspectorId;

    /** 工程id */
    @Excel(name = "工程id")
    private Long projectId;
    private String projectName;

    /** 桩号 */
    @Excel(name = "桩号")
    private String pileNumber;

    /** 断面位置（顶、上游、下游） */
    @Excel(name = "断面位置", readConverterExp = "顶=、上游、下游")
    private String sectionPosition;

    /** 轴线距离（正、负） */
    @Excel(name = "轴线距离", readConverterExp = "正=、负")
    private String axisDistance;

    /** 文字描述 */
    @Excel(name = "文字描述")
    private String description;

    /** 巡查时间 */
    @Excel(name = "巡查时间")
    private String patrolTime;

    /** 巡查位置 */
    @Excel(name = "巡查位置")
    private String address;

    /** 经度 */
    @Excel(name = "经度")
    private String lon;

    /** 纬度 */
    @Excel(name = "纬度")
    private String lat;

    /** 高程 */
    @Excel(name = "高程")
    private String high;

    /** 审核状态（已提交、审核中、通过、未通过） */
    @Excel(name = "审核状态", readConverterExp = "已=提交、审核中、通过、未通过")
    private String auditStatus;

    /** $column.columnComment */
    @Excel(name = "图片", readConverterExp = "$column.readConverterExp()")
    private String freedom1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String freedom2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String freedom3;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String freedom4;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String freedom5;

    //巡查类型名称
   private  String  typeName;


    private String X;
    private String Y;

    public String getX() {
        return X;
    }

    public void setX(String x) {
        X = x;
    }

    public String getY() {
        return Y;
    }

    public void setY(String y) {
        Y = y;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPatrolType(Long patrolType) 
    {
        this.patrolType = patrolType;
    }

    public Long getPatrolType() 
    {
        return patrolType;
    }
    public void setPatrolUnit(String patrolUnit) 
    {
        this.patrolUnit = patrolUnit;
    }

    public String getPatrolUnit() 
    {
        return patrolUnit;
    }
    public void setInspectorId(Long inspectorId) 
    {
        this.inspectorId = inspectorId;
    }

    public Long getInspectorId() 
    {
        return inspectorId;
    }
    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }
    public void setPileNumber(String pileNumber) 
    {
        this.pileNumber = pileNumber;
    }

    public String getPileNumber() 
    {
        return pileNumber;
    }
    public void setSectionPosition(String sectionPosition) 
    {
        this.sectionPosition = sectionPosition;
    }

    public String getSectionPosition() 
    {
        return sectionPosition;
    }
    public void setAxisDistance(String axisDistance) 
    {
        this.axisDistance = axisDistance;
    }

    public String getAxisDistance() 
    {
        return axisDistance;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setPatrolTime(String patrolTime) 
    {
        this.patrolTime = patrolTime;
    }

    public String getPatrolTime() 
    {
        return patrolTime;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setLon(String lon) 
    {
        this.lon = lon;
    }

    public String getLon() 
    {
        return lon;
    }
    public void setLat(String lat) 
    {
        this.lat = lat;
    }

    public String getLat() 
    {
        return lat;
    }
    public void setHigh(String high) 
    {
        this.high = high;
    }

    public String getHigh() 
    {
        return high;
    }
    public void setAuditStatus(String auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatus() 
    {
        return auditStatus;
    }
    public void setFreedom1(String freedom1) 
    {
        this.freedom1 = freedom1;
    }

    public String getFreedom1() 
    {
        return freedom1;
    }
    public void setFreedom2(String freedom2) 
    {
        this.freedom2 = freedom2;
    }

    public String getFreedom2() 
    {
        return freedom2;
    }
    public void setFreedom3(String freedom3) 
    {
        this.freedom3 = freedom3;
    }

    public String getFreedom3() 
    {
        return freedom3;
    }
    public void setFreedom4(String freedom4) 
    {
        this.freedom4 = freedom4;
    }

    public String getFreedom4() 
    {
        return freedom4;
    }
    public void setFreedom5(String freedom5) 
    {
        this.freedom5 = freedom5;
    }

    public String getFreedom5() 
    {
        return freedom5;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("patrolType", getPatrolType())
            .append("patrolUnit", getPatrolUnit())
            .append("inspectorId", getInspectorId())
            .append("projectId", getProjectId())
            .append("pileNumber", getPileNumber())
            .append("sectionPosition", getSectionPosition())
            .append("axisDistance", getAxisDistance())
            .append("description", getDescription())
            .append("patrolTime", getPatrolTime())
            .append("address", getAddress())
            .append("lon", getLon())
            .append("lat", getLat())
            .append("high", getHigh())
            .append("auditStatus", getAuditStatus())
            .append("freedom1", getFreedom1())
            .append("freedom2", getFreedom2())
            .append("freedom3", getFreedom3())
            .append("freedom4", getFreedom4())
            .append("freedom5", getFreedom5())
            .append("typeName", getTypeName())
            .append("x", getX())
            .append("y", getY())
            .toString();
    }
}
