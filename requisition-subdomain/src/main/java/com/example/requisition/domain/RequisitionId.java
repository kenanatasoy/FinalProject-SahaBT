package com.example.requisition.domain;

import java.util.Objects;

public final class RequisitionId {

    private final Long value;

    private RequisitionId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public static RequisitionId of(Long value) {
        return new RequisitionId(value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RequisitionId other = (RequisitionId) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString() {
        return "RequisitionId [value=" + value + "]";
    }

}

