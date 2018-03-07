package jpa;
import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
@Access(AccessType.PROPERTY)
public class Department implements Serializable {
    private long departmentNo;
    private String nameDep;
    private Period operationPeriod;
    public Department() {
        this(-1,"", Period.PARTIAL_BUSINESS_HOURS);
    }
    public Department(long departmentNo, String nameDep, Period operationPeriod) {
        this.departmentNo = departmentNo;
        this.nameDep = nameDep;
        this.operationPeriod=operationPeriod;
    }
    @Id
    @Column(name="DEPARTMENT_NO",nullable=false)
    public long getDepartmentNo() {
        return departmentNo;
    }
    public void setDepartmentNo(long departmentNo) {
        this.departmentNo = departmentNo;
    }
    @Column(name="NAME_DEP",unique=true,nullable=false)
    public String getNameDep() {
        return nameDep;
    }
    public void setNameDep(String nameDep) {
        this.nameDep = nameDep;
    }
    @Column(name="OPERATION_PERIOD", nullable=false)
    @Enumerated(EnumType.STRING)
    public Period getOperationPeriod() {
        return operationPeriod;
    }
    public void setOperationPeriod(Period operationPeriod) {
        this.operationPeriod = operationPeriod;
    }
    @Override
    public String toString() {
        return "departmentNo: "+departmentNo+" nameDep: "+nameDep+" operationPeriod: "+operationPeriod;
    }
}
