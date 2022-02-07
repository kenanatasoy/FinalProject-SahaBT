package com.example.requisition.domain;


import com.example.publisher.domain.PublisherId;
import com.example.shared.domain.Isbn;

import java.util.Objects;

public class Requisition {

    private final RequisitionId requisitionId;
    private final Isbn isbn;
    private final PublisherId publisherId;


    private Requisition(RequisitionId requisitionId, Isbn isbn, PublisherId publisherId) {
        this.requisitionId = requisitionId;
        this.isbn = isbn;
        this.publisherId = publisherId;
    }

    public RequisitionId getRequisitionId() {
        return requisitionId;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public PublisherId getPublisherId() {
        return publisherId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisitionId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Requisition other = (Requisition) obj;
        return Objects.equals(requisitionId, other.requisitionId);
    }

    @Override
    public String toString() {
        return "Requisition{" +
                "requisitionId=" + requisitionId +
                ", isbn=" + isbn +
                ", publisherId=" + publisherId +
                '}';
    }

    public static class Builder {

        private RequisitionId requisitionId;
        private Isbn isbn;
        private PublisherId publisherId;

        public Builder requisitionId(Long value){
            this.requisitionId = RequisitionId.of(value);
            return this;
        }

        public Builder isbn(String value){
            this.isbn = Isbn.valueOf(value);
            return this;
        }

        public Builder publisher(PublisherId publisherId){
            this.publisherId = PublisherId.valueOf(publisherId.getPublisherId());
            return this;
        }

        public Requisition build(){
            return new Requisition(requisitionId, isbn, publisherId);
        }


    }



}
