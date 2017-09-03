package com.xnw.persistence.model.system;

import com.xnw.persistence.domain.BaseDomain;
import java.io.Serializable;
import java.time.LocalDateTime;

public class SysFunction extends BaseDomain<Integer> implements Serializable {
    private Integer id;

    private String functionName;

    private String functionUrl;

    private Integer functionParentId;

    private String introduce;

    private Integer level;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    public Integer getFunctionParentId() {
        return functionParentId;
    }

    public void setFunctionParentId(Integer functionParentId) {
        this.functionParentId = functionParentId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysFunction other = (SysFunction) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFunctionName() == null ? other.getFunctionName() == null : this.getFunctionName().equals(other.getFunctionName()))
            && (this.getFunctionUrl() == null ? other.getFunctionUrl() == null : this.getFunctionUrl().equals(other.getFunctionUrl()))
            && (this.getFunctionParentId() == null ? other.getFunctionParentId() == null : this.getFunctionParentId().equals(other.getFunctionParentId()))
            && (this.getIntroduce() == null ? other.getIntroduce() == null : this.getIntroduce().equals(other.getIntroduce()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getUpdatedBy() == null ? other.getUpdatedBy() == null : this.getUpdatedBy().equals(other.getUpdatedBy()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFunctionName() == null) ? 0 : getFunctionName().hashCode());
        result = prime * result + ((getFunctionUrl() == null) ? 0 : getFunctionUrl().hashCode());
        result = prime * result + ((getFunctionParentId() == null) ? 0 : getFunctionParentId().hashCode());
        result = prime * result + ((getIntroduce() == null) ? 0 : getIntroduce().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getUpdatedBy() == null) ? 0 : getUpdatedBy().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    public SysFunction id(Integer value) {
        this.id = value;
        return this;
    }

    public SysFunction functionName(String value) {
        this.functionName = value;
        return this;
    }

    public SysFunction functionUrl(String value) {
        this.functionUrl = value;
        return this;
    }

    public SysFunction functionParentId(Integer value) {
        this.functionParentId = value;
        return this;
    }

    public SysFunction introduce(String value) {
        this.introduce = value;
        return this;
    }

    public SysFunction level(Integer value) {
        this.level = value;
        return this;
    }

    public SysFunction createdAt(LocalDateTime value) {
        this.createdAt = value;
        return this;
    }

    public SysFunction updatedAt(LocalDateTime value) {
        this.updatedAt = value;
        return this;
    }

    public SysFunction createdBy(String value) {
        this.createdBy = value;
        return this;
    }

    public SysFunction updatedBy(String value) {
        this.updatedBy = value;
        return this;
    }

    public SysFunction state(Integer value) {
        this.state = value;
        return this;
    }
}