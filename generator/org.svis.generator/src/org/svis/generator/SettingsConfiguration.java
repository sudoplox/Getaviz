package org.svis.generator;

import java.io.File;
import java.awt.Color;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class SettingsConfiguration {
	private String path = "../org.svis.generator/src/org/svis/generator/settings.properties";
	private PropertiesConfiguration config;

	public SettingsConfiguration() {
		File file = new File(path);
		try {
			Configurations configs = new Configurations();
			config = configs.properties(file);
		} catch (ConfigurationException cex) {
			System.out.println(cex);
		}
	}

	public String getDatabaseName() {
		return config.getString("structure.database_name", "../databases/graph.db");
	}

	public boolean isHidePrivateElements() {
		return config.getBoolean("structure.hide_private_elements", false);
	}

	public String parser() {
		return config.getString("structure.parser", "verveinej");
	}

	public boolean isAttributeSortSize() {
		return config.getBoolean("structure.attribute_sort_size", false);
	}

	public boolean isMasterRoot() {
		return config.getBoolean("structure.master_root", false);
	}

	public boolean isMergePackages() {
		return config.getBoolean("structure.merge_packages", false);
	}

	public String getCityOutputFormat() {
		return config.getString("city.output_format", "x3d");
	}

	public String getBuildingType() {
		return config.getString("city.building_type", "city_original");
	}

	public String getScheme() {
		return config.getString("city.scheme", "types");
	}

	public String getClassElementsMode() {
		return config.getString("city.class_elements_mode", "methods_and_attributes");
	}

	public String getClassElementsSortModeCoarse() {
		return config.getString("city.class_elements_sort_mode_coarse", "methods_first");
	}

	public String getElementsSortModeFide() {
		return config.getString("city.elements_sort_mode_fide", "scheme");
	}

	public boolean isClassElementsSortModeFineDirectionReversed() {
		return config.getBoolean("city.class_elements_sort_mode_fine_direction_reversed", false);
	}

	public boolean isShowBuildingBase() {
		return config.getBoolean("city.building_base", false);
	}

	public String getBrickLayout() {
		return config.getString("city.brick.layout", "progressive");
	}

	public double getBrickSize() {
		return config.getDouble("city.brick.size", 1.0);
	}

	public double getBrickHorizontalMargin() {
		return config.getDouble("city.brick.horizontal_margin", 0.5);
	}

	public double getBrickHorizontalGap() {
		return config.getDouble("city.brick.horizontal_gap", 0.2);
	}

	public double getBrickVerticalMargin() {
		return config.getDouble("city.brick.vertical_margin", 0.2);
	}

	public double getBrickVerticalGap() {
		return config.getDouble("city.brick.vertical_gap", 0.2);
	}

	public boolean isShowAttributesAsCylinders() {
		return config.getBoolean("city.show_attributes_as_cylinders", true);
	}

	public String getPanelSeparatorMode() {
		return config.getString("city.panel_separator_mode", "separator");
	}

	public int[] getPanelHeightTresholdNos() {
		int[] defaultValue = { 3, 6, 12, 24, 48, 96, 144, 192, 240 };
		String[] result = config.getStringArray("city.panel.height_treshold_nos");
		if (result.length == 0) {
			return defaultValue;
		} else {
			int[] value = new int[result.length];
			for (int i = 0; i < result.length; i++) {
				value[i] = Integer.parseInt(result[i]);
			}
			return value;
		}
	}

	public double getPanelHeightUnit() {
		return config.getDouble("city.panel.height_unit", 0.5);
	}

	public double getPanelHorizontalMargin() {
		return config.getDouble("city.panel.horizontal_margin", 0.5);
	}

	public double getPanelVerticalMargin() {
		return config.getDouble("city.panel.vertical_margin", 0.25);
	}

	public double getPanelVerticalGap() {
		return config.getDouble("city.panel.vertical_gap", 0.125);
	}

	public double getPanelSeparatorHeight() {
		return config.getDouble("city.panel.separator_height", 0.125);
	}

	public String getOriginalBuildingMetric() {
		return config.getString("city.original_building_metric", "none");
	}

	public double getWidthMin() {
		return config.getDouble("city.width_min", 1.0);
	}

	public double getHeightMin() {
		return config.getDouble("city.height_min", 1.0);
	}

	public double getBuildingHorizontalMargin() {
		return config.getDouble("city.building.horizontal_margin", 3.0);
	}

	public double getBuildingHorizontalGap() {
		return config.getDouble("city.building.horizontal_gap", 3.0);
	}

	public double getBuildingVerticalMargin() {
		return config.getDouble("city.building.vertical_margin", 3.0);
	}

	public Color getPackageColorStart() {
		return getColor(config.getString("city.package.color_start", "#969696"));
	}

	public Color getPackageColorEnd() {
		return getColor(config.getString("city.package.color_end", "#f0f0f0"));
	}

	public Color getClassColorStart() {
		return getColor(config.getString("city.class.color_start", "#131615"));
	}

	public Color getClassColorEnd() {
		return getColor(config.getString("city.class.color_end", "#00ff00"));
	}

	public Color getCityClassColor() {
		return getColor(config.getString("city.class.color", "#353559"));
	}

	public Color getDynamicClassColorStart() {
		return getColor(config.getString("city.dynamic.class.color_start", "#fa965c"));
	}

	public Color getDynamicClassColorEnd() {
		return getColor(config.getString("dynamic.class.color_end", "#feb280"));
	}

	public Color getDynamicMethodColor() {
		return getColor(config.getString("city.dynamic.method.color", "#735eb9"));
	}

	public Color getDynamicPackageColorStart() {
		return getColor(config.getString("city.dynamic.package.color_start", "#23862c"));
	}

	public Color getDynamicPackageColorEnd() {
		return getColor(config.getString("city.dynamic.package.color_end", "#7bcd8d"));
	}

	public Color getCityColor(String name) {
		String color = name.toLowerCase();
		return getColor(config.getString("city.color." + color));
	}

	public double getDataFactor() {
		return config.getDouble("rd.data_factor", 4.0);
	}

	public double getMethodFactor() {
		return config.getDouble("rd.method_factor", 1.0);
	}

	public double getRDHeight() {
		return config.getDouble("rd.height", 1.0);
	}

	public int getRDHeightBoost() {
		return config.getInt("rd.height_boost", 8);
	}

	public double getRDHeightMultiplicator() {
		return config.getDouble("rd.height_multiplicator", 50.0);
	}

	public double getRDRingWidth() {
		return config.getDouble("rd.ring_width", 2.0);
	}

	public double getRDRingWidthMD() {
		return config.getDouble("rd.ring_width_md", 0);
	}

	public double getRDRingWidthAD() {
		return config.getDouble("rd.ring_width_ad", 0);
	}

	public double getMinArea() {
		return config.getDouble("rd.min_area", 10.0);
	}

	public double getNamespaceTransparency() {
		return config.getDouble("rd.namespace_transparency", 0);
	}

	public double getClassTransparency() {
		return config.getDouble("rd.class_transparency", 0);
	}

	public double getMethodTransparency() {
		return config.getDouble("rd.method_transparency", 0);
	}

	public double getDataTransparency() {
		return config.getDouble("rd.data_transparency", 0);
	}

	public Color getRDClassColor() {
		return getColor(config.getString("rd.color.class", "#353559"));
	}

	public String getRDClassColorFormatted() {
		return getColorFormatted(getRDClassColor());
	}

	public Color getDataColor() {
		return getColor(config.getString("rd.color.data", "#fffc19"));
	}

	public String getDataColorFormatted() {
		return getColorFormatted(getDataColor());
	}

	public Color getRDMethodColor() {
		return getColor(config.getString("rd.color.method", "#1485cc"));
	}

	public String getMethodColorFormatted() {
		return getColorFormatted(getRDMethodColor());
	}

	public Color getNamespaceColor() {
		return getColor(config.getString("rd.color.namespace", "#969696"));
	}

	public String getNamespaceColorFormatted() {
		return getColorFormatted(getNamespaceColor());
	}

	public Color getMethodInvocationColor() {
		return getColor(config.getString("rd.color.method_invocation", "#780a32"));
	}

	public String getMethodInvocationColorFormatted() {
		return getColorFormatted(getMethodInvocationColor());
	}

	public boolean isMethodDisks() {
		return config.getBoolean("rd.method_disks", false);
	}

	public boolean isDataDisks() {
		return config.getBoolean("rd.data_disks", false);
	}

	public boolean isMethodTypeMode() {
		return config.getBoolean("rd.method_type_mode", false);
	}

	public String getRDOutputFormat() {
		return config.getString("rd.output_format", "x3d");
	}

	public String getMetricRepresentation() {
		return config.getString("rd.metric_representation", "none");
	}

	public String getInvocationRepresentation() {
		return config.getString("rd.invocation_representation", "none");
	}

	public String getEvolutionRepresentation() {
		return config.getString("rd.evolution_representation", "time_line");
	}

	public String getVariant() {
		return config.getString("rd.variant", "static");
	}

	public String getPackageShape() {
		return config.getString("plant.package.shape", "default");
	}

	public boolean isPackageUseTextures() {
		return config.getBoolean("plant.package.use_textures", false);
	}

	public String getPackageOddTexture() {
		return config.getString("plant.package.odd_texture");
	}

	public String getPackageEvenTexture() {
		return config.getString("plant.package.even_texture");
	}

	public String getPackageOddColor() {
		Color color = getColor(config.getString("plant.package.odd_color", "#964327"));
		return getPlantColorFormatted(getColorFormatted(color));
	}

	public String getPackageEvenColor() {
		Color color = getColor(config.getString("plant.package.even_color", "#30ba43"));
		return getPlantColorFormatted(getColorFormatted(color));
	}

	public String getClassShape() {
		return config.getString("plant.class.shape", "default");
	}

	public boolean isClassUseTextures() {
		return config.getBoolean("plant.class.use_textures", false);
	}

	public String getClassSize() {
		return config.getString("plant.class.size", "count_attributes_and_methods");
	}

	public String getClassTexture() {
		return config.getString("plant.class.texture", "<ImageTexture url='pics/plant.png' scale='true' />");
	}

	public String getClassTextureHeadBrown() {
		return config.getString("plant.class.texture_head_brown", "<ImageTexture url='pics/plant.png' scale='true' />");
	}

	public String getClassTextureBloom() {
		return config.getString("plant.class.texture_bloom", "<ImageTexture url='pics/bloom.png' scale='false' />");
	}

	public String getClassColor() {
		Color color = getColor(config.getString("plant.class.color", "#34663b"));
		return getPlantColorFormatted(getColorFormatted(color));
	}

	public String getClassColor02() {
		Color color = getColor(config.getString("plant.class.color02", "#8b4413"));
		return getPlantColorFormatted(getColorFormatted(color));
	}

	public String getClassColor03() {
		Color color = getColor(config.getString("plant.class.color03", "#ffff00"));
		return getPlantColorFormatted(getColorFormatted(color));
	}

	public String getInnerClassShape() {
		return config.getString("plant.inner_class.shape", "default");
	}

	public boolean isInnerClassUseTextures() {
		return config.getBoolean("plant.inner_class.use_textures", false);
	}

	public String getInnerClassTexture() {
		return config.getString("plant.inner_class.texture", "<ImageTexture url='pics/plant.png' scale='true' />");
	}

	public String getInnerClassTextureJunctionHeadTopPart() {
		return config.getString("plant.inner_class.texture_head_brown",
				"<ImageTexture url='pics/junctionHeadTopPart.png' scale='false' />");
	}

	public String getInnerClassTextureBloom() {
		return config.getString("plant.inner_class.texture_bloom", "<ImageTexture url='pics/bloom.png' scale='false' />");
	}

	public String getInnerClassColor() {
		Color color = getColor(config.getString("plant.inner_class.color", "#329c3c"));
		return getPlantColorFormatted(getColorFormatted(color));
	}

	public String getInnerClassColor02() {
		Color color = getColor(config.getString("plant.inner_class.color02", "#8b4413"));
		return getPlantColorFormatted(getColorFormatted(color));
	}

	public String getInnerClassColor03() {
		Color color = getColor(config.getString("plant.inner_class.color03", "#ffff00"));
		return getPlantColorFormatted(getColorFormatted(color));
	}
	
	public String getAttributeShape() {
		return config.getString("plant.attribute.shape", "realistic_petal");
	}

	public boolean isShowAttributes() {
		return config.getBoolean("plant.attribute.show", true);
	}

	public Boolean isAttributeUseTextures() {
		return config.getBoolean("plant.attribute.use_textures", true);
	}

	public String getAttributeTexture() {
		return config.getString("plant.attribute.texture", "<ImageTexture url='pics/lilacPetal.png' scale='false' />");
	}

	public String getAttributeColor() {
		Color color = getColor(config.getString("plant.attribute.color", "#8a3398"));
		return getPlantColorFormatted(getColorFormatted(color));
	}
	
	public String getInnerClassAttributeShape() {
		return config.getString("plant.inner_class_attribute.shape", "default");
	}

	public String getInnerClassAttributeTexture() {
		return config.getString("plant.inner_class_attribute.texture", "<ImageTexture url='pics/lilacPetal.png' scale='false' />");
	}

	public String getInnerClassAttributeColor() {
		Color color = getColor(config.getString("plant.inner_class_attribute.color", "#ab2626"));
		return getPlantColorFormatted(getColorFormatted(color));
	}
	
	public String getMethodShape() {
		return config.getString("plant.method.shape", "default");
	}

	public boolean isShowMethods() {
		return config.getBoolean("plant.method.show", true);
	}

	public Boolean isMethodUseTextures() {
		return config.getBoolean("plant.method.use_textures", true);
	}

	public String getMethodTexture() {
		return config.getString("plant.method.texture", "<ImageTexture url='pics/junctionGreen.png' scale='false' />");
	}
	
	public String getMethodTexturePollball() {
		return config.getString("plant.method.texture_pollball", "<ImageTexture url='pics/pollball.png' scale='false' />");
	}

	public String getMethodColor() {
		Color color = getColor(config.getString("plant.method.color", "#000100"));
		return getPlantColorFormatted(getColorFormatted(color));
	}
	
	public String getMethodColor02() {
		Color color = getColor(config.getString("plant.method.color", "#010100"));
		return getPlantColorFormatted(getColorFormatted(color));
	}
	
	public String getInnerClassMethodhape() {
		return config.getString("plant.inner_class_method.shape", "default");
	}

	public String getInnerClassMethodTexture() {
		return config.getString("plant.inner_class_method.texture", "<ImageTexture url='pics/bloom.png' scale='false' />");
	}

	public String getInnerClassMethodColor() {
		Color color = getColor(config.getString("plant.inner_class_method.color", "#8b4413"));
		return getPlantColorFormatted(getColorFormatted(color));
	}
	
	public double getAreaheight() {
		return config.getDouble("plant.area_height", 3.5);
	}
	
	public double getStemThickness() {
		return config.getDouble("plant.stem.thickness", 3.0);
	}
	
	public double getStemHeight() {
		return config.getDouble("plant.stem.height", 6.0);
	}
	
	public double getCronHeight() {
		return config.getDouble("plant.cron.height", 2.0);
	}
	
	public double getCronHeadHeight() {
		return config.getDouble("plant.cron.head_height", 0.5);
	}
	
	public double getPetalAngle() {
		return config.getDouble("plant.petal.angle", 0.5236);
	}
	
	public double getPetalDistanceMultiplier() {
		return config.getDouble("plant.petal.distance_multiplier", 3.0);
	}

	public double getPollstemAngle() {
		return config.getDouble("plant.pollstem.angle", 0.05);
	}
	
	public double getPollstemAngleDistanceMultiplier() {
		return config.getDouble("plant.pollstem.angle_distance_multiplier", 0.3);
	}
	
	public double getPollstemBallMultiplier() {
		return config.getDouble("plant.pollstem.ball_multiplier", 1.57);
	}
	
	public double getPollstemBallHeight() {
		return getCronHeight() + 3.78;
	}
	
	public double getJunctionAngle() {
		return config.getDouble("plant.junction.angle", 1.3);
	}
	
	public double getJunctionStemThickness() {
		return getStemThickness() / 2;
	}
	
	public double getJunctionDistanceMultiplier() {
		return config.getDouble("plant.junction.distance_multiplier", 8.0);
	}
	
	public double getJunctionPollstemBallMultiplier() {
		return config.getDouble("plant.junction.pollstem.ball_multiplier", 0.1);
	}
	
	public double getPlantBuildingHorizontalMargin() {
		return config.getDouble("plant.building.horizontal_margin", 3.0);
	}
	
	public double getPlantBuildingHorizontalGap() {
		return config.getDouble("plant.building.horizontal_gap", 7.0);
	}
	
	public double getPlantBuildingVerticalMargin() {
		return config.getDouble("plant.building.vertical_margin", 3.0);
	}

	private String getColorFormatted(Color color) {
		float[] components = color.getColorComponents(null);
		String formattedColor = String.format("%f %f %f", components[0], components[1], components[2]);
		return formattedColor;
	}

	private String getPlantColorFormatted(String formattedColor) {
		return "<Material diffuseColor='" + formattedColor + "' />";
	}

	private Color getColor(String hex) {
		return Color.decode(hex);
	}
}
