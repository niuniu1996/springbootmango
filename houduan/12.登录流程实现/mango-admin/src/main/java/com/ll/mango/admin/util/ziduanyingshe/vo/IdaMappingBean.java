package com.ll.mango.admin.util.ziduanyingshe.vo;

import com.ll.mango.admin.util.ziduanyingshe.entity.Ida;
import com.ll.mango.admin.util.ziduanyingshe.entity.Sda;

/**
 * @Author 奥特曼
 * @Date 2020/12/23 0023 11:38
 * @Description TODO
 **/
public class IdaMappingBean {
    //ida
    private String id;
    private String structName;
    private String structAlias;
    private String metadataId;
    private String seq;
    private String type;
    private String scale;
    private String length;
    private String required;
    private String _parentId;
    private String interfaceId;
    private String remark;
    private String xpath;
    //sda
    private String sdaId;
    private String sdaStructName;
    private String sdaStructAlias;
    private String sdaMetadataId;
    private String sdaType;
    private String sdaRequired;
    private String sdaRemark;
    private String sdaXpath;

    public IdaMappingBean(String id, String structName, String structAlias, String metadataId, String seq, String type, String scale, String length, String required, String _parentId, String interfaceId, String remark, String xpath, String sdaId, String sdaStructName, String sdaStructAlias, String sdaMetadataId, String sdaType, String sdaRequired, String sdaRemark, String sdaXpath) {
        this.id = id;
        this.structName = structName;
        this.structAlias = structAlias;
        this.metadataId = metadataId;
        this.seq = seq;
        this.type = type;
        this.scale = scale;
        this.length = length;
        this.required = required;
        this._parentId = _parentId;
        this.interfaceId = interfaceId;
        this.remark = remark;
        this.xpath = xpath;
        this.sdaId = sdaId;
        this.sdaStructName = sdaStructName;
        this.sdaStructAlias = sdaStructAlias;
        this.sdaMetadataId = sdaMetadataId;
        this.sdaType = sdaType;
        this.sdaRequired = sdaRequired;
        this.sdaRemark = sdaRemark;
        this.sdaXpath = sdaXpath;
    }

    public IdaMappingBean(Ida ida, Sda sda) {
        //此处吧所有的属性搞上
        setId(ida.getId());
        setStructName(ida.getStructName());
        setStructAlias(ida.getStructAlias());
        setMetadataId(ida.getMetadataId());
        setSeq(ida.getSeq());
        if (ida.getType() != null) {
            if (ida.getLength() != null) {
                setType(ida.getType() + "(" + ida.getLength() + ")");
            } else {
                setType(ida.getType());
            }
        }
        setScale(ida.getScale());
        setLength(ida.getLength());
        setRequired(ida.getRequired());
        set_parentId(ida.get_parentId());
        setInterfaceId(ida.getInterfaceId());
        setRemark(ida.getRemark());
        setXpath(ida.getXpath());
        //sda
        setSdaId(sda.getSdaId());
        setSdaStructName(sda.getSdaStructName());
        setSdaStructAlias(sda.getSdaStructAlias());
        setSdaMetadataId(sda.getSdaMetadataId());
        setSdaType(sda.getSdaType());
        setSdaRequired(sda.getSdaRequired());
        setSdaRemark(sda.getSdaRemark());
        setSdaXpath(sda.getSdaXpath());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStructName() {
        return structName;
    }

    public void setStructName(String structName) {
        this.structName = structName;
    }

    public String getStructAlias() {
        return structAlias;
    }

    public void setStructAlias(String structAlias) {
        this.structAlias = structAlias;
    }

    public String getMetadataId() {
        return metadataId;
    }

    public void setMetadataId(String metadataId) {
        this.metadataId = metadataId;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String get_parentId() {
        return _parentId;
    }

    public void set_parentId(String _parentId) {
        this._parentId = _parentId;
    }

    public String getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(String interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
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
