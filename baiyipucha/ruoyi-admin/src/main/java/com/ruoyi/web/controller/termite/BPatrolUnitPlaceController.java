package com.ruoyi.web.controller.termite;

import java.io.DataInput;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.BPatrolMapper;
import com.ruoyi.system.mapper.BPatrolUnitPlaceMapper;
import com.ruoyi.system.service.*;
import com.ruoyi.web.controller.termite.utils.MileageUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 普查处管理Controller
 * 
 * @author ruoyi
 * @date 2024-04-08
 */
@RestController
@RequestMapping("/system/place")
public class BPatrolUnitPlaceController extends BaseController
{

    @Autowired
    private IBPatrolService bPatrolService;

    @Autowired
    private IBAuditService ibAuditService;
    @Autowired
    private IBProjectService projectService;
    @Autowired
    private IBPatrolFileService fileService;

    @Autowired
    ISysDeptService deptService;

    @Autowired
    private BPatrolUnitPlaceMapper bPatrolUnitPlaceMapper;

    @Autowired
    private  BPatrolMapper bPatrolMapper;



    @Log(title = "普查处管理", businessType = BusinessType.INSERT)
    @PostMapping("/add2")
    @Transactional
    public AjaxResult add2(@RequestBody BPatrolUnitPlaceAll bPatrolUnitPlaceAll) throws IOException {
        //先存记录
        List<BPatrol> patrols = bPatrolUnitPlaceAll.getPatrols();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (BPatrol patrol : patrols) {
            patrol.setAddress(bPatrolUnitPlaceAll.getAddress());
            patrol.setPatrolUnit(bPatrolUnitPlaceAll.getPatrolUnit());
            patrol.setPatrolType(bPatrolUnitPlaceAll.getPatrolType());
            patrol.setProjectId(bPatrolUnitPlaceAll.getProjectId());
            patrol.setInspectorId(bPatrolUnitPlaceAll.getInspectorId());
            String currentTime = sdf.format(new Date());
            patrol.setPatrolTime(currentTime);
            bPatrolService.insertBPatrol(patrol);
        }
        String s="";
        for (BPatrol patrol : patrols) {
            s= s+patrol.getId()+",";
        }

        BPatrolUnitPlace bPatrolUnitPlace=new BPatrolUnitPlace();
        bPatrolUnitPlace.setPatrolUnit(Long.valueOf(bPatrolUnitPlaceAll.getPatrolUnit()));
        bPatrolUnitPlace.setPatrolId(s);
        bPatrolUnitPlace.setDetrimentType(bPatrolUnitPlaceAll.getPatrolType());
        bPatrolUnitPlace.setAdress(bPatrolUnitPlaceAll.getAddress());
        bPatrolUnitPlace.setLat(String.valueOf(bPatrolUnitPlaceAll.getLat()));
        bPatrolUnitPlace.setLon(String.valueOf(bPatrolUnitPlaceAll.getLon()));
        bPatrolUnitPlace.setInspector(String.valueOf(bPatrolUnitPlaceAll.getInspectorId()));
        bPatrolUnitPlace.setProjectId(bPatrolUnitPlaceAll.getProjectId());
        bPatrolUnitPlace.setCreateTime(new Date());
        bPatrolUnitPlaceMapper.insertBPatrolUnitPlace(bPatrolUnitPlace);

            return  AjaxResult.success();

    }

    /**
     * 查询巡查列表
     */
    @GetMapping("/list")
    public TableDataInfo list(BPatrol bPatrol) {
        startPage();
        List<BPatrol> list = bPatrolService.selectBPatrolList(bPatrol);

        List<BPatrol> distinctList = list.stream()
                .distinct()
                .collect(Collectors.toList());

        return getDataTable(distinctList);
    }

    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        for (Long id : ids) {
            BPatrolUnitPlace bp = bPatrolUnitPlaceMapper.selectBPatrolUnitPlaceById(id);
            String patrolId = bp.getPatrolId();
            String [] splitPatrolId= patrolId.split(",");
            for (String s : splitPatrolId) {
                String  replace= s.replace(",", "");
                bPatrolMapper.deleteBPatrolById(Long.parseLong(replace));
            }
        }
        bPatrolUnitPlaceMapper.deleteBPatrolUnitPlaceByIds(ids);
        return AjaxResult.success("删除成功！");
    }





}
