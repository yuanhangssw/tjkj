package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.BPatrolUnitPlace;
import com.ruoyi.system.domain.BProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CommonMapper {

    @Select("SELECT DISTINCT\n" +
            "\tt2.id,\n" +
            "\tt2.project_name projectName,\n" +
            "\tt2.project_type projectType,\n" +
            "\tt2.dept_id deptId,\n" +
            "\tt2.registration_number registrationNumber,\n" +
            "\tt2.address,\n" +
            "\tt2.reservoir_grade reservoirGrade,\n" +
            "\tt2.dyke_grade dykeGrade,\n" +
            "\tt2.dyke_length dykeLength,\n" +
            "\tt2.dyke_patrol_length dykePatrolLength,\n" +
            "\tt2.dyke_pile dykePile,\n" +
            "\tt2.dyke_pile_end dykePileEnd,\n" +
            "\tt2.dyke_patrol_pile dykePatrolPile,\n" +
            "\tt2.dyke_patrol_pile_end dykePatrolPileEnd,\n" +
            "\tt2.storage_capacity storageCapacity ,\n" +
            "\tt2.census_method censusMethod,\n" +
            "\tt2.person,\n" +
            "\tt2.person_phone personPhone,\n" +
            "\tt2.del_flag delFlag,\n" +
            "\tt2.create_by createBy,\n" +
            "\tt2.create_time createTime,\n" +
            "\tt2.update_by updateBy,\n" +
            "\tt2.update_time updateTime,\n" +
            "\tt2.freedom1,\n" +
            "\tt2.freedom2,\n" +
            "\tt2.freedom3,\n" +
            "\tt2.freedom4,\n" +
            "\tt2.freedom5,\n" +
            "\ts.dept_name  deptName\n" +
            "FROM\n" +
            "\t`b_inspector_unit` t1\n" +
            "\tLEFT JOIN b_project t2 ON t1.project_id = t2.id \n" +
            "\tLEFT JOIN sys_dept s  on s.dept_id=t2.dept_id\n" +
            "WHERE\n" +
            "\tinspector =\t#{userid}\n" +
            "\t\t")
     List<BProject> getprojectlistbyuserid(@Param("userid") long userid);

    @Select("SELECT " +
            " COUNT( a.id ) total  " +
            " FROM " +
            " `b_patrol` a " +
            " LEFT JOIN b_patrol_unit b ON a.patrol_unit = b.id  " +
            " WHERE " +
            " b.project_id = #{projectid}  " +
            " AND inspector_id = #{userid}  " +
            " and  patrol_type =#{type}")
    int   gettotalbytype(@Param("userid") long userid,@Param("type") int type,@Param("projectid") long project);

    @Select("SELECT\n" +
            "\tcount( patrol_unit_id ) \n" +
            "FROM\n" +
            "\t`b_inspector_unit` \n" +
            "WHERE\n" +
            "\tproject_id = #{projectid}\n" +
            "\tAND inspector=#{userid} "
            )
    int  gettotalunit(@Param("userid") long userid,@Param("projectid") long project);
    @Select("SELECT " +
            " COUNT(a.id) total  " +
            " FROM " +
            " `b_patrol` a " +
            " LEFT JOIN b_patrol_unit b ON a.patrol_unit = b.id  " +
            " WHERE " +
            " b.project_id = #{projectid}  " +
            " AND inspector_id = #{userid}  ")
    int getdatatotal (@Param("userid") long userid,@Param("projectid") long project);
    @Select("SELECT " +
            " COUNT(a.id) total  " +
            " FROM " +
            " `b_patrol` a " +
            " LEFT JOIN b_patrol_unit b ON a.patrol_unit = b.id  " +
            " WHERE " +
            " b.project_id = #{projectid}  " +
            " AND inspector_id = #{userid}  " +
            "  and audit_status =#{status}")
    int getdatatotalbystatus (@Param("userid") long userid,@Param("status") String status,@Param("projectid") long project);

//    @Select("\n" +
//            "SELECT\n" +
//            "    a.patrol_unit,\n" +
//            "    b.unit_name AS unitname,\n" +
//            "    SUM(CASE WHEN a.patrol_type = '1' THEN 1 ELSE 0 END) AS type1total,\n" +
//            "    SUM(CASE WHEN a.patrol_type = '2' THEN 1 ELSE 0 END) AS type2total,\n" +
//            "\t\tp.*\n" +
//            "FROM\n" +
//            "    `b_patrol` a\n" +
//            "LEFT JOIN b_patrol_unit b ON a.patrol_unit = b.id \n" +
//            "LEFT JOIN b_project p ON p.id = b.project_id \n" +
//            "WHERE\n" +
//            "    b.project_id =  #{projectid}\n" +
//            "    AND a.inspector_id = #{userid} \n" +
//            "GROUP BY\n" +
//            "    a.patrol_unit,\n" +
//            "    b.unit_name;\n")
//    List<Map<String,Object>> getprojecttotallist(@Param("projectid")Long projectid, @Param("userid") Long userid);


   @Select("SELECT\n" +
           "\tbup.patrol_unit,\n" +
           "\tbpu.unit_name,\n" +
           "\tSUM( CASE WHEN bup.detriment_type = '1' THEN 1 ELSE 0 END ) AS type1total,\n" +
           "\tSUM( CASE WHEN bup.detriment_type = '2' THEN 1 ELSE 0 END ) AS type2total \n" +
           "FROM\n" +
           "\tb_patrol_unit_place bup\n" +
           "\tLEFT JOIN b_patrol_unit bpu ON bup.patrol_unit = bpu.id \n" +
           "WHERE\n" +
           "\tbup.inspector = #{userid}\n" +
           "\tAND bup.project_id = #{projectid}\n" +
           "GROUP BY\n" +
           "\tbup.patrol_unit")
    List<Map<String,Object>> getprojecttotallist(@Param("projectid")Long projectid, @Param("userid") Long userid);

    @Select("SELECT\n" +
            " COUNT(a.id) total,\n" +
            " sum( CASE WHEN a.audit_status = '3' THEN 1 ELSE 0 END )  AS passtotal ,\n" +
            " sum( CASE WHEN a.audit_status = '4' THEN 1 ELSE 0 END )  AS backtotal\n" +
            "FROM\n" +
            "\t`b_patrol` a" +
            " LEFT JOIN b_patrol_unit b ON a.patrol_unit = b.id \n" +
            " WHERE   \n" +
            " b.project_id = #{projectid}\n" +
            " AND a.inspector_id = #{userid}\n"
            )
      Map<String,Integer> getdatatotalbystatus2(@Param("projectid")Long projectid, @Param("userid") Long userid);

    @Select("SELECT\n" +
            "\tDISTINCT t2.id,\n" +
            "\tt2.unit_name unit_name \n" +
            "FROM\n" +
            "\t`b_inspector_unit` t1\n" +
            "\tLEFT JOIN b_patrol_unit t2 ON t1.patrol_unit_id = t2.id \n" +
            "WHERE\n" +
            "\tt1.inspector =#{userid}\n" +
            "\tand t1.project_id=#{projectid}")
    List<Map<String, Object>> getprojectunitllist(@Param("projectid")Long projectid, @Param("userid") Long userid);

    @Select("SELECT count(*) FROM b_patrol_unit_place where patrol_unit in (select patrol_unit_id from b_inspector_unit  where inspector=#{userid} and project_id=#{projectid}\n" +
            ")")
    public int getPcdata(@Param("projectid") int projectid,@Param("userid") int userId);

    @Select("SELECT count(DISTINCT patrol_unit ) FROM b_patrol_unit_place " +
            "where patrol_unit in (select patrol_unit_id from b_inspector_unit  where inspector=#{userid} and project_id=#{projectid})\n")
    public  int getCompletedata(@Param("projectid") int projectid,@Param("userid") int userid);

    @Select("SELECT count(*) FROM b_patrol_unit_place    where  project_id=#{projectid}")
    public  int getCompletedataAdmin(@Param("projectid") Long projectid);

    @Select("SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "\tb_patrol_unit \n" +
            "WHERE\n" +
            "\tid IN (\n" +
            "\tSELECT\n" +
            "\t\tpatrol_unit_id \n" +
            "\tFROM\n" +
            "\t\tb_inspector_unit \n" +
            "\tWHERE\n" +
            "\t\tinspector = #{userid} \n" +
            "\t\tAND project_id = #{projectid} \n" +
            "\t)")
    List<Map<String, Object>> getprojectunitllist3(@Param("projectid")Long projectid,@Param("userid") Long userid);


//    @Select("select \n" +
//            "SUM( CASE WHEN bp.patrol_type = '1' THEN 1 ELSE 0 END ) AS type1total,\n" +
//            "SUM( CASE WHEN bp.patrol_type = '2' THEN 1 ELSE 0 END ) AS type2total,\n" +
//            "pu.id,\n" +
//            "pu.unit_name\n" +
//            "from \t b_patrol  bp \n" +
//            "LEFT JOIN   b_inspector_unit bi\n" +
//            "on bp.patrol_unit= bi.patrol_unit_id  \n" +
//            "LEFT JOIN  b_patrol_unit pu \n" +
//            "on pu.id=bi.patrol_unit_id\n" +
//            "where bi.project_id=#{projectId} and bi.inspector=#{userId}\n" +
//            "GROUP BY\n" +
//            "\tbp.patrol_unit,\n" +
//            "\tpu.unit_name")
//    List< Map<String, Object>> getprojecttotallistandUnitId(@Param("projectId") int projectId, @Param("userId") int userId);

    @Select("\t\t\n" +
            "SELECT\n" +
            "\tbup.patrol_unit,\n" +
            "\tbpu.unit_name ,\n" +
            "\tSUM( CASE WHEN bup.detriment_type = '1' THEN 1 ELSE 0 END ) AS type1total, \n" +
            "  SUM( CASE WHEN bup.detriment_type = '2' THEN 1 ELSE 0 END ) AS type2total\n" +
            "\n" +
            "\tFROM\n" +
            "\tb_patrol_unit_place bup\n" +
            "\tLEFT JOIN b_patrol_unit bpu ON bup.patrol_unit = bpu.id\n" +
            "\t\n" +
            "\twhere  bup.inspector=#{userId} and bup.project_id=#{projectId}\n" +
            "\t\n" +
            "\tgroup by bup.patrol_unit")
    List< Map<String, Object>> getprojecttotallistandUnitId(@Param("projectId") int projectId, @Param("userId") int userId);



    @Select("SELECT iu.patrol_unit_id as id, 0 as type1total,0 as  type2total,pu.unit_name\n" +
            "FROM b_inspector_unit iu\n" +
            "left join b_patrol_unit pu\n" +
            "on iu.patrol_unit_id=pu.id\n" +
            "WHERE iu.project_id = #{projectId}\n" +
            "    AND iu.inspector = #{userId}\n" +
            "    AND iu.patrol_unit_id NOT IN (select \n" +
            "pu.id\n" +
            "from \t b_patrol  bp \n" +
            "LEFT JOIN   b_inspector_unit bi\n" +
            "on bp.patrol_unit= bi.patrol_unit_id  \n" +
            "LEFT JOIN  b_patrol_unit pu \n" +
            "on pu.id=bi.patrol_unit_id\n" +
            "where bi.project_id=#{projectId} and bi.inspector=#{userId}\n" +
            "GROUP BY\n" +
            "\tbp.patrol_unit\n" +
            ") ")
    List<Map<String, Object>> getprojecttotallistandUnitIdSub(@Param("projectId") int projectId, @Param("userId") int userId);


    @Select("SELECT\n" +
            "\tSUM( CASE WHEN detriment_type = '1' THEN 1 ELSE 0 END ) AS type1total,\n" +
            "\tSUM( CASE WHEN detriment_type = '2' THEN 1 ELSE 0 END ) AS type2total \n" +
            "FROM\n" +
            "\t`b_patrol_unit_place` \n" +
            "WHERE\n" +
            "\tproject_id = #{projectId} \n" +
            "\tAND inspector = #{inspector}")
    Map<String, Object> getdataBaiyi(BPatrolUnitPlace bPatrolUnitPlace);


    @Select("\t\n" +
            "\tSELECT  \n" +
            "    SUM(CASE WHEN detriment_type = '1' THEN 1 ELSE 0 END) AS type1total,\n" +
            "    SUM(CASE WHEN detriment_type = '2' THEN 1 ELSE 0 END) AS type2total\n" +
            "FROM `b_patrol_unit_place`\n" +
            "WHERE  patrol_unit =#{patrolUnit} and project_id = #{projectId} AND inspector = #{inspector}  \n" +
            "GROUP BY detriment_type;")
    Map<String, Object> getdataBaiyiAndUnit(BPatrolUnitPlace bPatrolUnitPlace);


//    @Select("SELECT   count(DISTINCT project_id)  as projectNum  FROM `b_inspector_unit`  where inspector=#{inspector}")
//    int getProjectNum(Long inspector);

    @Select("SELECT count(*) FROM `b_project`  where dept_id=#{deptId}")
    int getProjectNum(Long deptId);


//    @Select("SELECT  count(DISTINCT patrol_unit_id)   FROM `b_inspector_unit`   WHERE inspector =#{inspector}")
//    int getUnitNum(Long inspector);

    @Select("SELECT count(*) FROM `b_patrol_unit` where project_id in\n" +
            "(SELECT id FROM `b_project`  where dept_id=#{deptId})")
    int getUnitNum(Long deptId);

    @Select("SELECT count(*) FROM `b_inspector` WHERE  dept_id=#{deptId}")
    int getInspectorNum(Long deptId);





    @Select("")
    Map<String, Object> getInspectType();

    @Select("SELECT\n" +
            "    bpup.project_id,\n" +
            "    bp.project_name,\n" +
            "    SUM( CASE WHEN detriment_type = '1' THEN 1 ELSE 0 END ) AS type1total,\n" +
            "    SUM( CASE WHEN detriment_type = '2' THEN 1 ELSE 0 END ) AS type2total\n" +
            "FROM\n" +
            "    `b_patrol_unit_place` bpup\n" +
            "LEFT JOIN b_project bp ON bp.id = bpup.project_id\n" +
            "WHERE\n" +
            "    bpup.project_id = #{id}\n" +
            "GROUP BY\n" +
            "    bpup.project_id, bp.project_name")
    Map getdataProjectZhNumber(Long id);

    @Select("SELECT count(DISTINCT patrol_unit) from b_patrol_unit_place  where  project_id=#{id}\n")
    int getScheduleCompleteUnit(Long id);


    @Select("SELECT count(*) FROM `b_patrol_unit`   where project_id=#{id}\n")
    int getScheduleAllCompleteUnit(Long id);
}
