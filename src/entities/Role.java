package entities;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "roleId")
    private Integer roleId;

    @Column(name = "name")
    private String name;

    @Column(name = "permissions")
    private Integer permissions;

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }
}
