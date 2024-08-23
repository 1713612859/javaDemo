package com.test.swagger.controller;

import com.test.swagger.domain.Material;
import com.test.swagger.page.Pagination;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc StudentController
 * @Author LiuYunLong
 */

@RestController
@RequestMapping("/material/")
@Tag(name = "素材表", description = "素材表接口")
@Validated
@Slf4j
public class MaterialController {

	 @Operation(summary = "保存素材表", description = "保存素材表description")
	 @PostMapping("save")
	 public void save(@Validated({Material.Save.class}) @RequestBody Material material) {
//		  material.getUpdateDatetime();
		  log.info(material.toString());
	 }

	 @Operation(summary = "查询素材表详情", description = "根据主键查询description")
	 @Parameter(name = "id", description = "主键", required = true, in = ParameterIn.PATH)
	 @GetMapping("detail/{id}")
	 public Material detail(@NotNull(message = "id不能为空") @PathVariable Long id) {
		  log.info(id.toString());
		  return new Material();
	 }

	 @Operation(summary = "删除素材表", description = "根据主键删除description")
	 @Parameter(name = "id", description = "主键", required = true, in = ParameterIn.PATH)
	 @DeleteMapping("delete/{id}")
	 public void delete(@NotNull(message = "id不能为空") @PathVariable Long id) {
		  log.info(id.toString());
	 }

	 //@Parameter(in = ParameterIn.QUERY) 表示接口参数不是application/json的形式，而是form-data的形式
	 @Operation(summary = "查询素材表列表", description = "基础列表查询,只包含所有属性and.eq条件description")
	 @PostMapping("list")
	 public List<Material> list(@RequestBody Material material, @Parameter(in = ParameterIn.QUERY) @Validated Pagination pagination) {
		  log.info(material.toString());
		  log.info(pagination.toString());
		  return new ArrayList<Material>();
	 }
}