package com.example.requisition.domain;

import com.example.sale.Publisher;

import java.util.Objects;

public class Requisition {

    private final RequisitionId requisitionId;
    private final Isbn isbn;
    private final Publisher publisher;

    private Requisition(RequisitionId requisitionId, Isbn isbn, Publisher publisher) {
        this.requisitionId = requisitionId;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public RequisitionId getRequisitionId() {
        return requisitionId;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public Publisher getPublisher() {
        return publisher;
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
                ", publisher=" + publisher +
                '}';
    }

    public static class Builder {

        private RequisitionId requisitionId;
        private Isbn isbn;
        private Publisher publisher;

        public Builder requsitionId(Long value){
            this.requisitionId = RequisitionId.of(value);
            return this;
        }

        public Builder isbn(String value){
            this.isbn = Isbn.of(value);
            return this;
        }

        public Builder publisher(Publisher publisher){
            this.publisher = new Publisher.Builder()
                    .publisherId(publisher.getId())
                    .name(publisher.getName())
                    .logo(publisher.getLogo().getValues())
                    .build();
            return this;
        }

        public Requisition build(){
            return new Requisition(requisitionId, isbn, publisher);
        }


    }



}
