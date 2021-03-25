package com.example.asmspring.entity;

import javax.persistence.*;

@Entity
@Table(name = "pairing", schema = "asm_spring", catalog = "")
public class PairingEntity {
    private Long id;
    private Integer childId;
    private Integer fatherId;
    private Integer motherId;
    private PersonEntity personByChildId;
    private PersonEntity personByFatherId;
    private PersonEntity personByMotherId;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "child_id", nullable = true, insertable = false, updatable = false)
    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    @Basic
    @Column(name = "father_id", nullable = true, insertable = false, updatable = false)
    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    @Basic
    @Column(name = "mother_id", nullable = true, insertable = false, updatable = false)
    public Integer getMotherId() {
        return motherId;
    }

    public void setMotherId(Integer motherId) {
        this.motherId = motherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PairingEntity that = (PairingEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (childId != null ? !childId.equals(that.childId) : that.childId != null) return false;
        if (fatherId != null ? !fatherId.equals(that.fatherId) : that.fatherId != null) return false;
        if (motherId != null ? !motherId.equals(that.motherId) : that.motherId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (childId != null ? childId.hashCode() : 0);
        result = 31 * result + (fatherId != null ? fatherId.hashCode() : 0);
        result = 31 * result + (motherId != null ? motherId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    public PersonEntity getPersonByChildId() {
        return personByChildId;
    }

    public void setPersonByChildId(PersonEntity personByChildId) {
        this.personByChildId = personByChildId;
    }

    @ManyToOne
    @JoinColumn(name = "father_id", referencedColumnName = "id")
    public PersonEntity getPersonByFatherId() {
        return personByFatherId;
    }

    public void setPersonByFatherId(PersonEntity personByFatherId) {
        this.personByFatherId = personByFatherId;
    }

    @ManyToOne
    @JoinColumn(name = "mother_id", referencedColumnName = "id")
    public PersonEntity getPersonByMotherId() {
        return personByMotherId;
    }

    public void setPersonByMotherId(PersonEntity personByMotherId) {
        this.personByMotherId = personByMotherId;
    }
}
