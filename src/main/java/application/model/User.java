package application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity {
    @Column
    @NotEmpty(message = "The field name not has empty")
    @Size(min=3, message = "The Field name has minimum 3 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
