package com.xnw.persistence.mybatis.generator.plugins;

import com.xnw.constant.DataSourceConstant;
import com.xnw.persistence.shard.PartitionedTable;
import com.xnw.persistence.shard.SegmentTable;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;

import java.util.regex.Pattern;

import static com.xnw.utils.StringUtil.isNotEmpty;

public class ShardTablePlugin extends BasePlugin {

	private static final DataSourceConstant DATA_SOURCE = new DataSourceConstant();
	private static final String DATA_SOURCE_PRE = "DataSourceConstant.";
	private static final String FULL_DATE_TYPE = "java.util.Date";
	private static final String SHARD_TABLE_SUFIX_PATTERN = "_(\\d{4}_\\d{2}|\\d{1,3})";
	private String tableName = null;

	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		CommentGenerator commentGenerator = context.getCommentGenerator();
		FullyQualifiedJavaType dateType = new FullyQualifiedJavaType(FULL_DATE_TYPE);
		topLevelClass.addImportedType(dateType);
		// 添加page字段
		Field shardDate = new Field();
		shardDate.setVisibility(JavaVisibility.PRIVATE);
		shardDate.setType(dateType);
		shardDate.setName("shardDate");
		commentGenerator.addFieldComment(shardDate, introspectedTable);
		topLevelClass.addField(shardDate);

		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("setShardDate");
		method.addParameter(new Parameter(dateType, "shardDate"));
		method.addBodyLine("this.shardDate = shardDate;");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);

		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("getShardDate");
		method.setReturnType(dateType);
		method.addBodyLine("return this.shardDate;");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		return Boolean.TRUE;
	}

	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		String shardType = introspectedTable.getTableConfigurationProperty("shardType");
		String shardBy = introspectedTable.getTableConfigurationProperty("shardBy");
		String tableNum = introspectedTable.getTableConfigurationProperty("tableNum");
		String shardKey = introspectedTable.getTableConfigurationProperty("shardKey");
		String partitionedTable = introspectedTable.getTableConfigurationProperty("partitionedTable");
		StringBuilder sb = new StringBuilder();
		if (isNotEmpty(shardType) || isNotEmpty(shardBy) || isNotEmpty(tableNum)) {
			FullyQualifiedJavaType segmentType = new FullyQualifiedJavaType(SegmentTable.class.getCanonicalName());
			interfaze.addImportedType(segmentType);
			interfaze.addImportedType(new FullyQualifiedJavaType(DataSourceConstant.ShardType.class.getCanonicalName()));
			sb.setLength(0);
			sb.append("@SegmentTable(");
			sb.append("table=\"").append(tableName).append("\"");
			if (isNotEmpty(shardType)) {
				sb.append(",");
				sb.append("shardType=").append("ShardType.").append(shardType.toUpperCase());
			}
			if (isNotEmpty(shardBy)) {
				sb.append(",");
				sb.append("shardBy=\"").append(shardBy).append("\"");
			}
			if (isNotEmpty(tableNum)) {
				sb.append(",");
				sb.append("tableNum=").append(tableNum);
			}
			if (isNotEmpty(shardKey)) {
				sb.append(",");
				sb.append("shardKey=\"").append(shardKey).append("\"");
			}
			sb.append(")");
			interfaze.addAnnotation(sb.toString());
		}
		if (isNotEmpty(partitionedTable)) {
			FullyQualifiedJavaType segmentType = new FullyQualifiedJavaType(PartitionedTable.class.getCanonicalName());
			interfaze.addImportedType(segmentType);
			interfaze.addImportedType(new FullyQualifiedJavaType(DataSourceConstant.class.getCanonicalName()));
			sb.setLength(0);
			sb.append("@PartitionedTable(");
			sb.append(transferStrToDataSource(partitionedTable)).append(")");
			interfaze.addAnnotation(sb.toString());
		}
		return Boolean.TRUE;
	}

	private String transferStrToDataSource(String val) {
		for (java.lang.reflect.Field field : DATA_SOURCE.getClass().getFields()) {
			field.setAccessible(true);
			try {
				if (val.equals(field.get(DATA_SOURCE))) {
					return DATA_SOURCE_PRE + field.getName();
				}
			} catch (Exception e) {
			}
		}
		return "";
	}

	public void initialized(IntrospectedTable introspectedTable) {
		tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
		String newTableName = Pattern.compile(SHARD_TABLE_SUFIX_PATTERN).matcher(tableName).replaceAll("").trim();
		introspectedTable.setSqlMapAliasedFullyQualifiedRuntimeTableName(newTableName);
		introspectedTable.setSqlMapFullyQualifiedRuntimeTableName(newTableName);
		tableName = newTableName;
	}
}
