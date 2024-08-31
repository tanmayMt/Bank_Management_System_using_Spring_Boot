package net.javaguides.banking_app.entity;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accounts")
@Entity
public class Account {
    @Id   //Make the id field as primary key 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_holder_name")  //Configure the column for this field
    private String accountHolderName;
    private double balance;
}