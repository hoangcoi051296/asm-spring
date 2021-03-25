package com.example.asmspring.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "person", schema = "asm_spring", catalog = "")
public class PersonEntity {
    private Long id;
    private String firstName;
    private String lastName;
    private String lastNameBirth;
    private String birth;
    private String death;
    private String gender;
    private String comment;
    private Collection<PairingEntity> pairingsById;
    private Collection<PairingEntity> pairingsById_0;
    private Collection<PairingEntity> pairingsById_1;

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
    @Column(name = "first_name", nullable = true, length = -1)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = -1)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "last_name_birth", nullable = true, length = -1)
    public String getLastNameBirth() {
        return lastNameBirth;
    }

    public void setLastNameBirth(String lastNameBirth) {
        this.lastNameBirth = lastNameBirth;
    }

    @Basic
    @Column(name = "birth", nullable = true, length = -1)
    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Basic
    @Column(name = "death", nullable = true, length = -1)
    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = -1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (lastNameBirth != null ? !lastNameBirth.equals(that.lastNameBirth) : that.lastNameBirth != null)
            return false;
        if (birth != null ? !birth.equals(that.birth) : that.birth != null) return false;
        if (death != null ? !death.equals(that.death) : that.death != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (lastNameBirth != null ? lastNameBirth.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (death != null ? death.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personByChildId")
    public Collection<PairingEntity> getPairingsById() {
        return pairingsById;
    }

    public void setPairingsById(Collection<PairingEntity> pairingsById) {
        this.pairingsById = pairingsById;
    }

    @OneToMany(mappedBy = "personByFatherId")
    public Collection<PairingEntity> getPairingsById_0() {
        return pairingsById_0;
    }

    public void setPairingsById_0(Collection<PairingEntity> pairingsById_0) {
        this.pairingsById_0 = pairingsById_0;
    }

    @OneToMany(mappedBy = "personByMotherId")
    public Collection<PairingEntity> getPairingsById_1() {
        return pairingsById_1;
    }

    public void setPairingsById_1(Collection<PairingEntity> pairingsById_1) {
        this.pairingsById_1 = pairingsById_1;
    }
}
