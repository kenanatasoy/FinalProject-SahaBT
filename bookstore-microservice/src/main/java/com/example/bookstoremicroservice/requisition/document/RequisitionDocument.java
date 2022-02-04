package com.example.bookstoremicroservice.requisition.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "requisitions")
public class RequisitionDocument {

    @Id
    private Long requisitionId;

    @Indexed
    private String isbn;

    private Long publisherId;

    public RequisitionDocument() {
    }

    public Long getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(Long requisitionId) {
        this.requisitionId = requisitionId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
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
        RequisitionDocument other = (RequisitionDocument) obj;
        return Objects.equals(requisitionId, other.requisitionId);
    }

    @Override
    public String toString() {
        return "RequisitionDocument{" +
                "requisitionId=" + requisitionId +
                ", isbn='" + isbn + '\'' +
                ", publisherId=" + publisherId +
                '}';
    }
}
