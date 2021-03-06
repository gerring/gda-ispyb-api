/*-
 *******************************************************************************
 * Copyright (c) 2011, 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    See git history
 *******************************************************************************/
package uk.ac.diamond.ispyb.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DataCollectionPlanInfo {
	
	private Double energy;
	private Double preferredBeamSizeX;
	private Double preferredBeamSizeY;
	private Double exposureTime;
	private Double distance;
	private Double orientation;
	private Double monoBandwidth;
	private String detectorType;
	private String detectorManufacturer;
	private String detectorModel;
	private Double detectorDistanceMin;
	private Double detectorDistanceMax;
	private Double density;
	private String composition; 
	
	private List<ScanParameters> scanParameters = new ArrayList<>();
	
	public Double getEnergy() {
		return energy;
	}

	public void setEnergy(Double energy) {
		this.energy = energy;
	}

	public Double getPreferredBeamSizeX() {
		return preferredBeamSizeX;
	}

	public void setPreferredBeamSizeX(Double preferredBeamSizeX) {
		this.preferredBeamSizeX = preferredBeamSizeX;
	}

	public Double getPreferredBeamSizeY() {
		return preferredBeamSizeY;
	}

	public void setPreferredBeamSizeY(Double preferredBeamSizeY) {
		this.preferredBeamSizeY = preferredBeamSizeY;
	}

	public Double getExposureTime() {
		return exposureTime;
	}

	public void setExposureTime(Double exposureTime) {
		this.exposureTime = exposureTime;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getOrientation() {
		return orientation;
	}

	public void setOrientation(Double orientation) {
		this.orientation = orientation;
	}

	public Double getMonoBandwidth() {
		return monoBandwidth;
	}

	public void setMonoBandwidth(Double monoBandwidth) {
		this.monoBandwidth = monoBandwidth;
	}

	public String getDetectorType() {
		return detectorType;
	}

	public void setDetectorType(String detectorType) {
		this.detectorType = detectorType;
	}

	public String getDetectorManufacturer() {
		return detectorManufacturer;
	}

	public void setDetectorManufacturer(String detectorManufacturer) {
		this.detectorManufacturer = detectorManufacturer;
	}

	public String getDetectorModel() {
		return detectorModel;
	}

	public void setDetectorModel(String detectorModel) {
		this.detectorModel = detectorModel;
	}

	public Double getDetectorDistanceMin() {
		return detectorDistanceMin;
	}

	public void setDetectorDistanceMin(Double detectorDistanceMin) {
		this.detectorDistanceMin = detectorDistanceMin;
	}

	public Double getDetectorDistanceMax() {
		return detectorDistanceMax;
	}

	public void setDetectorDistanceMax(Double detectorDistanceMax) {
		this.detectorDistanceMax = detectorDistanceMax;
	}

	public Double getDensity() {
		return density;
	}

	public void setDensity(Double density) {
		this.density = density;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public List<ScanParameters> getScanParameters() {
		return scanParameters;
	}

	public void addScanParameter(ScanParameters... scan) {
		scanParameters.addAll(Arrays.asList(scan));
	};

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that);
	}
}
