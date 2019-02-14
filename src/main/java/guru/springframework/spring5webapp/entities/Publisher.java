package guru.springframework.spring5webapp.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "Publisher_seq")
    @SequenceGenerator(name = "Publisher_seq",initialValue = 1,allocationSize = 1,sequenceName = "myPublisher_Seq")
    private Long publisherID;
    private String publisherName;
    private String publisherAddress;

    public Publisher(String publisherName, String publisherAddress) {
        this.publisherName = publisherName;
        this.publisherAddress = publisherAddress;
    }

    public Long getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(Long publisherID) {
        this.publisherID = publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public Publisher() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(getPublisherID(), publisher.getPublisherID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPublisherID());
    }

    @Override
    public String toString() {
        return publisherName + "";
    }
}
