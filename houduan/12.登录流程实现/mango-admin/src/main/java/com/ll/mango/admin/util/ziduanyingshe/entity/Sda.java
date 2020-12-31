package com.ll.mango.admin.util.ziduanyingshe.entity;

/**
 * @Author 奥特曼
 * @Date 2020/12/28 0028 16:15
 * @Description TODO
 **/
public class Sda {
    private String sdaId;
    private String sdaStructName;
    private String sdaStructAlias;
    private String sdaMetadataId;
    private String sdaType;
    private String sdaRequired;
    private String sdaRemark;
    private String sdaXpath;

    public Sda( ) {
    }

    public Sda(String sdaId, String sdaStructName, String sdaStructAlias, String sdaMetadataId, String sdaType, String sdaRequired, String sdaRemark, String sdaXpath) {
        this.sdaId = sdaId;
        this.sdaStructName = sdaStructName;
        this.sdaStructAlias = sdaStructAlias;
        this.sdaMetadataId = sdaMetadataId;
        this.sdaType = sdaType;
        this.sdaRequired = sdaRequired;
        this.sdaRemark = sdaRemark;
        this.sdaXpath = sdaXpath;
    }

    public String getSdaId() {
        return sdaId;
    }

    public void setSdaId(String sdaId) {
        this.sdaId = sdaId;
    }

    public String getSdaStructName() {
        return sdaStructName;
    }

    public void setSdaStructName(String sdaStructName) {
        this.sdaStructName = sdaStructName;
    }

    public String getSdaStructAlias() {
        return sdaStructAlias;
    }

    public void setSdaStructAlias(String sdaStructAlias) {
        this.sdaStructAlias = sdaStructAlias;
    }

    public String getSdaMetadataId() {
        return sdaMetadataId;
    }

    public void setSdaMetadataId(String sdaMetadataId) {
        this.sdaMetadataId = sdaMetadataId;
    }

    public String getSdaType() {
        return sdaType;
    }

    public void setSdaType(String sdaType) {
        this.sdaType = sdaType;
    }

    public String getSdaRequired() {
        return sdaRequired;
    }

    public void setSdaRequired(String sdaRequired) {
        this.sdaRequired = sdaRequired;
    }

    public String getSdaRemark() {
        return sdaRemark;
    }

    public void setSdaRemark(String sdaRemark) {
        this.sdaRemark = sdaRemark;
    }

    public String getSdaXpath() {
        return sdaXpath;
    }

    public void setSdaXpath(String sdaXpath) {
        this.sdaXpath = sdaXpath;
    }
}
