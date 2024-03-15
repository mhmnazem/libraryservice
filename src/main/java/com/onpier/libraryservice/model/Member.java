package com.onpier.libraryservice.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;


/**
 * @author mhmnazem
 * @created 3/14/24
 * @email Mohammad.nazem@gmail.com
 */

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "member_since")
    private Date memberSince;
    @Column(name = "member_till")
    private Date memberTill;
    @Column(name = "gender")
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public Date getMemberTill() {
        return memberTill;
    }

    public void setMemberTill(Date memberTill) {
        this.memberTill = memberTill;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(name, member.name) && Objects.equals(firstName, member.firstName) && Objects.equals(memberSince, member.memberSince) && Objects.equals(memberTill, member.memberTill) && Objects.equals(gender, member.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, firstName, memberSince, memberTill, gender);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", memberSince=" + memberSince +
                ", memberTill=" + memberTill +
                ", gender='" + gender + '\'' +
                '}';
    }
}
