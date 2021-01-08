package TaskHibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String aName;

    @Column(name = "lastName")
    private String bLastName;

    @Column(name = "age")
    private Byte cAge;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.aName = name;
        this.bLastName = lastName;
        this.cAge = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return aName;
    }

    public void setName(String name) {
        this.aName = name;
    }

    public String getLastName() {
        return bLastName;
    }

    public void setLastName(String lastName) {
        this.bLastName = lastName;
    }

    public Byte getAge() {
        return cAge;
    }

    public void setAge(Byte age) {
        this.cAge = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + aName + '\'' +
                ", lastName='" + bLastName + '\'' +
                ", age=" + cAge +
                '}';
    }

}
