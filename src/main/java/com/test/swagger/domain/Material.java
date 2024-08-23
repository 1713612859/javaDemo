package com.test.swagger.domain;

import com.test.swagger.In;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Desc Student
 * @Author LiuYunLong
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "素材表实体", description = "素材表实体description")
public class Material implements java.io.Serializable {
	 public interface Save {
	 }

	 private static final long serialVersionUID = 1L;

	 @Null(groups = {Save.class}, message = "id必须为null")
	 @Schema(description = "主键", example = "0")
	 private Long id;

	 @Schema(description = "适用机构号")
	 private String orgcode;

	 //@In是自定义的Bean Validation注解，未展示
	 @In(groups = {Save.class}, value = {"00", "01", "02"}, message = "素材类型必须是{value}之一")
	 @NotNull(groups = {Save.class}, message = "素材类型不能为空")
	 @Schema(description = "素材分类 00图片 01视频 02PDF", allowableValues = {"00", "01", "02"})
	 private String materialType;

	 @Schema(description = "素材类型名称", accessMode = Schema.AccessMode.READ_ONLY)
	 private String materialTypeName;

	 //@ByteSize是自定义的Bean Validation注解，未展示
	 @NotBlank(groups = {Save.class}, message = "素材名称不能为空")
	 //	 @Length(groups = {Save.class}, min = 1, max = 200, message = "素材名称字节长度必须在{min}-{max}之间")
	 @Schema(description = "素材名称")
	 private String materialName;

	 @NotBlank(groups = {Save.class}, message = "素材路径必须包含可见字符")
	 @Schema(description = "素材路径")
	 private String materialPath;

	 @Null(groups = {Save.class}, message = "vertical必须为null")
	 @Schema(description = "素材方向", accessMode = Schema.AccessMode.READ_ONLY)
	 private String vertical;

	 @Schema(description = "素材方向名称", accessMode = Schema.AccessMode.READ_ONLY)
	 private String verticalName;

	 @Null(groups = {Save.class}, message = "converted必须为null")
	 @Schema(description = "视频是否已完成转码", accessMode = Schema.AccessMode.READ_ONLY)
	 private String converted;

	 @Null(groups = {Save.class}, message = "failcount必须为null")
	 @Schema(description = "转码失败次数", accessMode = Schema.AccessMode.READ_ONLY)
	 private Integer failcount;

	 @Null(groups = {Save.class}, message = "createId必须为null")
	 @Schema(description = "创建用户", accessMode = Schema.AccessMode.READ_ONLY)
	 private Long createId;

	 @Null(groups = {Save.class}, message = "createDatetime必须为null")
	 @Schema(description = "创建时间", accessMode = Schema.AccessMode.READ_ONLY)
	 private LocalDateTime createDatetime;

	 @Null(groups = {Save.class}, message = "updateId必须为null")
	 @Schema(description = "修改用户", accessMode = Schema.AccessMode.READ_ONLY)
	 private Long updateId;

	 @Null(groups = {Save.class}, message = "updateDatetime必须为null")
	 @Schema(description = "修改时间", accessMode = Schema.AccessMode.READ_ONLY)
	 private LocalDateTime updateDatetime;
}
