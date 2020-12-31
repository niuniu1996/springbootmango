package com.ll.mango.admin.util.ziduanyingshe.entity;

/**
 * @Author 奥特曼
 * @Date 2020/12/28 0028 16:15
 * @Description TODO
 **/
public class Ida {
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

    public Ida() {
    }

    public Ida(String id, String structName, String structAlias, String metadataId, String seq, String type, String scale, String length, String required, String _parentId, String interfaceId, String remark, String xpath) {
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
}
