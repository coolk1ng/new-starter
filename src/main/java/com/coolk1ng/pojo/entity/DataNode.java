package com.coolk1ng.pojo.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author coolk1ng
 * @since 2022/9/26 17:09
 */
public class DataNode {

    @JSONField(name = "MLT Overview_Process[Local_product_code]")
    private String localProductCode;
    @JSONField(name = "MLT Overview_Process[batch]")
    private String batch;
    @JSONField(name = "MLT Overview_Process[brand_description]")
    private String brandDescription;
    @JSONField(name = "MLT Overview_Process[Prod_loc_type]")
    private String prodLocType;
    @JSONField(name = "MLT Overview_Process[end_date]")
    private Date endDate;
    @JSONField(name = "MLT Overview_Process[Process]")
    private String process;
    @JSONField(name = "MLT Overview_Process[Actual]")
    private String actual;
    @JSONField(name = "MLT Overview_Process[SAP Setting]")
    private String setting;
    @JSONField(name = "MLT Overview_Process[MLT without pick]")
    private String withoutPick;
    @JSONField(name = "MLT Overview_Process[Target]")
    private String target;

    public DataNode() {
    }

    public DataNode(String localProductCode, String batch, String brandDescription, String prodLocType, Date endDate, String process, String actual, String setting, String withoutPick, String target) {
        this.localProductCode = localProductCode;
        this.batch = batch;
        this.brandDescription = brandDescription;
        this.prodLocType = prodLocType;
        this.endDate = endDate;
        this.process = process;
        this.actual = actual;
        this.setting = setting;
        this.withoutPick = withoutPick;
        this.target = target;
    }

    public String getLocalProductCode() {
        return localProductCode;
    }

    public void setLocalProductCode(String localProductCode) {
        this.localProductCode = localProductCode;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public String getProdLocType() {
        return prodLocType;
    }

    public void setProdLocType(String prodLocType) {
        this.prodLocType = prodLocType;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getWithoutPick() {
        return withoutPick;
    }

    public void setWithoutPick(String withoutPick) {
        this.withoutPick = withoutPick;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
